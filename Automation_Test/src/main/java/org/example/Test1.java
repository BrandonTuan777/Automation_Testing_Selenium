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
    private WebElement input1;
    private WebElement input11;

    String input = "abc123.126%^&";
    String expect = "123.126";

    public void removeAtrribute(WebElement element, String attr) {
        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].removeAttribute('" + attr + "')", element);
    }

    public void setAtrribute(WebElement element, String attr) {
        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].setAttribute('" + attr + "','')", element);
    }


    @BeforeMethod
    public void Setup() {

        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));


    }

    @Test
    public void Run() {
        Actions action = new Actions(chromeDriver);
        chromeDriver.get("https://rongbay.com/");

        WebElement el1 = chromeDriver.findElement(By.xpath("//a[@class='btnAdvertise_dt seo1554191484']"));
        el1.click();

        WebElement el2 = chromeDriver.findElement(By.xpath("//*[@id=\"PostAllForm\"]/div[2]/div/ul/li[2]"));
        action.moveToElement(el2).perform();

        WebElement el3 = chromeDriver.findElement(By.xpath("//ul[@class='step_3 group_15']//a[contains(text(),'Nhà riêng')]"));
        el3.click();
        sleep(3000);

        WebElement el4 = chromeDriver.findElement(By.id("ad_title"));
        el4.sendKeys("Nhà của Thi");

        WebElement el5 = chromeDriver.findElement(By.name("data[id_cities]"));
        el5.click();

        WebElement el6 = chromeDriver.findElement(By.xpath("//option[@value='4']"));
        el6.click();
        WebElement el67 = chromeDriver.findElement(By.name("data[id_districs]"));
        el67.click();
        WebElement el68 = chromeDriver.findElement(By.xpath("//option[@value='99']"));
        el68.click();

        WebElement el7 = chromeDriver.findElement(By.id("project_user_post_name"));
        el7.sendKeys("Nhà 4 tầng của Thi 10 tỷ");

        WebElement el8 = chromeDriver.findElement(By.name("data[field_extra][dientich]"));
        el8.sendKeys("100");

        WebElement el9 = chromeDriver.findElement(By.id("price_bds"));
        el9.sendKeys("10");

        WebElement el10 = chromeDriver.findElement(By.name("data[field_extra][price_tt]"));
        el10.click();

//

        WebElement el11=chromeDriver.findElement((By.id("description_ifr")));
        chromeDriver.switchTo().frame(el11);

        WebElement el12 = chromeDriver.findElement(By.id("tinymce"));
        el12.sendKeys("1111");

        chromeDriver.switchTo().defaultContent();


        WebElement el13 = chromeDriver.findElement(By.xpath(" //li[@title='Đông']"));
        el13.click();

        WebElement el14 = chromeDriver.findElement(By.xpath("//li[@title=\"Từ 7-10m\"]"));
        el14.click();

        WebElement el15 = chromeDriver.findElement(By.xpath("//li[@title=\"Có sổ đỏ/ hồng\"]"));
        el15.click();
        WebElement el16 = chromeDriver.findElement(By.name("data[job_contact_fullname]"));
        el16.sendKeys("1111");
        WebElement el17 = chromeDriver.findElement(By.name("data[ad_mobile]"));
        el17.sendKeys("0888700931");
        WebElement el18 = chromeDriver.findElement(By.name("data[job_contact_email]"));
        el18.sendKeys("baconheocon123@gmail.com");

        WebElement el19 = chromeDriver.findElement(By.id("submit_item_new"));
        el19.click();
        sleep(2000);

//
//        // Switching to Alert
//        Alert alert = chromeDriver.switchTo().alert();
//
//        // Capturing alert message.
//        String alertMessage= chromeDriver.switchTo().alert().getText();
//
//        // Displaying alert message
//        System.out.println(alertMessage);
//        sleep(5000);
//
//        // Accepting alert
//        alert.accept();



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

