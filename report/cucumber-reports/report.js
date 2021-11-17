$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/functionalTests/End2End_Tests.feature");
formatter.feature({
  "name": "Automated End2End Tests",
  "description": "Description: The purpose of this feature is to test End2End integration.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Customer places an order by purchasing an item from search",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user is on Home Page and login",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.Steps.user_is_on_Home_Page_and_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user searches for dress",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.Steps.user_searches_for_dress()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "choose to buy the first item",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Steps.choose_to_buy_the_first_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "selects the size and quantity of the dress",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Steps.selects_the_size_and_quantity_of_the_dress()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "add the dress to the cart",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.Steps.add_the_dress_to_the_cart()"
});
formatter.result({
  "status": "passed"
});
});