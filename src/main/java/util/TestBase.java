package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
      FileInputStream fis =
          new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("firefox")) {
			System.out.println("firefox driver returned");
//			System.setProperty("user.dir") + "/src/main/java/config/geckodriver");
//			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			System.out.println("chrome driver returned");
      System.setProperty(
          "webdriver.chrome.driver",
          System.getProperty("user.dir") + "/src/main/java/config/chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else {
			System.out.println("default chrome driver returned");
			System.setProperty("webdriver.chrome.driver", ("user.dir") + "/src/main/java/config/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	} 

}
