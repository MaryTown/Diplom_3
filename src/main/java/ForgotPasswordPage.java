import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final String url = Urls.url + "forgot-password";

    public String getUrl() {
        return url;
    }

    private final WebDriver webDriver;

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

}