package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import util.TestBase;

import java.util.ArrayList;
import java.util.List;

public class WishListPage extends TestBase {


	public WishListPage() {
		PageFactory.initElements(driver, this);
	}
	List<Object> priceList = new ArrayList<>();

	public List<Object> getPrice() {
		for (int i=1;i<=4;i++){
			String xpath ="//*[@class='wishlist-items-wrapper']/tr["+i+"]/td[4]";
      		System.out.println(xpath);
			String price = driver.findElement(By.xpath(xpath)).getText();
			priceList.add(price);
		}
    System.out.println(priceList);
		return priceList;
	}



}
