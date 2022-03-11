package com.yahoo.pages;

import com.yahoo.my_methods.MyMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends MyMethods {

    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Sign in")
    WebElement logInLink;
    @FindBy(xpath = "//button[@class='btn primary']")
    WebElement acceptCookie;

    public void acceptCookies(){
        acceptCookie.click();
    }

    public void clickOnLoginLink(){
        logInLink.click();
    }


}
