package com.yahoo.test_suite;

import com.yahoo.customlisteners.CustomListeners;
import com.yahoo.pages.FinancePage;
import com.yahoo.pages.HomePage;
import com.yahoo.pages.LoginPage;
import com.yahoo.read_excel.ExcelUtility;
import com.yahoo.test_base.TestBase;
import org.junit.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Listeners(CustomListeners.class)
public class LoginPageTestWithExcel extends TestBase {

    public static final String File_Path = System.getProperty("user.dir") + "/src/test/java/test_data/mycredentials.xlsx";

    HomePage homePage;
    LoginPage loginPage;
    FinancePage financePage;

    @BeforeClass
    public void setExcel() {
        //Tell the code about the location of Excel file
        try {
            ExcelUtility.setExcelFile(File_Path, "LoginTests");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void initialise() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        financePage = new FinancePage();
    }

    @DataProvider(name = "credentials")
    public Object[][] getData() {
        Object[][] data = ExcelUtility.getTestData("Invalid_Login");
        return data;
    }

    @Test(dataProvider = "credentials")
    public void doLogin(String userName, String password){
        homePage.acceptCookies();
        homePage.clickOnLoginLink();
        loginPage.setUserName(userName);

        try {
            String actualError = loginPage.getLoginError();
            System.out.println(actualError);
        }
        catch (Exception e){
            loginPage.setPassword(password);
            financePage.getHeaders();

            List<String> expectedListOfValues = new ArrayList<>();
            //Below expected values subject to change
            expectedListOfValues.add("28 Earnings");
            expectedListOfValues.add("15 Stock splits");
            expectedListOfValues.add("2 IPO pricing");
            expectedListOfValues.add("87 Economic events");

            System.out.println("Expected List: "+expectedListOfValues);
            //TestNG: //Assert.assertEquals(expectedListOfValues,financePage.getListOfValues(),"List of values are not Matched");
            //Below used JUnit:
            Assert.assertArrayEquals("List of values are not matched ",expectedListOfValues.toArray(),financePage.getListOfValues().toArray());
            e.printStackTrace();
            e.getCause();
        }

    }


}
