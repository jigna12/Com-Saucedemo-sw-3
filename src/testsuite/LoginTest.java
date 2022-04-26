package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String BaseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(BaseUrl);
    }
    /*
    1. userShuoldLoginSuccessfullyWithValidCredentials
          * Enter “standard_user” username
          * Enter “secret_sauce” password
          * Click on ‘LOGIN’ button
          * Verify the text “PRODUCTS”
     */
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {

        sendTextToElement(By.id("user-name"),"standard_user");//Find the UserName and enter the UserName
        sendTextToElement(By.name("password"),"secret_sauce");//Find the password and enter the password
        clickOnElement(By.id("login-button")); //Find the Login button and click on login button

        String ActMsg = getTextFromElement(By.xpath("//span[contains(text(),'Products')]")); //Find the Products area text element and get the text
        System.out.println("Actual Message :");
        messageValidation("PRODUCTS", ActMsg); //Validate actual and expected message
    }
    /*  verifyThatSixProductsAreDisplayedOnPage
     * Enter “standard_user” username
     * Enter “secret_sauce” password
     * Click on ‘LOGIN’ button
     * Verify that six products are displayed on page   */
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage()
    {
        sendTextToElement(By.id("user-name"),"standard_user");//Find the UserName and enter the UserName
        sendTextToElement(By.name("password"),"secret_sauce");//Find the password and enter the password
        clickOnElement(By.id("login-button")); //Find the Login button and click on login button

        //This requirement is from document
        int ExpectedNoOfProducts=6;
        //find no of products and count in Array List
        List<WebElement> Products = driver.findElements(By.className("inventory_item"));
        int ActNumberOfProducts = Products.size();
        System.out.println("Actual No of Products on Display  = " +ActNumberOfProducts);

        //Validate actual and expected message
        Assert.assertEquals("No of products in display are not match with expected =",ExpectedNoOfProducts,ActNumberOfProducts);

    }
    @After
    public void teardown()
    {
        closeBrowser();
    }
}
