package com.salesforce.dev.pages.Opportunities;

import com.salesforce.dev.pages.Base.*;
import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jimmy Vargas on 6/10/2015.
 */
public class OpportunitiesTab extends TabPage{

    public OpportunitiesTab(WebDriver driver){
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(this.driver,this);
    }

     public Object clickNewBtn(){
        this.wait.until(ExpectedConditions.visibilityOf(newBtn));
        newBtn.click();

        return new NewOpportunityPage(this.driver);
    }






}

