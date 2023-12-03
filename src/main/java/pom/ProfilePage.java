package pom;

import config.Urls;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    private final String url = Urls.STELLARBURGERS_URL + "account/profile";

    public String getUrl() {
        return url;
    }
    private final WebDriver webDriver;

    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.get(url);
    }

    // кнопка Конструктор
    private By constructorButton = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2']");

    // кнопка с логотипом Stellar Burgers
    private final By logoButton = By.xpath(".//a[@href = '/']");

    // кнопка "Сохранить"
    //private final By saveProfileButton = By.xpath(".//button[text() = 'Сохранить']");

    // кнопка "Выход" в ЛК
    private final By logoutPersonalAccountButton = By.xpath(".//button[text() = 'Выход']");

    @Step("Нажать на кнопку Конструктор в ЛК")
    public void clickConstructorButton() {
        WebElement element = webDriver.findElement(constructorButton);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);
    }

    @Step("Нажать на кнопку с логотипом Stallar Burgers в ЛК")
    public void clickLogo() {
        WebElement element = webDriver.findElement(logoButton);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);
    }

    @Step("Нажать на кнопку Выход в ЛК")
    public void clickLogoutPersonalAccountButton() {
        WebElement element = webDriver.findElement(logoutPersonalAccountButton);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);
    }

    public By logoutPersonalAccountButton() {
        return logoutPersonalAccountButton;
    }
}
