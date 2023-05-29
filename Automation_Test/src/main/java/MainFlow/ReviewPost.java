package MainFlow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReviewPost {
    ChromeDriver chromeDriver;
    @BeforeMethod
    public void Setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions option = new ChromeOptions().addArguments("--remote-allow-origins=*");

        chromeDriver = new ChromeDriver(option);

        chromeDriver.get("https://rongbay.com/");
    }

    @Test
    public void ReviewPost(){
        
    }
}
