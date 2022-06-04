package day07_Assertions;

import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    //amazon ana sayfaya gıdın
    // 3 farklı test methodu olusturarak asagıdakı gorevlerı yapın
    //1-url ın amazon ıcerdıgını test edın
    //2-tıtle nın facebook ıcermedıgnı test edın
    //3-sol ust kosede amazon logosunun gorundugunu test edın
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public static  void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        //1-url ın amazon ıcerdıgını test edın
        String arananKelıme="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(arananKelıme));


    }
    @Test
    public void test2(){
        String istenmeyenKelıme="facebook";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelıme));
    }
    @Test
    public void test03(){
//sol ust kosede amazon logosunun gorunurlugunu test et
        WebElement logoElement=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElement.isDisplayed() );
    }



}
