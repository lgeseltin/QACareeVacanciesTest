package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseFunc {
    public WebDriver driver;

    private static final Logger LOGGER = LogManager.getLogger(BaseFunc.class);
    private static final String CHROME_DRIVER_WIN32 = "./drivers/windows/Chrome/chromedriver.exe";
    private static final String CHROME_PROPERTY = "webdriver.chrome.driver";


    public BaseFunc() {
        this.initDriver();
    }

    public void initDriver() {
        System.setProperty(CHROME_PROPERTY, CHROME_DRIVER_WIN32);
        this.driver = new ChromeDriver();
        LOGGER.info("Starting WEB Browser");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
    }

    public void goToUrl(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            LOGGER.info("URL missing http" + url);
            url = "http://" + url;
        }
        LOGGER.info("Opening " + url);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public WebElement getElement(By locator) {
        LOGGER.info("Getting element: " + locator);
        return driver.findElement(locator);
    }

    public void focusElement(By locator) {
                Actions actions = new Actions(driver);
        WebElement focusElement = getElement(locator);
        actions.moveToElement(focusElement).build().perform();
        LOGGER.info("Found element " + locator + " and focused on it");
    }

    public void quitDriver() {
        driver.quit();
        LOGGER.info("Browser closed gracefully");
    }
}