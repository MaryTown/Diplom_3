import Browsers.BrowserDriverSetting;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ConstructorTest {
    WebDriver webDriver;
    MainPage mainPage;

    @Before
    public void setUp() {
        webDriver = browserDriverSetUp();
        mainPage = new MainPage(webDriver);
        webDriver.get(mainPage.getUrl());
    }

    @Test
    @DisplayName("Переход на вкладку «Булки»")
    public void clickOnBunsTest() {
        mainPage.clickSauces();
        mainPage.clickBuns();
        Assert.assertTrue(webDriver.findElement(mainPage.bunsActiveMainPageSpan).isDisplayed());
        Assert.assertTrue(webDriver.findElement(mainPage.fillingsMainPageSpan).isDisplayed());
        Assert.assertTrue(webDriver.findElement(mainPage.saucesMainPageSpan).isDisplayed());
    }
    @Test
    @DisplayName("Переход на вкладку «Соусы»")
    public void clickOnSaucesTest() {
        mainPage.clickSauces();
        Assert.assertTrue(webDriver.findElement(mainPage.saucesActiveMainPageSpan).isDisplayed());
        Assert.assertTrue(webDriver.findElement(mainPage.bunsMainPageSpan).isDisplayed());
        Assert.assertTrue(webDriver.findElement(mainPage.fillingsMainPageSpan).isDisplayed());
    }
    @Test
    @DisplayName("Переход на вкладку «Начинки»")
    public void clickOnFillingTest() {
        mainPage.clickFillings();
        Assert.assertTrue(webDriver.findElement(mainPage.fillingsActiveMainPageSpan).isDisplayed());
        Assert.assertTrue(webDriver.findElement(mainPage.bunsMainPageSpan).isDisplayed());
        Assert.assertTrue(webDriver.findElement(mainPage.saucesMainPageSpan).isDisplayed());
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
