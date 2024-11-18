package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://www.google.com");
            driver.manage().window().maximize();


            WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
            searchBar.sendKeys("who fears satoru gojo");

            Thread.sleep(1000);

            WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
            searchBtn.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));

            List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("h3")));

            System.out.println("Top 5 Google Search Results:");
            for (int i = 0; i < 5 && i < results.size(); i++) {
                System.out.println((i + 1) + ". " + results.get(i).getText());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            Thread.sleep(10000);
            driver.quit();
        }
    }
}
