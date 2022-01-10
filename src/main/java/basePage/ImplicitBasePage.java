package basePage;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class ImplicitBasePage {
    static private final Logger logger = LoggerFactory.getLogger(ImplicitBasePage.class);
    public WebDriver driver;
    public Actions action;
    public Random random;

    public ImplicitBasePage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
        random = new Random();
        PageFactory.initElements(driver, this);
    }

    String getElementSelector(WebElement element) {
        return element.toString().split("->")[1];
    }

    public void performClick(WebElement element) {
        try {
            logger.info("Trying to click on element: {}", getElementSelector(element));
            element.click();
        } catch (TimeoutException e) {
            e.printStackTrace();
            logger.error("Element not found");
        }
    }

    public void typeTextTo(WebElement element, String message) {
        element.clear();
        element.sendKeys(message);
        logger.info("Text: {} has been typed to element: {}", message, element);
    }
}
