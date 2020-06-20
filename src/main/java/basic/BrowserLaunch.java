package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch {
    public static void main(String[] args) {
        // IllegalStateException -- The path to the driver executable must be set by the webdriver.chrome.driver system property
        // key--webdriver.chrome.driver, value--src/main/resources/chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //launch browser & goes to the url provided
        //Creating object of a class called WebDriver
        WebDriver driver = new ChromeDriver();//It is not WebDriver cause WebDriver is a interface and we cannot create object of a interface
        //Launch FireFox
        // WebDriver driver1 = new FirefoxDriver();
        //It is a method which launch your driver & went to URL
        driver.get("https://www.amazon.com");
        //Surrounding by try and catch for exception
        try {
            Thread.sleep(5000);//It is a method which keeps wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //quites the browser
        driver.quit();//--its a method

    }

}
