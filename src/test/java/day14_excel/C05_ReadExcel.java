package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {

    @Test
    public void readExcelTeast() throws IOException {
        // 7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        // 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim

        // 10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);


        //sayfa 2 ye gıdıp
        // satır sayısının 24 kullanılan satır sayısının 12 oldugunu test edın

        int sonSatırIndex=workbook
                .getSheet("Sayfa2")
                .getLastRowNum();

        int expectedSatırSayısı=24;
        Assert.assertEquals(expectedSatırSayısı,sonSatırIndex+1);



        int kullanılanSatırSayısı=workbook
                .getSheet("Sayfa2")
                .getPhysicalNumberOfRows();

        int expectedKullanılanSatırSayısı=12;
        Assert.assertEquals(expectedKullanılanSatırSayısı,kullanılanSatırSayısı);
    }
}
