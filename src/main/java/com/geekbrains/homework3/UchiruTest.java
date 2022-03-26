package com.geekbrains.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class UchiruTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://uchi.ru/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("login")).sendKeys("77");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("азбука30661");

        driver.findElement(By.xpath("//input[@name='commit']")).click();

        Thread.sleep(5000);

        List<WebElement> modalCloseBtns = driver.findElements(By.xpath("//div[@class='popmechanic-close']"));

        if (modalCloseBtns.size() > 0) {
            modalCloseBtns.get(0).click();
        }

        driver.findElement(By.xpath("//span[.='Родителю']")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
