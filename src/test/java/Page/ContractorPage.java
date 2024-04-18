package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContractorPage {
	WebDriver driver;
	
	@FindBy(xpath="//li[@class=\"nav-item\"][2]")WebElement Services;
	
	@FindBy(xpath="//a[text()=\"Find A Contractor \"]")WebElement Contractor;
	
	@FindBy(xpath="//input[@placeholder=\"Pincode/Area\"]")WebElement Pincode;
	
	
	@FindBy(xpath="//button[@class=\"ctaText baseBtn track-store js-pincode-cta\"]")WebElement Search;
	
	//@FindBy(xpath="//span[@class=\"form-checkbox-input__custom--check track_checkbox\"]")WebElement Category;
	
	@FindBy(xpath="(//p[text()=\"Jogeshwari-malad\"])[1]")WebElement name;
	
	public ContractorPage(WebDriver driver) 
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
	public void Pincodes(String pin) throws InterruptedException
	{
		Thread.sleep(1000);
		Pincode.sendKeys(pin);
	}
	public void search() throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Search);
	}
//	public void categories()
//	{
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", Category);
//		
//	}
	public void scrolldownContractors ()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,4000)");
		js.executeScript("arguments[0].click();", Search);
		js.executeScript("window.scroll(0,800)");
	}
	public String verify()
	{
		String message = name.getText();
		return message;
	}
	
		
	}

