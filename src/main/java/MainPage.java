import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final String url = Urls.url;

    public String getUrl() {
        return url;
    }
    private final WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // кнопка "Личный кабинет"
    private final By personalAccountMainPageButton = By.xpath("//*[text()='Личный Кабинет']");

    // кнопка "Войти в аккаунт"
    private final By loginMainPageButton = By.xpath(".//button[text()='Войти в аккаунт']");

    // кнопка "Оформить заказ"
    public final By createOrderMainPageButton = By.xpath(".//button[text()='Оформить заказ']");

    // вкладка "Булки"
    public final By bunsActiveMainPageSpan = By.xpath(".//span[text() ='Булки']");
    public final By bunsMainPageSpan = By.xpath("//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");

    // вкладка "Соусы"
    public final By saucesActiveMainPageSpan = By.xpath(".//span[text() ='Соусы']");
    public final By saucesMainPageSpan = By.xpath("//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");

    // вкладка "Начинки"
    public final By fillingsActiveMainPageSpan = By.xpath(".//span[text() ='Начинки']");
    public final By fillingsMainPageSpan = By.xpath("//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

    // кнопка с логотипом Stellar Burgers
    private final By logoButton = By.xpath(".//a[@href ='/']");

    // поле "Email" на ЭФ Вход
    private final By emailLoginPageField = By.xpath("//input[@name='name']");

    // поле "Пароль" на ЭФ Вход
    private final By passwordLoginPageField = By.xpath("//input[@name='Пароль']");

    // кнопка "Войти" на ЭФ Вход
    private final By loginLoginPageButton = By.xpath("//button[text()='Войти']");

    // кнопка "Войти" на ЭФ Регистрация
    private final By loginRegistrationPageButton = By.xpath(".//a[text() = 'Войти']");

    // кнопка "Войти" на ЭФ Восстановление пароля
    private final By loginForgotPasswordPageButton = By.xpath(".//a[text() ='Войти']");

    // кнопка "Выход" в ЛК
    private final By logoutPersonalAccountButton = By.xpath(".//button[text() ='Выход']");

    public void putEmail(String email) {
        webDriver.findElement(emailLoginPageField).sendKeys(email);
    }

    public void putPassword(String password) {
        webDriver.findElement(passwordLoginPageField).sendKeys(password);
    }

    public void clickPersonalAccountMainPageButton() {
        webDriver.findElement(personalAccountMainPageButton).click();
    }

    public void clickLoginMainPageButton() {
        webDriver.findElement(loginMainPageButton).click();
    }

    public void loginWithButtonPersonalAccountOnMainPage(String email, String password) {
        webDriver.findElement(personalAccountMainPageButton).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(emailLoginPageField));
        putEmail(email);
        putPassword(password);
        webDriver.findElement(loginLoginPageButton).click();
    }

    public void loginWithButtonLoginOnMainPage(String email, String password) {
        webDriver.findElement(loginMainPageButton).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(emailLoginPageField));
        putEmail(email);
        putPassword(password);
        webDriver.findElement(loginLoginPageButton).click();
    }

    public void loginWithButtonLoginOnRegisterPage(String email, String password) {
        webDriver.findElement(loginRegistrationPageButton).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(emailLoginPageField));
        putEmail(email);
        putPassword(password);
        webDriver.findElement(loginLoginPageButton).click();
    }

    public void loginWithButtonLoginOnForgotPasswordPage(String email, String password) {
        webDriver.findElement(loginForgotPasswordPageButton);
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(emailLoginPageField));
        putEmail(email);
        putPassword(password);
        webDriver.findElement(loginLoginPageButton).click();
    }
    public void clickButtonPersonalAccountOnMainPage() {
        webDriver.findElement(personalAccountMainPageButton).click();
    }

    public void clickButtonLogoAndConstructorOnPersonalAccount() {
        webDriver.findElement(logoButton).click();
    }

    public void clickLogoutOnPersonalAccount() {
        webDriver.findElement(logoutPersonalAccountButton).click();
    }

    public void clickBuns() {
        webDriver.findElement(bunsMainPageSpan).click();
    }
    public void clickSauces() {
        webDriver.findElement(saucesMainPageSpan).click();
    }
    public void clickFillings() {
        webDriver.findElement(fillingsMainPageSpan).click();
    }
}
