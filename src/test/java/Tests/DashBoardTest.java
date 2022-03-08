package Tests;

import Common.SetupBrowser;
import Pages.DashBoardPage;
import Pages.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashBoardTest extends SetupBrowser {

    DashBoardPage dashboardpage;
    SignInPage signinpage;

    @BeforeClass
    public void setupClass() throws Exception {
        signinpage = new SignInPage(driver);
    }

    @Test
    public void Navigate_To_Dash_Board_Page() throws Exception {
        dashboardpage = signinpage.signIn();
    }
}
