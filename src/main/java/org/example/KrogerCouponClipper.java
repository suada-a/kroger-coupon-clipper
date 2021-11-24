package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KrogerCouponClipper {

    public static void main(String[] args) {
        String emailAddress = args[0];
        String password = args[1];

        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--disable-blink-features=AutomationControlled");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.kroger.com/signin?redirectUrl=/savings/cl/coupons/");
        driver.manage().window().maximize();

        //Clicks out of the Boost by Kroger Plus popup screen
        WebElement boostPopUp = driver.findElement(By.xpath("//html/body/div[5]/div/div/footer/div/button[2]"));
        if (boostPopUp.isDisplayed()) {
            boostPopUp.click();
        }

        WebElement emailAddressBox = driver.findElement(By.id("SignIn-emailInput"));
        WebElement passwordBox = driver.findElement(By.id("SignIn-passwordInput"));
        WebElement signInButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/main/section/section/section/form/button"));

        //Change default text to login information
        emailAddressBox.sendKeys(emailAddress);
        passwordBox.sendKeys(password);
        signInButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div[1]/main/section/div/section[1]/div[3]/div/div/div[2]")));

        WebElement couponsClipped = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/main/section/div/section[1]/div[3]/div/div/div[2]"));
        int currentNumberOfCouponsClipped = Integer.parseInt(couponsClipped.getText());

        final int MAX_NUMBER_OF_COUPONS = 150;

        while(currentNumberOfCouponsClipped != MAX_NUMBER_OF_COUPONS) {
            WebElement clipButton = driver.findElement(By.xpath("//button[text()='Clip']"));
            String clipButtonText = clipButton.getText();
            clipButton.click();
            currentNumberOfCouponsClipped++;
        }
        
        driver.close();
    }
}

