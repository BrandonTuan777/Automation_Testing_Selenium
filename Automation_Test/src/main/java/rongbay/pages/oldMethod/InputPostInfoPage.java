package rongbay.pages.oldMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import rongbay.pages.MainPage;

import java.util.List;

public class InputPostInfoPage {
    private final WebDriver driver;
    @FindBy(xpath = "//input[@name='data[ad_title]']")
    private WebElement TitleField;
    @FindBy(xpath = "//select[@name='data[id_cities]']")
    private WebElement CityDropdown;
    @FindBy(xpath = "//select[@name='data[id_cities]']//option")
    private List<WebElement> AllOptionCityDropdown;
    @FindBy(xpath = "//select[@name='data[id_districs]']")
    private WebElement DistrictDropdown;
    @FindBy(xpath = "//select[@name='data[id_districs]']//option[@value]")
    private List<WebElement> ALlOptionDistrictDropdown;
    @FindBy(xpath = "//input[@name='data[field_extra][project_user_post_name]']")
    private WebElement ProjectNameField;
    @FindBy(xpath = "//input[@name='data[txt_address]']")
    private WebElement AddressField;
    @FindBy(xpath = "//input[@name='data[field_extra][dientich]']")
    private WebElement AcreageField;
    @FindBy(xpath = "//input[@name='data[field_extra][giatien]']")
    private WebElement PriceField;
    @FindBy(xpath = "//select[@name='data[field_extra][price][giatien_type]']")
    private WebElement PriceTypeDropdown;
    @FindBy(xpath = "//select[@name='data[field_extra][price][giatien_type]']//option")
    private List<WebElement> AllOptionPriceType;
    @FindBy(xpath = "//input[@name='data[field_extra][price_tt]']")
    private WebElement AgreeBox;
    @FindBy(xpath = "//iframe[@id='description_ifr']")
    private WebElement PostContentIframe;
    @FindBy(xpath = "//body[@class='mceContentBody ']")
    private WebElement PostBodyContent;
    @FindBy(xpath = "//div[@class='box_info_bds sub_19 ']//li[@class='icon_sub_bds icon_bds ']")
    private List<WebElement> ListOfCheckBoxMainDoorDirection;
    @FindBy(xpath = "//div[@class='box_info_bds sub_28 ']//li[@class='icon_sub_bds icon_bds ']")
    private List<WebElement> ListOfCheckBoxBalconyDirection;
    @FindBy(xpath = "//div[@class='box_info_bds sub_47 ']//li[@class='icon_sub_bds icon_bds ']")
    private List<WebElement> ListOfCheckBoxLegalDoc;
    @FindBy(xpath = "//input[@name='data[job_contact_fullname]']")
    private WebElement ContactNameField;
    @FindBy(xpath = "//input[@name='data[ad_mobile]']")
    private WebElement ContactPhoneField;
    @FindBy(xpath = "//input[@name='data[job_contact_email]']")
    private WebElement ContactEmailField;
    @FindBy(xpath = "//input[@class='submit_item_new']")
    private WebElement PostBtn;
    public InputPostInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void InputPostInfo() {
        InputTittle("Bán nhà mặt phố Đồng Khởi");
        SelectCity(3);
        SelectDistrict(4);
        InputProjectName("Nhà mặt tiền khu Đồng Khởi");
        InputAcreage("120");
        InputPrice("100");
        SelectPriceType(0);
        ClickAgreeCheckBox();
        InputPostContent("Nhà 4 tầng rộng rãi thoáng mát, có 3 phòng ngủ, 1 bếp, 3 WC");
        SelectMainDoorDirection(0);
        SelectBalconyDirection(3);
        SelectLegalDoc(0);
        InputContactName("Nguyễn Văn A");
        InputContactPhone("09063847292");
        InputContactEmail("nguyenvana@gmail.com");
        ClickConfirmBtn();
    }

    public void InputTittle(String string) {
        TitleField.sendKeys(string);
    }

    public void SelectCity(int number) {
        CityDropdown.click();
        AllOptionCityDropdown.get(number).click();
    }

    public void SelectDistrict(int number) {
        DistrictDropdown.click();
        ALlOptionDistrictDropdown.get(number).click();
    }

    public void InputProjectName(String string) {
        ProjectNameField.sendKeys(string);
    }

    public void InputAddress(String string) {
        AddressField.sendKeys(string);
    }

    public void InputAcreage(String string) {
        AcreageField.sendKeys(string);
    }

    public void InputPrice(String string) {
        PriceField.sendKeys(string);
    }

    public void SelectPriceType(int number) {
        PriceTypeDropdown.click();
        AllOptionPriceType.get(number).click();
    }

    public void ClickAgreeCheckBox() {
        AgreeBox.click();
    }

    public void InputPostContent(String string) {
        // Move to post description Iframe
        driver.switchTo().frame(PostContentIframe);
        PostBodyContent.sendKeys(string);

        // Get out of post description Iframe
        driver.switchTo().defaultContent();
    }

    public void SelectMainDoorDirection(int number) {
        ListOfCheckBoxMainDoorDirection.get(number).click();
    }

    public void SelectBalconyDirection(int number) {
        ListOfCheckBoxBalconyDirection.get(number).click();
    }

    public void SelectLegalDoc(int number) {
        ListOfCheckBoxLegalDoc.get(number).click();
    }

    public void InputContactName(String string) {
        ContactNameField.sendKeys(string);
    }

    public void InputContactPhone(String string) {
        ContactPhoneField.sendKeys(string);
    }

    public void InputContactEmail(String string) {
        ContactEmailField.sendKeys(string);
    }

    public void ClickConfirmBtn() {
        PostBtn.click();
    }
}
