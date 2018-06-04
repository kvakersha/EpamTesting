package com.spbstu.lab4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class DifferentElementsPages {

    @FindBy(css = ".dropdown-menu | [href=\"page8.htm\"]")
    SelenideElement DifferentElementsPageButton;

    @FindBy(css = ".label-checkbox")
    ElementsCollection CheckBoxes;

    @FindBy(css = ".label-radio")
    ElementsCollection Radios;

    @FindBy(css = "div.colors")
    ElementsCollection DropDownColors;

    @FindBy(css = "[value=\"Default Button\"]")
    SelenideElement DefaultButton;

    @FindBy(css = "[value=\"Button\"]")
    SelenideElement Button;

    @FindBy(css = ".logs li")
    ElementsCollection Logs;

    @FindBy(css = "#mCSB_1")
    SelenideElement LeftSection;

    @FindBy(css = "#mCSB_2")
    SelenideElement RightSection;

    @FindBy(css = ".dropdown-menu | [href=\"page4.htm\"]")
    SelenideElement DatesPageButton;

    @FindBy(css = ".ui-slider-handle")
    ElementsCollection Sliders;


    public DifferentElementsPages(){Selenide.page(this);}


    public void areDiffBoxexExists() {
        for(int i=0; i<4; i++){
            CheckBoxes.get(i).shouldBe(Condition.visible);
            Radios.get(i).shouldBe(Condition.visible);
        }
        DropDownColors.get(0).shouldBe(Condition.visible);
        LeftSection.shouldBe(Condition.visible);
        RightSection.shouldBe(Condition.visible);
        DefaultButton.shouldBe(Condition.visible);
        Button.shouldBe(Condition.visible);
    }

    public void selectBoxElements(String str) {
        for (int i = 0; i < 4; i++) {
            if (CheckBoxes.get(i).getText().contains(str)) {
                CheckBoxes.get(i).click();
            }
            if (Radios.get(i).getText().contains(str)) {
                Radios.get(i).click();
            }
        }
    }

    public void selectColorElement(String str){
        $(".colors .uui-form-element").selectOption(str);
    }

    public void checkSelectedElements(String[] strAr){
        for(int i=0; i<6; i++){
            Logs.get(6-i-1).shouldHave(Condition.text(strAr[i]));
        }
    }

    public void checkUnselectedElements(String[] strAr){
        for (int i = 0; i < Logs.size();i++)
            System.out.println(Logs.get(i).getText());

        for(int i=4; i<6; i++){
            Logs.get(i).shouldHave(Condition.text(strAr[6-5-i]));
        }
    }

    public void slideToPositions(int left, int right) {
        Integer length = 274;
        Integer leftBegin = Integer.parseInt(Sliders.get(0).getText());
        Integer rightBegin = Integer.parseInt(Sliders.get(1).getText());

            if (left <= leftBegin) {
                actions().dragAndDropBy(Sliders.get(0), -((length * ((leftBegin - left) + 1) / 100)), 0).perform();
                System.out.println("Left: " + Integer.parseInt(Sliders.get(0).getText()));
            } else {
                actions().dragAndDropBy(Sliders.get(0), (length * ((leftBegin + left) - 1) / 100), 0).perform();
                System.out.println("Left: " + Integer.parseInt(Sliders.get(0).getText()));
            }
            if(Integer.parseInt(Sliders.get(0).getText())==leftBegin){
                if (left <= leftBegin) {
                    actions().dragAndDropBy(Sliders.get(0), -((length * ((leftBegin - left) + 1) / 100)), 0).perform();
                    System.out.println("Left: " + Integer.parseInt(Sliders.get(0).getText()));
                } else {
                    actions().dragAndDropBy(Sliders.get(0), (length * ((leftBegin + left) - 1) / 100), 0).perform();
                    System.out.println("Left: " + Integer.parseInt(Sliders.get(0).getText()));
                }
            }
            else {
                if (right < rightBegin) {
                    actions().dragAndDropBy(Sliders.get(1), -(length * ((rightBegin - right) + 1) / 100), 0).perform();
                    System.out.println("Right: " + Integer.parseInt(Sliders.get(1).getText()));
                } else {
                    actions().dragAndDropBy(Sliders.get(1), (length * ((-rightBegin + right) + 1) / 100), 0).perform();
                    System.out.println("Right: " + Integer.parseInt(Sliders.get(1).getText()));
                }
            }

            System.out.println("");
            System.out.println("Left: " + Integer.parseInt(Sliders.get(0).getText()));
            System.out.println("Right: " + Integer.parseInt(Sliders.get(1).getText()));

            Sliders.get(0).shouldHave(Condition.text(String.valueOf(left)));
            Sliders.get(1).shouldHave(Condition.text(String.valueOf(right)));
    }
}
