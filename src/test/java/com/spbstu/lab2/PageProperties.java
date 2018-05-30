package com.spbstu.lab2;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.Sources;

@Sources({"classpath:pageProperties"})
public interface PageProperties extends Config{

    @Key("webdriver.chrome.driver")
    String driverPath();

    @Key("homepage.url")
    String homePageURL();
}