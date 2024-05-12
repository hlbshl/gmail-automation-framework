package utils;

import common.CommonAction;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static common.Config.FILE_PATH;

public class ScreenshotTaker {
    public static void takeScreenshot(String methodName) {
        File srcFile = ((TakesScreenshot) CommonAction.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(FILE_PATH + methodName + ".jpg"));
        } catch (IOException e) {
            LoggerUtil.logError("Failed to take a screenshot: " + e.getLocalizedMessage());
        }
    }
}
