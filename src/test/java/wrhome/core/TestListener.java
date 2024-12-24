package wrhome.core;


import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import static wrhome.core.BaseSeleniumTest.driver;

public class TestListener implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
//        Allure.getLifecycle().addAttachment(
//                "screenshot", "image/png", "png",
//                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
//        );
        driver.close();
        driver.quit();
    }

}
