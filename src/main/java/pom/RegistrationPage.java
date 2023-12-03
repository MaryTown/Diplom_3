package pom;

import config.Urls;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

    private final String url = Urls.STELLARBURGERS_URL + "register";

    public String getUrl() {
        return url;
    }
    private final WebDriver webDriver;

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.get(url);
    }

    // поле "Имя"
    private final By nameRegisterPageField = By.xpath("//label[text()='Имя']//following-sibling::input[@name='name']");

    // поле "Email"
    private final By emailRegisterPageField = By.xpath("//label[text()='Email']//following-sibling::input[@name='name']");

    // поле "Пароль"
    private final By passwordRegisterPageField = By.xpath("//input[@name='Пароль']");

    // кнопка "Зарегистрироваться"
    private final By registerRegisterPageButton = By.xpath(".//button[text() = 'Зарегистрироваться']");

    // сообщение "Некорректный пароль"
    private final By errorRegisterPageMessage = By.xpath(".//p[text() = 'Некорректный пароль']");

    // кнопка "Войти" после регистрации
    private By loginAfterRegistrationButton = By.xpath(".//button[text()='Войти']");

    public By loginAfterRegistrationButton() {
        return loginAfterRegistrationButton;
    }

    // кнопка "Войти"
    private By loginAlreadyRegistratedButton = By.xpath(".//a[text()='Войти']");

    @Step("Нажать на кнопку Войти на странице регистрации")
    public void clickLoginAlreadyRegistratedButton(){
        WebElement element = webDriver.findElement(loginAlreadyRegistratedButton);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);
    }

    @Step("ввести Имя на странице регистрации")
    public void inputName(String name) {
        webDriver.findElement(nameRegisterPageField).sendKeys(name);
    }

    @Step("ввести Email на странице регистрации")
    public void inputEmail(String email) {
        webDriver.findElement(emailRegisterPageField).sendKeys(email);
    }

    @Step("Ввести пароль на странице регистрации")
    public void inputPassword(String password) {
        webDriver.findElement(passwordRegisterPageField).sendKeys(password);
    }

    public void registrarUser(String name, String email, String password) {
        inputName(name);
        inputEmail(email);
        inputPassword(password);
        webDriver.findElement(registerRegisterPageButton).click();
    }

    @Step("Проверить, что активно сообщение Некорректный пароль")
    public boolean checkErrorRegisterPageMessageActive() {
        return webDriver.findElement(errorRegisterPageMessage).isDisplayed();
    }

}
