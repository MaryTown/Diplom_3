import Browsers.BrowserDriverSetting;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.Matchers.containsString;

public class LoginTest {

    WebDriver webDriver;
    MainPage mainPage;
    ForgotPasswordPage forgotPasswordPage;
    UserAuth userAuth;
    private User user;

    private final String name = User.getName();
    private final String email = User.getEmail();
    private final String password = User.getPassword();
    private String accessToken;
    RegistrationPage registrationPage;

    @Before
    public void setUp() {
        webDriver = BrowserDriverSetting.browserDriverSetUp();
        registrationPage = new RegistrationPage(webDriver);
        webDriver.get(registrationPage.getUrl());
        registrationPage.registrateUser(name, email, password);
        mainPage = new MainPage(webDriver);
        webDriver.get(mainPage.getUrl());
        forgotPasswordPage = new ForgotPasswordPage(webDriver);
        userAuth = new UserAuth();
        User user = GettingParams.getRandomUser();
        Response response = userAuth.create(user);
        accessToken = response.path("accessToken");
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void loginWithLoginOnMainPageTest() {
        webDriver.get(mainPage.getUrl());
        mainPage.loginWithButtonLoginOnMainPage(email, password);
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(mainPage.createOrderMainPageButton));
        Assert.assertThat(webDriver.findElement(mainPage.createOrderMainPageButton).getText(), containsString("Оформить заказ"));
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void loginWithPersonalAccountOnMainPageTest() {
        webDriver.get(mainPage.getUrl());
        mainPage.loginWithButtonPersonalAccountOnMainPage(email, password);
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(mainPage.createOrderMainPageButton));
        Assert.assertThat(webDriver.findElement(mainPage.createOrderMainPageButton).getText(), containsString("Оформить заказ"));
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void loginWithLoginOnRegisterPageTest() {
        webDriver.get(registrationPage.getUrl());
        mainPage.loginWithButtonLoginOnRegisterPage(email, password);
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(mainPage.createOrderMainPageButton));
        Assert.assertThat(webDriver.findElement(mainPage.createOrderMainPageButton).getText(), containsString("Оформить заказ"));
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void loginWithLoginOnForgotPasswordPageTest() {
        webDriver.get(forgotPasswordPage.getUrl());
        mainPage.loginWithButtonLoginOnForgotPasswordPage(email, password);
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(mainPage.createOrderMainPageButton));
        Assert.assertThat(webDriver.findElement(mainPage.createOrderMainPageButton).getText(), containsString("Оформить заказ"));
    }

    @After
    public void cleanUp() {
        if (accessToken != null) {
            UserAuth.delete(accessToken);
        }
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
