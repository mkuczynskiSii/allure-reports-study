package testBase;

import driverFactory.DriverFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yaml.Loader;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBase {
    static private final Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected WebDriver driver;
    private static DriverFactory driverFactory;

    private static Loader loader;


    @BeforeAll
    static void setDriver() throws IOException {
        loader = new Loader();
        driverFactory = new DriverFactory();
        logger.info("Webdriver initialized");
    }

    @Step("Start the application")
    @BeforeEach
    void setUp() {
        driver = driverFactory.getDriver(loader.getBrowser());
        logger.info("Webdriver window start");
    }

    @Step("Stop the application")
    @AfterEach
    void tearDown() {
        Allure
                .getLifecycle()
                .addAttachment(
                        LocalDateTime
                                .now()
                                .format(DateTimeFormatter.ofPattern(
                                        "dd-MMM-yy_hh:mm:ss")), "image/png", "png", makeScreenShot());
        driver.quit();
        logger.info("Webdriver window closed");
    }

    @Step("Make screenshot")
    private byte[] makeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
