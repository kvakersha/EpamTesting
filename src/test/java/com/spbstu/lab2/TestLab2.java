package com.spbstu.lab2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

public class TestLab2 {

    private WebDriver driver;

    @Before
    public void before() {
        // TODO this should be specified in pom.xml
        String Site = "https://jdi-framework.github.io/tests/index.htm";
        // TODO same situation
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
        ForTest.homePage.Url();
        Assert.assertEquals(ForTest.homePage.Url(), enums.Site.value);
        Assert.assertEquals(ForTest.homePage.Title(), enums.Title.value);
        Assert.assertTrue(ForTest.homePage.isLoggedIn(enums.Login.value, enums.Password.value));

        Assert.assertEquals(ForTest.homePage.UsernameIn(), enums.UserName.value);
        Assert.assertEquals(ForTest.homePage.Title(), enums.Title.value);

        Assert.assertEquals(ForTest.homePage.iconsNumber(), enums.actualIconsNumber.val);

        for (int i = 0; i < enums.actualIconsNumber.val; i++) {
            Assert.assertEquals(ForTest.homePage.pictureText(i), enums.texts.text[i]);
        }

        Assert.assertEquals(ForTest.homePage.isMainTitle(), enums.MainHeader.value);
        Assert.assertEquals(ForTest.homePage.isMainText(), enums.HomePage.value);
    }
}
