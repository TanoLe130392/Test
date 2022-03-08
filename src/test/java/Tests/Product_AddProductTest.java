package Tests;

import Common.SetupBrowser;
import Pages.DashBoardPage;
import Pages.Product_AddProductPage;
import Pages.SignInPage;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Product_AddProductTest extends SetupBrowser {

    SignInPage signinpage;
    DashBoardPage dashboardpage;
    Product_AddProductPage productaddproductpage;

    @BeforeClass
    public void SetupClass() throws Exception {
        signinpage = new SignInPage(driver);
        dashboardpage = signinpage.signIn();
        productaddproductpage = dashboardpage.NavigateToAddNewProductPage();
    }

    @Test
    public void Add_New_Product() throws Exception {
        productaddproductpage.Add_New_Product();
    }
}
