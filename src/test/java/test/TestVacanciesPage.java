package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.VacanciesPage;
import pages.VacanciesTestAutomationEngineerPage;
import utils.BaseFunc;

public class TestVacanciesPage {

    private static final Logger LOGGER = LogManager.getLogger(TestVacanciesPage.class);
    private static final String DESKTOP_URL = "https://ctco.lv/en";

    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage = new HomePage(this.baseFunc);
    private VacanciesPage vacanciesPage = new VacanciesPage(this.baseFunc);
    private VacanciesTestAutomationEngineerPage vacanciesTestAutomationEngineerPage = new VacanciesTestAutomationEngineerPage(this.baseFunc);

    @Before
    public void openBrowser() {
        baseFunc.goToUrl(DESKTOP_URL);
    }

    @Test
    public void checkSkillsForAutomationTestEngineer() throws InterruptedException {
        homePage.focusOnCareersMenu();
        homePage.getVacanciesPageButtonElementAndClick();
        vacanciesPage.getTestAutomationEngineerButtonElementAndClick();
        Thread.sleep(2000);
        Assert.assertEquals("Assert that skills paragraph contains 5 skills", vacanciesTestAutomationEngineerPage.getSkillsList().length, 5);
        LOGGER.info("Test for check Skills For Automation Test Engineer - PASSED");
    }

    @After
    public void closeBrowser() {
        baseFunc.quitDriver();
    }
}