package com.spbstu.lab2;

import org.aeonbits.owner.Config;
import static org.aeonbits.owner.Config.Sources;

@Sources({"classpath:test.properties"})
public interface TestConfig extends Config {
    @Key("homepage.url")
    String homepage();

    @Key("webdriver.chrome.driver")
    String pathToDriver();
}
