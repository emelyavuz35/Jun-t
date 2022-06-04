package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q3 extends TestBase {
    // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
    
    //-->Task1 Find Dropdown on Multi Selection
    //-->Task2 Find  all Dropdown Elements on page
    //-->Task3 printout DropDown Elements' number
    //-->Task4 choose dropdown elements and printout dropdown elements' name  until choise 6


    @Test
    public void test01() {
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

        WebElement dropDownElements=driver.findElement(By.xpath("(//input[@id='justAnInputBox'])[1]"));
        WebElement dropDownElements1=driver.findElement(By.xpath("(//input[@id='justAnotherInputBox'])[1]"));
        WebElement dropDownElements2=driver.findElement(By.xpath("//*[@id=\"justAnInputBox1\"]"));






    }
}
