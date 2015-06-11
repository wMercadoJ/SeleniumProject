package com.salesforce.dev.pages.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jimmy Vargas on 6/11/2015.
 */
public abstract class TabPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "//a[contains(text(),'Create New View')]")
    protected WebElement createNewViewLink;

    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    protected WebElement deleteViewLink;

    @FindBy(xpath = "//a[contains(text(),'Edit')]")
    protected WebElement editViewLink;

    @FindBy(id = "fcf")
    protected WebElement viewCombobox;

    @FindBy(name = "new")
    protected WebElement newBtn;

    abstract protected Object clickNewBtn();

    public void selectViewByVisibleText(String viewName){
        try{
            wait.until(ExpectedConditions.visibilityOf(viewCombobox));
            Select lcb = new Select(viewCombobox);
            lcb.selectByVisibleText(viewName);
        }
        catch(WebDriverException e){
            System.out.println(e.getMessage());
        }
        finally {
            driver.switchTo().defaultContent();
        }
    }

}
