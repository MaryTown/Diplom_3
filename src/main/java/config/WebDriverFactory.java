package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebDriverFactory {
    static WebDriver webDriver;

    public static WebDriver get(String browserName) {
        switch (browserName){
            case "chrome":
                webDriver = new ChromeDriver();
                //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");//в последних версиях селениум уже не нужно
                return webDriver;
            case "yandex":
                ChromeOptions options = new ChromeOptions();
                options.setBinary(Urls.BROWSER_LOCATION);
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver/yandexdriver.exe");
                webDriver = new ChromeDriver(options);
//                WebDriverManager.firefoxdriver().setup();
                return webDriver;
            default:
                throw  new RuntimeException("Browser is not detected");
        }
    }

}
