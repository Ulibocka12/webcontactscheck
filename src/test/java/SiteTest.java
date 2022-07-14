import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SiteTest {

    private ChromeDriver driver;

    @BeforeAll
    public static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void websiteСontactСheck() {
        driver.get ("https://www.google.ru");
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.className("gLFyf"))).sendKeys("Byndyusoft");
        WebElement textField = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(By.className("gLFyf")));
        driver.findElement(By.className("gNO89b")).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"rso\"]//a"))).click();
        driver.get ("https://www.google.ru");
        ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(w.get(1));
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class = 'btn btn--lg btn--info js-popup-callback-show']"))).click();
        String actualText = driver.findElement(By.className("popup-callback__footer-contacts")).getText();
        String expected = "8 800 775-15-21\nsales@byndyusoft.com";
        assertEquals(expected, actualText);

    }


}