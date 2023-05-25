package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class MuaBan {
    public static String baseUrl ="https://muaban.net/?gidzl=zF4-UlsHEI_ow3jz-8S_B_FWEtFWX3jslB8xAhI4QY-_jMWjvz0uA-wnCt-oX3Cklh0mUc8zLpDa-vOzB0";
    public static WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

    public WebElement getPath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    @BeforeClass // Open window by chrome driver with base url
    public void setBaseUrl()
    {
        driver.manage().window().maximize(); // Open window with max size
        driver.get(baseUrl);
    }

    @Test (priority = 0)
    public void Login() throws Exception {
        driver.findElement(By.xpath("//button[@class='sc-18oo25t-9 kiHQrM']//span[@class='sc-1vo1n72-0 sc-1f1ueip-0 fpHzhT kgayrJ']")).click();
        Thread.sleep(3000);

        getPath("//input[@name='phone']").sendKeys("0902883759");
        Thread.sleep(1000);

        getPath("//input[@name='password']").sendKeys("dinhthi3105");
        Thread.sleep(1000);

        getPath("//button[@class='sc-1pn7ybv-0 sc-1pn7ybv-3 jLpDkO guDaOL']").click();
        Thread.sleep(2000);
    }

    @Test (priority = 1)
    public void CreateNewPost() throws Exception {
        // Create button
        WebElement createBtn = getPath("//button//span[@class='sc-1vo1n72-0 sc-1f1ueip-0 fpHzhT hAIFiU']");
        createBtn.click();
        Thread.sleep(3000);

        // Click danh mục
        WebElement categoryList =  getPath("//div[@class='sc-5fp63n-5 fOhFor']");
        categoryList.click();
        Thread.sleep(3000);

        // Click Bất động sản
        getPath("//img[@src='/_next/image?url=%2Ficons%2Fcategory%2Fc3.png&w=96&q=75']").click();
        Thread.sleep(1000);

        // Click Cho thuê
        List<WebElement> ListCategory1 = driver.findElements(
                By.xpath("//div[@class='sc-12fxoq3-7 bJOETV mb-scroll-y']//div[@class='sc-12fxoq3-4 hyuWUa']"));
        long countElement = ListCategory1.size();
        for(int i = 0; i< countElement; i++) {
            try {
                ListCategory1.get(1).click();
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale Element Reference" + e);
            }
        }
        Thread.sleep(1000);

        // Click Nhà trọ
        List<WebElement> ListCategory2 = driver.findElements(By.xpath("//div[@class='sc-12fxoq3-7 bJOETV mb-scroll-y']//div[@class='sc-12fxoq3-4 hyuWUa']"));
        long countElement2 = ListCategory2.size();
        for(int i = 0; i< countElement2; i++) {
            try {
                ListCategory2.get(2).click();
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale Element Reference" + e);
            }
        }
        Thread.sleep(2000);
    }

    @Test (priority = 2)
    public void InputLocationInfo() throws Exception {
        // Input City
        getPath("//div[@id='city_id']//div[@class='sc-5fp63n-5 fOhFor']").click();
        Thread.sleep(1000);

//        getPath("//input[@class='sc-12qow75-7 fYerli']").
//                ("TP.HCM");
//        Thread.sleep(1000);

        getPath("//div[@class='sc-12qow75-2 kEyocY']").click();
        Thread.sleep(1000);

        // Input District
        getPath("//div[@id='district_id']//div[@class='sc-5fp63n-5 fOhFor']").click();
        Thread.sleep(1000);

        getPath("//input[@class='sc-12qow75-7 fYerli']").sendKeys("4");
        Thread.sleep(1000);

        getPath("//div[@class='sc-12qow75-2 kEyocY']").click();
        Thread.sleep(1000);

        // Input Ward
        getPath("//div[@id='ward_id']//div[@class='sc-5fp63n-5 fOhFor']").click();
        Thread.sleep(1000);

        getPath("//input[@class='sc-12qow75-7 fYerli']").sendKeys("16");
        Thread.sleep(1000);

        getPath("//div[@class='sc-12qow75-2 kEyocY']").click();
        Thread.sleep(1000);

        // Input Street name
        getPath("//div[@id='street_id']//div[@class='sc-5fp63n-5 fOhFor']").click();
        Thread.sleep(1000);

        getPath("//input[@class='sc-12qow75-7 fYerli']").sendKeys("Tôn Thất Thuyết");
        Thread.sleep(1000);

        getPath("//div[@class='sc-12qow75-2 kEyocY']").click();
        Thread.sleep(1000);

        // Input street number
        getPath("//input[@name='street_number']").sendKeys("92/10");
        Thread.sleep(1000);

        getPath("//input[@name='street_number_display']").click();
        Thread.sleep(1000);
    }
    @Test (priority = 3)
    public void InputBasicInfo() throws Exception{
        // Input living area
        getPath("//input[@name='living_area']").sendKeys("100");
        Thread.sleep(1000);

        // Input price
        getPath("//input[@name='price']").sendKeys("1500000");
        Thread.sleep(1000);

        // Input features
        getPath("//div[@id='features']").click();
        Thread.sleep(1000);

        getPath("//input[@name='Mặt tiền']").click();
        Thread.sleep(1000);

        getPath("//button[@class='sc-259jba-8 cckiJc']").click();
        Thread.sleep(1000);
    }

    @Test (priority = 4)
    public void InputPostContent() throws Exception {
        getPath("//input[@name='title']").sendKeys("Cho thuê nhà trọ tiện nghi ngay mặt tiền");
        Thread.sleep(1000);

        getPath("//textarea[@name='body']").
                sendKeys("Nhà mặt tiền thoáng mát có wifi, có chỗ để xe, có camera an ninh phòng chống đột nhập, bao điện nước.");
        Thread.sleep(1000);

        getPath("//button[@class='sc-f1un1v-4 etAArU']").click();
        Thread.sleep(3000);
    }

    @AfterTest // Close window after run all test
    public void endSession()
    {
        driver.quit();
    }
}

