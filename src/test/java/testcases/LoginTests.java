package testcases;

import base.TestBase;
import org.openqa.selenium.By;

import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    //
//
    public void loginToAmazon() {
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email")).sendKeys("testuser@gmail.com");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.id("ap_password")).sendKeys("mypassword");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }

    public void HeaderAmazon() {
        driver.findElement(By.xpath("//a[contains(@href,'goldbox')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'bestsellers')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'giftfinder')]")).click();
    }


   // @Test

    //public void loginToTiffany(){
      //  driver.get("https://www.tiffany.com");
        //driver.findElement(By.className("account-text")).click();
        //driver.findElement(By.id("txtEmail")).sendKeys("shilpy_126@yahoo.com");
        //driver.findElement(By.id("txtPassword")).sendKeys("Selenium1");
        //driver.findElement(By.id("btnSignIn ")).click();
    }


