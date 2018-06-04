package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    private static final String XPATH_YEAR = "//div[@class=\"_5k_5\"]/span/span/select[3]";
    private static final String XPATH_MONTH = "//div[@class=\"_5k_5\"]/span/span/select[2]";
    private static final String XPATH_DAY = "//div[@class=\"_5k_5\"]/span/span/select[1]";

    /**
     * Task 23.3. Facebook
     *
     * @param args args
     */
    public static void main(final String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        WebElement selectDay = driver.findElement(By.xpath(XPATH_DAY));
        Select day = new Select(selectDay);
        day.selectByIndex(14);

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_MONTH));
        Select month = new Select(selectMonth);
        month.selectByIndex(2);

        WebElement selectYear = driver.findElement(By.xpath(XPATH_YEAR));
        Select year = new Select(selectYear);
        year.selectByIndex(7);
    }
}
