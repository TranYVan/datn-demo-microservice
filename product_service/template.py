import os
from pathlib import Path 

PROJECT_NAME = "src" #add your project name here

LIST_FILES = [
    ".env",
    ".gitignore",
    "app.py",
    "init_setup.py",
    "README.md",
    "requirements.txt",
    "src/__init__.py",
    # config folder
    "src/config/__init__.py",
    "src/config/config.py",
    "src/config/dev_config.py",
    "src/config/production.py",
    # controllers
    "src/controllers/__init__.py",
    "src/controllers/product_controller.py",
    # middlewares
    "src/middlewares/__init__.py",
    # models
    "src/models/__init__.py",
    "src/models/product_model.py",
    # services
    "src/services/__init__.py",
    "src/services/product_service.py",
    # routes and utils
     "src/routes/product_route.py",
     "src/utils.py",
   ]

for file_path in LIST_FILES:
    file_path = Path(file_path)
    file_dir, file_name = os.path.split(file_path)

    # first make dir
    if file_dir!="":
        os.makedirs(file_dir, exist_ok= True)
        print(f"Creating Directory: {file_dir} for file: {file_name}")
    
    if (not os.path.exists(file_path)) or (os.path.getsize(file_path)==0):
        with open(file_path, "w") as f:
            pass
            print(f"Creating an empty file: {file_path}")
    else:
        print(f"File already exists {file_path}")