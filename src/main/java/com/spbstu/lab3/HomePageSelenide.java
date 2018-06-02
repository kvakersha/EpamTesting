package com.spbstu.lab3;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import com.spbstu.lab3.utilities.TestConfig;

public class HomePageSelenide {

    @FindBy(css = ".profile-photo")
    SelenideElement ProfileIcon;

    @FindBy(css = "#Login")
    SelenideElement LoginIn;

    @FindBy(css = "#Password")
    SelenideElement PasswordIn;

    @FindBy(css = "form .btn-login")
    SelenideElement EnterIn;

    @FindBy(css = ".logout")
    SelenideElement LogOutIn;

    @FindBy(css = ".icons-benefit")
    ElementsCollection IconsIn;

    @FindBy(css = ".benefit-txt")
    ElementsCollection TextsIn;

    @FindBy(css = ".main-title")
    SelenideElement MainTitleIn;

    @FindBy(css = ".main-txt")
    SelenideElement MainTextIn;

    @FindBy(css = "li.sub-menu")
    SelenideElement ServiceLeftSection;

    @FindBy(css = "li.dropdown")
    SelenideElement ServiceHeader;

    public HomePageSelenide(){
        Selenide.page(this);
    }

    public static void open(TestConfig cfg) {
        Selenide.open(cfg.homepage());
    }

    public String getTitle() {
        return Selenide.title();
    }

    public void isLoggedIn(String Login, String Password) {
        ProfileIcon.click();
        LoginIn.sendKeys(Login);
        PasswordIn.sendKeys(Password);
        EnterIn.click();
        LogOutIn.shouldBe(Condition.visible);
    }

    public void isUserNameOK(String Username){
        ProfileIcon.shouldBe(Condition.visible);
        ProfileIcon.shouldHave(Condition.text(Username));
    }

    public void areIconsAndTextsExists() {
        for(int i=0; i<4; i++) {
            IconsIn.get(i).shouldBe(Condition.visible);
            TextsIn.get(i).shouldBe(Condition.visible);
        }
    }

    public void isMainTitleOK(String mainTitle) {
        MainTitleIn.shouldBe(Condition.visible);
        MainTitleIn.shouldHave(Condition.text(mainTitle));
    }

    public void isMainTextOK(String mainText) {
        MainTextIn.shouldBe(Condition.visible);
        MainTextIn.shouldHave(Condition.text(mainText));
    }

    public void areSreviceButtonsOK(String[] str){
        ServiceLeftSection.click();
        ServiceHeader.click();
        for(int i=0; i<6; i++){
            ServiceLeftSection.shouldHave(Condition.text(str[i]));
            ServiceHeader.shouldHave(Condition.text(str[i]));
        }
    }
}
