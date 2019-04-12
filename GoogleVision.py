import os
import io

# Imports the Google Cloud client library
from google.cloud import vision
from google.cloud.vision import types
from google.oauth2 import service_account

credentials = service_account.Credentials.from_service_account_file('HackFree2019.json')

# Instantiates a client
client = vision.ImageAnnotatorClient(credentials=credentials)

# The name of the image file to annotate
file_name = os.path.join(
    os.path.dirname(__file__),
    'image.jpg')

# Loads the image into memory
with io.open(file_name, 'rb') as image_file:
    content = image_file.read()

image = types.Image(content=content)

# Performs label detection on the image file
response = client.label_detection(image=image)
labels = response.label_annotations

transfer = [labels[0].description, labels[0].score]
