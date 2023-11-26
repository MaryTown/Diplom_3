import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private final String url = Urls.url + "account/profile";

    public String getUrl() {
        return url;
    }
    private final WebDriver webDriver;

    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // кнопка "Сохранить"
    public final By saveProfilePageButton = By.xpath(".//button[text() ='Сохранить']");

    public void clickButtonSaveOnProfilePage() {
        webDriver.findElement(saveProfilePageButton).click();
    }
}
