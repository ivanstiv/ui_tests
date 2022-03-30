package com.geekbrains.homework5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class UchiruTest2 {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String UCHIRU_BASE_URL = "https://uchi.ru/signin/main/new";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(UCHIRU_BASE_URL);
    }

    @Test
    void parentRegisterTest() throws InterruptedException {
        String regBtnLocator = "//button[.='Родитель']";
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(regBtnLocator)));
        WebElement regBtn = driver.findElement(By.xpath(regBtnLocator));
        Assertions.assertTrue(regBtn.isDisplayed());
        regBtn.click();

        String nameFieldLocator = "//input[@placeholder='Имя']";
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nameFieldLocator)));
        WebElement nameField = driver.findElement(By.xpath(nameFieldLocator));
        Assertions.assertTrue(nameField.isDisplayed());
        nameField.sendKeys("Ваня");
        driver.findElement(By.xpath("//input[@placeholder='E-mail']")).sendKeys("parent4@mail.ru");
        driver.findElement(By.xpath("//input[@placeholder='Телефон']")).sendKeys("+7(900)100-00-04");

        actions.moveToElement(
                driver.findElement(By.xpath("//div[text()[contains(., 'Соглашаюсь с условиями')]]"))
        ).moveByOffset(1, -39).click().build().perform();

        driver.findElement(By.xpath("//button[.='Продолжить']")).click();

        String addChildTitleLocator = "//span[text()[contains(., 'Добавьте ребенка')]]";
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addChildTitleLocator)));
        Assertions.assertTrue(driver.findElement(By.xpath(addChildTitleLocator)).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
