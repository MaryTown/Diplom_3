import api.user.UserAuth;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class OpenMainPageTest extends BaseTest {
    UserAuth userAuth;
    String accessToken;

    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    public void clickConstructorOnPersonalAccountTest() {
        webDriver.get(mainPage.getUrl());

        //регистрация и авторизация, чтобы зайти в ЛК
        Response response = userAuth.create(user);
        accessToken = response.path("accessToken");
        mainPage.clickLoginMainPageButton();
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();

        //переход по клику на конструктор
        profilePage.clickConstructorButton();

        Assert.assertEquals("Оформить заказ", webDriver.findElement(mainPage.createOrderMainPageButton()).getText());
    }

    @Test
    @DisplayName("Переход по клику на логотип Stellar Burgers")
    public void clickLogoOnPersonalAccountTest() {
        webDriver.get(mainPage.getUrl());

        //регистрация и авторизация, чтобы зайти в ЛК
        Response response = userAuth.create(user);
        accessToken = response.path("accessToken");
        mainPage.clickLoginMainPageButton();
        loginPage.inputEmail(user.getEmail());
        loginPage.inputPassword(user.getPassword());
        loginPage.clickLoginButton();

        //переход по клику на логотип
        profilePage.clickLogo();

        Assert.assertEquals("Оформить заказ", webDriver.findElement(mainPage.createOrderMainPageButton()).getText());
    }
}