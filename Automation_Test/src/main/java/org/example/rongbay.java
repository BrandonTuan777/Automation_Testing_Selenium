package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class rongbay {
    public static String baseUrl ="https://rongbay.com";
    public static WebDriver driver = new ChromeDriver();

    Actions action = new Actions(driver);

    public WebElement getPath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public void removeAttribute(WebElement element, String attr) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attr + "')", element);
    }

    public void setAttribute(WebElement element, String attr) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attr + "','')", element);
    }

    @BeforeClass // Open window by chrome driver with base url
    public void setBaseUrl()
    {
        driver.manage().window().maximize(); // Open window with max size
        driver.get(baseUrl);
    }

    @Test (priority = 0)
    public void CreateNewPost() throws  Exception{
        getPath("//a[@title='Đăng tin rao vặt']").click();
        Thread.sleep(2000);

        action.moveToElement(driver.findElement(By.xpath("//ul[@class='choo se_cat_post ']"))).perform();
        Thread.sleep(1000);

        action.moveToElement(driver.findElement(By.linkText("Thuê, Cho thuê nhà"))).perform();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Nhà trọ/ Phòng trọ")).click();
        Thread.sleep(2000);
    }

    @Test (priority = 1)
    public void InputTitle() throws Exception {
        // Input title
        getPath("//input[@id='ad_title']").sendKeys("Cho thuê nhà trọ mặt tiền giá hạt dẻ");
        Thread.sleep(1000);
    }

    @Test (priority = 2)
    public void InputAddress() throws Exception {
        // Select city
        getPath("//select[@name='data[id_cities]']").click();
        Thread.sleep(1000);

        getPath("//option[@value='4']").click();
        Thread.sleep(1000);

        // Select district
        getPath("//select[@id='choose_district']").click();
        Thread.sleep(1000);

        getPath("//option[@value='96']").click();
        Thread.sleep(1000);

        // Select ward
        getPath("//select[@name='data[id_phoenix]']").click();
        Thread.sleep(1000);

        getPath("//option[@value='128']").click();
        Thread.sleep(1000);

        // Select Street
        getPath("//select[@name='data[id_streest]']").click();
        Thread.sleep(1000);

        getPath("//option[@value='1582']").click();
        Thread.sleep(1000);
    }

    @Test (priority = 3)
    public void InputAreaAndPrice() throws  Exception{
        // Input living area
        getPath("//input[@name='data[field_extra][dientich]']").sendKeys("100");
        Thread.sleep(1000);

        // Input price
        getPath("//input[@id='price']").sendKeys("1000000");
        Thread.sleep(1000);

        // Check box
        getPath("//input[@name='data[field_extra][price_tt]']").click();
        Thread.sleep(1000);
    }

    @Test (priority = 4)
    public void InputPostContent() throws  Exception{
        // Input post content
        driver.switchTo().frame("description_ifr");
        getPath("//body[@id='tinymce']").sendKeys("Nhà mặt tiền thoáng mát có wifi, có chỗ để xe, có camera an ninh phòng chống đột nhập, bao điện nước.");
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
    }

    @Test (priority = 5)
    public void SelectAdvantage() throws Exception {
        // Select customers
        getPath("//li[@data-id='62']").click();
        Thread.sleep(1000);

        // Select advantage
        getPath("//li[@data-id='37']").click();
        Thread.sleep(1000);

        getPath("//li[@data-id='40']").click();
        Thread.sleep(1000);

        getPath("//li[@data-id='42']").click();
        Thread.sleep(1000);

        getPath("//li[@data-id='43']").click();
        Thread.sleep(1000);
    }

    @Test (priority = 6)
    public void InputContactInfo() throws Exception{
        // Input name
        getPath("//input[@name='data[job_contact_fullname]']").sendKeys("Dũng");
        Thread.sleep(1000);

        // Input phone
        getPath("//input[@name='data[ad_mobile]']").sendKeys("0902274636");
        Thread.sleep(1000);

        // Input email
        getPath("//input[@name='data[job_contact_email]']").sendKeys("dung@gmail.com");
        Thread.sleep(1000);

        // Click confirm button
        getPath("//input[@id='submit_item_new']").click();
        Thread.sleep(5000);
    }

    @AfterTest // Close window after run all test
    public void endSession()
    {
        driver.quit();
    }
}
