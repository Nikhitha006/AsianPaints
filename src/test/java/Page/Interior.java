package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Interior {
	WebDriver driver;
	@FindBy(xpath="//li[@class=\"nav-item\"][2]")WebElement Services;
	@FindBy(xpath="//a[@href=\"https://www.asianpaints.com/services/asian-paints-safe-painting-service.html\"][text()=\"Painting Services\"]")WebElement PaintingServices;
	@FindBy(xpath="//div[@class=\"image-explore-stores\"]//img[@alt=\"Our-Services-Interior-Wall-Painting\"]") WebElement Interiorpaintings;
    @FindBy(xpath="//img[@alt=\"Royale Glitz Paint - Asian Paints\"]")WebElement RoyaleGlitz;
    
  
    
    public Interior(WebDriver driver) 
    {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
    
    public void hover()
	{
		Actions act= new Actions(driver);
		act.moveToElement(Services).build().perform();
	}
    
    
    public void Paintingservice() throws InterruptedException
    {
    	//PaintingServices.click();
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;

    			js.executeScript("arguments[0].click();",PaintingServices);
    	
    }
  
    public void scrolldown() throws InterruptedException
    	{
    
    		JavascriptExecutor js=(JavascriptExecutor)driver;
    		js.executeScript("window.scroll(0,600)");
    	}
    
    public void Interiorpainting() throws InterruptedException
    {
    	//Interiorpaintings.click();
    	Thread.sleep(1000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",Interiorpaintings);
    }
    public void scrolldown1() throws InterruptedException
    
	{
    	Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,600)");
	}
    public void royaleglitz() throws InterruptedException
    {
    	//RoyaleGlitz.click();
    	Thread.sleep(1000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",RoyaleGlitz);
    }    
    
    
}
