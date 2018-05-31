package com.spbstu.lab3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;


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
    List<SelenideElement> IconsIn;

    @FindBy(css = ".benefit-txt")
    List<SelenideElement> TextsIn;

    @FindBy(css = ".main-title")
    SelenideElement MainTitleIn;

    @FindBy(css = ".main-txt")
    SelenideElement MainTextIn;

    public HomePageSelenide(){
        Selenide.page(this);
    }

    public static void open() {
        Selenide.open("https://jdi-framework.github.io/tests/index.htm");
    }

    public void getTitle() {
        Selenide.title();
    }

    public void isLoggedIn(String Login, String Password) {
        ProfileIcon.click();
        LoginIn.sendKeys(Login);
        PasswordIn.sendKeys(Password);
        EnterIn.click();
        LogOutIn.shouldBe(Condition.visible);
    }

    public String getUsername() {
        return ProfileIcon.getText();
    }

    public int getIconsNumber() {
        //System.out.println(IconsIn.size());
        return IconsIn.size();
    }

    public String getPictureText(int i) {
        return TextsIn.get(i).getText();
    }

    public String getMainTitle() {
        return MainTitleIn.getText();
    }

    public String getMainText() {
        return MainTextIn.getText();
    }
}
