package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {

    ChromeDriver chromeDriver;

    @BeforeMethod
    public void Setup() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        chromeDriver.get("https://rongbay.com/");

    }

    @Test
    public void CreateNewPost() {
        Actions action = new Actions(chromeDriver);

        WebElement createPostBtn = chromeDriver.findElement(By.xpath("//a[@class='btnAdvertise_dt seo1554191484']"));
        createPostBtn .click();

        WebElement hoverMuaBanNhaDat = chromeDriver.findElement(By.xpath("//*[@id=\"PostAllForm\"]/div[2]/div/ul/li[2]"));
        action.moveToElement(hoverMuaBanNhaDat).perform();

        WebElement nhaRiengBtn = chromeDriver.findElement(By.xpath("//ul[@class='step_3 group_15']//a[contains(text(),'Nhà riêng')]"));
        nhaRiengBtn.click();
        sleep(3000);

        WebElement titleField = chromeDriver.findElement(By.id("ad_title"));
        titleField.sendKeys("Nhà của Thi");

        WebElement citiDropdown = chromeDriver.findElement(By.name("data[id_cities]"));
        citiDropdown.click();

        WebElement selectCity = chromeDriver.findElement(By.xpath("//option[@value='4']"));
        selectCity.click();

        WebElement districtDropdown = chromeDriver.findElement(By.name("data[id_districs]"));
        districtDropdown.click();

        WebElement selectDistrict = chromeDriver.findElement(By.xpath("//option[@value='99']"));
        selectDistrict.click();

        WebElement postName = chromeDriver.findElement(By.id("project_user_post_name"));
        postName.sendKeys("Nhà 4 tầng");

        WebElement acreageField = chromeDriver.findElement(By.name("data[field_extra][dientich]"));
        acreageField.sendKeys("100");

        WebElement priceField = chromeDriver.findElement(By.id("price_bds"));
        priceField.sendKeys("10");

        WebElement unitPrice = chromeDriver.findElement(By.name("data[field_extra][price_tt]"));
        unitPrice.click();

        WebElement descriptionIframe = chromeDriver.findElement((By.id("description_ifr")));
        chromeDriver.switchTo().frame(descriptionIframe);

        WebElement descriptionField = chromeDriver.findElement(By.id("tinymce"));
        descriptionField.sendKeys("Đây là nhà có 4 tầng, có 3 phòng ngủ 4 nhà vệ sinh," +
                " 1 phòng khách, 1 nhà bếp, chỗ để xe rộng rãi, có sân thoáng mát");

        chromeDriver.switchTo().defaultContent();

        WebElement selectDirection = chromeDriver.findElement(By.xpath(" //li[@title='Đông']"));
        selectDirection.click();

        WebElement houseFront = chromeDriver.findElement(By.xpath("//li[@title=\"Từ 7-10m\"]"));
        houseFront.click();

        WebElement legalDocuments = chromeDriver.findElement(By.xpath("//li[@title=\"Có sổ đỏ/ hồng\"]"));
        legalDocuments.click();

        WebElement nameFiled = chromeDriver.findElement(By.name("data[job_contact_fullname]"));
        nameFiled.sendKeys("Nguyễn Văn Phùng");

        WebElement phoneFiled = chromeDriver.findElement(By.name("data[ad_mobile]"));
        phoneFiled.sendKeys("0888700931");

        WebElement emailField = chromeDriver.findElement(By.name("data[job_contact_email]"));
        emailField.sendKeys("phung@gmail.com");

        WebElement submitBtn = chromeDriver.findElement(By.id("submit_item_new"));
        submitBtn.click();
        sleep(2000);

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

