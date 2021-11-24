package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class KrogerCouponClipperTest {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);

        driver.get("https://www.kroger.com/signin?redirectUrl=/cl/mycoupons/");
        driver.manage().window().maximize();

        //Clicks out of the Boost by Kroger Plus Popup Screen
        WebElement boostPopUp = driver.findElement(By.xpath("//html/body/div[5]/div/div/footer/div/button[2]"));
        if (boostPopUp.isDisplayed()) {
            boostPopUp.click();
        }
    }

    @Test
    public void getTitle() {
        String expectedTitle = "Kroger";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
