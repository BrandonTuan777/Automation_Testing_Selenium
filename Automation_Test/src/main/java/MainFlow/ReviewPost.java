package MainFlow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class ReviewPost {
    public static ChromeOptions option = new ChromeOptions()
            .addArguments("--remote-allow-origins=*");
    public static WebDriver chromeDriver = new ChromeDriver(option);

    @BeforeClass
    public void Setup() {
        chromeDriver.get("https://rongbay.com/");
    }

    @Test
    public void ReviewPost() {
        Actions action = new Actions(chromeDriver);

        // Click Arrow Button
        WebElement arrowDropDown= chromeDriver.findElement(By.className("icon_province"));
        arrowDropDown.click();

        //Click region button "Hai Phong"
        WebElement region= chromeDriver.findElement(By.xpath("//b[contains(text(),'Hải Phòng')]"));
        region.click();

        //Click element Xe may xe dap
        List <WebElement> choice= chromeDriver.findElements(By.xpath("//a[@class=\"Item\"]"));
        long countElements=choice.size();
        for(int i=0;i<countElements;i++){
            try {
                choice.get(3).click();
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale Element Reference" + e);
            }
        }

        sleep(5000);

        // Click element trong page xe may xe dap
        List <WebElement> choice2= chromeDriver.findElements(By.xpath("//a[@class='rd_view newsTitle float_l']"));
        long countElements2=choice2.size();
        for(int i=0;i<countElements2;i++){
            try {
                choice2.get(4).click();
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale Element Reference" + e);
            }
        }



    }

    private void sleep(int time){
        try{
            Thread.sleep(time);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
