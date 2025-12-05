package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.TestListener;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homepage;
    AccountPage accountPage;

    @BeforeMethod
    public void setUp(ITestContext testContext) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        //options.addArguments("--headless");
        options.addArguments("--incognito");
        //options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));

        testContext.setAttribute("driver", driver);

        loginPage = new LoginPage(driver);
        homepage = new HomePage(driver);
        accountPage = new AccountPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}