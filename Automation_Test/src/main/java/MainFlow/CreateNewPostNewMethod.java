package MainFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;

public class CreateNewPostNewMethod {
    public static ChromeOptions option = new ChromeOptions()
            .addArguments("--remote-allow-origins=*");
    public static WebDriver chromeDriver = new ChromeDriver(option);

    public static Actions action = new Actions(chromeDriver);

    @BeforeMethod
    public void Setup() {
        chromeDriver.get("https://rongbay.com/");
    }

    @Test
    public void CreateNewPost() throws Exception {
        Thread.sleep(2000);
        // Click advertise button
        WebElement advertiseBtn = chromeDriver.findElement(By.xpath("//a[text()='Mua quảng cáo']"));
        advertiseBtn.click();

        // CLick create new post with new method
        WebElement createNewPostBtn = chromeDriver.findElement(By.xpath("//p[@class='label tab roboto_medium fa fa-edit ']"));
        createNewPostBtn.click();

        // CLick create new post now button
        WebElement createNewPostNowBtn = chromeDriver.findElement(By.xpath("//a[text()='ĐĂNG TIN NGAY']"));
        createNewPostNowBtn.click();

        Thread.sleep(2000);

        chromeDriver.get("https://touch.rongbay.com/?cmd=dangtin");

        // Input post description
        WebElement descriptionField = chromeDriver.findElement(By.xpath("//textarea[@id='ad_description']"));
        descriptionField.sendKeys("Muốn bán xe đạp đẹp");

        // CLick next button
        WebElement nextButton = chromeDriver.findElement(By.xpath("//button[@type='button']"));
        nextButton.click();

        // Open category
        WebElement categoryDropdown = chromeDriver.findElement(By.xpath("//select[@name='ad_cat_id']"));
        categoryDropdown.click();

        // Select category element
        WebElement categoryEle = chromeDriver.findElement(By.xpath("//option[@value='20']"));
        categoryEle.click();

        // Input price
        WebElement priceField = chromeDriver.findElement(By.xpath("//input[@id='price']"));
        priceField.sendKeys("1000000");

        // Click next button
        nextButton.click();

        // Open city dropdown
        WebElement cityDropdown = chromeDriver.findElement(By.xpath("//select[@name='ad_city_id']"));
        cityDropdown.click();

        // Select city
        WebElement cityEle = chromeDriver.findElement(By.xpath("//option[@value='4']"));
        cityEle.click();

        // Open district dropdown
        WebElement districtDropdown = chromeDriver.findElement(By.xpath("//select[@name='ad_dist_id']"));
        districtDropdown.click();

        // Input phone
        WebElement phoneField = chromeDriver.findElement(By.xpath("//input[@name='ad_mobile']"));
        phoneField.sendKeys("0902883456");

        nextButton.click();

        // Input post's title
        WebElement titleField = chromeDriver.findElement(By.xpath("//input[@id='ad_title']"));
        titleField.sendKeys("Bán xe đạp màu hồng cute dễ thương");

        // Click submit button
        WebElement submitBtn = chromeDriver.findElement(By.xpath("//button[text()='Đăng ngay']"));
        submitBtn.click();

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


