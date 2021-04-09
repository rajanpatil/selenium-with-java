package com.selenium;

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
    driver = new ChromeDriver();
    System.setProperty("webdriver.chrome.driver",
        getAbsolutePathOfResource("driver/chrome_89/chromedriver"));
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
    driver.quit();
  }

  private static String getAbsolutePathOfResource(String resource) {
    ClassLoader classLoader = GoogleSearchTest.class.getClassLoader();
    return classLoader.getResource(resource).getPath();
  }
}