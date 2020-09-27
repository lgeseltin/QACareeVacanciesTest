package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseFunc;

public class VacanciesPage {

    private static final By TEST_AUTOMATION_BUTTON = By.xpath("//*[contains(@id,'menu-item-3249')]/a");
    private static final Logger LOGGER = LogManager.getLogger(VacanciesPage.class);
    private BaseFunc baseFunc;

    public VacanciesPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public WebElement getTestAutomationEngineerButtonElementAndClick() {
        WebElement TestAutomationEngineerButton = baseFunc.getElement(TEST_AUTOMATION_BUTTON);
        LOGGER.info("Found profession [Test Automation Engineer]");
        LOGGER.info("Click on profession [Test Automation Engineer]");
        TestAutomationEngineerButton.click();
        return TestAutomationEngineerButton;
    }
}