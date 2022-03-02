# HackFRee 2019 Hackathon Project

Overview: 
A program written in Python and Java to describe what is in an image, translated into the user's native language. This is meant to be a tool that can be used to identify unfamiliar food/animals/plants etc.

Description:
- Open cv used to either read image from camera or disk
- Google vision label detection applied and top label is grabbed
- Selenium and beautifulsoup used to scrape either merriam webster or urban dictionary (for fun) for description
- Google translate used to translate results into any of the supported languages as specified by settings
- Image with label and description shown
- jframe based java GUI used

Environment:
- Python 3.7
- selenium               --> pip install selenium
- beautifulsoup4         --> pip install beautifulsoup4
- google-cloud-vision    --> pip install google-cloud-vision
- google-cloud-translate --> pip install google-cloud-translate
- open cv 		 --> pip install opencv-python

*environment is automatically created with setup batch script
*pip might default to python 2, in that case, use pip3

Team:
Mateusz Wolak, Jon Riklan, Nicholas Procaccio, Alex Harris
