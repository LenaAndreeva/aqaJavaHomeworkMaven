package org.andreevaelena.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTests {
    private WebDriver driver;

    public void visitMtsSiteAndFillInPaymentFields() {
        visitMtsHomePage();
        fillInThePaymentFields();
    }

    public WebDriver initializeChromeDriver() {

        String os = System.getProperty("os.name").toLowerCase();
        String driverPath;

        if (os.contains("win")) {
            driverPath = "src/main/resources/chromedriver.exe";
        } else if (os.contains("nux"))  {
            driverPath = "src/main/resources/chromedriver-linux64/chromedriver";
        } else {
            throw new IllegalStateException("There is no driver for this operating system");
        }

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

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