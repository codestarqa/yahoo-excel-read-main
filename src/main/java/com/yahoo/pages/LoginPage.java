package com.yahoo.pages;

import com.yahoo.my_methods.MyMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends MyMethods {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='login-username']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='login-passwd']")
    WebElement password;

    //    @FindBy(xpath ="//button[@id='login-signin']")
    @FindBy(name = "signin")
    WebElement sinIn;
    @FindBy(name = "verifyPassword")
    WebElement veryPword;
    @FindBy(xpath = "//p[@id='username-error']")
    WebElement loginError;

    public void setUserName(String uName) {
        userName.sendKeys(uName);
        sinIn.click();
    }

    public void setPassword(String pWord) {
        password.sendKeys(pWord);
        veryPword.click();
    }

    public String getLoginError() {
        boolean errorShow = loginError.isDisplayed();
        String errorMsg;
        if (!errorShow) {
            errorMsg = "";
        } else {
            errorMsg = loginError.getText();
        }
        return errorMsg;
    }
}
