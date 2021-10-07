package core.report;

import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import core.driver.DriverManager;

@Log4j2
public class Report extends DriverManager {

    @Attachment(value = "Page Screenshot", type = "image/png")
    public static byte[] takeScreenShot() {
        log.info("Tirando print screen da tela");
        return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
