from fastapi import FastAPI, File, UploadFile, Depends, HTTPException, status
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
from pydantic import BaseModel
from typing import Optional, List

class UserRegistration(BaseModel):
    name: str
    username: str
    email: str
    password: str


app = FastAPI()

# Allow CORS
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

# Model loading and setup
MODEL = tf.keras.models.load_model("../saved_models/model_46.h5", compile=False)
MODEL.compile(loss='categorical_crossentropy', optimizer='adam')

# Loading tokenizer
with open('../tokenizer/tokenizer.pkl', 'rb') as f:
    tokenizer = pickle.load(f)

# Load the pre-trained Xception model
base_model = Xception(weights='imagenet')
xception_model = Model(inputs=base_model.input, outputs=base_model.get_layer('avg_pool').output)

def idx_to_word(index, tokenizer):
    for word, idx in tokenizer.word_index.items():
        if idx == index:
            return word
    return None

# Function to preprocess image
def read_file_as_image(data) -> np.ndarray:
    image = np.array(Image.open(BytesIO(data)).resize((299, 299)))
    return image

# Function to predict caption
def predict_caption(model, image, tokenizer, max_length):
    in_text = 'startseq'
    for i in range(max_length):
        sequence = tokenizer.texts_to_sequences([in_text])[0]
        sequence = pad_sequences([sequence], max_length)
        yhat = model.predict([image, sequence], verbose=0)
        yhat = np.argmax(yhat)
        word = idx_to_word(yhat, tokenizer)
        if word is None:
            break
        in_text += " " + word
        if word == 'endseq':
            break
    return in_text

# Dependency to get the current user
def get_current_user(username: str, password: str):
    # Here you can implement your logic to check if the user exists in the database
    # For simplicity, let's assume there's only one user
    if username == "user" and password == "password":
        return True
    return False

# API endpoints
@app.get("/ping")
async def ping():
    return "Hello, I am alive"

@app.post("/login")
async def login(username: str, password: str):
    if get_current_user(username, password):
        return {"message": "Login successful"}
    else:
        raise HTTPException(status_code=status.HTTP_401_UNAUTHORIZED, detail="Invalid credentials")

@app.post("/register")
async def register(user_info: UserRegistration):
    # Here you can implement the logic to register a new user
    # For simplicity, let's assume we're just printing the user information
    return {"message": "User registered successfully", "user_info": user_info}

@app.post("/predict")
async def predict(
    file: UploadFile = File(...),
    username: str = Depends(get_current_user),
):
    image = read_file_as_image(await file.read())
    img = np.expand_dims(image, 0)
    img = preprocess_input(img)
    feature = xception_model.predict(img, verbose=0)
    caption = predict_caption(MODEL, feature, tokenizer, 35)[9:-7].capitalize() + "."
    return {
        'class': caption,
        'confidence': 90
    }

if __name__ == "__main__":
    uvicorn.run(app, host='localhost', port=8000)
