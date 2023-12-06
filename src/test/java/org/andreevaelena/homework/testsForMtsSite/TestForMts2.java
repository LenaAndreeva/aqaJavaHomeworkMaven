package org.andreevaelena.homework.testsForMtsSite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestForMts2 {

    @Test
    public void testPaymentBlockLogosVisibility() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.mts.by/");

        List<String> logoElement = getLogos();

        List<WebElement> foundLogos = new ArrayList<>();

        for (String selector : logoElement) {
            List<WebElement> logos = driver.findElements(By.xpath(selector));
            foundLogos.addAll(logos);
        }

        Assertions.assertFalse(foundLogos.isEmpty(), "No logos were found on the page");
        driver.quit();
    }

    private static List<String> getLogos() {
        List<String> logoElement = new ArrayList<>();
        logoElement.add("//img[@alt='Visa']");
        logoElement.add("//img[@alt='Verified By Visa']");
        logoElement.add("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg']");
        logoElement.add("//img[@alt='MasterCard Secure Code']");
        logoElement.add("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg']");
        logoElement.add("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mir.svg']");

        return logoElement;
    }
}
