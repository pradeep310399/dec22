package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditSalesforceTestng extends CommonClass {
	@Test
	public  void runEditSalesforce() throws InterruptedException {
		
		//search the name in search  bar
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("salesforce Automation by pradeepkumar N",Keys.ENTER);
		Thread.sleep(5000);
		//click the dropdown
		driver.findElement(By.xpath("(//span[text()='Show Actions']/parent::span)[1]")).click();
		Thread.sleep(5000);
		//click the edit option
		driver.findElement(By.xpath("//div[text()='Edit']/parent::a")).click();
		//edit the date 
		WebElement date = driver.findElement(By.xpath("//input[@name='CloseDate']"));
		date.clear();
		date.sendKeys("12/22/2021");
		//edit the stage as perception analysis
		Thread.sleep(5000);
		WebElement findElement2 = driver.findElement(By.xpath("//label[text()='Stage']/following::input[1]"));
		findElement2.click();
		WebElement perceptionanalysis = driver.findElement(By.xpath("//span[contains(@class,'slds-media')]/following::span[text()='Perception Analysis']"));
		perceptionanalysis.click();
		String attribute = perceptionanalysis.getAttribute("title");
		System.out.println(attribute);
		//entering the delivery status as in progress
		Thread.sleep(5000);
		WebElement delivery = driver.findElement(By.xpath("//span[contains(@class,'slds-form')]/following::label[text()='Delivery/Installation Status']"));
		driver.executeScript("arguments[0].click();", delivery);	
		Thread.sleep(5000);
		WebElement inprogress = driver.findElement(By.xpath("(//span[text()='In progress'])"));
		driver.executeScript("arguments[0].click();", inprogress);
		/*
		 * Actions builder = new Actions(driver);
		 * builder.moveToElement(inprogress).doubleClick().perform();
		 */
		//enter the description
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])")).sendKeys("SalesForce");
		//click the save button
		WebElement savebutton = driver.findElement(By.xpath("(//button[@name='SaveEdit'])"));
		driver.executeScript("arguments[0].click();", savebutton);
		//check the perception analysis is clicked
		if(attribute.contains("Perception Analysis")) {
			System.out.println("verfied");
		}
		else {
			System.out.println("other");
		}
		
	}
	
		
		

	

}
		
