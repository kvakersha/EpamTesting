package com.spbstu.lab3;

import org.testng.annotations.BeforeClass;


public class Init {

    @BeforeClass
    public void beforeSuite() {
        com.codeborne.selenide.Configuration.timeout = 6000;
        com.codeborne.selenide.Configuration.browser = "chrome";
    }

}
