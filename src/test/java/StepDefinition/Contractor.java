package StepDefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import DriverSetup.SetupDriver;
import Page.Call;
import Page.ContractorDetails;
import Page.ContractorPage;
import Page.Interior;
import Page.InvalidCall;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Contractor {
	private static final String String = null;
	static WebDriver driver;
    ContractorPage p;
	Interior i;
	Call c;
	InvalidCall q;
	ContractorDetails cd;

	@Given("user is on the homepage of Asian Paints website")
	public void user_is_on_the_homepage_of_asian_paints_website() 
	{
		driver=SetupDriver.chromedriver();
	}

	@When("hover over the {string} menu")
	public void hover_over_the_menu(String string)
	{
	    i = new Interior(driver);
	    i.hover();
	   
	}	
	
//-------------------------------------------------------------------------
//Scenario 1
	
	@When("click on the painting services  option")
	public void click_on_the_painting_services_option() throws InterruptedException {
		i.Paintingservice();
	}


	@And("scrolldown the painting services")
	public void scrolldown_the_painting_services() throws InterruptedException {
		i.scrolldown();
	}

	@And("click on interior wall painting")
	public void click_on_interior_wall_painting() throws InterruptedException {
		i.Interiorpainting();
	}

	@And("scrolldown the page")
	public void scrolldown_the_page() throws InterruptedException {
		i.scrolldown1();
	}
	@And("click on royale glitz")
	public void click_on_royale_glitz() throws InterruptedException {
		i.royaleglitz();
	}

	@Then("It displays the royale glitz")
	public void it_displays_the_royale_glitz() {
		String url="https://www.asianpaints.com/products/paints-and-textures/interior-walls/plain-finishes/royale-glitz.html";
		Assert.assertEquals(url,driver.getCurrentUrl());   
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//Scenario 2 
	
@And("click on the find a contractor option")
public void click_on_the_find_a_contractor_option() throws InterruptedException 
{
	p = new ContractorPage(driver);
    p.hover();
    p.Contractors();
}


@And("^enter a valid (.*)")
public void enter_a_valid(String pincode) throws InterruptedException 
{
    p.Pincodes(pincode);
}


@And("click on search")
public void click_on_search() throws InterruptedException
{
   p.search();
}

//@And("select category")
//public void select_category() 
//{
//   p.categories();
//}
@And("Scrolldown the page contractor page")
public void scrolldown_the_page_contractor_page() 
{
   p.scrolldownContractors();
}



@Then("It gives the contractor details accordingly given pincode")
public void it_gives_the_contractor_details_accordingly_given_pincode() 
{
	    String actual =p.verify();
	    String expected = "Jogeshwari-Malad";
	    Assert.assertEquals(actual, expected);
	
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// scenario 3
@And("click on the Modular Kitchen option")
public void click_on_the_modular_kitchen_option() 
{
	c=new Call(driver);
   c.kitchen();
}

@And("scroll down the page towards book a call")
public void scroll_down_the_page_towards_book_a_call() 
{
   c.scrolldown();
}


@And("customer details are (.*), (.*), (.*) and (.*)$")
public void customer_details_are_and(String enquireName, String enquireEmail, String enquireMobile, String enquirePincode) throws InterruptedException 
{
  c.typedata(enquireName, enquireMobile, enquirePincode, enquireEmail);
}



@And("click on the BOOK A CALL button")
public void click_on_the_book_a_call_button() throws InterruptedException
{
   c.button();
}

@Then("call is booked successfully")
public void call_is_booked_successfully() throws InterruptedException
{
	String url="https://www.asianpaints.com/home-decor/kitchen.html";
	Assert.assertEquals(url,driver.getCurrentUrl());
}
//Scenario 4---------------------------------------------------------------------------------------------------

@When("user should click on the modular kitchen option")
public void user_should_click_on_the_modular_kitchen_option() 
{
   q=new InvalidCall(driver);
   q.kitchen();
}

@And("user should scroll down the page to book a call")
public void user_should_scroll_down_the_page_to_book_a_call() 
{
    q.scrolldown();
}

@And("user details are (.*), (.*), (.*) and (.*)$" )
public void user_details_are(String enquireName, String enquireEmail, String enquireMobile, String enquirePincode) throws InterruptedException
{
	q.typedata(enquireName, enquireMobile, enquirePincode, enquireEmail);
}

@And("user should click on the book a call button")
public void user_should_click_on_the_book_a_call_button() throws InterruptedException
{
   q.button();
}
@Then("user call is is not able to book the call")
public void user_call_is_is_not_able_to_book_the_call() throws InterruptedException 
{
//	String actual =q.verify2();
//    String expected = "Get free assistance from our AP Beautiful Homes Stores design expert";
//    Assert.assertEquals(expected, actual );
}

//Scenario 5-----------------------------------------------------------------------------------------------------

@When("user is click Find a Contractor")
public void user_is_click_find_a_contractor() throws InterruptedException 
{
	cd=new ContractorDetails(driver);
   cd.Contractors();
}

//@And("^user is able to find contractor by their area (.*)^")
//public void user_is_able_to_find_contractor_by_their_area_hyderabad(String Area) 
//{
//   cd.area(Area);
//}

@And("^user is able to find contractor by their area (.*)$")
public void user_is_able_to_find_contractor_by_their_area(String string) throws InterruptedException {
   cd.area(string);
}


@And("user should click on search for details")
public void user_should_click_on_search_for_details() throws InterruptedException 
{
    cd.search();
}
@Then("show the contractors belongs to their area")
public void show_the_contractors_belongs_to_their_area() 
{
    String actual =cd.verify();
    String expected = "Hyderabad Nampally";
    Assert.assertEquals(actual, expected);
}


@AfterStep
public static void takeScreendown(Scenario scenerio) {
	   TakesScreenshot ts= (TakesScreenshot) driver;
	   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
	   scenerio.attach(src, "image/png",scenerio.getName());
}
}
