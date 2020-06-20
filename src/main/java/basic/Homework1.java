package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Homework1 {
    static WebDriver driver;

    public static void main(String[] args) {

        Homework1 homework1 = new Homework1();
        homework1.launchBrowser("chrome", "windows");
        homework1.searchForWomenWinterCoatsAndValidate();
        homework1.waitFor(5);
        homework1.quitBrowser();

    }

    private void searchForWomenWinterCoatsAndValidate(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("women winter coats");
            driver.findElement(By.xpath("//input[@value='Go']")).click();
            boolean result = driver.findElement(By.xpath("//span[@class=\"a-color-state a-text-bold\"]")).isDisplayed();
            if (result == true) {
                System.out.println(result + " : element is displayed");
            } else {
                System.out.println(result + " : elements is not displayed");
            }


        }





    public void launchBrowser(String browserName, String os) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            } else {
                System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
            }
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            } else {
                System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
            }
            driver = new FirefoxDriver();
        }
        driver.get("https://www.amazon.com");
    }

    public void waitFor(int seconds) {

        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void quitBrowser(){driver.quit();}

}




