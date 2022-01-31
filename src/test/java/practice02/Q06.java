package practice02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q06 {

/*
   ...Exercise6...
*/
   static WebDriver driver;
@BeforeClass
    public static void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

}

@Test
public void test() {
    // 1. Amazon.com'a gidelim.
   driver.get("https://Amazon.com");
// 2. DropDown üzerinde Books secelim.(All yazan yerde)
    List<WebElement> list=driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
//    kategorilerin hepsini konsola yazdiralim
    for (WebElement each: list) {
        System.out.println(each.getText());
    }
// 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
   WebElement yaziArama= driver.findElement(By.id("twotabsearchtextbox"));
   yaziArama.sendKeys(" Les Miserables"+ Keys.ENTER);

// 4. Sonuc sayisini ekrana yazdiralim.

    System.out.println(driver.findElement(By.xpath("(//span[@dir='auto'])[1]")).getText());
// 5. Sonucların Les Miserables i icerdigini assert edelim
    driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));

}

@AfterClass
        public static void tearDown(){



}








}
