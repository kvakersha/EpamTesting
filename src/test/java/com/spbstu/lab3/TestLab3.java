package com.spbstu.lab3;

import org.testng.annotations.Test;

public class TestLab3 {

    @Test
    public void Lab3_1() {

        HomePageSelenide homePageSelenide;
        homePageSelenide = new HomePageSelenide();
        //PageObject.homePage.open();
        homePageSelenide.open();
        //HomePageSelenide.getTitile((String) com.spbstu.lab3.enums.PAGE_DATA.TITLE.toString());
       // HomePageSelenide.
        /*
        PageObject.homePage.getUrl();
        Assert.assertEquals(PageObject.homePage.getUrl(), com.spbstu.lab3.PAGE_DATA.SITE.str);
        Assert.assertEquals(PageObject.homePage.getTitle(), com.spbstu.lab3.PAGE_DATA.TITLE.str);
        Assert.assertTrue(PageObject.homePage.isLoggedIn(com.spbstu.lab3.PAGE_DATA.LOGIN.str, com.spbstu.lab3.PAGE_DATA.PASSWORD.str));

        Assert.assertEquals(PageObject.homePage.getUsername(), com.spbstu.lab3.PAGE_DATA.USER_NAME.str);
        Assert.assertEquals(PageObject.homePage.getTitle(), com.spbstu.lab3.PAGE_DATA.TITLE.str);

        Assert.assertEquals(PageObject.homePage.getIconsNumber(), com.spbstu.lab3.PAGE_DATA.ACTUAL_ICONS_NUMBERS.i);

        for (int i = 0; i < com.spbstu.lab3.PAGE_DATA.ACTUAL_ICONS_NUMBERS.i; i++) {
            Assert.assertEquals(PageObject.homePage.getPictureText(i), com.spbstu.lab3.PAGE_DATA.TEXT.strAr[i]);
        }

        Assert.assertEquals(PageObject.homePage.getMainTitle(), com.spbstu.lab3.PAGE_DATA.MAIN_HEADER.str);
        Assert.assertEquals(PageObject.homePage.getMainText(), com.spbstu.lab3.PAGE_DATA.HOME_PAGE.str);
        */
    }
}
