from pydantic import BaseModel

class UserCreate(BaseModel):
    name: str
    username: str
    email: str
    password: str

class UserLogin(BaseModel):
    username_or_email: str
    password: str
