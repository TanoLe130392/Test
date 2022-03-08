package Pages;

import Common.SetupBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.WebUI;

import java.util.List;

public class DashBoardPage {

    WebDriver driver;
    WebUI webUI;

    By SearchCategoryTextBox = By.xpath("//input[@id='search']");
    By AddNewCategoryBtn = By.xpath("//a[@class='btn btn-primary']");
    By ProductMenuTab = By.xpath("//span[@class='aiz-side-nav-arrow'][1]");

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
        webUI = new WebUI(driver);
    }

    public void SubMenuClick(String submenuName) {
        webUI.clickElement(By.xpath("//span[normalize-space()='" + submenuName + "']"));
    }


    public Product_CategoryPage NavigateToAddCategoryPage(){
        webUI.waitForPageLoaded();
        webUI.clickElement(ProductMenuTab);
        SubMenuClick("Category");
        webUI.clickElement(AddNewCategoryBtn);
        return new Product_CategoryPage(driver);
    }

    public Product_BrandPage NavigateToBrandPage(){
        webUI.waitForPageLoaded();
        webUI.clickElement(ProductMenuTab);
        SubMenuClick("Brand");
        return new Product_BrandPage(driver);
    }

    public Product_AddProductPage NavigateToAddNewProductPage(){
        webUI.waitForPageLoaded();
        webUI.clickElement(ProductMenuTab);
        SubMenuClick("Add New Product");
        return new Product_AddProductPage(driver);
    }

    public void SearchCategory(String value) {
        SubMenuClick("Category");
        Assert.assertEquals(driver.getCurrentUrl(),"https://ecommerce.anhtester.com/admin/categories", "You are not landing on the admin category page to search");
        webUI.setText(SearchCategoryTextBox,value);
        driver.findElement(SearchCategoryTextBox).sendKeys(Keys.ENTER);

    }

    public void CheckSearchDataOnTableByColumn(int column, String searchvalue){
        List<WebElement> rowNumber = driver.findElements(By.xpath("//table//tbody//tr"));
        for (int i =1 ; i <=rowNumber.size();i++){
            WebElement elementCheck = driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td["+column+"]"));
            System.out.println("Element No. " +i);
            System.out.println("Element check = " +elementCheck.getText().toUpperCase());
            System.out.println("search value = " + searchvalue.toUpperCase());
            //Assert.assertEquals(elementCheck.getText().toUpperCase(),searchvalue.toUpperCase(),"No such searching value = " + searchvalue + "");
        }
    }
}