package portal.web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import portal.web.utils.WebConfig;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private String baseUrl;
    private String url;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver, String endpoint){
        this.driver = driver;
        baseUrl = WebConfig.getBaseUrl();
        this.url = baseUrl + endpoint;
        int defaultTimeout = Integer.parseInt(WebConfig.getDefaultTimeout());
        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
    }

    public void navigateTo(){
        driver.get(url);
    }
}
