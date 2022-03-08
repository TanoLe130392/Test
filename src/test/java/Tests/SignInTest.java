package Tests;

import Common.SetupBrowser;
import Pages.DashBoardPage;
import Pages.SignInPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.annotations.Test;


public class SignInTest extends SetupBrowser {

    SignInPage signinpage;

    @Test
    public void SignIn() throws Exception {
        signinpage = new SignInPage(driver);
        signinpage.signIn();
    }
}
