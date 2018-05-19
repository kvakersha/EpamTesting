package com.spbstu.lab2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestLab2 {

    private WebDriver driver;

    @Before
    public void before() {
        String Site = "https://jdi-framework.github.io/tests/index.htm";
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        driver.navigate().to(Site);
        ForTest.initHP(this.driver);
    }

    @AfterTest
    public void after() {
        ForTest.homePage.driver.close();
    }


    @Test
    public void Lab2() {
        String Site = "https://jdi-framework.github.io/tests/index.htm";
        String Title = "Index Page";
        String test = "Index";
        ForTest.homePage.Url();
        Assert.assertEquals(ForTest.homePage.Url(), Site);
        Assert.assertEquals(ForTest.homePage.Title(), Title);

        String Login = "epam";
        String Password = "1234";
        Assert.assertTrue(ForTest.homePage.isLoggedIn(Login, Password));

        String UserName = "PITER CHAILOVSKII";
        Assert.assertEquals(ForTest.homePage.UsernameIn(), UserName);
        Assert.assertEquals(ForTest.homePage.Title(), Title);

        Integer actualIconsNumber = 4;
        Assert.assertEquals(ForTest.homePage.iconsNumber(), actualIconsNumber);

        List<String> Texts = new ArrayList<String>();
        Texts.add("To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM projec");
        Texts.add("To be flexible and\n" +
                "customizable");
        Texts.add("To be multiplatform");
        Texts.add("Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
        for (int i = 0; i < Texts.size(); i++) {
            Assert.assertEquals(ForTest.homePage.pictureText(i), Texts.get(i));
        }

        String MainHeader = "EPAM FRAMEWORK WISHES…";
        String HomePage = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

        Assert.assertEquals(ForTest.homePage.isMainTitle(), MainHeader);
        Assert.assertEquals(ForTest.homePage.isMainText(), HomePage);
    }
}
