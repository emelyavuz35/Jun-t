package day12_Seynchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitlyWait extends TestBase {

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_controls adresıne gıdın
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4-Textbox ın etkın(enable) olmadıgını dogrulayın

        WebElement enableKutusu=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(enableKutusu.isEnabled());
        //5-enable butonuna tıklayın ve textbox etkın oluncaya kadar bekleyın

        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.elementToBeClickable(enableKutusu));
        //6-"It's enabled!"mesajının goruntulendıgını dogrulayın
        WebElement ıtIsEnabledYazıElementı=driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
        Assert.assertTrue(enableKutusu.isDisplayed());
        //7-textbox un etkın oldugunu dogrulayın
        Assert.assertTrue(enableKutusu.isEnabled());
    }
}
