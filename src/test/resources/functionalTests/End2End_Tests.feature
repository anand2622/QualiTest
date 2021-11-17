@Wishlist_Test
Feature: Automated End2End Tests
Description: The purpose of this feature is to test End2End integration.

Scenario: Customer places an order by purchasing an item from search
	Given I add four diffrent products to my wish list
	When I view my wishlist table
	Then I find total four selected items in my wishlist
	When I search for lowest product
	And I am able to add lowest price item to my cart
	Then I am able to verify the item in my cart
