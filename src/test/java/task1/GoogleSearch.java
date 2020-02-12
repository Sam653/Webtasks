package task1;

// Нужно написать простой тест (поиск в гугле, логин в какую-либо почту и т.д).
// В качестве конфигурации вебдрайвера используй вебдрайверменеджер (WebDriverManager)

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearch {

    private WebDriver driver;
    private String searchKey = "metallica disposable heroes";

    @BeforeSuite
    public void webDriverManagerTest(){
        // run a new browser object
        WebDriverManager.chromedriver().setup(); // for Chrome
        //WebDriverManager.firefoxdriver().setup(); // for FF
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void profileSetup() {
        // set window in full size
        driver.manage().window().maximize();
    }

    @Test
    public void searchInGoogle() {
        // open Google.com
        driver.get("http://www.google.com");

        // find Search field
        WebElement googleSearch = driver.findElement(By.name("q"));

        // input required "searchKey"
        googleSearch.sendKeys(searchKey);

        // press "Search" button
        googleSearch.submit();

                //WebDriverWait wait = new WebDriverWait(driver, 15); // пауза?
                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Metallica")));

        // a little break for searching
        WebDriverWait waitDriver = new WebDriverWait(driver, 20);

        // find YouTube video
        WebElement youtubeVideo = waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Metallica - Disposable Heroes (Studio Version) - YouTube")));

        // click on YouTube link
        youtubeVideo.click();

        // print of results
        System.out.println(searchKey + " video was found on YouTube!");
    }

    // close browser after test execution
    @AfterSuite
    public void quitDriver(){
        //driver.quit();
    }
}