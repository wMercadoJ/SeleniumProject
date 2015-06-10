package com.salesforce.dev.pages;

import com.salesforce.dev.framework.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.applet.Main;


/**
 * Created by Jimmy Vargas on 6/4/2015.
 */
public class MainPage {


    TopHeader topHeader;
    HomeTab homeTab;
    LeadsTab leadsTab;

    //GettingStartedTab gettingStartedTab;

    private WebDriver driver;
    private WebDriverWait wait;

    //@FindBy(id = "home_Tab")-> didn't work
    //@FindBy(xpath = "//a[@class='brandPrimaryFgr']));") ->didn't work
    @FindBy(xpath = "//a[@href='/home/home.jsp']")
    WebElement homeTabLink;

    @FindBy(linkText = "Leads")
    WebElement leadsTabLink;


    @FindBy(linkText = "Opportunities")
    WebElement opportunitiesLink;

    public MainPage(WebDriver driver){
        this.driver = driver;
        this.wait = DriverManager.getInstance().getWait();
        topHeader = new TopHeader(this.driver);
        //homeTab = new HomeTab(this.driver);

        PageFactory.initElements(this.driver, this);
    }
    public TopHeader gotoTopHeader(){
        return this.topHeader;
    }

    public HomeTab gotoHomeTab(){
        try{
            //wait.until(ExpectedConditions.visibilityOf(homeTabLink));
            wait.until(ExpectedConditions.elementToBeClickable(homeTabLink));
            homeTabLink.click();
        }
        catch(WebDriverException e){
        }
        return new HomeTab(this.driver);
    }

    public LeadsTab gotoLeadsTab(){
        wait.until(ExpectedConditions.elementToBeClickable(leadsTabLink));
        leadsTabLink.click();

        return new LeadsTab(this.driver);
    }

    /**
     * This method returns an instance from OpportunitiesTab
     *
     * @author: Jimmy Vargas
     * @version: 1.0
     * @since: 6/10/2015
     * */
    public OpportunitiesTab gotoOpportunitiesTab(){
        wait.until(ExpectedConditions.elementToBeClickable(opportunitiesLink));
        opportunitiesLink.click();

        return new OpportunitiesTab(this.driver);

    }



}
