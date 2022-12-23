package portal.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import portal.web.utils.WebConfig;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CourseOverviewPage extends BasePage{
    private By courseContent = By.id("course-content");
    private By courseItem = By.cssSelector("[id^='CourseItem']");
    private By courseNavBtn;
    int defaultTimeout = Integer.parseInt(WebConfig.getDefaultTimeout());
    public CourseOverviewPage(WebDriver driver)  { super(driver, "/courses");}


    public void clickCourseNav(String courseGuid){
        String idString = "NavigateToCourseBtn " + courseGuid;
        courseNavBtn = By.id(idString);
        wait.until(ExpectedConditions.elementToBeClickable(courseNavBtn));

        WebElement courseNavBtnElement = driver.findElement(courseNavBtn);
        courseNavBtnElement.click();
    }

    public boolean getCourseContentError(){
        wait.until(ExpectedConditions.presenceOfElementLocated(courseContent));
        WebElement courseContentElement = driver.findElement(courseContent);
        return courseContentElement.getText().contains("ERROR");
    }
}
