package com.salesforce.dev.pages;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Leads.LeadsTab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jimmy Vargas on 6/5/2015.
 */
public class CreateNewViewPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "fname")
    WebElement viewNameField;

    @FindBy(id = "devname")
    WebElement viewUniqueNameField;

    @FindBy(id = "fscope1")
    WebElement myUnconvertedLeadsRadio;

    @FindBy(xpath = "//input[@data-uidsfdc='4']")
    WebElement saveBtn;

    @FindBy(css = "img.rightArrowIcon")
    WebElement addFieldsBtn;

    public CreateNewViewPage(WebDriver driver){
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(this.driver, this);
    }

    public void setViewName(String viewName){
        wait.until(ExpectedConditions.visibilityOf(viewNameField));
        viewNameField.clear();
        viewNameField.sendKeys(viewName);
    }
    public void setViewUniqueName(String viewUniqueName){
        wait.until(ExpectedConditions.visibilityOf(viewUniqueNameField));
        viewUniqueNameField.clear();
        viewUniqueNameField.sendKeys(viewUniqueName);
    }
    public void selectMyUnconvertedLeadsRadio(){
        wait.until(ExpectedConditions.visibilityOf(myUnconvertedLeadsRadio));
        myUnconvertedLeadsRadio.click();

    }

    // did this way in order to save time
    public void selectFieldsToDisplay(String lastName,String firstName){
        Select selectFieldsToDisplay = new Select(driver.findElement(By.id("colselector_select_0")));
        selectFieldsToDisplay.selectByVisibleText(lastName);
        selectFieldsToDisplay.selectByVisibleText(firstName);
    }


    public void clickAddFieldsBtn(){
        wait.until(ExpectedConditions.visibilityOf(addFieldsBtn));
        addFieldsBtn.click();
    }

    public LeadsTab clickSaveBtn(){
        saveBtn.click();
        return new LeadsTab(this.driver);
    }

}
