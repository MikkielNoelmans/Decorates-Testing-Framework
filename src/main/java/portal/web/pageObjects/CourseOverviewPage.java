package portal.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import portal.web.utils.WebConfig;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CourseOverviewPage extends BasePage{
    private By courseContainer = By.className("course-items");
    private By courseItem = By.className("course-item");
    private By courseNavBtn;
    int defaultTimeout = Integer.parseInt(WebConfig.getDefaultTimeout());
    public CourseOverviewPage(WebDriver driver)  { super(driver, "/courses");}

    /*
    public void clickCourseNav(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
        wait.until(ExpectedConditions.elementToBeClickable(courseNavBtn));

        WebElement courseNavBtnElement = driver.findElement(courseNavBtn);
        courseNavBtnElement.click();
    }
    */

    public List<WebElement> getCourseList(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
        wait.until(ExpectedConditions.urlContains("courses"));

        WebElement courseListElement = driver.findElement(courseContainer);
        List<WebElement> courseElementList = courseListElement.findElements(courseItem);
        return courseElementList;
    }

    public void clickNavigateButton(WebElement parentCourseElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));

        String courseId = getCourseId(parentCourseElement);
        courseNavBtn = By.id(courseId);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(courseNavBtn)));

        WebElement NavButtonToClick = driver.findElement(courseNavBtn);
        NavButtonToClick.click();
    }

    public String getCourseId(WebElement course){
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
        //wait.until(ExpectedConditions.visibilityOf(course.findElement(By.cssSelector("[id^='CourseItem']"))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return course.findElement(By.cssSelector("[id^='CourseItem']")).getAttribute("id");
    }

    public WebElement getRandomCourse(){
        Random random = new Random();
        List<WebElement> courseList = getCourseList();
        int randomUpperLimit = courseList.size();
        return courseList.get(random.nextInt(randomUpperLimit));
    }
}
