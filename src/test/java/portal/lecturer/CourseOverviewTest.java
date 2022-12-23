package portal.lecturer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import portal.hooks.DefaultHooks;

import java.time.Duration;

import static com.google.common.truth.Truth.assertThat;

public class CourseOverviewTest extends DefaultHooks {
    String linuxUrl = "c721863f-5287-4b90-81ac-7a05587d568c";
    String dotNetUrl = "9740ca8c-f346-44f7-893a-9b29183c5e53";
    @BeforeTest
    public void beforeGroup(){
        pages.courseOverviewPage.navigateTo();
    }
    @Test(groups = {"Course overview", "Platform-wide actions"})
    public void click_darkmode_toggle_and_cycle_mode() {
        System.out.println("Check if the darkmode button works on this page.");
        Boolean darkModeBeginState = pages.courseOverviewPage.darkModeValue();
        System.out.println("Darkmode starting value: " + darkModeBeginState);
        pages.courseOverviewPage.clickDarkMode();
        pages.courseOverviewPage.driverWait(1);
        Boolean darkModeEndState = pages.courseOverviewPage.darkModeValue();
        assertThat(darkModeEndState).isNotEqualTo(darkModeBeginState);
        System.out.println("Darkmode ending value: " + darkModeEndState);
    }

    @Test(groups = {"Course overview", "Platform-wide actions"})
    public void click_sidebar_navigate_to_courses() {
        System.out.println("Check if the navigate to course menu button works on this page.");
        pages.courseOverviewPage.navigateTo();
        System.out.println("Starting url: " + pages.courseOverviewPage.getCurrentURL());
        pages.courseOverviewPage.driverWait(1);
        pages.courseOverviewPage.clickCourseNav();
        assertThat(pages.courseOverviewPage.getCurrentURL().contains("https://10.128.11.14:9001/courses/"));
        System.out.println("Current url: " + pages.courseOverviewPage.getCurrentURL());
    }

    @Test(groups ={"Course overview", "Functionality"})
    public void click_navigate_to_course_button(){
        System.out.println("Check if button to navigate to selected course works");
        pages.courseOverviewPage.navigateTo();
        pages.courseOverviewPage.clickCourseNav(linuxUrl);
        String courseUrlToCheck = "https://10.128.11.14:9001/courses/" + linuxUrl;
        assertThat(pages.courseOverviewPage.getCurrentURL().equals(courseUrlToCheck));
    }

    @Test(groups ={"Course overview", "Error checking"})
    public void click_course_with_no_content(){
        System.out.println("Check if platform displays error when course has no content");
        pages.courseOverviewPage.navigateTo();
        pages.courseOverviewPage.clickCourseNav(dotNetUrl);
        assertThat(pages.courseOverviewPage.getCourseContentError()).isTrue();
    }

    @Test(groups = {"Course overview", "Platform-wide actions"})
    public void click_sidebar_navigate_to_homepage() {
        System.out.println("Check if the navigate to course menu button works on this page.");
        System.out.println("Starting url: " + pages.courseOverviewPage.getCurrentURL());
        pages.courseOverviewPage.clickHomeNav();
        assertThat(pages.courseOverviewPage.getCurrentURL().equals("https://10.128.11.14:9001/"));
        System.out.println("Current url: " + pages.courseOverviewPage.getCurrentURL());
    }
}
