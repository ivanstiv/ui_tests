package com.geekbrains.homework6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessParentSignUp extends BaseView {
    static final String ADD_CHILD_TITLE_LOCATOR = "//span[text()[contains(., 'Добавьте ребенка')]]";

    public SuccessParentSignUp(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ADD_CHILD_TITLE_LOCATOR)
    public WebElement addChildTitleLocator;

    @Step("Проверить наличие заголовка на втором этапе регистрации")
    public void checkTitle() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADD_CHILD_TITLE_LOCATOR)));
        Assertions.assertTrue(addChildTitleLocator.isDisplayed());
    }
}
