package org.andreevaelena.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebPageManager {
    private WebDriver driver;

    public void visitMtsSiteAndFillInPaymentFields() {
        visitMtsHomePage();
        fillInThePaymentFields();
    }

    public WebDriver initializeChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        return driver;
    }

    public void visitMtsHomePage() {
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cookieCloseBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn_black cookie__ok']")));
        cookieCloseBtn.click();
    }
    public void fillInThePaymentFields () {
        WebElement fieldForNum = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        WebElement fieldForPaymentAmount = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        fieldForNum.sendKeys("297777777");
        fieldForPaymentAmount.sendKeys("5");

        WebElement continueButton = driver.findElement(By.cssSelector("form[id='pay-connection'] button[type='submit']"));
        continueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/iframe")));
        driver.switchTo().frame(iFrame);
    }
}