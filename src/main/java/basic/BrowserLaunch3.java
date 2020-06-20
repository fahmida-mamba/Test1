package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch3 {

    static WebDriver driver;

    public static void main(String[] args) {

        BrowserLaunch3 browserLaunch3 = new BrowserLaunch3();
        browserLaunch3.launchBrowser("chrome");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java Books");
        browserLaunch3.wait5Seconds();
        browserLaunch3.quitBrowser();

    }

    public void launchBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.get("https://www.amazon.com");
    }

    public void wait5Seconds() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

    }

    public void quitBrowser(){driver.quit();}

}




