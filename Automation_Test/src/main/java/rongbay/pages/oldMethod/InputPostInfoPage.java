package rongbay.pages.oldMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import rongbay.pages.MainPage;

import java.util.List;

public class InputPostInfoPage {
    private final WebDriver driver;
    private final By TitleField = By.xpath("//input[@name='data[ad_title]']");
    private final By CityDropdown = By.xpath("//select[@name='data[id_cities]']");
    private final By AllOptionCityDropdown = By.xpath("//select[@name='data[id_cities]']//option");
    private final By DistrictDropdown = By.xpath("//select[@name='data[id_districs]']");
    private final By ALlOptionDistrictDropdown = By.xpath("//select[@name='data[id_districs]']//option[@value]");
    private final By ProjectNameField = By.xpath("//input[@name='data[field_extra][project_user_post_name]']");
    private final By AddressField = By.xpath("//input[@name='data[txt_address]']");
    private final By AcreageField = By.xpath("//input[@name='data[field_extra][dientich]']");
    private final By PriceField = By.xpath("//input[@name='data[field_extra][giatien]']");
    private final By PriceTypeDropdown = By.xpath("//select[@name='data[field_extra][price][giatien_type]']");
    private final By AllOptionPriceType = By.xpath("//select[@name='data[field_extra][price][giatien_type]']//option");
    private final By AgreeBox = By.xpath("//input[@name='data[field_extra][price_tt]']");
    private final By PostContentIframe = By.xpath("//iframe[@id='description_ifr']");
    private final By PostBodyContent = By.xpath("//body[@class='mceContentBody ']");
    private final By ListOfCheckBoxMainDoorDirection = By.xpath(
            "//div[@class='box_info_bds sub_19 ']//li[@class='icon_sub_bds icon_bds ']");
    private final By ListOfCheckBoxBalconyDirection = By.xpath(
            "//div[@class='box_info_bds sub_28 ']//li[@class='icon_sub_bds icon_bds ']");
    private final By ListOfCheckBoxLegalDoc = By.xpath(
            "//div[@class='box_info_bds sub_47 ']//li[@class='icon_sub_bds icon_bds ']");
    private final By ContactNameField = By.ByName.xpath("//input[@name='data[job_contact_fullname]']");
    private final By ContactPhoneField = By.xpath("//input[@name='data[ad_mobile]']");
    private final By ContactEmailField = By.xpath("//input[@name='data[job_contact_email]']");
    private final By PostBtn = By.xpath("//input[@class='submit_item_new']");
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
        WebElement Title = driver.findElement(TitleField);
        Title.sendKeys(string);
    }

    public void SelectCity(int number) {
        WebElement City = driver.findElement(CityDropdown);
        City.click();

        List<WebElement> ListCity = driver.findElements(AllOptionCityDropdown);
        ListCity.get(number).click();
    }

    public void SelectDistrict(int number) {
        WebElement District = driver.findElement(DistrictDropdown);
        District.click();

        List<WebElement> ListDistrict = driver.findElements(ALlOptionDistrictDropdown);
        ListDistrict.get(number).click();
    }

    public void InputProjectName(String string) {
        WebElement ProjectName = driver.findElement(ProjectNameField);
        ProjectName.sendKeys(string);
    }

    public void InputAddress(String string) {
        WebElement Address = driver.findElement(AddressField);
        Address.sendKeys(string);
    }

    public void InputAcreage(String string) {
        WebElement Acreage = driver.findElement(AcreageField);
        Acreage.sendKeys(string);
    }

    public void InputPrice(String string) {
        WebElement Price = driver.findElement(PriceField);
        Price.sendKeys(string);
    }

    public void SelectPriceType(int number) {
        WebElement PriceType = driver.findElement(PriceTypeDropdown);
        PriceType.click();

        List<WebElement> ListPriceType = driver.findElements(AllOptionPriceType);
        ListPriceType.get(number).click();
    }

    public void ClickAgreeCheckBox() {
        WebElement AgreeCheckBox = driver.findElement(AgreeBox);
        AgreeCheckBox.click();
    }

    public void InputPostContent(String string) {
        // Move to post description Iframe
        WebElement DescriptionIframe = driver.findElement(PostContentIframe);
        driver.switchTo().frame(DescriptionIframe);

        WebElement PostBody = driver.findElement(PostBodyContent);
        PostBody.sendKeys(string);

        // Get out of post description Iframe
        driver.switchTo().defaultContent();
    }

    public void SelectMainDoorDirection(int number) {
        List<WebElement> ListOfMainDoorDirection = driver.findElements(ListOfCheckBoxMainDoorDirection);
        ListOfMainDoorDirection.get(number).click();
    }

    public void SelectBalconyDirection(int number) {
        List<WebElement> ListOfBalconyDirection = driver.findElements(ListOfCheckBoxBalconyDirection);
        ListOfBalconyDirection.get(number).click();
    }

    public void SelectLegalDoc(int number) {
        List<WebElement> ListOfLegalDoc = driver.findElements(ListOfCheckBoxLegalDoc);
        ListOfLegalDoc.get(number).click();
    }

    public void InputContactName(String string) {
        WebElement ContactName = driver.findElement(ContactNameField);
        ContactName.sendKeys(string);
    }

    public void InputContactPhone(String string) {
        WebElement ContactPhone = driver.findElement(ContactPhoneField);
        ContactPhone.sendKeys(string);
    }

    public void InputContactEmail(String string) {
        WebElement ContactEmail = driver.findElement(ContactEmailField);
        ContactEmail.sendKeys(string);
    }

    public void ClickConfirmBtn() {
        WebElement ConfirmBtn = driver.findElement(PostBtn);
        ConfirmBtn.click();
    }
}
