package Pages;

import helpers.ExcelHelpers;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.WebUI;

public class Product_AddProductPage {

    WebDriver driver;
    WebUI webUI;
    Actions action;

    // -----   Objects - Product Information
    By productNameInput = By.xpath("//input[@placeholder='Product Name']");
    By categoryDropdown = By.xpath("//button[@title='Computer & Accessories']");
    By searchCategoryInput = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    By brandDropdown = By.xpath("//button[@title='Select Brand']");
    By searchBrandInput = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    By minimumPurchaseQtyInput = By.xpath("//input[@name='min_qty']");
    By unitInput = By.xpath("//input[@name='unit']");
    By tagsInput = By.xpath("//tags[@role='tagslist']");


    // ----- Objects - Product Variation
    By colorOnOffBtn = By.xpath("//div[@class='col-md-1']//span");
    By colorDropdown = By.xpath("//input[@value='Colors']/following::button[@title='Nothing selected'][1]");
    By searchcolorInput = By.xpath("//input[@value='Colors']/following::input[@type='search'][1]");
    By attributesDropdown = By.xpath("//input[@value='Attributes']/following::button[@title='Nothing selected']");
    By attributesInput = By.xpath("//input[@value='Attributes']/following::input[@type='search']");
    By sizeDropdown = By.xpath("//input[@value = 'Size']/following::button[@title='Nothing selected']");
    By sizeInput = By.xpath("//input[@value = 'Size']/following::input[@type='search']");


    // ----- Objects - Product price + stock
    By unitPriceInput = By.xpath("//input[@name = 'unit_price']");
    By discountInput = By.xpath("//input[@name = 'discount']");
    By unitDiscountDropdown = By.xpath("(//input[@placeholder='Discount']/following::button)[1]");
    By quantityInput = By.xpath("//input[@name='current_stock']");

    // ----- Objects - Save buttons
    By savePublishBtn = By.xpath("//button[normalize-space()='Save & Publish']");



    public Product_AddProductPage(WebDriver driver) {
        this.driver = driver;
        webUI = new WebUI(driver);
        action = new Actions(driver);
    }

    ExcelHelpers excel = new ExcelHelpers();

    public void Input_data_Product_Information() throws Exception {
        excel.setExcelFile("src/test/resources/Login Account.xlsx","Add Product Page data");
        webUI.setText(productNameInput,"HaiQuy");
        webUI.clickElement(categoryDropdown);
        webUI.setText(searchCategoryInput,"TomLe");
        driver.findElement(searchCategoryInput).sendKeys(Keys.ENTER);


        webUI.clickElement(brandDropdown);
        webUI.setText(searchBrandInput,"TOMSTG");
        driver.findElement(searchBrandInput).sendKeys(Keys.ENTER);

        webUI.setText(minimumPurchaseQtyInput,"1");
        webUI.setText(unitInput, "pcs");

    }

    public void Input_Data_Product_Variation(){
        WebElement scrollDown = driver.findElement(By.xpath("//label[normalize-space()='Video Link']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollDown);
        if (driver.findElement(colorOnOffBtn).isEnabled() == true) {
            webUI.clickElement(colorOnOffBtn);
        }
        webUI.clickElement(colorDropdown);
        webUI.setText(searchcolorInput,"Orange");
        driver.findElement(searchcolorInput).sendKeys(Keys.ENTER);
        action.keyDown( Keys.CONTROL ).sendKeys( "a" ).keyUp( Keys.CONTROL ).build().perform();
        action.sendKeys(Keys.DELETE);
        webUI.setText(searchcolorInput,"Yellow");
        driver.findElement(searchcolorInput).sendKeys(Keys.ENTER);
        action.keyDown( Keys.CONTROL ).sendKeys( "a" ).keyUp( Keys.CONTROL ).build().perform();
        action.sendKeys(Keys.DELETE);
        webUI.clickElement(By.xpath("//input[@value='Colors']"));
        webUI.clickElement(attributesDropdown);
        webUI.setText(attributesInput,"Size");
        driver.findElement(attributesInput).sendKeys(Keys.ENTER);
        webUI.clickElement(By.xpath("//input[@value='Attributes']"));
        webUI.clickElement(sizeDropdown);
        webUI.setText(sizeInput,"XL");
        driver.findElement(sizeInput).sendKeys(Keys.ENTER);
        webUI.clickElement(By.xpath("//input[@value='Size']"));

    }

    public void Input_Data_ProductPrice_Stock() throws InterruptedException {

        WebElement scrollDown = driver.findElement(By.xpath("//input[@value='Attributes']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollDown);
        webUI.setText(unitPriceInput,"5000");
        webUI.setText(discountInput,"30");
    }

    public void Click_On_Save_Publish_button(){
        WebElement scrollDown = driver.findElement(By.xpath("//h5[normalize-space()='SEO Meta Tags']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollDown);
        webUI.clickElement(savePublishBtn);
    }

    public void Add_New_Product() throws Exception {
        Input_data_Product_Information();
        Input_Data_Product_Variation();
        Input_Data_ProductPrice_Stock();
        Click_On_Save_Publish_button();
    }
}
