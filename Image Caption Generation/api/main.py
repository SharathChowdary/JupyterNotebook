
from fastapi import FastAPI, File, UploadFile
from fastapi.middleware.cors import CORSMiddleware
import uvicorn
import numpy as np
from io import BytesIO
from PIL import Image
import tensorflow as tf
from tensorflow.keras.models import Model
from tensorflow.keras.applications.xception import Xception, preprocess_input
from tensorflow.keras.preprocessing.sequence import pad_sequences
import pickle

app = FastAPI()

origins = [
    "http://localhost",
    "http://localhost:3000",
]
app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

MODEL = tf.keras.models.load_model("../saved_models/1/model_46.h5", compile=False)
MODEL.compile(loss='categorical_crossentropy', optimizer='adam')

# loading tokenizer
with open('../tokenizer/tokenizer.pkl', 'rb') as f:
    tokenizer = pickle.load(f)

# Load the pre-trained Xception model
base_model = Xception(weights='imagenet')
# Remove the top layer (fully connected layers)
xception_model = Model(inputs=base_model.input, outputs=base_model.get_layer('avg_pool').output)

@app.get("/ping")
async def ping():
    return "Hello, I am alive"


# function that returns the corresponding word to the given index in the vocabulary
def idx_to_word(integer, tokenizer):
    for word, index in tokenizer.word_index.items():
        if index == integer:
            return word
    return None


# generate caption for an image
def predict_caption(model, image, tokenizer, max_length):
    # add start tag for generation process
    in_text = 'startseq'
    # iterate over the max length of sequence
    for i in range(max_length):
        # encode input sequence
        sequence = tokenizer.texts_to_sequences([in_text])[0]
        # pad the sequence
        sequence = pad_sequences([sequence], max_length)
        # predict next word
        yhat = model.predict([image, sequence], verbose=0)
        # get index with high probability
        yhat = np.argmax(yhat)
        # convert index to word
        word = idx_to_word(yhat, tokenizer)
        # stop if word not found
        if word is None:
            break
        # append word as input for generating next word
        in_text += " " + word
        # stop if we reach end tag
        if word == 'endseq':
            break
    return in_text


def read_file_as_image(data) -> np.ndarray:
    image = np.array(Image.open(BytesIO(data)).resize((299, 299)))
    return image

@app.post("/predict")
async def predict(
    file: UploadFile = File(...)
):
    image = read_file_as_image(await file.read())
    img = np.expand_dims(image, 0)

    img = preprocess_input(img)
    # extract features
    feature = xception_model.predict(img, verbose=0)
    # predict from the trained model
    caption = predict_caption(MODEL, feature, tokenizer, 35)[9:-7].capitalize() + "."
    return {
        'class': caption,
        'confidence':float(90)
    }

if __name__ == "__main__":
    uvicorn.run(app, host='localhost', port=8000)

