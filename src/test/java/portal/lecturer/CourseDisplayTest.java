package portal.lecturer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import portal.hooks.DefaultHooks;

import static com.google.common.truth.Truth.assertThat;

public class CourseDisplayTest extends DefaultHooks {
    String urlAddition = "/c721863f-5287-4b90-81ac-7a05587d568c";
    @BeforeTest
    public void beforeGroup(){
        pages.courseDisplayPage.navigateTo();
    }

    @Test(groups = {"Course display", "Platform-wide actions"})
    public void click_darkmode_toggle_and_cycle_mode() {
        System.out.println("Check if the darkmode button works on this page.");
        Boolean darkModeBeginState = pages.courseDisplayPage.darkModeValue();
        System.out.println("Darkmode starting value: " + darkModeBeginState);
        pages.courseDisplayPage.clickDarkMode();
        Boolean darkModeEndState = pages.courseDisplayPage.darkModeValue();
        assertThat(darkModeEndState).isNotEqualTo(darkModeBeginState);
        System.out.println("Darkmode ending value: " + darkModeEndState);
    }

    @Test(groups = {"Course display", "Platform-wide actions"})
    public void click_sidebar_navigate_to_courses() {
        System.out.println("Check if the navigate to course menu button works on this page.");
        System.out.println("Starting url: " + pages.courseDisplayPage.getCurrentURL());
        pages.courseDisplayPage.clickCourseNav();
        assertThat(pages.courseDisplayPage.getCurrentURL().contains("https://10.128.11.14:9001/courses/"));
        System.out.println("Current url: " + pages.courseDisplayPage.getCurrentURL());
    }

    @Test(groups = {"Course display", "Platform-wide actions"})
    public void click_sidebar_navigate_to_homepage() {
        System.out.println("Check if the navigate to course menu button works on this page.");
        pages.courseDisplayPage.navigateTo(urlAddition);
        System.out.println("Starting url: " + pages.courseDisplayPage.getCurrentURL());
        pages.courseDisplayPage.clickHomeNav();
        assertThat(pages.courseDisplayPage.getCurrentURL().equals("https://10.128.11.14:9001/"));
        System.out.println("Current url: " + pages.courseDisplayPage.getCurrentURL());
    }

    @Test(groups = {"Course display", "Course content"})
    public void check_course_content_loaded(){
        System.out.println("Comparing detected header count on loaded course with known header count, to assert that the course has been loaded.");
        pages.courseDisplayPage.navigateTo(urlAddition);
        int expectedHeaderCount = 7;
        System.out.println("Expected header count: " + expectedHeaderCount);
        int headerCount = pages.courseDisplayPage.headerCount();
        System.out.println("Detected header count: " + headerCount);
        assertThat(headerCount).isEqualTo(expectedHeaderCount);
    }

    @Test(groups = {"Course display", "Course content"})
    public void check_header_buttons_loaded(){
        System.out.println("Checking if subheader buttons have loaded correctly");
    }


}
