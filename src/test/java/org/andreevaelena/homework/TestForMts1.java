package org.andreevaelena.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestForMts1 {

    @Test
    public void testDropdownItems() {

        WebPageManager webPageManager = new WebPageManager();
        WebDriver driver = webPageManager.initializeChromeDriver();
        webPageManager.visitMtsHomePage(driver);

        WebElement dropdown = driver.findElement(By.xpath("//span[@class='select__arrow']//*[name()='svg']"));
        dropdown.click();

        List<WebElement> options = dropdown.findElements(By.tagName("option"));
        String[] expectedOptions = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};

        for (int i = 0; i < options.size(); i++) {
            String actualOption = options.get(i).getText();
            Assertions.assertEquals(expectedOptions[i], actualOption, "Название пункта не соответствует ожидаемому");
        }
    }
}
