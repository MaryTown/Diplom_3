import api.user.UserAuth;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountTest extends BaseTest {
    UserAuth userAuth;
    String accessToken;

    @Test
    @DisplayName("Проверь переход по клику на «Личный кабинет»")
    public void clickPersonalAccountOnMainPageTest() {
        Response response = userAuth.create(user);
        accessToken = response.path("accessToken");
        webDriver.get(loginPage.getUrl());

        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(mainPage.createOrderMainPageButton()));

        webDriver.get(mainPage.getUrl());
        mainPage.clickButtonPersonalAccountOnMainPage();
        Assert.assertEquals("Выход", webDriver.findElement(profilePage.logoutPersonalAccountButton()).getText());
    }

    @Test
    @DisplayName("Проверь выход по кнопке «Выйти» в личном кабинете")
    public void logoutButtonClickTest() {
        Response response = userAuth.create(user);
        accessToken = response.path("accessToken");
        webDriver.get(loginPage.getUrl());
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(mainPage.createOrderMainPageButton()));

        webDriver.get(mainPage.getUrl());
        mainPage.clickButtonPersonalAccountOnMainPage();
        profilePage.clickLogoutPersonalAccountButton();
        Assert.assertEquals("Войти", webDriver.findElement(registrationPage.loginAfterRegistrationButton()).getText());
    }
}
