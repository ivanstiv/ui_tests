package com.geekbrains.homework6;

import org.junit.jupiter.api.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseView {
    static final String REG_BTN_LOCATOR = "//button[.='Родитель']";

    @FindBy(xpath = REG_BTN_LOCATOR)
    public WebElement signUpParentButton;

    @Step("Клик на кнопку регистрации родителя")
    public SignUpParentPage clickSignUpParentButton() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(REG_BTN_LOCATOR)));
        Assertions.assertTrue(signUpParentButton.isDisplayed());
        signUpParentButton.click();
        return new SignUpParentPage(driver);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }
}

