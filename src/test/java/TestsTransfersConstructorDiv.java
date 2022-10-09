import config.Config;
import pageobjects.MainPage;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.assertEquals;

public class TestsTransfersConstructorDiv {
    private WebDriver driver;
    private MainPage mainPage;

    @Test
    @DisplayName("Раздел «Конструктор»: переход к разделу 'Булки'")
    @Description("Проверка, что при клике на название 'Булки' переходим в этот раздел")
    public void apronOfTestsBunsInBrowsers() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get(mainPage.getUrl());
        driver.manage().window().maximize();
        mainPage.waitHeader();
        transferForBunsIsActive();
        driver.quit();
        WebDriverManager.chromedriver().driverVersion("104.0.5112.20").setup();
        driver = new ChromeDriver(new ChromeOptions().setBinary(new Config().getYandexBinaryPath()));
        mainPage = new MainPage(driver);
        driver.get(mainPage.getUrl());
        driver.manage().window().maximize();
        mainPage.waitHeader();
        transferForBunsIsActive();
        driver.quit();
    }

    @Test
    @DisplayName("Раздел «Конструктор»: переход к разделу 'Соусы'")
    @Description("Проверка, что при клике на название 'Соусы' переходим в этот раздел")
    public void apronOfTestsSaucesInBrowsers() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get(mainPage.getUrl());
        driver.manage().window().maximize();
        mainPage.waitHeader();
        transferForSaucesIsActive();
        driver.quit();
        WebDriverManager.chromedriver().driverVersion("104.0.5112.20").setup();
        driver = new ChromeDriver(new ChromeOptions().setBinary(new Config().getYandexBinaryPath()));
        mainPage = new MainPage(driver);
        driver.get(mainPage.getUrl());
        driver.manage().window().maximize();
        mainPage.waitHeader();
        transferForSaucesIsActive();
        driver.quit();
    }

    @Test
    @DisplayName("Раздел «Конструктор»: переход к разделу 'Начинки'")
    @Description("Проверка, что при клике на название 'Начинки' переходим в этот раздел")
    public void apronOfTestsFillingsInBrowsers() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get(mainPage.getUrl());
        driver.manage().window().maximize();
        mainPage.waitHeader();
        transferForFillingsIsActive();
        driver.quit();
        WebDriverManager.chromedriver().driverVersion("104.0.5112.20").setup();
        driver = new ChromeDriver(new ChromeOptions().setBinary(new Config().getYandexBinaryPath()));
        mainPage = new MainPage(driver);
        driver.get(mainPage.getUrl());
        driver.manage().window().maximize();
        mainPage.waitHeader();
        transferForSaucesIsActive();
        driver.quit();
    }
    public void transferForBunsIsActive() {
        mainPage.clickBuns();
        assertEquals("Булки", mainPage.getTextActiveLink());
    }

    public void transferForSaucesIsActive() {
        mainPage.clickSauces();
        assertEquals("Соусы", mainPage.getTextActiveLink());
    }

    public void transferForFillingsIsActive() {
        mainPage.clickFillings();
        assertEquals("Начинки", mainPage.getTextActiveLink());
    }
}
