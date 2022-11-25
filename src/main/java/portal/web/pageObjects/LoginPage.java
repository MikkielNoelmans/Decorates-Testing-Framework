package portal.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private By loginBtn = By.cssSelector("button");
    private By errorMsg = By.cssSelector("#flash");
    public LoginPage(WebDriver driver) {
        super(driver, "/login");
    }

    public void clickClogin(){
        WebElement loginBtnElement = driver.findElement(loginBtn);
        loginBtnElement.click();
    }

    public String getErrorMessage() {
        WebElement errorMsgElement = wait.until(
                ExpectedConditions.elementToBeClickable(
                        errorMsg
                ));
        return errorMsgElement.getText();
    }
}
