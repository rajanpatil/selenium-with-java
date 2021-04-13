package com.selenium;

import java.io.File;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class GoogleSearchTest {

  private static WebDriver driver;

  @BeforeAll
  static void beforeAll() {
    System.setProperty("webdriver.chrome.driver",
        getChromeDriverAbsolutePath());
    driver = new ChromeDriver();
  }

  @AfterAll
  static void afterAll() {
    driver.quit();
  }

  @Test
  @DisplayName("Google search 'ChromeDriver'")
  void testGoogleSearch() throws InterruptedException {
    driver.get("http://www.google.com/");
    Thread.sleep(5000);  // Let the user actually see something!
    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys("ChromeDriver");
    searchBox.submit();
    Thread.sleep(5000);  // Let the user actually see something!
  }

  private static String getChromeDriverAbsolutePath() {
    File chromeDriverFile = new File("./driver/chrome_89/chromedriver");
    return chromeDriverFile.getAbsolutePath();
  }
}
