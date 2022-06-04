package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        //excel dosyasındakı tum verılerı class ımıza alıp bır
        // java oobjesıne store edelım
        //boylece her seferınde excel e ulasıp satır sutun vs ugrasmayalım

        //bır database yapısında olan excel ı koyabılecegımız en uygun java oblesı map  tir


        Map<String,String> ulkelerMap=new HashMap<>();
        // 7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        // 8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim

        // 10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);
        int sonSatırIndex=workbook.getSheet("Sayfa1").getLastRowNum();//son satır ındexını getırecek

        for (int i = 0; i <=sonSatırIndex ; i++) {
            //key i. satırdakı 0 index ındekı data olacak
            String key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            //value ıse i. satırdakı 1 2 ve 3. ındex tekı dataların bırlesımı olacak

            String value=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString()
                             +", "
                            +workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString()
                            +", "
                             +workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            ulkelerMap.put(key,value);
            System.out.println(ulkelerMap);

            //Listede Ghana oldugunu test edelım
            Assert.assertTrue(ulkelerMap.keySet().contains("Ghana"));
        }


    }
}
