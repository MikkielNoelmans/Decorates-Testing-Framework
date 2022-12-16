package portal.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import portal.web.utils.WebConfig;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private String baseUrl;
    private String url;
    protected WebDriverWait wait;
    private int defaultTimeout = Integer.parseInt(WebConfig.getDefaultTimeout());

    private By drawerToggle = By.id("DrawerToggle");
    private By darkModeToggle = By.id("DarkModeToggle");
    private By homeNav = By.id("HomeNavBtn");
    private By courseNav = By.id("CourseNavBtn");

    public BasePage(WebDriver driver, String endpoint){
        this.driver = driver;
        baseUrl = WebConfig.getBaseUrl();
        this.url = baseUrl + endpoint;
        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
    }

    public void navigateTo(){
        driver.get(url);
    }
    public void navigateTo(String urlAddition) { driver.get(url + urlAddition); }

    public void clickDarkMode() {
        WebElement darkModeToggleBtn = driver.findElement(darkModeToggle);
        darkModeToggleBtn.click();
    }

    public boolean darkModeValue() {
        WebElement darkModeToggleBtn = driver.findElement(darkModeToggle);
        String darkModeState = darkModeToggleBtn.getAttribute("aria-pressed");
        if(darkModeState == "false") {return false;} else {return true;}
    }

    public void clickDrawerToggle() {
        WebElement drawerToggleBtn = driver.findElement(drawerToggle);
        drawerToggleBtn.click();
    }
    /*
    //This function is limited due to blazor code and does currently not work

    public boolean drawerToggleValue(){
        WebElement drawerToggleBtn = driver.findElement(drawerToggle);

    }
    */

    public void clickHomeNav() {
        WebElement homeNavBtn = driver.findElement(homeNav);
        homeNavBtn.click();
    }

    public void clickCourseNav() {
        WebElement courseNavBtn = driver.findElement(courseNav);
        courseNavBtn.click();
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
}
