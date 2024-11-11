echo "[ `date` ]": "START"
echo "[ `date` ]": "installing the requirements" 
pip install -r requirements.txt
echo "[ `date` ]": "creating folders and files" 
python3 template.py
echo "[ `date` ]": "END"