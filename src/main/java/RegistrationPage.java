import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private final String url = Urls.url + "register";

    public String getUrl() {
        return url;
    }
    private final WebDriver webDriver;

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // поле "Имя"
    private final By nameRegisterPageField = By.xpath("//label[text()='Имя']//following-sibling::input[@name='name']");

    // поле "Email"
    private final By emailRegisterPageField = By.xpath("//label[text()='Email']//following-sibling::input[@name='name']");

    // поле "Пароль"
    private final By passwordRegisterPageField = By.xpath("//input[@name='Пароль']");

    // кнопка "Зарегистрироваться"
    private final By registerRegisterPageButton = By.xpath(".//button[text() = 'Зарегистрироваться']");

    // сообщение "Некорректный пароль"
    public final By errorRegisterPageMessage = By.xpath(".//p[text() = 'Некорректный пароль']");

    // кнопка "Войти" после регистрации
    public By loginAfterRegistrationButton = By.xpath(".//button[text()='Войти']");

    public void inputName(String name) {
        webDriver.findElement(nameRegisterPageField).sendKeys(name);
    }

    public void inputEmail(String email) {
        webDriver.findElement(emailRegisterPageField).sendKeys(email);
    }

    public void inputPassword(String password) {
        webDriver.findElement(passwordRegisterPageField).sendKeys(password);
    }

    public void registrateUser(String name, String email, String password) {
        inputName(name);
        inputEmail(email);
        inputPassword(password);
        webDriver.findElement(registerRegisterPageButton).click();
    }
}
