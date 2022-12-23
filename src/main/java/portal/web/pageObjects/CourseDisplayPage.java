package portal.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import portal.web.utils.WebConfig;

import java.time.Duration;
import java.util.List;

public class CourseDisplayPage extends BasePage {
    private By headerDrawer = By.id("toggle-drawer-button");
    private By headerContainer = By.id("chapter-button-container");
    private By headers = By.cssSelector("[id^='headerBtn']");
    private By subHeaders = By.cssSelector("[id^='subHeaderBtn']");
    private By mainContentContainer = By.id("course-content-container");
    private By courseContent = By.id("course-content");
    private By loadingSpinner = By.cssSelector(".mud-progress-circular.mud-primary-text.mud-progress-medium.mud-progress-indeterminate");
    int defaultTimeout = Integer.parseInt(WebConfig.getDefaultTimeout());

    public CourseDisplayPage(WebDriver driver) {
        super(driver, "/course");
    }
    public void clickHeaderDrawer(){

    }
    public int headerCount(){
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(loadingSpinner)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        By selector = By.cssSelector("[class*='course-element']");

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));

        WebElement courseContentContainer = driver.findElement(courseContent);

        List<WebElement> elementList = courseContentContainer.findElements(selector);

        return elementList.size();
    }

}
