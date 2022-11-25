package portal.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import portal.web.utils.WebConfig;

import java.time.Duration;

public class CounterPage extends BasePage {
    private By counterBtn = By.cssSelector(".mud-button-root.mud-button.mud-button-filled.mud-button-filled-primary.mud-button-filled-size-medium.mud-ripple");

    private By counterText = By.cssSelector(".mud-typography.mud-typography-body1.mb-4");
    int defaultTimeout = Integer.parseInt(WebConfig.getDefaultTimeout());

    public CounterPage(WebDriver driver) {
        super(driver, "/counter");
    }
    public void clickCounter(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
        wait.until(ExpectedConditions.elementToBeClickable(counterBtn));

        WebElement counterBtnElement = driver.findElement(counterBtn);
        counterBtnElement.click();
    }

    public String counterAmount(){
        WebElement counterElement = driver.findElement(counterText);
        return counterElement.getText();
    }
}
