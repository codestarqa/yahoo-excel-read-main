package com.yahoo.all_drivers;

import com.yahoo.properties_reader.ReadingProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class AllDrivers {
    public static WebDriver driver;
    public String baseUrl = ReadingProperties.getInstance().getProperty("baseUrl");
    public String sec=ReadingProperties.getInstance().getProperty("implicitlyWait");
    public long seconds=Long.parseLong(sec);

    public void selectBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Wrong browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        driver.get(baseUrl);
    }

    public void closeBrowser(){
        if (driver != null){
            driver.quit();
        }
    }
}
