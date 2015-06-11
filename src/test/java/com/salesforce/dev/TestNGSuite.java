package com.salesforce.dev;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by carlos_gonzales on 29-05-15.
 */
public class TestNGSuite {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Starting suite");
    }

    @AfterSuite
    public void afterSuite() {
        try{
            DriverManager.getInstance().quit();
        }
        catch(WebDriverException e){
            System.out.println(e.getMessage());
        }
    }
}
