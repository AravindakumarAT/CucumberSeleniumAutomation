package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKartStepDefinition 
{
	public WebDriver driver;
	@Given("user is on GreenKart Landing Page")
	public void user_is_on_green_kart_landing_page() 
	{
	    driver =new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	@When("user searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String string)
	{
		
	} 
	@Then("user searched for same shortname in offers page to check if product exist")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist() 
	{
	    
	}
}
