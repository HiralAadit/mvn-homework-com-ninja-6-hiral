package com.tutorialsninja.testbase;

import com.tutorialsninja.Utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {
    String browser = "chrome";
    //PropertyReader.getInstance().getProperty("browser");


    @BeforeMethod
    public void setUp(){
        selectBrowser(browser);
    }





    @AfterMethod
    public void tearDown(){
        closerBrowser();
    }
}

