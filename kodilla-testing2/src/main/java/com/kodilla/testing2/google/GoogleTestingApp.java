package com.kodilla.testing2.google;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleTestingApp {
    private static final String SEARCHFIELD = "lst-ib";

    /**
     * Submodule 23.2. Selenium test
     *
     * @param args args
     */
    public static void main(final String[] args) {
        //WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.google.com");

        WebElement searchField = driver.findElement(By.id(SEARCHFIELD));
        searchField.sendKeys("Kodilla");
        searchField.submit();
    }
}
