package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_webTables extends TestBase {
    @Test
    public void dinamikYazıcı() {
        //oncekı class a gıdıp
        //gırıs yap methodunu kullaanrak sayfaya gırıs yapın
        //ınput olarak verılen satır sayısı ve sutun sayısına sahıp celldekı text ı yazdırın

        int satir=3;
        int sutun=5;

        driver.get(" https://www.hotelmycamp.com");
        C02_WebTable obj=new C02_WebTable();
        obj .girisYap();

        WebElement arananCell=driver.findElement(By.xpath("//tbody//tr[3]//td[5]"));
        System.out.println(arananCell.getText());
    }
    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }
}
