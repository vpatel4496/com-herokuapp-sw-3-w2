package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.id("username"), "tomsmith");
        sendTextToElement(By.id("password"), "SuperSecretPassword!");
        clickOnElement(By.xpath("//button[@class='radius']/i"));
        verifyText("Secure Area", By.xpath("//div[@id='content']/div/h2"), "Secure area text validation");

    }
    @Test
    public void verifyTheUsernameErrorMessage() {
        sendTextToElement(By.tagName("input#username"), "tomsmith1");
        sendTextToElement(By.id("password"), "SuperSecretPassword!");
        clickOnElement(By.className("radius"));
        verifyText("Your username is invalid!", By.xpath("//div[@id='flash']"), "Username is not valid ");

    }
    @Test
    public void verifyThePasswordErrorMessage() {
        sendTextToElement(By.xpath("//input[@id='username']"), "tomsmith");
        sendTextToElement(By.id("password"), "SuperSecretPassword");
        clickOnElement(By.className("radius"));
        verifyText("Your password is invalid!", By.linkText("//div[@id='flash']"), "Your password is invalid!");

    }
    @After
    public void closeBrowser() {
        closeBrowser();

    }



}



