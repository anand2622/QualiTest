package stepDefinitions;

import java.util.ArrayList;
import java.util.Collections;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pageObjects.HomePage;
import pageObjects.WishListPage;
import util.TestBase;
import io.cucumber.java.en.Given;

public class Steps extends TestBase{

	HomePage homePage;
	WishListPage productListingPage;
	
	@Given("^I add four diffrent products to my wish list$")
	public void user_is_on_Home_Page_and_login() throws InterruptedException {
		TestBase.initialization();
		Thread.sleep(6000l);
		homePage = new HomePage();
		homePage.addProductInWishList();
	}

	@When("^I view my wishlist table$")
	public void view_wishlist_table() throws Throwable {
		homePage.navigateToWishlist();
		Thread.sleep(5000);
	}

	@Then("I find total four selected items in my wishlist")
	public void iFindTotalFourSelectedItemsInMyWishlist() {
		WishListPage ws = new WishListPage();
		int size = ws.getPrice().size();
    	System.out.println(size);
		Assert.assertTrue(size==4);
	}

	@When("I search for lowest product")
	public void iSearchForLowestProduct() {
    	System.out.println("Find lowest product");
	}

	@And("I am able to add lowest price item to my cart")
	public void iAmAbleToAddLowestPriceItemToMyCart() throws InterruptedException {
    	System.out.println("adding lowest product into cart");
		Thread.sleep(12000l);
    	driver.findElement(By.xpath("//*[@class='wishlist-items-wrapper']/tr[3]/td[6]")).click();
	}

	@Then("I am able to verify the item in my cart")
	public void iAmAbleToVerifyTheItemInMyCart() throws InterruptedException {
		driver.findElement(By.xpath("(//*[@class='cart-contents'])[1]")).click();
		Thread.sleep(12000l);
		int cartSize = driver.findElements(By.xpath("//*[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']/tbody/tr")).size();
		Assert.assertTrue(cartSize>1);
	}

}
