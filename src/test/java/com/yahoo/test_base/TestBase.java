package com.yahoo.test_base;

import com.yahoo.my_methods.MyMethods;
import com.yahoo.properties_reader.ReadingProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends MyMethods {

    String browser = ReadingProperties.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDown(){
        closeBrowser();
    }
}
