package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YouTubeTesti {
static WebDriver driver;

@BeforeClass
    public static void setUp(){
    //    1) Bir class oluşturun: YoutubeAssertions
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    //    2) https://www.youtube.com adresine gidin
    driver.get("https://www.youtube.com");
    driver.findElement(By.xpath("(//yt-formatted-string[@class='style-scope ytd-button-renderer style-primary size-default'])[2]")).click();


}
    //    3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
@Test
    public void titleTesti(){
    //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    String actuelTitle=driver.getTitle();
    String expectedTitle="YouTube";
    Assert.assertEquals(expectedTitle,actuelTitle);



    }
    @Test
    public void imageTesti(){
        //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    WebElement acrtuelImage=driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-logo'])[1]"));
    Assert.assertTrue(acrtuelImage.isDisplayed());
    }
    @Test
    public void searchBoxTesti(){
        //    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTestTesti(){
//    ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualWrongTitle=driver.getTitle();
        String expectedWrongTitle="youtube";

        Assert.assertFalse(expectedWrongTitle.contains(actualWrongTitle));
    }


@AfterClass
public static void tearDown(){
driver.close();

}


}
