package testBase;

import driverFactory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yaml.Loader;

import java.io.IOException;
import java.time.Duration;

public class ImplicitTestBase {
    static private final Logger logger = LoggerFactory.getLogger(ImplicitTestBase.class);
    protected WebDriver driver;
    private static DriverFactory driverFactory;

    private static Loader loader;

    @BeforeAll
    static void setDriver() throws IOException {
        loader = new Loader();
        driverFactory = new DriverFactory();
        logger.info("Webdriver initialized");
    }

    @BeforeEach
    void setUp() {
        driver = driverFactory.getDriver(loader.getBrowser());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Webdriver window start");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.info("Webdriver window closed");
    }
}
