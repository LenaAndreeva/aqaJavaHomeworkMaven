package org.andreevaelena.homework.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.GoogleCalculatorPage;

import java.net.URL;

public class BaseTest {
    protected AndroidDriver<AndroidElement> driver;
    protected GoogleCalculatorPage googleCalculatorPage = new GoogleCalculatorPage(driver);

    @BeforeEach
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "TECNO KI5q");
        capabilities.setCapability("udid", "099613737F007009");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<>(url, capabilities);
            googleCalculatorPage = new GoogleCalculatorPage(driver);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Server initialization failed");
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
