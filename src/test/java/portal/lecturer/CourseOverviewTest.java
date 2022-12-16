package portal.lecturer;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import portal.hooks.DefaultHooks;

import static com.google.common.truth.Truth.assertThat;

public class CourseOverviewTest extends DefaultHooks {
    @BeforeTest
    public void beforeGroup(){
        pages.courseOverviewPage.navigateTo();
    }

    @Test(groups = {"Course overview", "Functionality"})
    public void clickCourseNav() {
        WebElement randomCourse = pages.courseOverviewPage.getRandomCourse();
        pages.courseOverviewPage.clickNavigateButton(randomCourse);
        String urlToCheck = "https://10.128.11.14:9001/course/" + pages.courseOverviewPage.getCourseId(randomCourse).substring(11);
        assertThat(pages.courseOverviewPage.getCurrentURL().equals(urlToCheck));
    }

    @Test(groups = {"Course overview", "Platform-wide actions"})
    public void clickDarkModeToggle() {
        Boolean darkModeBeginState = pages.courseOverviewPage.darkModeValue();
        pages.courseOverviewPage.clickDarkMode();
        assertThat(pages.courseOverviewPage.darkModeValue() != darkModeBeginState);
    }

    @Test(groups = {"Course overview", "Platform-wide actions"})
    public void clickNavHome() {
        pages.courseOverviewPage.clickHomeNav();
        assertThat(pages.courseOverviewPage.getCurrentURL().equals("https://10.128.11.14:9001/"));
    }
}
