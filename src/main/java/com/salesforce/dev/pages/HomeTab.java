package com.salesforce.dev.pages;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jimmy Vargas on 6/5/2015.
 */
public class HomeTab {

    WebDriver driver;
    WebDriverWait wait;

    //LeftMenu -> should the correct and it would henritance from another class

    @FindBy(id = "createNewButton")
    WebElement createNewButton;

    @FindBy(css = "a.menuButtonMenuLink.taskMru")
    WebElement createTaskMenuOption;

    public HomeTab(WebDriver driver){
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(this.driver,this);
    }

    public void clickCreateNewBtn(){
        try{
            wait.until(ExpectedConditions.visibilityOf(createNewButton));
            this.createNewButton.click();
        }
        catch(WebDriverException e){
            throw new WebDriverException(e);
        }
        finally {
            this.driver.switchTo().defaultContent();
        }
    }

    public CreateTaskPage clickCreateTaskMenuOption(){
        try{
            wait.until(ExpectedConditions.visibilityOf(createTaskMenuOption));
            createTaskMenuOption.click();
        }
        catch(WebDriverException e){
            throw new WebDriverException(e);
        }
        finally {
            driver.switchTo().defaultContent();
        }

        return new CreateTaskPage(this.driver);

    }



}
