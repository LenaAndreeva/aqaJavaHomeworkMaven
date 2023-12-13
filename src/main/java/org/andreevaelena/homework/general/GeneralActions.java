package org.andreevaelena.homework.general;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GeneralActions {

    public static WebDriver createDriver() {

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
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;
    }
}
