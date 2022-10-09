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

public class TestsLogin {
    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private RegPage regPage;
    private PasswordRecoveryPage passwordRecoveryPage;

    @Test
    @DisplayName("Вход: проверка входа по кнопке «Войти в аккаунт» на главной странице")
    @Description("Переходим по указанной кнопке на страницу логина с заголовком 'Вход'")
    public void apronOfTestsLoginInBrowsers1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get(mainPage.getUrl());
        driver.manage().window().maximize();
        mainPage.waitHeader();
        buttonLogInAccountOnMainPageIsTrue();
        driver.quit();
        WebDriverManager.chromedriver().driverVersion("104.0.5112.20").setup();
        driver = new ChromeDriver(new ChromeOptions().setBinary(new Config().getYandexBinaryPath()));
        mainPage = new MainPage(driver);
        driver.get(mainPage.getUrl());
        driver.manage().window().maximize();
        mainPage.waitHeader();
        buttonLogInAccountOnMainPageIsTrue();
        driver.quit();
    }

    @Test
    @DisplayName("Вход: проверка входа через кнопку «Личный кабинет» на главной странице")
    @Description("Переходим по указанной ссылке на страницу логина с заголовком 'Вход'")
    public void apronOfTestsLoginInBrowsers2() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get(mainPage.getUrl());
        driver.manage().window().maximize();
        mainPage.waitHeader();
        linkPersonalAccountOnMainPageIsTrue();
        driver.quit();
        WebDriverManager.chromedriver().driverVersion("104.0.5112.20").setup();
        driver = new ChromeDriver(new ChromeOptions().setBinary(new Config().getYandexBinaryPath()));
        mainPage = new MainPage(driver);
        driver.get(mainPage.getUrl());
        driver.manage().window().maximize();
        mainPage.waitHeader();
        linkPersonalAccountOnMainPageIsTrue();
        driver.quit();
    }

    @Test
    @DisplayName("Вход: проверка входа через кнопку 'Войти' в форме регистрации")
    @Description("Переходим по указанной ссылке на страницу логина с заголовком 'Вход'")
    public void apronOfTestsLoginInBrowsers3() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        regPage = new RegPage(driver);
        driver.get(regPage.getUrl());
        driver.manage().window().maximize();
        regPage.waitHeader();
        linkEnterOnRegPageIsTrue();
        driver.quit();
        WebDriverManager.chromedriver().driverVersion("104.0.5112.20").setup();
        driver = new ChromeDriver(new ChromeOptions().setBinary(new Config().getYandexBinaryPath()));
        regPage = new RegPage(driver);
        driver.get(regPage.getUrl());
        driver.manage().window().maximize();
        regPage.waitHeader();
        linkEnterOnRegPageIsTrue();
        driver.quit();
    }

    @Test
    @DisplayName("Вход: проверка входа через кнопку 'Войти' в форме восстановления пароля")
    @Description("Переходим по указанной ссылке на страницу логина с заголовком 'Вход'")
    public void apronOfTestsLoginInBrowsers4() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        driver.get(passwordRecoveryPage.getUrl());
        driver.manage().window().maximize();
        passwordRecoveryPage.waitHeader();
        linkEnterOnPasswordRecoveryPageIsTrue();
        driver.quit();
        WebDriverManager.chromedriver().driverVersion("104.0.5112.20").setup();
        driver = new ChromeDriver(new ChromeOptions().setBinary(new Config().getYandexBinaryPath()));
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        driver.get(passwordRecoveryPage.getUrl());
        driver.manage().window().maximize();
        passwordRecoveryPage.waitHeader();
        linkEnterOnPasswordRecoveryPageIsTrue();
        driver.quit();
    }
    public void buttonLogInAccountOnMainPageIsTrue() {
        loginPage = new LoginPage(driver);
        mainPage.clickButtonLogInAccount();
        loginPage.waitHeader();
        assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
    }

    public void linkPersonalAccountOnMainPageIsTrue() {
        loginPage = new LoginPage(driver);
        mainPage.clickLinkPersonalAccount();
        loginPage.waitHeader();
        assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
    }

    public void linkEnterOnRegPageIsTrue() {
        loginPage = new LoginPage(driver);
        regPage.clickLinkEnter();
        loginPage.waitHeader();
        assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
    }

    public void linkEnterOnPasswordRecoveryPageIsTrue() {
        loginPage = new LoginPage(driver);
        passwordRecoveryPage.clickLinkEnter();
        loginPage.waitHeader();
        assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
    }
}
