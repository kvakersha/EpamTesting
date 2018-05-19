package com.spbstu.lab1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class TestLab1 extends Init {

    @Test
    public void Lab1() {
        //public void CheckSiteOpen()
        String Site = "https://jdi-framework.github.io/tests/index.htm";
        driver.get("https://jdi-framework.github.io/tests/index.htm");
        Assert.assertEquals(driver.getCurrentUrl(), Site);

        String Title = "Index Page";

        //public void CheckTitle()
        Assert.assertEquals(driver.getTitle(), Title);

        //public void CheckLogInAndUserName()
        String Login = "epam";
        String Password = "1234";
        String UserName = "PITER CHAILOVSKII";
        //driver.get("https://jdi-framework.github.io/tests/index.htm");
        driver.findElement(By.cssSelector("[href='#']")).click();
        driver.findElement(By.cssSelector("[id = 'Login']")).sendKeys(Login);
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys(Password);
        driver.findElement(By.cssSelector("[type = 'submit']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("[href = '#']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector("[href='#']")).getText(), UserName);
        Assert.assertEquals(driver.getTitle(), Title);

        //public void CheckImagesAreDisplayed()
        //driver.get("https://jdi-framework.github.io/tests/index.htm");
        Assert.assertEquals((driver.findElements(By.cssSelector("[class = 'benefit-icon']")).size()), 4);

        //public void CheckImagesTextsAreDisplayed()
        ArrayList<String> Texts = new ArrayList<String>();
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
        //driver.get("https://jdi-framework.github.io/tests/index.htm");
        Assert.assertEquals((driver.findElements(By.cssSelector("[class = 'benefit-txt']")).size()), 4);

        ArrayList<WebElement> TextsUnderIcons;
        TextsUnderIcons = (ArrayList<WebElement>) driver.findElements(By.cssSelector("[class = 'benefit-txt']")); // проверка текста под иконками
        for (int i = 0; i < Texts.size(); i++) {
            Assert.assertEquals(TextsUnderIcons.get(i).getText(), Texts.get(i));
        }

        //public void CheckMainHeaderAndHomePage()
        String MainHeader = "EPAM FRAMEWORK WISHES…";
        String HomePage = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        //driver.get("https://jdi-framework.github.io/tests/index.htm");
        Assert.assertEquals((driver.findElement(By.cssSelector(".main-title"))).getText(), MainHeader);
        Assert.assertEquals((driver.findElement(By.cssSelector(".main-txt"))).getText(), HomePage);
    }
}
