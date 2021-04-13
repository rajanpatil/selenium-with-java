package com.selenium;

import java.io.File;
import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class GoogleSearchTest {

  private static WebDriver driver;
  private static WebDriverWait wait;

  @BeforeAll
  static void beforeAll() {
    System.setProperty("webdriver.chrome.driver",
        getChromeDriverAbsolutePath());
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  }

  @AfterAll
  static void afterAll() {
    driver.quit();
  }

  @Test
  @DisplayName("Google search 'ChromeDriver'")
  void testGoogleSearch() throws InterruptedException {
    driver.get("http://www.google.com/");
    driver.findElement(By.id("zV9nZe")).click();
    wait(5000);
    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys("ChromeDriver");
    searchBox.submit();
    wait(5000);
  }

  private void wait(int timeoutMillis) throws InterruptedException {
    synchronized(wait) {
      wait.wait(timeoutMillis);
    }
  }

  private static String getChromeDriverAbsolutePath() {
    File chromeDriverFile = new File("./driver/chrome_89/chromedriver");
    return chromeDriverFile.getAbsolutePath();
  }
}
