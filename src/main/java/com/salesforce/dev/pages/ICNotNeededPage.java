package com.salesforce.dev.pages;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jimmy Vargas on 6/5/2015.
 */
public class ICNotNeededPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "save")
    WebElement continueButton;

    public ICNotNeededPage(WebDriver driver){
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(this.driver,this);
    }

    public LoginPage clickContinueBtn(){
        this.continueButton.click();
        return new LoginPage(this.driver);
    }

    public boolean isICNotNeededPagePresent(){
        try{
            wait.until(ExpectedConditions.visibilityOf(continueButton));
        }
        catch(WebDriverException e){
            return false;
        }
        return true;
    }

}
