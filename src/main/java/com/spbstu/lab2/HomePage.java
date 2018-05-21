package com.spbstu.lab2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage {

    public WebDriver driver;
    @FindBy(css = ".profile-photo")
    WebElement ProfileIcon;
    @FindBy(css = "#Login")
    WebElement LoginIn;
    @FindBy(css = "#Password")
    WebElement PasswordIn;
    @FindBy(css = "form .btn-login")
    WebElement EnterIn;
    @FindBy(css = ".logout")
    WebElement LogOutIn;
    @FindBy(css = ".icons-benefit")
    List<WebElement> IconsIn;
    @FindBy(css = ".benefit-txt")
    List<WebElement> TextsIn;
    @FindBy(css = ".main-title")
    WebElement MainTitleIn;
    @FindBy(css = ".main-txt")
    WebElement MainTextIn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String Site) {
        driver.navigate().to(Site);
    }

    public String Url() {
        return driver.getCurrentUrl();
    }

    public String Title() {
        return driver.getTitle();
    }

    public boolean isLoggedIn(String Login, String Password) {
        ProfileIcon.click();
        LoginIn.sendKeys(Login);
        PasswordIn.sendKeys(Password);
        EnterIn.click();
        return LogOutIn.isDisplayed();
    }

    // TODO wrong method naming !
    public String UsernameIn() {
        return ProfileIcon.getText();
    }

    public int iconsNumber() {
        //System.out.println(IconsIn.size());
        return IconsIn.size();
    }

    public String pictureText(int i) {
        return TextsIn.get(i).getText();
    }

    // TODO methods with "is" prefix should return boolean values...
    public String isMainTitle() {
        return MainTitleIn.getText();
    }

    public String isMainText() {
        return MainTextIn.getText();
    }
}
