import numpy as np
import cv2
import time

cap = cv2.VideoCapture(0)

while(True):
    # Capture frame-by-frame
    ret, frame = cap.read()

    # Our operations on the frame come here
    img = cv2.cvtColor(frame, cv2.COLOR_BGR2BGRA)

    # Display the resulting frame
    cv2.imshow('frame', img)
    if cv2.waitKey(1) & 0xFF == ord(' '):
        time.sleep(2)
        cv2.imwrite("image.jpg", img)
        break

# When everything done, release the capture
cap.release()
cv2.destroyAllWindows()
