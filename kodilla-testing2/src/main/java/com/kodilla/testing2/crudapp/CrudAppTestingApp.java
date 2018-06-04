package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrudAppTestingApp {
    private static final String XPATH_INPUT = "//html/body/main/section/form/fieldset/input";
    private static final String XPATH_TEXTAREA = "//html/body/main/section/form/fieldset[2]/textarea";
    private static final String XPATH_WAIT_FOR = "//select[1]";
    private static final String XPATH_SELECT = "//div[contains(@class, \"tasks-container\")]/form/div/fieldset/select[1]";

    /**
     * Submodule 23.3. Selenium test
     *
     * @param args args
     */
    public static void main(final String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://krzysieksad.github.io/");

        WebElement searchField = driver.findElement(By.xpath(XPATH_INPUT));
        searchField.sendKeys("New robotic task");

        WebElement textareaField = driver.findElement(By.xpath(XPATH_TEXTAREA));
        textareaField.sendKeys("New robotic content");

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed()) {
        }

        WebElement selectCombo = driver.findElement(By.xpath(XPATH_SELECT));
        Select selectBoard = new Select(selectCombo);
        selectBoard.selectByIndex(1);
    }
}
