package portal.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import portal.web.utils.WebConfig;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.StringTokenizer;

public class HomePage extends BasePage {
    private By emailInput = By.id("i0116");
    private By passwordInput = By.id("i0118");
    private By nextBtn = By.id("idSIButton9");
    int defaultTimeout = Integer.parseInt(WebConfig.getDefaultTimeout());

    public HomePage(WebDriver driver) {
        super(driver, "/");
    }

    public void firstLoginStage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));

        WebElement emailInputElement = driver.findElement(emailInput);
        WebElement nextBtnElement = driver.findElement(nextBtn);
        emailInputElement.sendKeys("e-mail");
        nextBtnElement.click();
    }

    public void secondLoginStage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));

        WebElement passwordInputElement = driver.findElement(passwordInput);
        WebElement nextBtnElement = driver.findElement(nextBtn);
        passwordInputElement.sendKeys("wachtwoord");
        nextBtnElement.click();
    }

    public void waitForAuthenticator() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void CookieWriter() {
        File file = new File("Cookies.data");
        try {
            // Delete old file if exists
            file.delete();
            file.createNewFile();
            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);
            // loop for getting the cookie information

            // loop for getting the cookie information
            for (Cookie ck : driver.manage().getCookies()) {
                Bwrite.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.isSecure()));
                Bwrite.newLine();
            }
            Bwrite.close();
            fileWrite.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void CookieSetter() {
        try {
            File file = new File("Cookies.data");
            FileReader fileReader = new FileReader(file);
            BufferedReader Buffreader = new BufferedReader(fileReader);
            String strline;
            while((strline=Buffreader.readLine())!=null){
                StringTokenizer token = new StringTokenizer(strline,";");
                while(token.hasMoreTokens()){
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date expiry = null;

                    String val;
                    if(!(val=token.nextToken()).equals("null"))
                    {
                        expiry = dateFormat.parse(val);
                    }
                    Boolean isSecure = Boolean.valueOf(token.nextToken());
                    Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
                    System.out.println(ck);
                    driver.manage().addCookie(ck); // This will add the stored cookie to your current session
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
