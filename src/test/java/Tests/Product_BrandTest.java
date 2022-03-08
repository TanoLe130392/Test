package Tests;

import Common.SetupBrowser;
import Pages.DashBoardPage;
import Pages.Product_BrandPage;
import Pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Product_BrandTest extends SetupBrowser {

    SignInPage signinpage;
    DashBoardPage dashboardpage;
    Product_BrandPage productbrandpage;

    @BeforeClass
    public void SetupClass() throws Exception {
        signinpage = new SignInPage(driver);
        dashboardpage = signinpage.signIn();
        productbrandpage = dashboardpage.NavigateToBrandPage();
    }

    @Test
    public void Add_New_Brand(){
        productbrandpage.Add_New_Brand("TomSTG");
    }
}
