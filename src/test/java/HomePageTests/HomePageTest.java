package HomePageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest {


    @Test
    public void AlloLogoTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://allo.ua");

        WebElement alloButtonLocator = driver.findElement(By.xpath("//a[@class='v-logo']"));

        Assert.assertTrue(alloButtonLocator.isDisplayed());

        driver.quit();

    }

    @Test
    public void checkSearchFieldAndSearchResults() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://allo.ua");

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='search-form__input']"));

        Assert.assertTrue(searchInput.isDisplayed(), "Поле пошуку не відображається !");

        searchInput.sendKeys("Фен");

        WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class, 'search-form__submit')]"));

        searchButton.click();

        Thread.sleep(2000);

        WebElement firstProduct = driver.findElement(By.xpath("//a[contains(@class, 'product-card__title')][1]"));

        String productText = firstProduct.getText();

        Assert.assertTrue(productText.toLowerCase().contains("фен"));


    }
}

