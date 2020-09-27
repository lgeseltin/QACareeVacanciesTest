package pages;

import utils.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);
    private static final By CAREERS = By.xpath("//*[@id='menu-item-127']/a");
    private static final By VACANCIES = By.xpath("//*[@id='menu-item-131']");
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void focusOnCareersMenu() {
        baseFunc.focusElement(CAREERS);
        LOGGER.info("Button [Careers] is found");
    }

    public WebElement getVacanciesPageButtonElementAndClick() {
        WebElement vacanciesButton = baseFunc.getElement(VACANCIES);
        LOGGER.info("Button [Vacancies] is found");
        LOGGER.info("Click on button [Vacancies]");
        vacanciesButton.click();
        return vacanciesButton;
    }
}