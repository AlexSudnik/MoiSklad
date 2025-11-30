package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    protected final String VALID_USERNAME = "admin@axudygu";
    protected final String VALID_PASSWORD = "Qwerty12345";
    protected final By LOGIN_FIELD_LOCATOR = By.id("lable-login");
    protected final By PASSWORD_FIELD_LOCATOR = By.id("lable-password");
    protected final By LOGIN_BUTTON_LOCATOR = By.id("submitButton");
    protected final By LOGIN_MISTAKE_ERROR_LOCATOR = By.xpath("//div[@class='error-msg']");
    protected final By FORGOT_PASSWORD_LOCATOR = By.id("restlink");
    public final By RESTORE_PASSWORD_TEXT_LOCATOR = By.xpath("//div[contains(@class, 'b-page-info')]/h1");
    protected final By LOGIN_WITH_1S_BUTTON_LOCATOR = By.cssSelector(".b-button-login-via");
    public final By LOGIN_WITH_1S_LABEL_LOCATOR = By.xpath("//img[@src='/resources/image/logo.png']");
    protected final By SWITCH_TO_ENGLISH_LOCATOR = By.xpath("//a[@href='?lang=en_US']");
    protected final By ENGLISH_VERSION_TEXT_LOCATOR = By.xpath("//div[@class='b-page-info']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(LOGIN_BUTTON_LOCATOR);
    }

    public void open() {
        driver.get(URL);
    }

    public void enterValidLoginAndPassword() {
        driver.findElement(LOGIN_FIELD_LOCATOR).sendKeys(VALID_USERNAME);
        driver.findElement(PASSWORD_FIELD_LOCATOR).sendKeys(VALID_PASSWORD);
    }

    public void clickEnterButton() {
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
    }

    public void enterValidLoginAndEmptyPassword() {
        driver.findElement(LOGIN_FIELD_LOCATOR).sendKeys(VALID_USERNAME);
        driver.findElement(PASSWORD_FIELD_LOCATOR).sendKeys("");
    }

    public String invalidLoginDataMessage() {
        return driver.findElement(LOGIN_MISTAKE_ERROR_LOCATOR).getText();
    }

    public void enterEmptyLoginAndEmptyPassword() {
        driver.findElement(LOGIN_FIELD_LOCATOR).sendKeys("");
        driver.findElement(PASSWORD_FIELD_LOCATOR).sendKeys("");
    }

    public void enterValidLoginAndInvalidPassword() {
        driver.findElement(LOGIN_FIELD_LOCATOR).sendKeys(VALID_USERNAME);
        driver.findElement(PASSWORD_FIELD_LOCATOR).sendKeys("6546435");
    }

    public void forgotPasswordButtonClick() {
        driver.findElement(FORGOT_PASSWORD_LOCATOR).click();
    }

    public String restorePasswordWindowText() {
        return driver.findElement(RESTORE_PASSWORD_TEXT_LOCATOR).getText();
    }

    public void enterWith1sButtonClick() {
        driver.findElement(LOGIN_WITH_1S_BUTTON_LOCATOR).click();
    }

    public boolean logo1sIsDisplayed() {
        return driver.findElement(LOGIN_WITH_1S_LABEL_LOCATOR).isDisplayed();
    }

    public void clickToEnglishSwitcher() {
        driver.findElement(SWITCH_TO_ENGLISH_LOCATOR).click();
    }

    public String textInEnglishVersion() {
        return driver.findElement(ENGLISH_VERSION_TEXT_LOCATOR).getText();
    }
}
