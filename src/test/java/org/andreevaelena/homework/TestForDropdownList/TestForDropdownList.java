package org.andreevaelena.homework.TestForDropdownList;

import org.andreevaelena.homework.WebPageManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestForDropdownList {
    @Test
    @DisplayName("Проверка наличия всех опций в выпадающем списке")
    public void testPaymentDropdownListItems() {

        WebPageManager webPageManager = new WebPageManager();
        WebDriver driver = webPageManager.initializeChromeDriver();
        driver.manage().window().maximize();
        webPageManager.visitMtsHomePage();

        WebElement dropdownBtn = driver.findElement(By.xpath("//span[@class='select__arrow']//*[name()='svg']"));
        dropdownBtn.click();

        List<WebElement> options = dropdownBtn.findElements(By.tagName("option"));
        String[] expectedOptions = {
                DropdownListOptionsData.SERVICE_CONNECTION,
                DropdownListOptionsData.HOME_INTERNET,
                DropdownListOptionsData.INSTALLMENT,
                DropdownListOptionsData.DEBT
        };

        for (int i = 0; i < options.size(); i++) {
            String actualOption = options.get(i).getText();

            Assertions.assertEquals(expectedOptions[i], actualOption);
        }

        driver.quit();
    }
}
