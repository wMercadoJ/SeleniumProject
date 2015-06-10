package com.salesforce.dev.pages;

import com.gargoylesoftware.htmlunit.Page;
import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jimmy Vargas on 6/4/2015.
 */
public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "username")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "Login")
    WebElement loginBtn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(this.driver,this);
    }

    public MainPage loginAs(String userName,String password){
        this.setUserName(userName);
        this.setPassword(password);
        this.clickLoginBtn();
        ICNotNeededPage icNotNeededPage = new ICNotNeededPage(this.driver);

        if(icNotNeededPage.isICNotNeededPagePresent()){
            icNotNeededPage.continueButton.click();
        }
        return new MainPage(this.driver);
    }

    public void setUserName(String userName){
        try{
            wait.until(ExpectedConditions.visibilityOf(userNameField));
            userNameField.clear();
            userNameField.sendKeys(userName);
        }
        catch(WebDriverException e){
            throw new  WebDriverException(e);
        }
    }

    public void setPassword(String password){
        try{
            wait.until(ExpectedConditions.visibilityOf(passwordField));
            passwordField.clear();
            passwordField.sendKeys(password);
        }
        catch(WebDriverException e){
            throw new  WebDriverException(e);
        }
    }

    public void clickLoginBtn(){
        try{
            wait.until(ExpectedConditions.visibilityOf(passwordField));
            this.loginBtn.click();
        }
        catch(WebDriverException e){
            throw new  WebDriverException(e);
        }
    }
}
