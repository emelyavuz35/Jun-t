package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com");

    }
    @Test
    public void titleTest(){
        Assert.assertTrue("title best kelımesı icermiyor",driver.getTitle().contains("Best"));
    }
    @Test
    public void logoTest(){
       // WebElement logoBestBuy=driver.findElement(By.xpath("//img[@class='logo']"));
        WebElement helloHeading= driver.findElement(By.xpath("//div[@class='heading']"));
       // WebElement logoBestBuy

    }
    @Test
    public void mexicoLinkTest(){

    }



    @After
    public void kapat(){
        driver.close();
    }
}
