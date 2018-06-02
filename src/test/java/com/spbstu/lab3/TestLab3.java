package com.spbstu.lab3;

import com.codeborne.selenide.Condition;
import com.spbstu.lab3.enums.DIFF_ELEMENTS_DATA;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.spbstu.lab3.TestWebsiteSelenide.differentElementsPages;
import static com.spbstu.lab3.TestWebsiteSelenide.homePageSelenide;
import static org.aeonbits.owner.ConfigFactory.create;
import com.spbstu.lab3.enums.PAGE_DATA;
import com.spbstu.lab3.utilities.TestConfig;

public class TestLab3 {

    TestConfig cfg;

    @BeforeSuite
    public void beforeSuite() {
        cfg = create(TestConfig.class);
        com.codeborne.selenide.Configuration.timeout = 6000;
        com.codeborne.selenide.Configuration.browser = "chrome";
        TestWebsiteSelenide.init();
    }

    @Test
    public void Lab3_1() {

        homePageSelenide.open(cfg);
        homePageSelenide.isLoggedIn(PAGE_DATA.LOGIN.str, PAGE_DATA.PASSWORD.str);
        homePageSelenide.isUserNameOK(PAGE_DATA.USER_NAME.str);
        homePageSelenide.areIconsAndTextsExists();
        homePageSelenide.isMainTitleOK(PAGE_DATA.MAIN_HEADER.str);
        homePageSelenide.isMainTextOK(PAGE_DATA.HOME_PAGE.str);
        homePageSelenide.areSreviceButtonsOK(PAGE_DATA.SERVICE.strAr);

        differentElementsPages.DifferentElementsPageButton.click();
        differentElementsPages.areDiffBoxexExists();

        differentElementsPages.selectBoxElements("Wind");
        differentElementsPages.selectBoxElements("Water");
        differentElementsPages.selectBoxElements("Selen");
        differentElementsPages.selectColorElement("Yellow");
        differentElementsPages.selectBoxElements("Water");
        differentElementsPages.selectBoxElements("Wind");
        differentElementsPages.checkSelectedElements(DIFF_ELEMENTS_DATA.SELECT_ELEMENTS.strAr);
        for (int i = 0; i < differentElementsPages.Logs.size();i++)
            System.out.println(differentElementsPages.Logs.get(i).getText());
    }

    @Test
    public void Lab3_2() {
        homePageSelenide.open(cfg);
        homePageSelenide.isLoggedIn(PAGE_DATA.LOGIN.str, PAGE_DATA.PASSWORD.str);
        homePageSelenide.isUserNameOK(PAGE_DATA.USER_NAME.str);

        homePageSelenide.ServiceHeader.click();
        differentElementsPages.DatesPageButton.click();

        Integer length = 274;
        differentElementsPages.slideToPositions(0, 100);
       // sleep(3000);
        differentElementsPages.slideToPositions(0, 0);
        //sleep(1000);
        differentElementsPages.slideToPositions(100, 100);
        //sleep(1000);
        differentElementsPages.slideToPositions(30, 70);

        //case (20, 100) -> (0, 100)
        /*
        actions().dragAndDropBy(differentElementsPages.Sliders.get(0) , -(length*21/100), 0).perform();
        differentElementsPages.Sliders.get(0).shouldHave(Condition.text(String.valueOf(0)));
        differentElementsPages.Sliders.get(1).shouldHave(Condition.text(String.valueOf(100)));
        //case (0, 100) -> (0, 0)
        actions().dragAndDropBy(differentElementsPages.Sliders.get(1) , -(length*101/100), 0).perform();
        differentElementsPages.Sliders.get(0).shouldHave(Condition.text(String.valueOf(0)));
        differentElementsPages.Sliders.get(1).shouldHave(Condition.text(String.valueOf(0)));
        //case (0, 0) -> (100, 100)
        actions().dragAndDropBy(differentElementsPages.Sliders.get(0) , (length*(1+100)/100), 0).perform();
        System.out.println(Integer.parseInt(differentElementsPages.Sliders.get(0).getText()));
        actions().dragAndDropBy(differentElementsPages.Sliders.get(1) , (1), 0).perform();
        System.out.println(Integer.parseInt(differentElementsPages.Sliders.get(1).getText()));
        differentElementsPages.Sliders.get(0).shouldHave(Condition.text(String.valueOf(100)));
        differentElementsPages.Sliders.get(1).shouldHave(Condition.text(String.valueOf(100)));
        */
        //System.out.println(Integer.parseInt(differentElementsPages.Sliders.get(1).getText()));
        //actions().dragAndDropBy(differentElementsPages.Sliders.get(1) , -(length*99/100), 0).perform();
        //System.out.println(Integer.parseInt(differentElementsPages.Sliders.get(1).getText()));
    }
}
