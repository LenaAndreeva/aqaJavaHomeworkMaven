package org.andreevaelena.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestForMts1 {
    @Test
    public void testPaymentBlockTitleVisibility() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.mts.by/");

        WebElement blockElement = driver.findElement(By.xpath("//div[@class='col-12 col-xl-8']//h2[1]"));

        String blockTitle = blockElement.getText().replaceAll("\\s+", " ");
        String expectedTitle = "Онлайн пополнение без комиссии";

        Assertions.assertEquals(expectedTitle, blockTitle, "The block name does not match");
        driver.quit();
    }
}
