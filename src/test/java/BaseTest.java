import api.user.UserAuth;
import api.user.GettingParams;
import api.user.User;
import config.WebDriverFactory;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.*;

import java.time.Duration;

public class BaseTest {
    UserAuth userAuth;
    String accessToken;
    User user;
    MainPage mainPage;
    ForgotPasswordPage forgotPasswordPage;
    LoginPage loginPage;
    ProfilePage profilePage;
    RegistrationPage registrationPage;
    WebDriver webDriver;

    @Before
    public void setUp() {
        userAuth = new UserAuth();
        user = GettingParams.getRandomUser();

        String browserName = System.getProperty("browserName");
        webDriver = WebDriverFactory.get(browserName);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //webDriver = new ChromeDriver();
        //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        mainPage = new MainPage(webDriver);
        forgotPasswordPage = new ForgotPasswordPage(webDriver);
        profilePage = new ProfilePage(webDriver);
        loginPage = new LoginPage(webDriver);
        registrationPage = new RegistrationPage(webDriver);
    }

    @After
    public void cleanUp() {
        if (accessToken != null) {
            UserAuth.delete(accessToken);
        }

        webDriver.quit();
    }
}