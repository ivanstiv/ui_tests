package com.geekbrains.homework6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UchiruTest3 {
    WebDriver driver;
    private final static String UCHIRU_BASE_URL = "https://uchi.ru/signin/main/new";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
    void parentRegisterTest() throws InterruptedException {
        driver.get(UCHIRU_BASE_URL);
        new MainPage(driver).clickSignUpParentButton().signUpParent().checkTitle();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
