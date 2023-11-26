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

public class PersonalAccountTest {

    WebDriver webDriver;
    MainPage mainPage;
    ProfilePage profilePage;
    ForgotPasswordPage forgotPasswordPage;

    RegistrationPage registrationPage;
    UserAuth userAuth;
    private User user;

    private final String name = User.getName();
    private final String email = User.getEmail();
    private final String password = User.getPassword();
    private String accessToken;

    @Before
    public void setUp() {
        webDriver = BrowserDriverSetting.browserDriverSetUp();
        registrationPage = new RegistrationPage(webDriver);
        webDriver.get(registrationPage.getUrl());
        registrationPage.registrateUser(name, email, password);
        mainPage = new MainPage(webDriver);
        webDriver.get(mainPage.getUrl());
        mainPage.loginWithButtonLoginOnMainPage(email, password);
        mainPage.clickButtonPersonalAccountOnMainPage();
        userAuth = new UserAuth();
        User user = GettingParams.getRandomUser();
        Response response = userAuth.create(user);
        accessToken = response.path("accessToken");
    }

    @Test
    @DisplayName("Проверь переход по клику на «Личный кабинет»")
    public void clickPersonalAccountOnMainPageTest() {
        profilePage = new ProfilePage(webDriver);
        mainPage.clickButtonPersonalAccountOnMainPage();
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(profilePage.saveProfilePageButton));
        Assert.assertThat(webDriver.findElement(profilePage.saveProfilePageButton).getText(), containsString("Сохранить"));
    }

    @Test
    @DisplayName("Проверь выход по кнопке «Выйти» в личном кабинете")
    public void logoutButtonClickTest() {
        mainPage.clickLogoutOnPersonalAccount();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(registrationPage.loginAfterRegistrationButton));
        Assert.assertThat(webDriver.findElement(registrationPage.loginAfterRegistrationButton).getText(), containsString("Войти"));
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
