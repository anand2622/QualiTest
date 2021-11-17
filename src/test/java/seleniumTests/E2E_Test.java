package seleniumTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2E_Test {

	private static WebDriver driver;
	
	public static void main(String[] args) throws Throwable {
	
		System.setProperty("webdriver.chrome.driver", ("user.dir") + "/src/main/java/config/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.shop.demoqa.com");
		
		driver.findElement(By.xpath("//a[@class='noo-search']")).click();
		WebElement searchElement = driver.findElement(By.xpath("//input[@name='s']"));
		searchElement.sendKeys("Dress");
		searchElement.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//a[contains(text(),'white milkmaid hook and eye bodycon midi dress')]")).click();
		
		Select dressColor = new Select(driver.findElement(By.xpath("//select[@id='pa_color']")));
		dressColor.selectByVisibleText("White");
		
		Select dressSize = new Select(driver.findElement(By.xpath("//select[@id='pa_size']")));
		dressSize.selectByVisibleText("Medium");
		
		driver.findElement(By.xpath("//button[contains(@class,'single_add_to_cart_button button alt')]")).click();
		driver.findElement(By.xpath("//i[contains(@class,'icon_bag_alt')]")).click();
		driver.findElement(By.xpath("//a[contains(@class,'checkout-button button alt wc-forward')]")).click();
		
		 
		Thread.sleep(5000);
		
		driver.findElement(By.id("billing_first_name")).sendKeys("Amit");
		driver.findElement(By.id("billing_last_name")).sendKeys("Verma");
		
		Select country = new Select(driver.findElement(By.id("billing_country")));
		country.selectByVisibleText("United States (US)");
		
		driver.findElement(By.id("billing_address_1")).sendKeys("3, plano avenue");
		driver.findElement(By.id("billing_city")).sendKeys("clifton");
		
		Select state = new Select(driver.findElement(By.id("billing_state")));
		state.selectByVisibleText("New Jersey");
		
		driver.findElement(By.id("billing_postcode")).sendKeys("07012");
		driver.findElement(By.id("billing_phone")).sendKeys("235-726-7895");
		driver.findElement(By.id("billing_email")).sendKeys("drealav08@gmail.com");
		
		WebElement acceptTC = driver.findElement(By.xpath("//input[@id='terms']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", acceptTC);
		acceptTC.click();
		
	}

}
