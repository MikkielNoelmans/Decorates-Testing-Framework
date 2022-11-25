package portal.hooks;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import portal.web.pageObjects.AllPages;

public class DefaultHooks {
    protected AllPages pages;

    @BeforeSuite(alwaysRun = true)
    public void setup(){
        pages = new AllPages();
        pages.counterPage.navigateTo();
    }

    @AfterSuite(alwaysRun = true)
    public void teardown(){
        pages.closeBrowser();
    }
}
