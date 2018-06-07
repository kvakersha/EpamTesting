package com.spbstu.lab5.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.*;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.web.matcher.junit.Assert;
import com.spbstu.lab5.entities.Data;
import com.spbstu.lab5.enums.PAGE_DATA;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/page2.htm", title = "Metal and Colors")

public class MetalsAndColorsPage extends WebPage {
    @FindBy(css = ".radio")
    public RadioButtons radios;

    @JFindBy(css = "#elements-checklist | .checkbox label")
    public CheckList elements;

    @JDropdown(root = @FindBy(css = ".colors"),
            list = @FindBy(tagName = "li"))
    public Dropdown colors;

    @JComboBox(root = @FindBy(css = ".metals"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(tagName = "li"))
    public ComboBox metals;

    @JComboBox(root = @FindBy(css = ".salad"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button"))
    public ComboBox vegetables;

    @FindBy(css = ".panel-body-list.results li")
    public TextList resultLog;

    public TextList expectedResult;

    @FindBy(css = "#submit-button")
    public Button submit;

    //counter of data
    Integer count = 0;

    public void unSelectElementsAndVegetables(Data data) {
        /*for(int i=0; i<4; i++){
            if(elements.isSelected(PAGE_DATA.ELEMENTS.strAr[i])){
                    elements.select(PAGE_DATA.ELEMENTS.strAr[i]);
            }
            if(vegetables.isSelected(PAGE_DATA.VEGETABLES.strAr[i])){
                elements.select(PAGE_DATA.VEGETABLES.strAr[i]);
            }
        }*/
        for (int i = 0; i < data.getElements().length; i++)
            elements.select(data.getElements()[i]);
        for (int i = 0; i < data.getVegetables().length; i++)
            vegetables.select(data.getVegetables()[i]);
    }

    public void selectMetalsAndColors(Data data) {

        radios.select(Integer.toString(data.getSummary()[0]));
        radios.select(Integer.toString(data.getSummary()[1]));

        for (int i = 0; i < data.getElements().length; i++) {
            elements.select(data.getElements()[i]);
        }

        colors.select(data.getColor());
        metals.select(data.getMetals());

        for (int i = 0; i < data.getVegetables().length; i++) {
            vegetables.select(data.getVegetables()[i]);
        }
        submit.click();
        count++;
        unSelectElementsAndVegetables(data);
        //System.out.println(resultLog.getValue());
    }

    public void checkSelectedData() {
        //System.out.println(resultLog.getValue());
        Assert.assertTrue(resultLog.getValue().contains(PAGE_DATA.EXPECTED_RESULT.strAr[count - 1]));
    }
}