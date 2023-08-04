package rongbay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final Actions action;
    @FindBy(xpath = "//a[@class='btnAdvertise_dt seo1554191484']")
    private WebElement CreateBtnEle;
    @FindBy(xpath = "//*[@id=\"PostAllForm\"]/div[2]/div/ul/li[2]")
    private WebElement MuaBanNhaDatEle;
    @FindBy(xpath = "//ul[@class='step_3 group_15']//a[contains(text(),'Nhà riêng')]")
    private WebElement NhaRiengBtnEle;
    @FindBy(xpath = "//span[@class='icon_province']")
    private WebElement DropdownSelectCountry;
    @FindBy(xpath = "//li[@class='City seo1554192416']//b")
    private List<WebElement> ListOfCountry;
    @FindBy(xpath = "//li[@class='Navi2_wid']//a")
    private List<WebElement> ListOfOption;
    @FindBy(xpath = "//a[@class='rd_view newsTitle float_l']")
    private List<WebElement> ListOfTitle;
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
        CreateBtnEle.click();
    }

    public void HoverToMuaBanNhaDat() {
        action.moveToElement(MuaBanNhaDatEle).perform();
    }

    public void ClickNhaRiengBtn() {
        NhaRiengBtnEle.click();
    }

    public void OpenDropdownSelectCountry() {
        DropdownSelectCountry.click();
    }

    public void SelectCountry(int num) {
        ListOfCountry.get(num).click();
    }

    public void SelectOption(int num) {
        ListOfOption.get(num).click();
    }

    public void SelectTitle(int num) {
        ListOfTitle.get(num).click();
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