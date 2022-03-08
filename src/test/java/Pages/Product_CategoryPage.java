package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebUI;

public class Product_CategoryPage {

    WebDriver driver;
    DashBoardPage dashboardpage;
    WebUI webUI;

    //Objects for Add new Category page
    By ParentCategory = By.xpath("//button[@title='No Parent']");
    By FilteringAttributes = By.xpath("//button[@title='Nothing selected']");
    By SearchField_ParentCategory = By.xpath("(//input[@class='form-control'])[2]");
    By SearchField_FilteringAttributes = By.xpath("(//input[@class='form-control'])[5]");
    By ChooseFile_Banner = By.xpath("(//div[@class='form-control file-amount'])[1]");
    By ChooseFile_Icon = By.xpath("(//div[@class='form-control file-amount'])[2]");
    By AddFileBtn = By.xpath("//button[contains(text(),'Add Files')]");
    By SaveBtn = By.xpath("//button[normalize-space()='Save']");


    public Product_CategoryPage(WebDriver driver) {
        this.driver = driver;
        webUI = new WebUI(driver);
    }

    public void InputDataOnTextBox(String fieldName, String value) {
        //driver.findElement(By.id(fieldName)).sendKeys(value);
        webUI.setText(By.id(fieldName),value);
    }

    public void SelectValueOnDynamicDropdownList(String fieldName, String value) {
        if (fieldName.equals("Parent Category")) {
            webUI.clickElement(ParentCategory);
            webUI.setText(SearchField_ParentCategory,value);
            driver.findElement(SearchField_ParentCategory).sendKeys(Keys.ENTER);
        }


        if (fieldName.equals("Filtering Attributes")) {
            webUI.clickElement(FilteringAttributes);
            webUI.setText(SearchField_FilteringAttributes,value);
            driver.findElement(SearchField_FilteringAttributes).sendKeys(Keys.ENTER);
        }
    }

    public void SelectFileOnChooseFile(String fieldName, String fileName) {
        if (fieldName.equals("Banner")) {
            webUI.clickElement(ChooseFile_Banner);
            webUI.clickElement(By.xpath("//div[@title = '" + fileName + "']"));
            webUI.clickElement(AddFileBtn);
        }
        if (fieldName.equals("Icon")) {
            webUI.clickElement(ChooseFile_Icon);
            webUI.clickElement(By.xpath("//div[@title = '" + fileName + "']"));
            webUI.clickElement(AddFileBtn);
        }
    }

    public void ClickSaveBtn(){
        WebElement SaveBtnElement = driver.findElement(SaveBtn);
        Assert.assertTrue(SaveBtnElement.isDisplayed(), "Không hiển thị element save");
        SaveBtnElement.click();
    }

    public void AddNewCategory (String categoryName) {

        Assert.assertEquals(driver.getCurrentUrl(),"https://ecommerce.anhtester.com/admin/categories/create");

        InputDataOnTextBox("name",categoryName);
        SelectValueOnDynamicDropdownList("Parent Category", "Macbook Model A2337");
        InputDataOnTextBox("order_level","2");
        SelectFileOnChooseFile("Banner","image.png");
        SelectValueOnDynamicDropdownList("Filtering Attributes", "Fabric");
        ClickSaveBtn();

        Assert.assertEquals(driver.getCurrentUrl(),"https://ecommerce.anhtester.com/admin/categories");

    }
}