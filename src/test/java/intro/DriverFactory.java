package intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DriverFactory {

    private static WebDriver driver = null;
    private static String url = "https://www.facebook.com/";
    private static String hotel = "https://www.hotels.com/";


    @BeforeClass
    public void beforeActions(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to(hotel);
    }

    @AfterClass
    public void quitDriver(){
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getUrl() {
        return url;
    }
}
