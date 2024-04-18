package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractorDetails {
	WebDriver driver;
	
	@FindBy(xpath="//li[@class=\"nav-item\"][2]")WebElement Services;
	
	@FindBy(xpath="//a[text()=\"Find A Contractor \"]")WebElement Contractor;
	
	@FindBy(xpath="//input[@placeholder=\"Pincode/Area\"]")WebElement Area;
	
	@FindBy(xpath="//button[@class=\"ctaText baseBtn track-store js-pincode-cta\"]")WebElement Search;
	@FindBy(xpath="//h2[text()=\"Asian Paints Trusted Painting Contractors\"]")WebElement City;
	
	
	
	
	
	
	public ContractorDetails(WebDriver driver) 
	     {
			this.driver=driver;
			PageFactory.initElements(driver, this);

		}
	
	
	public void hover()
	{
		Actions act= new Actions(driver);
		act.moveToElement(Services).build().perform();
	}
	
	public void Contractors() throws InterruptedException
	{
		//Contractor.click();
		Thread.sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", Contractor);
	}
	public void area(String area) throws InterruptedException
	{
		Thread.sleep(1000);
		Area.sendKeys(area);
	}
	
	public void search() throws InterruptedException
	{
		
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Search);
		js.executeScript("window.scroll(0,200)");
	}
	public String verify()
	{
		
		
		String message = City.getText();
		return message;
	}

	
	
	
}
