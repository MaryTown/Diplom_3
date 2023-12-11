import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход на вкладку «Булки»")
    public void clickOnBunsTest() {
        webDriver.get(mainPage.getUrl());
        mainPage.clickSauces();
        mainPage.clickBuns();

        Assert.assertTrue(mainPage.checkBunsActive());
        Assert.assertTrue(mainPage.checkSoucesUnactive());
        Assert.assertTrue(mainPage.checkFillingsUnactive());
    }

    @Test
    @DisplayName("Переход на вкладку «Соусы»")
    public void clickOnSaucesTest() {
        webDriver.get(mainPage.getUrl());
        mainPage.clickSauces();

        Assert.assertTrue(mainPage.checkSaucesActive());
        Assert.assertTrue(mainPage.checkBunsUnactive());
        Assert.assertTrue(mainPage.checkFillingsUnactive());
    }

    @Test
    @DisplayName("Переход на вкладку «Начинки»")
    public void clickOnFillingTest() {
        webDriver.get(mainPage.getUrl());
        mainPage.clickFillings();

        Assert.assertTrue(mainPage.checkFillingsActive());
        Assert.assertTrue(mainPage.checkBunsUnactive());
        Assert.assertTrue(mainPage.checkSoucesUnactive());
    }
}
