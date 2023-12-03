package pom;

import config.Urls;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final String url = Urls.STELLARBURGERS_URL;

    public String getUrl() {
        return url;
    }
    private final WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.get(url);
    }

    // кнопка "Войти в аккаунт"
    private final By loginMainPageButton = By.xpath(".//button[text() = 'Войти в аккаунт']");

    // кнопка "Личный кабинет"
    private final By personalAccountMainPageButton = By.xpath("//*[text() = 'Личный Кабинет']");

    // кнопка "Оформить заказ"
    private final By createOrderMainPageButton = By.xpath(".//button[text() = 'Оформить заказ']");

    // вкладка "Булки"
    private final By bunsActiveMainPageSpan = By.xpath(".//span[text() = 'Булки']");
    private final By bunsMainPageSpan = By.xpath("//div[starts-with(@class,'tab_tab__1SPyG')][1]");

    // вкладка "Соусы"
    private final By saucesActiveMainPageSpan = By.xpath(".//span[text() = 'Соусы']");
    private final By saucesMainPageSpan = By.xpath("//div[starts-with(@class,'tab_tab__1SPyG')][2]");

    // вкладка "Начинки"
    private final By fillingsActiveMainPageSpan = By.xpath(".//span[text() = 'Начинки']");
    private final By fillingsMainPageSpan = By.xpath("//div[starts-with(@class,'tab_tab__1SPyG')][3]");

    @Step("Нажать на кнопку Войти в аккаунт на главной странице")
    public void clickLoginMainPageButton() {
        WebElement element = webDriver.findElement(loginMainPageButton);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);
    }

    @Step("Нажать на кнопку Личный кабинет на главной странице")
    public void clickButtonPersonalAccountOnMainPage() {
        WebElement element = webDriver.findElement(personalAccountMainPageButton);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);
    }

    @Step("Нажать на кнопку Булки")
    public void clickBuns() {
        WebElement element = webDriver.findElement(bunsMainPageSpan);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);
    }

    @Step("Нажать на кнопку Соусы")
    public void clickSauces() {
        WebElement element = webDriver.findElement(saucesMainPageSpan);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);
    }

    @Step("Нажать на кнопку Начинки")
    public void clickFillings() {
        WebElement element = webDriver.findElement(fillingsMainPageSpan);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);
    }

    @Step("Проверить, что активна вкладка Булки")
    public boolean checkBunsActive() {
        return webDriver.findElement(bunsActiveMainPageSpan).isDisplayed();
    }

    @Step("Проверить, что активна вкладка Соусы")
    public boolean checkSaucesActive() {
        return webDriver.findElement(saucesActiveMainPageSpan).isDisplayed();
    }

    @Step("Проверить, что активна вкладка Начинки")
    public boolean checkFillingsActive() {
        return webDriver.findElement(fillingsActiveMainPageSpan).isDisplayed();
    }

    @Step("Проверить, что не активна вкладка Булки")
    public boolean checkBunsUnactive() {
        return webDriver.findElement(bunsMainPageSpan).isDisplayed();
    }

    @Step("Проверить, что не активна вкладка Соусы")
    public boolean checkSoucesUnactive() {
        return webDriver.findElement(saucesMainPageSpan).isDisplayed();
    }

    @Step("Проверить, что не активна вкладка Начинки")
    public boolean checkFillingsUnactive() {
        return webDriver.findElement(fillingsMainPageSpan).isDisplayed();
    }

    public By createOrderMainPageButton() {
        return createOrderMainPageButton;
    }
}