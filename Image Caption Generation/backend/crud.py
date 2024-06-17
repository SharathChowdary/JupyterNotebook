from typing import List, Optional
from models import User

# Dummy database
database = []

def create_user(user: User):
    database.append(user)

def get_user(username: str) -> Optional[User]:
    for user in database:
        if user.username == username:
            return user
    return None

def update_user(username: str, new_data: dict):
    user = get_user(username)
    if user:
        for key, value in new_data.items():
            setattr(user, key, value)

def delete_user(username: str):
    user = get_user(username)
    if user:
        database.remove(user)

def get_all_users() -> List[User]:
    return database
