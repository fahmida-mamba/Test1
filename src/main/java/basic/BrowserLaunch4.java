package basic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch4 {
    private static WebDriver driver;

    public static void main(String[] args) {
        BrowserLaunch4 browserLaunch4 = new BrowserLaunch4();
        browserLaunch4.launchBrowser("chrome", "windows");

        //Locators :
        //id, xpath, className, cssSelector, linkText, partialLinkText, name, tagName
        //type
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java Books");
        //click
        driver.findElement(By.xpath("//input[@value='Go']")).click();
        //input[@value='Go']
        // -- starts with double slash
        // --tag name of that line
        // [ --square bracket start
        //@key='value'
        // ] --square bracket end
        browserLaunch4.waitFor(2);
        boolean result=driver.findElement(By.xpath("//input[@value='Go']")).isDisplayed();

        if (result == true) {
            System.out.println(result + " : element is displayed");
        } else {
            System.out.println(result + " : element is not displayed");
        }

        browserLaunch4.waitFor(5);
        browserLaunch4.quitBrowser();
    }

    public void launchBrowser(String browserName, String os) {
        //chrome
        if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            }
            driver = new ChromeDriver();
        }
        //firefox
        else if (browserName.equalsIgnoreCase("firefox")) {
            if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            } else {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        }
        //browser opens & navigate to the url
        driver.get("https://www.amazon.com");
    }
    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void quitBrowser() {
        driver.quit();
    }

}
