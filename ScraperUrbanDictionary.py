from selenium import webdriver
from selenium.webdriver import firefox
from bs4 import BeautifulSoup
from GoogleVision import transfer
from Translator import translate_text


url = "https://www.urbandictionary.com/define.php?term="
url += transfer[0]  # acount for spacing

# create instance of driver and find website
driver = webdriver.Chrome(executable_path="chromedriver.exe")
driver.set_window_position(-2000, 0)
driver.get(url)

'''
python_button1 = driver.find_element_by_class_name("search-icon") #find and click "Search" icon
python_button1.click()

python_button2 = driver.find_element_by_class_name("search-bar-submit")
python_button2.send_keys("ostrich")
'''


# Selenium --> Beautiful Soup
soup = BeautifulSoup(driver.page_source, 'html.parser')  # --driver.page_source--html doc, html.parser
driver.quit()

data = soup.find(class_='meaning')
output = (data.text.strip())

f = open("ScraperData.txt", "w+", encoding='utf-8')
f.truncate()
f.write(translate_text(transfer[0]) + "\n\n")
f.write(translate_text(output))
f.write("\n\n")
f.write(translate_text("Confidence") + ": " + str(transfer[1]))
f.close()
