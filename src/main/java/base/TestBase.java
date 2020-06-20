package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.lang.reflect.Method;


import static base.ExtentTestManager.*;



public class TestBase {
    public static WebDriver driver;
    private static ExtentReports extent;

    @Parameters({"browserName", "os"})
    @BeforeMethod
    public void launchBrowser(String browserName, String os) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            }
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            } else {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        }
        driver.get("https://www.amazon.com");
    }
    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

    //Extent report starts



    //Extent Report Setup

    @BeforeSuite

    public void extentSetup(ITestContext context) {

        ExtentTestManager.setOutputDirectory(context);

        extent = ExtentTestManager.getInstance();

    }



    @BeforeMethod

    public void startExtent(Method method) {

        String className = method.getDeclaringClass().getSimpleName();

        ExtentTestManager.startTest(method.getName());

        ExtentTestManager.getTest().assignCategory(className);

    }



    //Extent Report

    @AfterMethod

    public void afterEachTestMethod(ITestResult result) {

        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));

        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {

            ExtentTestManager.getTest().assignCategory(group);

        }



        if (result.getStatus() == 1) {

            ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE PASSED : " + result.getName());

        } else if (result.getStatus() == 2) {

            ExtentTestManager.getTest().log(LogStatus.FAIL, "TEST CASE FAILED : " + result.getName() + " :: " + getStackTrace(result.getThrowable()));

        } else if (result.getStatus() == 3) {

            ExtentTestManager.getTest().log(LogStatus.SKIP, "TEST CASE SKIPPED : " + result.getName());

        }

        ExtentTestManager.endTest();

        extent.flush();

        if (result.getStatus() == ITestResult.FAILURE) {

            captureScreenshot(driver, result.getName());

        }

    }



    @AfterSuite

    public void generateReport() {

        extent.close();

    }



    // Extent report ends
}


