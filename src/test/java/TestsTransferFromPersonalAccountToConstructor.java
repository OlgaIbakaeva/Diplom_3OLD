import config.Config;
import pageobjects.*;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.assertEquals;

public class TestsTransferFromPersonalAccountToConstructor {
    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на ссылку «Конструктор»")
    @Description("Проверка перехода по указанной ссылке на главную страницу с конструктором")
    public void apronOfTestsConstructorInBrowsers1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get(loginPage.getUrl());
        driver.manage().window().maximize();
        loginPage.waitHeader();
        transferOnLinkConstructorIsTrue();
        driver.quit();
        WebDriverManager.chromedriver().driverVersion("104.0.5112.20").setup();
        driver = new ChromeDriver(new ChromeOptions().setBinary(new Config().getYandexBinaryPath()));
        loginPage = new LoginPage(driver);
        driver.get(loginPage.getUrl());
        driver.manage().window().maximize();
        loginPage.waitHeader();
        transferOnLinkConstructorIsTrue();
        driver.quit();
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    @Description("Проверка перехода по клику на логотип на главную страницу с конструктором")
    public void apronOfTestsConstructorInBrowsers2() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get(loginPage.getUrl());
        driver.manage().window().maximize();
        loginPage.waitHeader();
        transferOnLogoIsTrue();
        driver.quit();
        WebDriverManager.chromedriver().driverVersion("104.0.5112.20").setup();
        driver = new ChromeDriver(new ChromeOptions().setBinary(new Config().getYandexBinaryPath()));
        loginPage = new LoginPage(driver);
        driver.get(loginPage.getUrl());
        driver.manage().window().maximize();
        loginPage.waitHeader();
        transferOnLogoIsTrue();
        driver.quit();
    }
    public void transferOnLinkConstructorIsTrue() {
        mainPage = new MainPage(driver);
        loginPage.clickLinkConstructor();
        mainPage.waitHeader();
        assertEquals(mainPage.getUrl()+"/", driver.getCurrentUrl());
    }

    public void transferOnLogoIsTrue() {
        mainPage = new MainPage(driver);
        loginPage.clickLogo();
        mainPage.waitHeader();
        assertEquals(mainPage.getUrl()+"/", driver.getCurrentUrl());
    }
}
