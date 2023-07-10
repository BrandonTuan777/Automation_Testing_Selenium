package rongbay.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rongbay.base.BaseSetup;
import rongbay.pages.MainPage;
import rongbay.pages.oldMethod.InputPostInfoPage;

public class CreateNewPostTest extends BaseSetup {
    private WebDriver driver;
    public MainPage createNewPostPage;
    public InputPostInfoPage infoPage;
    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Test (priority = 0)
    public void CreatePost() throws Exception {
        Actions action = new Actions(driver);
        System.out.println(driver);

        createNewPostPage = new MainPage(driver, action);
        infoPage = new InputPostInfoPage(driver);

        createNewPostPage.CreateNewPost();
        infoPage.InputPostInfo();

    }
}