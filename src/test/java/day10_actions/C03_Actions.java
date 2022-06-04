package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {
    @Test
    public void test01(){
        // 1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement cizgiliElement= driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliElement).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //    test edelim.
        String expectedYazı="You selected a context menu";
        String actualYazı=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazı,actualYazı);


        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWHDegeri=driver.getWindowHandle();
        driver.findElement(By.xpath("//[*text()'Elemental Selenıum'] ")).click();
        Set<String> handleSet=driver.getWindowHandles();
        String ikinciSayfaWindowHD="";
        System.out.println(handleSet);
        for (String each:handleSet
             ) {
            if (!each.equals(ikinciSayfaWindowHD)){
                ikinciSayfaWindowHD=each;
            }
        }
        //acılan sayfada h1 tag ında "Elemenatl Selenıum " yazdıgını test edelım
        driver.switchTo().window(ikinciSayfaWindowHD);
        WebElement yazıElementı=driver.findElement(By.tagName("h1"));
    }
}
