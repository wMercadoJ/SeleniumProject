package com.salesforce.dev;

import com.salesforce.dev.pages.*;
import com.salesforce.dev.pages.Opportunities.NewOpportunityPage;
import com.salesforce.dev.pages.Opportunities.OpportunitiesTab;
import com.salesforce.dev.pages.Opportunities.OpportunityPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Jimmy Vargas on 6/10/2015.
 */
public class Opportunities {

    String account = "gordines007@hotmail.com";
    String password = "control123!@#";

    String opportunityName = "opNameAUT";
    String stage = "Prospecting";


    HomePage homePage;
    LoginPage loginPage;
    MainPage mainPage;

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage();
        mainPage = homePage.loginAs(account,password);

    }
    @Test
    public void CreateOpportunity(){

        OpportunitiesTab opTab = mainPage.gotoOpportunitiesTab();
        //opTab.selectViewByVisibleText("New This Week");

        //small piece for all test case
        NewOpportunityPage newOpPage = (NewOpportunityPage)opTab.clickNewBtn();

        newOpPage.setOpportunityName(opportunityName);
        newOpPage.setCloseDate();
        newOpPage.setStageByVisibleText(stage);
        OpportunityPage opportunityPage = newOpPage.clickSaveBtn();



    }

    @AfterMethod
    public void tearDown(){

    }

}
