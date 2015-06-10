package com.salesforce.dev;

/**
 * Created by Jimmy Vargas on 6/5/2015.
 */

/***
 * 1. Create a View Lead
 Preconditions
 1. Login in the app
 Steps:
 1. Go to Sales App Menu
 2. Go to Leads tab
 3. Click the 'Create New View' link
 4. Set the View name
 5. Set the View Unique name
 6. Select the 'My unconverted Leads' radio button
 7. Select the Last Name and First Name fields in the MultiSelect (Select fields to display)
 8. Click Save
 Expected Result:
 The new View Lead should be displayed in the ComboBox views

 Postcondition
 Delete the created View Lead

 */

import com.salesforce.dev.framework.DriverManager;
import com.salesforce.dev.pages.CreateNewViewPage;
import com.salesforce.dev.pages.HomePage;
import com.salesforce.dev.pages.LeadsTab;
import com.salesforce.dev.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;

public class CreateViewLead {

    HomePage homePage;
    MainPage mainPage;
    LeadsTab leadsTab;

    String account = "gordines007@hotmail.com";
    String password = "control123!@#";

    String viewName = "ViewName_JV";
    String viewUniqueName = "viewUniqueName_JV";

    @BeforeMethod
    public void setup(){
        homePage = new HomePage();
        mainPage = homePage.loginAs(account,password);
    }

    @Test
    public void VerifyCreateViewLead(){


        leadsTab = mainPage.gotoLeadsTab();
        CreateNewViewPage newViewPage= leadsTab.clickCreateNewViewLink();
        newViewPage.setViewName(viewName);
        newViewPage.setViewUniqueName(viewUniqueName);
        newViewPage.selectMyUnconvertedLeadsRadio();
        newViewPage.selectFieldsToDisplay("Last Name", "First Name");
        newViewPage.clickAddFieldsBtn();

        leadsTab = newViewPage.clickSaveBtn();

        //getting name of the view from the LeadsPage
        System.out.println(leadsTab.getLeadViewFromCombobox(viewName));
        Assert.assertTrue(leadsTab.getLeadViewFromCombobox(viewName),
                            "The view name '"+ viewName + "' it is not in the combobox");


    }

    @AfterMethod
    public void tearDown(){
        leadsTab.deleteView(viewName);
        DriverManager.getInstance().quit();
    }

}
