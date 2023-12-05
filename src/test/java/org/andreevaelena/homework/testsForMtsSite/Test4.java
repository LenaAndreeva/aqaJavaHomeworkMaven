package org.andreevaelena.homework.testsForMtsSite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test4 {

    @Test
    public void testCheckingTheButtonOperation() {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.mts.by/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieCloseBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='cookie__close']")));
        cookieCloseBtn.click();

        WebElement fieldForNum = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        WebElement fieldForPayment = driver.findElement(By.xpath("//input[@id='connection-sum']"));

        fieldForNum.sendKeys("297777777");
        fieldForPayment.sendKeys("5");

        WebElement continueButton = driver.findElement(By.cssSelector("form[id='pay-connection'] button[type='submit']"));
        continueButton.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iFrame =  wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/iframe")));

        driver.switchTo().frame(iFrame);

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement field = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='cc-number']")));
        Assertions.assertTrue(field.isDisplayed());
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
