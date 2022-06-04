package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));
        //bana ıcınde oldugum projenın dosya yolunu path verır
      //  C:\Users\Casper\IdeaProjects\com.Batch59JUnit\src\test\java\day05_JUnit
        System.out.println(System.getProperty("user.home"));
        //C:\Users\Casper benım bılgısayarımın bana ozel kısmını verdı

        //C:\Users\Casper\Downloads
        //C:\Users\Casper\IdeaProjects\com.Batch59JUnit\src\test\java\day05_JUnit

        //homepath+"/Downloads"

        //masaustundekı text dosyasının varlıgını test edelım
        //C:\Users\Casper\Desktop\text.txt
        String dosyayolu=System.getProperty("user.home")+"\\Desktop\\text.txt";
        System.out.println(dosyayolu);


        /*
        bılgısayarımızdakı bır dosyanın varlıgını test edtmek ıcın once o dosyaya ulasmamız gerekır
        java da dosyaya erısım ıcın dosya yoluna yanı path e  ıhtıyac vardır.
        her bılgısayarın kullanıcı adı farklı olacagından masa ustu dosya yolu da bırbırınden farklı olacaktır.
        tesklerımızın tum bılgısayarlarda calısması ıcın dosya yolunu dınamık yapmak zorundayız
        bunun ıcın
        her bılgısayarın bırbırınden farklı olan yolunu bulmak ıın

         */
         String farklıKısım=System.getProperty("user.home");

        // herkesın bılgısayarında ortak olan kısım ıse
         String ortakKısım="\\Desktop\text.txt";
         String dosyaYolu=farklıKısım+ortakKısım;

        String masaUstuDosyaYolu=farklıKısım+ortakKısım;

        Assert.assertTrue(Files.exists(Paths.get(masaUstuDosyaYolu)));

    }
}
