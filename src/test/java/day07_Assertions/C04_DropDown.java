package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDown {
    /*
    amazona gıdıp dropdown dan books secenegını secıp java aratalım
    ve arama sonuclarının java ıcerdıgını test edın
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.amazon.com");
    }
    @AfterClass
    public static void tearDown(){
       // driver.close();
    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://www.amazon.com");
        //dropdown dan bır optıon secmek ıcın 3 adım vardır
        //1- dropdown ı locate etmek
        WebElement dropdownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2-bır select objesı olusturup
        //parametre olarak bır oncekı adımda locate ettıgımız ddm yı gırelım
        Select select=new  Select(dropdownMenu);
        //3-dropDown da var olan optıonlardan ıstedıgımız bır taneyı secelım
        select.selectByVisibleText("Books");
        //select.deselectByIndex(5);
        //select.selectByValue("search-alias=stripbooks-intl-ship");

        //arama kutusuna java yazdıralım
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        Thread.sleep(3000);

        WebElement sonucYazisiElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small]"));
        String sonucYazısıStr=sonucYazisiElementi.getText();
        String arananKelıme="Java";
        Assert.assertTrue(sonucYazısıStr.contains(arananKelıme));
        Thread.sleep(5000);






    }
}
