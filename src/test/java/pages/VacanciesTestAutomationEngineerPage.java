package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import utils.BaseFunc;

public class VacanciesTestAutomationEngineerPage {

    private static final By SKILLS_PARAGRAPH = By.xpath("//div[15]//p[3]");
    private static final Logger LOGGER = LogManager.getLogger(VacanciesTestAutomationEngineerPage.class);
    private BaseFunc baseFunc;

    public VacanciesTestAutomationEngineerPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String[] getSkillsList() {
        String[] skillsList = baseFunc.getElement(SKILLS_PARAGRAPH).getText().split("\r\n|\r|\n");
        LOGGER.info("Received Skills List " + skillsList);
        return skillsList;
    }
}
