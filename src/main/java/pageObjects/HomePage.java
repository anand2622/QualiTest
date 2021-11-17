package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "(//*[text()='Add to wishlist'])[5]")
	WebElement firstProduct;

	@FindBy(xpath = "(//*[text()='Add to wishlist'])[2]")
	WebElement secondProdct;

	@FindBy(xpath = "(//*[text()='Add to wishlist'])[3]")
	WebElement thirdProduct;

	@FindBy(xpath = "(//*[text()='Add to wishlist'])[1]")
	WebElement forthProduct;

	@FindBy(xpath = "(//*[@class='header-wishlist'])[1]")
	WebElement wishListLink;

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addProductInWishList() throws InterruptedException {
		System.out.println("Adding four diffrent product into wishlist");
		addProduct(firstProduct);
		Thread.sleep(5000l);
    	System.out.println("first product added");
		addProduct(secondProdct);
		Thread.sleep(5000l);
		System.out.println("Second product added");
		addProduct(thirdProduct);
		Thread.sleep(5000l);
		addProduct(forthProduct);
		Thread.sleep(5000l);
	}

	public void addProduct(WebElement product){
		if(!isProductAddedInWishlist(product)){
			product.click();
		}else {
      		System.out.println("Product already added in wish list Please see wishlist");
		}
	}
	public boolean isProductAddedInWishlist(WebElement product) {
		String text = product.getText().toLowerCase();
		boolean productAdded = false;
		if(text.contains("Product added! Browse wishlist")){
			productAdded = true;
		}
		return productAdded;
	}

	public void navigateToWishlist(){
		wishListLink.click();
	}
	
}
