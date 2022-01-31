package practice02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q02 {
      /*
...Exercise2...
   http://www.bestbuy.com 'a gidin,
   Sayfa basliginin "Best" icerdigini(contains) dogrulayin
   Ayrica Relative Locator kullanarak;
       logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
       mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin

*/
      static  WebDriver driver;
      @BeforeClass
      public static void set_up(){
          WebDriverManager.chromedriver().setup();
          driver=new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      }

    @Test
    public void titleTest(){
        //http://www.bestbuy.com 'a gidin,
        //   Sayfa basliginin "Best" icerdigini(contains) dogrulayin
        driver.get("http://www.bestbuy.com");
        String actualTitle=driver.getTitle();
       Boolean iceriyorMu=actualTitle.contains("Best");
        Assert.assertTrue("Title Best kelimesi icermiyor",iceriyorMu);
    }
    @Test
    public void logoTest(){
        //  logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
        WebElement helloWebElementi=driver.findElement(By.xpath("//div[text()='Bonjour!']"));
        WebElement logo=driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloWebElementi));
      //  boolean logoGorunuyorMu= logo.isDisplayed();
        //Assert.assertTrue(logoGorunuyorMu);
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void linkTest(){
        //mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
        WebElement usaWebElementi=driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
      // WebElement logoMexico=driver.findElement(RelativeLocator.with(By.tagName("h4")).above(usaWebElementi));
      //Assert.assertTrue(logoMexico.isDisplayed());

      }


@AfterClass
public static void tearDown(){

         // driver.close();
}
}