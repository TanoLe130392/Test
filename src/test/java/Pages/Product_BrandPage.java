package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.WebUI;

public class Product_BrandPage {

    WebDriver driver;
    DashBoardPage dashboardpage;
    Product_CategoryPage productcategorypage;
    WebUI webUI;

    By nameInput = By.xpath("//input[@placeholder='Name']");
    By logoBrowser = By.xpath("//div[@class='input-group-text bg-soft-secondary font-weight-medium']");
    By metaTitleInput = By.xpath("//input[@placeholder='Meta Title']");
    By metaDescriptionInput = By.xpath("//textarea[@name='meta_description']");
    By saveBtn = By.xpath("//button[normalize-space()='Save']");
    By addFileBtn = By.xpath("//button[normalize-space()='Add Files']");
    By searchbrandTextbox = By.xpath("//input[@id='search']");

    public Product_BrandPage(WebDriver driver) {
        this.driver = driver;
        webUI = new WebUI(driver);
    }

    public void Add_New_Brand(String brandName){
        Assert.assertEquals(driver.getCurrentUrl(),"https://ecommerce.anhtester.com/admin/brands");
        webUI.setText(nameInput,brandName);
        webUI.clickElement(logoBrowser);
        webUI.clickElement(By.xpath("//div[@title='Logo.png']"));
        webUI.clickElement(addFileBtn);
        webUI.setText(metaTitleInput,"Logo");
        webUI.setText(metaDescriptionInput,"Logo description");
        webUI.clickElement(saveBtn);
    }

    public void Search_Brand(String value){
        Assert.assertEquals(driver.getCurrentUrl(),"https://ecommerce.anhtester.com/admin/brands","You are not landing on Brand page detail");
        webUI.setText(searchbrandTextbox,value);
        driver.findElement(searchbrandTextbox).sendKeys(Keys.ENTER);
    }

    public void Check_Searching_Brand(String searchingvalue){
        String Elementcheck = driver.findElement(By.xpath("//table//tbody//tr//td[2]")).getText();
        Assert.assertEquals(Elementcheck,searchingvalue,"No searching data");
    }

}
