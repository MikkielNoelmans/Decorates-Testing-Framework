package portal.hooks;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import portal.web.pageObjects.AllPages;

public class DefaultHooks {
    protected static AllPages pages = new AllPages();

    @BeforeSuite(alwaysRun = true)
    public void setup(){
        pages.homePage.navigateTo();

        //Normal Running
        pages.homePage.CookieSetter();

        //Run when cookie expires
        /*
        pages.homePage.navigateTo();
        pages.homePage.firstLoginStage();
        pages.homePage.secondLoginStage();
        pages.homePage.waitForAuthenticator();
        pages.homePage.CookieWriter();
        //*/
    }

    @AfterSuite(alwaysRun = true)
    public void teardown(){
        pages.closeBrowser();
    }
}
