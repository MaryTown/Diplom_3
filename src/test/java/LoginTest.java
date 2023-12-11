import api.user.UserAuth;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest {
    UserAuth userAuth;
    String accessToken;

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void loginWithLoginOnMainPageTest() {
        webDriver.get(mainPage.getUrl());
        Response response = userAuth.create(user);
        accessToken = response.path("accessToken");
        mainPage.clickLoginMainPageButton();
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();
        Assert.assertEquals("Оформить заказ", webDriver.findElement(mainPage.createOrderMainPageButton()).getText());
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void loginWithPersonalAccountOnMainPageTest() {
        webDriver.get(mainPage.getUrl());
        Response response = userAuth.create(user);
        accessToken = response.path("accessToken");
        mainPage.clickButtonPersonalAccountOnMainPage();
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();
        Assert.assertEquals("Оформить заказ", webDriver.findElement(mainPage.createOrderMainPageButton()).getText());
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void loginWithLoginOnRegisterPageTest() {
        webDriver.get(registrationPage.getUrl());
        Response response = userAuth.create(user);
        accessToken = response.path("accessToken");
        registrationPage.clickLoginAlreadyRegistratedButton();
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();
        Assert.assertEquals("Оформить заказ", webDriver.findElement(mainPage.createOrderMainPageButton()).getText());
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void loginWithLoginOnForgotPasswordPageTest() {
        webDriver.get(forgotPasswordPage.getUrl());
        Response response = userAuth.create(user);
        accessToken = response.path("accessToken");
        forgotPasswordPage.clickLoginForgotPasswordPageButton();
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();
        Assert.assertEquals("Оформить заказ", webDriver.findElement(mainPage.createOrderMainPageButton()).getText());
    }
}