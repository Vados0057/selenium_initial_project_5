import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Script {
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();

        /*
            Test Case 1:
        Validate Automation Exercise site logoGiven user navigates to “https://automationexercise.com/”
        Then user should see logo on top-left
         */

        driver.get("https://automationexercise.com/");
        if (driver.findElement(By.cssSelector("div[class='logo pull-left'] img")).isDisplayed())
            System.out.println("Logo Validation PASSED");
        else System.out.println("Logo Validation FAILED");

        /*
            Test Case 2:
        Validate Automation Exercise site header itemsGiven user navigates to “https://automationexercise.com/”
        Then validate all below header items are displayed and enabled and their text is as below
        Home
        Products
        Cart
        Signup / Login
        Test Cases
        API Testing
        Video Tutorials
        Contact us
         */

        String[] expectedText = {" Home", " Products", " Cart", " Signup / Login", " Test Cases", " API Testing", " Video Tutorials", " Contact us"};
        List<WebElement> headerElements = driver.findElements(By.cssSelector("ul[class='nav navbar-nav']>li"));

        for (int i = 0; i < headerElements.size(); i++) {
            System.out.println(headerElements.get(i).getText().equals(expectedText[i]));
            System.out.println(headerElements.get(i).isDisplayed());
            System.out.println(headerElements.get(i).isEnabled());
        }

        /*
            Test Case 3:
        Validate Automation Exercise site SUBSCRIPTION formGiven user navigates to “https://automationexercise.com/”
        Then user should see heading2 as “SUBSCRIPTION”
        And user should see and email input box with “Your email address” placeholder
        And user should see arrow submit button
        And user should see “Get the most recent updates from our site and be updated your self...”
        text under the email input box
         */

        if (driver.findElement(By.cssSelector("div[class='single-widget']>h2")).isDisplayed())
            System.out.println("\"SUBSCRIPTION\" h2 validation is Passed");
        else System.out.println("\"SUBSCRIPTION\" h2 validation is FAILED");

        WebElement email = driver.findElement(By.id("susbscribe_email"));
        if (email.isDisplayed()) System.out.println("\"Email\" input box Validation is PASSED");
        else System.out.println("\"Email\" input box Validation is PASSED");

        if (email.getAttribute("placeholder").equals("Your email address"))
            System.out.println("\"Email\" placeholder validation is PASSED");
        else System.out.println("\"Email\" placeholder validation is FAILED");

        if (driver.findElement(By.cssSelector("form[class='searchform']>button")).isDisplayed())
            System.out.println("\"Submit arrow\" button validation is PASSED");
        else System.out.println("\"Submit arrow\" button validation is PASSED");

        if (driver.findElement(By.cssSelector("div[class='single-widget'] p")).isDisplayed())
            System.out.println("Text under the email input box validation is PASSED");
        else System.out.println("Text under the email input box validation is FAILED");

        /*
            Test Case 4:
        Validate Automation Exercise site footerGiven user navigates to “https://automationexercise.com/”
        Then user should see “Copyright © 2021 All rights reserved” text in the footer
         */

        WebElement footer = driver.findElement(By.cssSelector("div[class='footer-bottom'] p"));
        if (footer.isDisplayed()) System.out.println("Footer validation is PASSED");
        else System.out.println("Footer validation is FAILED");

        if (footer.getText().equals("Copyright © 2021 All rights reserved"))
            System.out.println("Footer text validation is PASSED");
        else System.out.println("Footer text validation is FAILED");

        Driver.quitDriver();
    }
}
