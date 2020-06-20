package basic;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework3 extends TestBase {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.tiffany.com");
        driver.findElement(By.className("account-text")).click();
        driver.findElement(By.id("txtEmail")).sendKeys("shilpy_126@yahoo.com");
        driver.findElement(By.id("txtPassword")).sendKeys("Selenium1");
        driver.findElement(By.id("btnSignIn ")).click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }


}