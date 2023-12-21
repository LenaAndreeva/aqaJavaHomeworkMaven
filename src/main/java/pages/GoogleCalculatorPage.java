package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import pages.base.BasePage;

public class GoogleCalculatorPage extends BasePage {

    private final By getNum3Btn = By.id("com.google.android.calculator:id/digit_3");
    private final By getNum5Btn = By.id("com.google.android.calculator:id/digit_5");
    private final By getNum9Btn = By.id("com.google.android.calculator:id/digit_9");
    private final By getAddBtn = By.id("com.google.android.calculator:id/op_add");
    private final By getSubtractBtn = By.id("com.google.android.calculator:id/op_sub");
    private final By getMultiplyBtn = By.id("com.google.android.calculator:id/op_mul");
    private final By getDivideBtn = By.id("com.google.android.calculator:id/op_div");
    private final By getEqBtn = By.id("com.google.android.calculator:id/eq");
    private final By getResult = By.id("com.google.android.calculator:id/result_final");


    public GoogleCalculatorPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public GoogleCalculatorPage clickNumber3() {
        driver.findElement(getNum3Btn).click();

        return this;
    }

    public GoogleCalculatorPage clickNumber5() {
        driver.findElement(getNum5Btn).click();

        return this;
    }

    public GoogleCalculatorPage clickNumber9() {
        driver.findElement(getNum9Btn).click();

        return this;
    }

    public GoogleCalculatorPage clickAddButton() {
        driver.findElement(getAddBtn).click();

        return this;
    }

    public GoogleCalculatorPage clickSubtractButton() {
        driver.findElement(getSubtractBtn).click();

        return this;
    }

    public GoogleCalculatorPage clickMultiplyButton() {
        driver.findElement(getMultiplyBtn).click();

        return this;
    }

    public GoogleCalculatorPage clickDivideButton() {
        driver.findElement(getDivideBtn).click();

        return this;
    }

    public GoogleCalculatorPage clickEqualsButton() {
        driver.findElement(getEqBtn).click();

        return this;
    }

    public String getDisplayedResult() {
        return driver.findElement(getResult).getText();
    }
}
