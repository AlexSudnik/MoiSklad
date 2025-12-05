package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    protected final By LOGIN_FIELD_BY = By.id("lable-login");
    protected final By PASSWORD_FIELD_BY = By.id("lable-password");
    protected final By LOGIN_BUTTON_BY = By.id("submitButton");
    protected final By LOGIN_MISTAKE_ERROR_BY = By.xpath("//div[@class='error-msg']");
    protected final By FORGOT_PASSWORD_BY = By.id("restlink");
    public final By RESTORE_PASSWORD_TEXT_BY = By.xpath("//div[contains(@class, 'b-page-info')]/h1");
    protected final By LOGIN_WITH_1S_BUTTON_BY = By.cssSelector(".b-button-login-via");
    public final By LOGIN_WITH_1S_LABEL_BY = By.xpath("//img[@src='/resources/image/logo.png']");
    protected final By SWITCH_TO_ENGLISH_BY = By.xpath("//a[@href='?lang=en_US']");
    protected final By ENGLISH_VERSION_TEXT_BY = By.xpath("//div[@class='b-page-info']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(LOGIN_BUTTON_BY);
    }

    public void open() {
        driver.get(URL);
    }

    public void enterLogin(String login){
        driver.findElement(LOGIN_FIELD_BY).sendKeys(login);
    }

    public void enterPassword(String password){
        driver.findElement(PASSWORD_FIELD_BY).sendKeys(password);
    }

    public void clickEnterButton() {
        driver.findElement(LOGIN_BUTTON_BY).click();
    }

    public String invalidLoginDataMessage() {
        return driver.findElement(LOGIN_MISTAKE_ERROR_BY).getText();
    }

    public void forgotPasswordButtonClick() {
        driver.findElement(FORGOT_PASSWORD_BY).click();
    }

    public String restorePasswordWindowText() {
        return driver.findElement(RESTORE_PASSWORD_TEXT_BY).getText();
    }

    public void enterWith1sButtonClick() {
        driver.findElement(LOGIN_WITH_1S_BUTTON_BY).click();
    }

    public boolean logo1sIsDisplayed() {
        return driver.findElement(LOGIN_WITH_1S_LABEL_BY).isDisplayed();
    }

    public void clickToEnglishSwitcher() {
        driver.findElement(SWITCH_TO_ENGLISH_BY).click();
    }

    public String textInEnglishVersion() {
        return driver.findElement(ENGLISH_VERSION_TEXT_BY).getText();
    }
}
