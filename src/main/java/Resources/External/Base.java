package Resources.External;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import util.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {
WebDriver driver;
public  Properties properties;
public WebDriver initializeDriver()throws IOException {
    if(driver==null) {
        String browser = loadProperties("webBrowser");
        Log.info(browser);
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/java/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            Log.info("You have initialized a Chrome driver");
            navigate();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/java/resources/drivers/geckodriver");
            driver = new FirefoxDriver();
            Log.info("You have initialized a Firefox driver");
            navigate();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
            Log.info("You have initialized a Edge driver");
            navigate();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
            Log.info("You have initialized a Safari driver");
            navigate();
        } else if(browser.equalsIgnoreCase("Chrome headless")){
            System.setProperty("webdriver.chrome.driver", "src/main/java/resources/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920x1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sendbox");
            driver = new ChromeDriver(options);
            Log.info("You have initialized Chrome in headless mode");
            navigate();
        }
        else if (browser.equalsIgnoreCase("Remote")) {
            //BrowserStack Integration
        } else {
            Log.error("There is some error in Browser name");
        }
    }
    return driver;
}
public String loadProperties(String property)throws IOException{
    properties=new Properties();
    FileInputStream dataFile=new FileInputStream("src/main/java/Resources/External/data.properties");
    properties.load(dataFile);
    return properties.getProperty(property);
}
    public void navigate() throws IOException {
        driver.manage().window().maximize();
        driver.get(loadProperties("url"));
    }
}
