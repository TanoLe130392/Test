package Tests;

import Common.SetupBrowser;
import Pages.DashBoardPage;
import Pages.Product_CategoryPage;
import Pages.SignInPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Product_CategoryTest extends SetupBrowser {

    SignInPage signinpage;
    DashBoardPage dashboardpage;
    Product_CategoryPage productcategorypage;

    @BeforeClass
    public void Navigate_To_Add_Category_Page() throws Exception {
        signinpage = new SignInPage(driver);
        dashboardpage = signinpage.signIn();
        productcategorypage = dashboardpage.NavigateToAddCategoryPage();
    }
    @Test (priority = 1)
    public void Verify_Adding_New_Category(){
        productcategorypage.AddNewCategory("Anna");
    }

    @Test (priority = 2)
    public void Verify_Searching_Category(){
        dashboardpage.SearchCategory("Anna");
        dashboardpage.CheckSearchDataOnTableByColumn(2,"Anna");
    }
}
