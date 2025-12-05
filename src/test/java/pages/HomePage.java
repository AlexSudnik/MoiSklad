package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    protected final By HOMEPAGE_BY = By.xpath("//div[@class='col-VTbsq_']/h1");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(HOMEPAGE_BY);
    }
}
