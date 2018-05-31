package com.spbstu.lab2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.aeonbits.owner.ConfigFactory.create;


public class TestLab2 {

    private WebDriver driver;
    TestConfig cfg;


    @BeforeSuite
    public void beforeSuite() {
        cfg = create(TestConfig.class);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        TestWebsite.initHP(this.driver);
    }



    @AfterTest
    public void after() {
        TestWebsite.homePage.driver.close();
    }

    @Test
    public void Lab2() {
        driver.navigate().to(cfg.homepage());
        TestWebsite.homePage.getUrl();
        Assert.assertEquals(TestWebsite.homePage.getUrl(), PAGE_DATA.SITE.str);
        Assert.assertEquals(TestWebsite.homePage.getTitle(), PAGE_DATA.TITLE.str);
        Assert.assertTrue(TestWebsite.homePage.isLoggedIn(PAGE_DATA.LOGIN.str, PAGE_DATA.PASSWORD.str));

        Assert.assertEquals(TestWebsite.homePage.getUsername(), PAGE_DATA.USER_NAME.str);
        Assert.assertEquals(TestWebsite.homePage.getTitle(), PAGE_DATA.TITLE.str);

       // Assert.assertEquals(TestWebsite.homePage.getIconsNumber(), PAGE_DATA.ACTUAL_ICONS_NUMBERS.i);

        Assert.assertEquals(java.util.Optional.ofNullable(TestWebsite.homePage.getIconsNumber()), java.util.Optional.ofNullable(PAGE_DATA.ACTUAL_ICONS_NUMBERS.i));
        for (int i = 0; i < PAGE_DATA.ACTUAL_ICONS_NUMBERS.i; i++) {
            Assert.assertEquals(TestWebsite.homePage.getPictureText(i), PAGE_DATA.TEXT.strAr[i]);
        }

        Assert.assertEquals(TestWebsite.homePage.getMainTitle(), PAGE_DATA.MAIN_HEADER.str);
        Assert.assertEquals(TestWebsite.homePage.getMainText(), PAGE_DATA.HOME_PAGE.str);
    }
}
