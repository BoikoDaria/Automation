package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homework {

    private WebDriver driver;


    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void openCategoryAndCheck() {
        driver.get("https://www.rozetka.com.ua");
        WebElement categoryButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@data-title=\"Красота и здоровье\"]"))));
        categoryButton.click();

        WebElement categoryTitle = driver.findElement(By.xpath("//span[contains(text(),\"Красота и здоровье\")]"));
        Assert.assertEquals(categoryTitle.isDisplayed(), true);
        driver.close();
    }

    @Test
    public void addGoodAndCheckBin() {
        driver.get("https://www.rozetka.com.ua");
        WebElement categoryButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@data-title=\"Красота и здоровье\"]"))));
        categoryButton.click();

        WebElement firstItem = driver.findElement(By.cssSelector("div.pab-row-fifth > div.pab-cell:first-child"));
        firstItem.click();
        firstItem = driver.findElement(By.cssSelector("div.pab-row-fourth > div.pab-cell:first-child"));
        firstItem.click();
        WebElement parfumeItem = driver.findElement(By.cssSelector("div.g-i-large-tile-catalog"));
        Assert.assertEquals(parfumeItem.isDisplayed(), true);
    }

}
