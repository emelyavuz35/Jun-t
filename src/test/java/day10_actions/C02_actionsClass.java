package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_actionsClass extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //amazon anasyfaya gıt

        //account menusunden create a list locate et
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement accountLinki=driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        actions.moveToElement(accountLinki).perform();

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        Thread.sleep(5000);
    }
}
