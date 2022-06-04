package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBox {
  static WebDriver driver;
    //1. Bir class oluşturun : CheckBoxTest
    //2.Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
@BeforeClass
    public static void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}
@AfterClass
    public static void tearDown(){
   // driver.close();
}
@Test
    public void test01() throws InterruptedException {
    //verılen web sayfasına gıdın
    //https://theinternet.herokuapp.com/checkboxes
    driver.get("https://the-internet.herokuapp.com/checkboxes");
    //checkbox1 checkbox2 elementlerını locate et
    WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
    WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
    //checkbox1 secılı degılseonay kutusunu tıkla
    if (!checkbox1.isSelected()){
        checkbox1.click();
    }
    if (!checkbox2.isSelected()){
        checkbox2.click();
    }
    Thread.sleep(3000);



}
}

