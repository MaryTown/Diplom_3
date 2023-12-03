package pom;

import config.Urls;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
    WebDriver webDriver;

    private final String url = Urls.STELLARBURGERS_URL + "forgot-password";

    public String getUrl() {
        return url;
    }

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.get(url);
    }

    // кнопка "Войти" на ЭФ Восстановление пароля
    private final By loginForgotPasswordPageButton = By.xpath(".//a[text() = 'Войти']");

    @Step("Нажать на кнопку Войти на странице восстановления пароля")
    public void clickLoginForgotPasswordPageButton() {
        WebElement element = webDriver.findElement(loginForgotPasswordPageButton);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);
    }
}