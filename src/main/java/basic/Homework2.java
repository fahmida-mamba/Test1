package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Homework2 {
    static WebDriver driver;

    public static void main(String[] args) {

        Homework2 homework2 = new Homework2();
        homework2.launchBrowser("chrome");
      // ArrayList<String> element = new ArrayList();

       //element.add("driver.findElement(By.xpath(\"//a[contains(@href,'goldbox')]\")).click();");

       driver.findElement(By.xpath("//a[contains(@href,'goldbox')]")).click();
       driver.findElement(By.xpath("//a[contains(@href,'bestsellers')]")).click();
       driver.findElement(By.xpath("//a[contains(@href,'giftfinder')]")).click();

        homework2.wait5Seconds();
        homework2.quitBrowser();

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



