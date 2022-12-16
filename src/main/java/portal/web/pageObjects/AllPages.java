package portal.web.pageObjects;

import portal.web.utils.BrowserUtil;
import org.openqa.selenium.WebDriver;

public class AllPages {
    public HomePage homePage;
    public CourseDisplayPage courseDisplayPage;
    public CourseOverviewPage courseOverviewPage;
    private WebDriver driver;

    public AllPages(){
        driver = BrowserUtil.createBrowser();
        homePage = new HomePage(driver);
        courseDisplayPage = new CourseDisplayPage(driver);
        courseOverviewPage = new CourseOverviewPage(driver);
    }

    public void closeBrowser(){
        driver.quit();
    }
}