import Browsers.BrowserDriverSetting;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static org.hamcrest.CoreMatchers.containsString;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    private static WebDriver webDriver;
    UserAuth userAuth;
    private User user;
    private String accessToken;
    RegistrationPage registrationPage;
    Random random = new Random();

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        registrationPage = new RegistrationPage(webDriver);
        webDriver.get(registrationPage.getUrl());
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        userAuth = new UserAuth();
        User user = GettingParams.getRandomUser();
        Response response = userAuth.create(user);
        accessToken = response.path("accessToken");
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void successRegisterUserTest() {
        registrationPage.registrateUser(user.getName(), user.getEmail(), user.getPassword());
        Assert.assertThat("Ошибка вместо корректной регистрации",
                webDriver.findElement(registrationPage.loginAfterRegistrationButton).getText(), containsString("Войти"));
    }

    @Test
    @DisplayName("Попытка регистрации пользователя с некорректным паролем")
    public void registerUserWithShortPasswordTest() {
        registrationPage.registrateUser(user.getName(), user.getEmail(), String.valueOf((int) (Math.random() * (99999 + 1))));
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(registrationPage.errorRegisterPageMessage));
        Assert.assertThat("Должна была открыться страница Вход",
                webDriver.findElement(registrationPage.errorRegisterPageMessage).getText(), containsString("Некорректный пароль"));
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
