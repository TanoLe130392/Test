package helpers;

import jdk.javadoc.doclet.Reporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class CaptureScreenshotHelper {
    // Tạo tham chiếu của TakesScreenshot với driver hiện tại

    public void CaptureScreenshot (WebDriver driver, String screenName) throws IOException {
    TakesScreenshot ts = (TakesScreenshot) driver;
    // Gọi hàm capture screenshot - getScreenshotAs
    File source = ts.getScreenshotAs(OutputType.FILE);
    //Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
    File theDir = new File("./Screenshots/");
        if (!theDir.exists()) {
        theDir.mkdirs();
    }
// result.getName() lấy tên của test case xong gán cho tên File chụp màn hình luôn
        FileHandler.copy(source, new File("./Screenshots/" + screenName + ".jpg"));
        System.out.println("Screenshot taken: " + screenName);
        }

}
