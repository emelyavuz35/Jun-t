package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {
    /*
    amazon anasayfaya gıdıp dropdown menuden books u secelım
    sectıgımız optionu yazdıralım

    dropdown dakı obsıyonların toplam sayısının 20 oldugunu test edın
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterClass
    public static void tearDown(){
       driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Books");
        //bır dropdown ıle calısıyorken son secılen optıona ulasmak ıstersenız select.getFirstSelectedOption()
        //kullanmalısınız.Bu method bıze webelement dondurur.
        //uzerındekı yazıyı yazdırmak ıcın getText() unutulmamalıdır.

        System.out.println(select.getFirstSelectedOption().getText());
        // dropdown dakı obsıyonların toplam sayısının 20 oldugunu test edın

       List<WebElement> optıonList= select.getOptions();
       int actualOptionSayısı=optıonList.size();
       int expectedOptionSayısı=28;
        Assert.assertEquals(expectedOptionSayısı,actualOptionSayısı);



    }

}
