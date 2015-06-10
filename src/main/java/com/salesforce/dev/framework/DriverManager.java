package com.salesforce.dev.framework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jimmy Vargas on 6/4/2015.
 */
public class DriverManager {
    private WebDriver driver;
    private WebDriverWait wait;

    private static DriverManager instance = null;

    private DriverManager(){
        this.initializer();

    }

    private void initializer(){
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,15);

        driver.get("https://www.salesforce.com");

        driver.manage().window().maximize();

    }

    public static DriverManager getInstance(){
        if(instance==null){
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriverWait getWait(){
        return this.wait;

    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public void quit(){
        driver.close();
        driver.quit();
    }
}
