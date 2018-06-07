package com.spbstu.lab5;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.spbstu.lab5.entities.MetalsAndColorsDataSet;
import com.spbstu.lab5.enums.PAGE_DATA;
import com.spbstu.lab5.utilities.TestConfig;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.settings.JDISettings.driverFactory;
import static com.spbstu.lab5.FilesLoader.getAllData;
import static com.spbstu.lab5.TestWebsiteSelenide.homePageJDI;
import static com.spbstu.lab5.TestWebsiteSelenide.metalsAndColorsPageJDI;
import static org.aeonbits.owner.ConfigFactory.create;

public class TestLab5 extends TestNGBase {

    @DataProvider(name = "dataProvider")
    public Object[] createData() {
        return getAllData();
    }


    @BeforeSuite
    public void beforeSuite() {
        driverFactory.setDriverPath(create(TestConfig.class).driverFolder());
        WebSite.init(TestWebsiteSelenide.class);
        driverFactory.getDriver();

        homePageJDI.open();
        homePageJDI.checkOpened();
        TestWebsiteSelenide.login(PAGE_DATA.LOGIN.str, PAGE_DATA.PASSWORD.str);
        TestWebsiteSelenide.openMetalsAndColorsPage();
        metalsAndColorsPageJDI.vegetables.select("Salad");
    }

    @Test(dataProvider = "dataProvider")
    public void Lab5(MetalsAndColorsDataSet metalsAndColorsDataSet) {
        metalsAndColorsPageJDI.selectMetalsAndColors(metalsAndColorsDataSet);
        metalsAndColorsPageJDI.checkSelectedMetalsAndColors(metalsAndColorsDataSet);
    }
}
