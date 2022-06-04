package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTesti() throws IOException {
        //input olarak verılen satır no
        //sutun no
        //degerlerını parametre olarak alıp
        // o cell dekı datayı string olarak bana donduren bır method olusturun

        int satırNo=12;
        int sutunNo=2;

        // donen string in cezayir oldugunu test edın

        String expectedData="Baku";

       String actualData= banaDataGetir(satırNo-1,sutunNo-1);//cunku excel ındex ıle calısır
        Assert.assertEquals(expectedData,actualData);
    }

    public static String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {
        String istenenData="";
        String DosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(DosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        istenenData=workbook
                .getSheet("Sayfa1")
                .getRow(satirIndex)
                .getCell(sutunIndex)
                .toString();



        return istenenData;
    }
}
