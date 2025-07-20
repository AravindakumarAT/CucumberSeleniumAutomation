package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKartStepDefinition 
{
	
	public WebDriver driver;
	String lanProductName;
	String offProductName;
	private Wait wait;
	@Given("user is on GreenKart Landing Page")
	public void user_is_on_green_kart_landing_page() 
	{
	    driver =new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	    wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	@When("user searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@class='search-keyword']")).sendKeys(shortName);
		Thread.sleep(2000);
		lanProductName=driver.findElement(By.xpath("//h4[@class='product-name']")).getText();
		lanProductName=lanProductName.split("-")[0].trim();
		
	} 
	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException 
	{
	    driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
	    Set<String> tabs=driver.getWindowHandles();
	    Iterator<String> tab=tabs.iterator();
	    String parentTab=tab.next();
	    String childTab=tab.next();
	    driver.switchTo().window(childTab);
	    driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
	    Thread.sleep(2000);
	    offProductName=driver.findElement(By.xpath("//tbody/tr/td[1]")).getText().trim();
	    
	}
	@Then("validate product name in offers page matches with Landing Page")
	public void And_validate_product_name_in_offers_page_matches_with_Landing_Page()
	{
		Assert.assertEquals(lanProductName, offProductName);
		driver.quit();
	}
}
