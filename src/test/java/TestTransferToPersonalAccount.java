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

public class TestTransferToPersonalAccount {
    private WebDriver driver;
    private MainPage mainPage;

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Проверка перехода в 'Личный кабинет' с главной страницы")
    public void apronOfTestsPersonalAccountInBrowsers() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get(mainPage.getUrl());
        driver.manage().window().maximize();
        mainPage.waitHeader();
        transferPersonalAccountIsTrue();
        driver.quit();
        WebDriverManager.chromedriver().driverVersion("104.0.5112.20").setup();
        driver = new ChromeDriver(new ChromeOptions().setBinary(new Config().getYandexBinaryPath()));
        mainPage = new MainPage(driver);
        driver.get(mainPage.getUrl());
        driver.manage().window().maximize();
        mainPage.waitHeader();
        transferPersonalAccountIsTrue();
        driver.quit();
    }

    public void transferPersonalAccountIsTrue() {
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickLinkPersonalAccount();
        loginPage.waitHeader();
        assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
    }
}
