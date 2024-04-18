package Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvalidCall {


		WebDriver driver;
//		@FindBy(xpath="//li[@class=\"nav-item\"][2]")WebElement Services;
//		@FindBy(xpath="(//a[@href=\"https://www.asianpaints.com/home-decor/kitchen.html\"])[1]")WebElement modularkitchen;
//		@FindBy(xpath="((//input[@id=\"enquire-name\"])[1]")WebElement enquirename;
//		@FindBy(xpath="(//input[@id=\"enquire-email\"])[1]")WebElement email;
//		@FindBy(xpath="(//input[@id=\"enquire-mobile\"])[1]")WebElement mobilenumber;
//		@FindBy(xpath="(//input[@id=\"enquire-pincode\"])[1]")WebElement pincode;
////		@FindBy(xpath="(//button[@class=\"ctaText enquireForm--step-1-submit track_form_submit\"])[2]")WebElement BookCall;
////		
		@FindBy(xpath="//li[@class=\"nav-item\"][2]")WebElement Services;
		@FindBy(xpath="(//a[@href=\"https://www.asianpaints.com/home-decor/kitchen.html\"])[1]")WebElement modularkitchen;
		@FindBy(xpath="(//input[@id=\"enquire-name\"])[3]")WebElement enquirename;
		@FindBy(xpath="(//input[@id=\"enquire-email\"])[3]")WebElement email;
		@FindBy(xpath="(//input[@id=\"enquire-mobile\"])[3]")WebElement mobilenumber;
		@FindBy(xpath="(//input[@id=\"enquire-pincode\"])[3]")WebElement pincode;
		@FindBy(xpath="(//button[@class=\"ctaText enquireForm--step-1-submit track_form_submit\"])[2]")WebElement BookCall;
		//@FindBy(xpath="(//p[text()=\"Get free assistance from our AP Beautiful Homes Stores design expert\"])[1]")WebElement free;
		
public InvalidCall(WebDriver driver) 
{
			this.driver=driver;
			PageFactory.initElements(driver, this);

}


	public void hover()
	{
		Actions act= new Actions(driver);
		act.moveToElement(Services).build().perform();
	}
	public void kitchen()
	{
		modularkitchen.click();
	}
	public void scrolldown()
	{
		
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scroll(0,4000)");
	}

		public void typedata(String Name, String Mobilenumber, String Pincode, String Email) throws InterruptedException 
		{
				enquirename.sendKeys(Name);
				Thread.sleep(1000);
				email.sendKeys(Email);
				Thread.sleep(1000);
				mobilenumber.sendKeys(Mobilenumber);
				Thread.sleep(1000);
				pincode.sendKeys(Pincode);
	}
		public void button() throws InterruptedException
		{
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", BookCall);
		}
//		public String verify2() throws InterruptedException
//		{   
//			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.elementToBeClickable(TryAgain));
//			String message = free.getText();
//			return message;
//		}
	}

