package com.salesforce.dev.pages;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jimmy Vargas on 6/10/2015.
 */
public class OpportunityPage {

    WebDriver driver;
    WebDriverWait wait;

    public OpportunityPage(WebDriver driver){
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
    }
}
