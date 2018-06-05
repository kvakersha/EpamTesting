package com.spbstu.lab3;

import com.spbstu.lab3.enums.PAGE_DATA;
import com.spbstu.lab3.utilities.TestConfig;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static com.spbstu.lab3.TestWebsiteSelenide.differentElementsPages;
import static com.spbstu.lab3.TestWebsiteSelenide.homePageSelenide;
import static com.spbstu.lab3.enums.DIFF_ELEMENTS_DATA.*;
import static org.aeonbits.owner.ConfigFactory.create;

public class TestLab3 {



    @BeforeSuite
    public void beforeSuite() {
        TestConfig cfg = create(TestConfig.class);
        com.codeborne.selenide.Configuration.timeout = 6000;
        com.codeborne.selenide.Configuration.browser = "chrome";
        TestWebsiteSelenide.init();
    }

    @Test
    public void Lab3_1() {
        homePageSelenide.open();
        homePageSelenide.checkLoggedIn(PAGE_DATA.LOGIN.str, PAGE_DATA.PASSWORD.str);
        homePageSelenide.checkUserName(PAGE_DATA.USER_NAME.str);
        homePageSelenide.checkIconsAndTextsExists();
        homePageSelenide.checkMainTitle(PAGE_DATA.MAIN_HEADER.str);
        homePageSelenide.checkMainText(PAGE_DATA.HOME_PAGE.str);
        homePageSelenide.checkSreviceButtons(PAGE_DATA.SERVICE.strAr);

        differentElementsPages.differentElementsPageButton.click();
        differentElementsPages.checkDiffBoxexExists();

        differentElementsPages.selectBoxElements(CHECK_BOXES.strAr[2]);
        differentElementsPages.selectBoxElements(CHECK_BOXES.strAr[0]);
        differentElementsPages.selectRadioElements(RADIOS.strAr[3]);
        differentElementsPages.selectColorElement(DROP_COLORS.strAr[3]);
        differentElementsPages.selectBoxElements(CHECK_BOXES.strAr[0]);
        differentElementsPages.selectBoxElements(CHECK_BOXES.strAr[2]);
        differentElementsPages.checkSelectedElements(SELECT_ELEMENTS.strAr);
    }

    @Test
    public void Lab3_2() {
        //homePageSelenide.open(cfg);
        //homePageSelenide.isLoggedIn(PAGE_DATA.LOGIN.str, PAGE_DATA.PASSWORD.str);
        //homePageSelenide.isUserNameOK(PAGE_DATA.USER_NAME.str);

        homePageSelenide.serviceHeader.click();
        differentElementsPages.datesPageButton.click();

        differentElementsPages.checkSlidePositions(0, 100);
        // sleep(3000);
        differentElementsPages.checkSlidePositions(0, 0);
        //sleep(1000);
        differentElementsPages.checkSlidePositions(100, 100);
        //sleep(1000);
        differentElementsPages.checkSlidePositions(30, 70);
        sleep(3000);
    }
}
