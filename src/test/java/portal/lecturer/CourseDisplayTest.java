package portal.lecturer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import portal.hooks.DefaultHooks;

import static com.google.common.truth.Truth.assertThat;

public class CourseDisplayTest extends DefaultHooks {
    @BeforeTest
    public void beforeGroup(){
        pages.courseDisplayPage.navigateTo();
    }

    @Test(groups = {"Course display", "Functionality"})
    public void clickDarkModeToggle() {
        Boolean darkModeBeginState = pages.courseDisplayPage.darkModeValue();
        pages.courseDisplayPage.clickDarkMode();
        assertThat(pages.courseDisplayPage.darkModeValue() != darkModeBeginState);
    }

    @Test(groups = {"Course display", "Platform-wide actions"})
    public void clickNavCourse() {
        pages.courseDisplayPage.clickCourseNav();
        assertThat(pages.courseDisplayPage.getCurrentURL().contains("https://10.128.11.14:9001/courses/"));
    }

    @Test(groups = {"Course display", "Course content"})
    public void checkHeaders(){
        pages.courseDisplayPage.navigateTo("/296dd345-7d6f-428b-98f2-ace8661a9cbe");
        System.out.println(pages.courseDisplayPage.headerCount("h1"));
    }

}
