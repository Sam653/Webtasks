package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    private static WebDriver driver;

    @BeforeTest
    public void startDriver(){
        WebDriverManager.chromedriver().setup(); // for Chrome and • WebDriverManager.firefoxdriver().setup(); // for FF
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void quitDriver(){
        driver.quit();
    }

}
