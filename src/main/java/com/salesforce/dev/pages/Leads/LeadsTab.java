package com.salesforce.dev.pages.Leads;

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.Base.TabPage;
import com.salesforce.dev.pages.CreateNewViewPage;
import com.salesforce.dev.pages.Opportunities.NewOpportunityPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jimmy Vargas on 6/5/2015.
 */
public class LeadsTab {

    WebDriver driver;
    WebDriverWait wait;


    @FindBy(xpath = "//a[contains(text(),'Create New View')]")
    WebElement createNewViewLink;

    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    WebElement deleteViewLink;

    @FindBy(xpath  =  "//select[contains(@id,'_listSelect')]")
    WebElement leadCombobox;

    public LeadsTab(WebDriver driver){
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(this.driver, this);

    }

    public CreateNewViewPage clickCreateNewViewLink(){
        wait.until(ExpectedConditions.elementToBeClickable(createNewViewLink));
        createNewViewLink.click();
        return new CreateNewViewPage(this.driver);
    }

    public boolean  getLeadViewFromCombobox(String viewName){
        try{
            wait.until(ExpectedConditions.visibilityOf(leadCombobox));
            Select lcb = new Select(leadCombobox);
            lcb.selectByVisibleText(viewName);

        } catch (WebDriverException e){
            System.out.println("Cant select the: " + viewName);
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void deleteView(String viewName){

        this.selectLeadView(viewName);
        this.clickDeleteViewLink();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void selectLeadView(String ViewName){
        (new Select(leadCombobox)).selectByVisibleText(ViewName);
    }

    public void clickDeleteViewLink(){
        deleteViewLink.click();
    }


}
