import api.user.UserCredentials;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация")
    public void successRegistrateUserTest() {
        registrationPage.registrarUser(user.getName(), user.getEmail(), user.getPassword());
        Assert.assertEquals("Войти", webDriver.findElement(registrationPage.loginAfterRegistrationButton()).getText());

        Response response = userAuth.login(UserCredentials.from(user));
        accessToken = response.path("accessToken");
    }

    @Test
    @DisplayName("Попытка регистрации пользователя с некорректным паролем")
    public void registrateUserWithShortPasswordTest() {
        String shortPassword = String.valueOf((int) (Math.random() * (99999 + 1)));
        registrationPage.registrarUser(user.getName(), user.getEmail(), shortPassword);
        Assert.assertTrue(registrationPage.checkErrorRegisterPageMessageActive());
    }

}
