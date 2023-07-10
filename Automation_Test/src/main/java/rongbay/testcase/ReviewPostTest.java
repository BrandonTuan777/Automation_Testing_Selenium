package rongbay.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rongbay.pages.MainPage;
import rongbay.base.BaseSetup;

public class ReviewPostTest extends BaseSetup {
    private WebDriver driver;
    public MainPage reviewPost;
    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }


    @Test(priority = 0)
    public void ReviewPost() throws Exception {
        Actions action = new Actions(driver);
        System.out.println(driver);

        reviewPost = new MainPage(driver, action);

        reviewPost.ReviewPost();
    }
}
