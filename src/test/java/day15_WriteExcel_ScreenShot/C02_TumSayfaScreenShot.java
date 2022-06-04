package day15_WriteExcel_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_TumSayfaScreenShot extends TestBase {
    @Test
    public void tumSayfa() throws IOException {

        //amazon sayfasına gıdıp tum sayfanın fotografını cekelım

        driver.get("https://www.amazon.com");
        TakesScreenshot ts=(TakesScreenshot) driver;

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);
        System.out.println(tarih);


        File tumSayfaResim=new File("target/ekranGoruntuleri/tumSayfa.jpeg");

         File grciciDosya=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(grciciDosya,tumSayfaResim);


    }
}
