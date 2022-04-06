package com.geekbrains.homework6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpParentPage extends BaseView {
    static final String NAME_FIELD_LOCATOR = "//input[@placeholder='Имя']";

    @FindBy(xpath = NAME_FIELD_LOCATOR)
    public WebElement nameField;

    @FindBy(xpath = "//input[@placeholder='E-mail']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Телефон']")
    public WebElement phoneField;

    @FindBy(xpath = "//div[text()[contains(., 'Соглашаюсь с условиями')]]")
    public WebElement checkBoxField;

    @FindBy(xpath = "//button[.='Продолжить']")
    public WebElement signUpBtn;

    @Step("Регистрация родителя")
    public SuccessParentSignUp signUpParent() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME_FIELD_LOCATOR)));
        Assertions.assertTrue(nameField.isDisplayed());
        nameField.sendKeys("Ваня");
        emailField.sendKeys("parent7@mail.ru");
        phoneField.sendKeys("+7(900)100-00-07");
        actions.moveToElement(checkBoxField).moveByOffset(1, -39).click().build().perform();
        signUpBtn.click();

        return new SuccessParentSignUp(driver);
    }

    public SignUpParentPage(WebDriver driver) {
        super(driver);
    }
}
