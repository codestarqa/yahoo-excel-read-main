package com.yahoo.pages;

import com.yahoo.my_methods.MyMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class FinancePage extends MyMethods {
    public FinancePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='root_5']")
    WebElement headers;
    @FindBy(xpath = "//div[@title='Market Data']")
    WebElement marketData;
    @FindBy(xpath = "//a[@title='Calendar']")
    WebElement calendar;
    @FindBy(xpath = "//a[@title='Next']")
    WebElement nextButton;
    @FindBy(xpath = "//div[@id='Lead-4-CalEvents-Proxy']//li[3]//a") // This is next frame
    List<WebElement> listValues;
    // This is a first frame
    //div[@id='mrt-node-Lead-4-CalEvents']//li[5]

    @FindBy(xpath = "//div[@id='Lead-4-CalEvents-Proxy']//li[3]//div")
    WebElement dates;

    public void getHeaders() {
        System.out.println("Header: " + headers.getText());
        headers.click();
        System.out.println("Market Data:" + marketData.getText());
        mouseHoverToElement(marketData);
        marketData.click();
        System.out.println(calendar.getText());
        mouseHoverToElement(calendar);
        calendar.click();
        nextButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='Lead-4-CalEvents-Proxy']")));
    }

    public List<String> getListOfValues() {
        List<String> values = new ArrayList<>();
        for (WebElement lst : listValues) {
            values.add(lst.getText());
        }
        return values;
    }

}
