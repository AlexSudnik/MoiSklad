package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(String.format("Test started: %s", result.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(String.format("Test success: %s", result.getName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver)result.getTestContext().getAttribute("driver");
        ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        System.out.println(String.format("Test failed: %s", result.getName()));
    }
}
