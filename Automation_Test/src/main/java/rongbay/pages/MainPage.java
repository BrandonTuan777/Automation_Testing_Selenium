package rongbay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final Actions action;
    private final By CreateBtnEle = By.xpath("//a[@class='btnAdvertise_dt seo1554191484']");
    private final By MuaBanNhaDatEle = By.xpath("//*[@id=\"PostAllForm\"]/div[2]/div/ul/li[2]");
    private final By NhaRiengBtnEle = By.xpath("//ul[@class='step_3 group_15']//a[contains(text(),'Nhà riêng')]");
    private final By DropdownSelectCountry = By.xpath("//span[@class='icon_province']");
    private final By ListOfCountry = By.xpath("//li[@class='City seo1554192416']//b");
    private final By ListOfOption = By.xpath("//li[@class='Navi2_wid']//a");
    private final By ListOfTitle =  By.xpath("//a[@class='rd_view newsTitle float_l']");

    // Khởi tạo class khi được gọi và truyền driver vào để các thành phần trong class này đọc
    public MainPage(WebDriver driver, Actions action) {
        this.driver = driver;
        this.action = action;
    }
    public void CreateNewPost(){
        ClickCreateBtn();
        HoverToMuaBanNhaDat();
        ClickNhaRiengBtn();
    }

    public void ReviewPost(){
        OpenDropdownSelectCountry();
        SelectCountry(1);
        SelectOption(3);
        SelectTitle(1);
    }

    public void ClickCreateBtn() {
        WebElement createBtn = driver.findElement(CreateBtnEle);
        createBtn.click();
    }

    public void HoverToMuaBanNhaDat() {
        WebElement tagMuaBanNhaDat = driver.findElement(MuaBanNhaDatEle);
        action.moveToElement(tagMuaBanNhaDat).perform();
    }

    public void ClickNhaRiengBtn() {
        WebElement nhaRiengBtn = driver.findElement(NhaRiengBtnEle);
        nhaRiengBtn.click();
    }

    public void OpenDropdownSelectCountry() {
        WebElement countryDropdown = driver.findElement(DropdownSelectCountry);
        countryDropdown.click();
    }

    public void SelectCountry(int num) {
        List<WebElement> listCountry = driver.findElements(ListOfCountry);
        listCountry.get(num).click();
    }

    public void SelectOption(int num) {
        List<WebElement> listOption = driver.findElements(ListOfOption);
        listOption.get(num).click();
    }

    public void SelectTitle(int num) {
        List<WebElement> listTitle = driver.findElements(ListOfTitle);
        listTitle.get(num).click();
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}