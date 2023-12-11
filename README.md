# Diplom_3 Selenium
#### Задание 3 Дипломного проекта курса Яндекс Практикума "Автоматизатор тестирования на JAVA"
UI-тестирование Web-приложения *StellarBurgers*: <br>
[*StellarBurgers*](https://stellarburgers.nomoreparties.site/)<br>
## **Технологии:**
- Java 11
- Maven 4.0.0
- Junit 4.13.2
- RestAssured 5.3.2
- Selenium 4.15.0
- Allure 2.24.0

## **Запуск тестов:**
- В Goole Chrome:
  `mvn clean test -DbrowserName=chrome`
- В Yandex Browser:
  `mvn clean test -DbrowserName=yandex` * <br>
*- для корректного запуска тестов в Yandex Browser на вашем компьютере необходимо указать 
путь к установленному браузеру (приложение browser.exe) в файле src.main.java.config.Urls в переменной BROWSER_LOCATION.

## **Отчет:**
`mvn allure:serve`