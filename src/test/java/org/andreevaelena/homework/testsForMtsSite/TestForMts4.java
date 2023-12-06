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

public class TestForMts4 {
    @Test
    public void testPaymentFormButtonFunctionality () {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();

        driver.get("https://www.mts.by/");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieCloseBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='cookie__close']")));
        cookieCloseBtn.click();

        WebElement fieldForNum = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        WebElement fieldForPaymentAmount = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        WebElement continueButton = driver.findElement(By.cssSelector("form[id='pay-connection'] button[type='submit']"));

        fieldForNum.sendKeys("297777777");
        fieldForPaymentAmount.sendKeys("5");
        continueButton.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iFrame = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/iframe")));
        driver.switchTo().frame(iFrame);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement field = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='cc-number']")));
        Assertions.assertTrue(field.isDisplayed());
        driver.switchTo().defaultContent();
        driver.quit();


        /*Instead of accepting cookie we can also use:

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200);"); */
    }
}
