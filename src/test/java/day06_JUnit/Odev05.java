package day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev05 {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");

    }
    @Test
    public void categori(){
        //  - Test 1
        //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

List<WebElement> kategoriSayisi=driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));

 int sayi=45;
if(kategoriSayisi.size()==sayi){
    System.out.println("Kategori sayisi 45'tir");
}else {
    System.out.println("Kategori sayisi 45 degildir");
}
    }
@Test
public void books(){
    //  -Test 2
    //  1. Kategori menusunden Books secenegini secin
   // driver.findElements(By.xpath("//*[@id='searchDropdownBox']")).click();
    driver.findElement(By.xpath("//*[@id='nav-search-dropdown-card']")).click();
    driver.findElement(By.xpath("//*[@id='searchDropdownBox']/option[6]")).click();

    //  2. Arama kutusuna Java yazin ve aratin
   WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
    aramaKutusu.sendKeys("Java"+ Keys.ENTER);

    //  3. Bulunan sonuc sayisini yazdirin
String sonucSayisi=driver.findElement(By.xpath("//*[@id='search']/span/div/span/h1/div/div[1]/div/div/span[1]")).getText();
   String sonucSayisiYaz[]=sonucSayisi.split(" ");
    System.out.println(sonucSayisiYaz[3]);
    //  4. Sonucun Java kelimesini icerdigini test edin
   String javaKelimesi=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
    System.out.println(javaKelimesi);
   String actuelKelime=javaKelimesi.replaceAll("\\D","");
  String expectedKelime="Java";
   if(expectedKelime.contains(actuelKelime)){
       System.out.println("Sonucun Java kelimesinin icerdigi testi PASS");
   }else {
       System.out.println("Sonucun Java kelimesinin icerdigi testi FAILED");
   }
}




    @AfterClass
    public static void tearDown(){
driver.close();
    }

}
