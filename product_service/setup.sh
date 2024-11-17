#!/bin/bash

# Script to set up a Python Flask environment with PostgreSQL and Flask-Migrate

# Function to display messages
function print_message() {
    echo "=========================================="
    echo "$1"
    echo "=========================================="
}

# Update the system
print_message "Updating the system..."
sudo apt update && sudo apt upgrade -y

# Install Python, pip, and virtual environment
print_message "Installing Python, pip, and virtual environment..."
sudo apt install python3 python3-pip python3-venv -y

# Install PostgreSQL and dependencies
print_message "Installing PostgreSQL..."
sudo apt install postgresql postgresql-contrib libpq-dev -y

# Start and enable PostgreSQL service
print_message "Starting PostgreSQL service..."
sudo systemctl start postgresql
sudo systemctl enable postgresql

# Create PostgreSQL user and database
print_message "Configuring PostgreSQL database and user..."
sudo -u postgres psql <<EOF
CREATE USER flask_user WITH PASSWORD 'your_password';
CREATE DATABASE flask_db;
GRANT ALL PRIVILEGES ON DATABASE flask_db TO flask_user;
\q
EOF

# python3 -m venv venv
# source venv/bin/activate

# Install Flask and dependencies
print_message "Installing Flask and dependencies..."
pip install -r requirements.txt
apt install python3-flask -y
# Success message
print_message "Environment setup completed successfully!"
print_message "To activate the virtual environment, use: source venv/bin/activate"
