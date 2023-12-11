package pom;

import config.Urls;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver webDriver;

    private final String url = Urls.STELLARBURGERS_URL + "login";

    public String getUrl() {
        return url;
    }

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.get(url);
    }

    // поле "Email" на ЭФ Вход
    private final By emailLoginPageField = By.xpath("//input[@name = 'name']");

    // поле "Пароль" на ЭФ Вход
    private final By passwordLoginPageField = By.xpath("//input[@name = 'Пароль']");

    // кнопка "Войти" на ЭФ Вход
    private final By loginLoginPageButton = By.xpath("//button[text() = 'Войти']");

    @Step("Ввести Email")
    public void inputEmail(String email) {
        webDriver.findElement(emailLoginPageField).sendKeys(email);
    }

    @Step("Ввести пароль")
    public void inputPassword(String password) {
        webDriver.findElement(passwordLoginPageField).sendKeys(password);
    }

    @Step("Нажатие на кнопку Войти")
    public void clickLoginButton() {
        WebElement element = webDriver.findElement(loginLoginPageButton);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);
    }

}
