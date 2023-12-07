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

public class TestForMts3 {

    @Test
    public void testPaymentBlockLink() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.mts.by/");

        WebElement link = driver.findElement(By.cssSelector("a[href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cookieCloseBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn_black cookie__ok']")));
        cookieCloseBtn.click();

        String currentUrl = driver.getCurrentUrl();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait2.until(ExpectedConditions.elementToBeClickable(link));
        link.click();

        String newUrl = driver.getCurrentUrl();

        Assertions.assertNotEquals(currentUrl, newUrl, "The link was not followed");
        driver.quit();
    }
}
