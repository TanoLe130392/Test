package Pages;

import helpers.CaptureScreenshotHelper;
import helpers.ExcelHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebUI;

public class SignInPage {

    WebDriver driver = null;
    DashBoardPage dashBoardPage;
    WebUI webUI;


    By emailInput = By.xpath("//input[@id='email']");
    By passwordInput = By.xpath("//input[@id='password']");
    By signInBtn = By.xpath("//button[normalize-space()='Login']");


    public SignInPage(WebDriver _driver) {
        driver = _driver;
        webUI = new WebUI(driver);
    }

    ExcelHelpers excel = new ExcelHelpers();
//    CaptureScreenshotHelper captureScreenshot = new CaptureScreenshotHelper();

    public DashBoardPage signIn() throws Exception {
        driver.get("https://ecommerce.anhtester.com/login");
        webUI.waitForPageLoaded();
        EnterEmail();
        EnterPassword();
        ClickSignInBtn();
        return new DashBoardPage(driver);
    }

    public void EnterEmail() throws Exception {
        WebElement emailElement = driver.findElement(emailInput);
        Assert.assertTrue(emailElement.isDisplayed(), "Không hiển thị element email");
        excel.setExcelFile("src/test/resources/Login Account.xlsx","LoginData");
        emailElement.sendKeys(excel.getCellData("username", 1));
    }

    public void EnterPassword() throws Exception {
        WebElement passwordElement = driver.findElement(passwordInput);
        Assert.assertTrue(passwordElement.isDisplayed(), "Không hiển thị element password");
        excel.setExcelFile("src/test/resources/Login Account.xlsx","LoginData");
        passwordElement.sendKeys(excel.getCellData("password", 1));
    }

    public void ClickSignInBtn(){
        WebElement SignInBtnElement = driver.findElement(signInBtn);
        Assert.assertTrue(SignInBtnElement.isDisplayed(), "Không hiển thị element password");
        SignInBtnElement.click();
    }

}
