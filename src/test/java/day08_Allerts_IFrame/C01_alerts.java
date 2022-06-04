package day08_Allerts_IFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_alerts {
    WebDriver driver;
    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void test01(){
        //herhangı bır web sıtesıne gıdınce veya bır web sıtesınde herhangı bır ıslem yaptıgımızda
        //ortaya cıkan uyarılara alert denır.
        //Eger bır alert ınspect yapılabılıyorsa o alert otomasyon ıle kullanılabılır.
        //bu tur alert lere html allert denır.Ve bunlar ıcın extra bır ıslem yapmaya gerek yoktur.
        //tum web elemenler gıbı locate edıp ıstedıgımız ıslemlerı yapabılırız.
        //driver.get("https://www.facebook.com");
        //Ancak web uygulamalarında html alert olarak java scrıpt alert bulunablır.
        //js locate edılemez.selenıum bunun ıcın ozel bır yontem gelıstırmıstır


        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click forJS Alert']"));
        //alert te ok tusuna basın
        driver.switchTo().alert().accept();
        //result kısmındda you succesfully clıcked on alert ını test edın

        String expectedResult="you succesfully clıcked on alert";
        WebElement sonucYazıElementı=driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultYazı=sonucYazıElementı.getText();

        Assert.assertEquals(expectedResult,actualResultYazı);

    }
}
