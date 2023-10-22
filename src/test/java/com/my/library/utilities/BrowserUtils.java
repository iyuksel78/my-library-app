package com.my.library.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    public static void sleep(int second){
        second*=1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    public static void switchWindowAndVerify(String expectedURL, String expectedTitle){
        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowsHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("getCurrentUrl is = " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedURL)){
                break;
            }

            String actualTitle = Driver.getDriver().getTitle();
            Assert.assertEquals(actualTitle,expectedTitle);
        }
    }

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
    }

    /**
     *
     * @param expectedInURL
     */
    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    public static void waitForInvisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);
        List<WebElement> optionsAsElements = select.getOptions();

        List<String> optionsAsString = new ArrayList<>();

        for (WebElement each : optionsAsElements) {
            optionsAsString.add(each.getText());
        }
        return  optionsAsString;
    }

    public static void clickRadioButton(List<WebElement> radioButtons, String expectedText){

        for (WebElement each : radioButtons) {

            if (each.getText().equalsIgnoreCase(expectedText)) {
                each.click();
            }

        }
    }




}
