package salesforce;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateSalesforceTestng extends CommonClass {
	@Test(dataProvider="sendData")
	public void runCreateSalesforce(String name,String DOB) {
		
		//click the new button
		driver.findElement(By.xpath("(//div[text()='New'])[1]")).click();
		//enter the opportunity name
		WebElement opportunityName = driver.findElement(By.xpath("(//input[@name='Name'])[1]"));
		opportunityName.sendKeys(name);
		opportunityName.getAttribute("value");
		System.out.println(opportunityName.getAttribute("value"));
		//enter the date
		driver.findElement(By.xpath("(//input[@name='CloseDate'])[1]")).sendKeys(DOB);
		//identify the stage bar
		WebElement findElement2 = driver.findElement(By.xpath("(//div[@class='slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right'])[3]"));
		findElement2.click();
		//select the need analysis option
		driver.findElement(By.xpath("(//span[@class='slds-media__body']/span)[4]")).click();
		//click the save button
		driver.findElement(By.xpath("(//button[@name='SaveEdit'])")).click();
		String title = driver.getTitle();
		System.out.println(driver.getTitle());
		if(title.contains("salesforce Automation by pradeepkumar N")) {
			System.out.println("verified");
		}else {
			System.out.println("other");
		}
		
		
		
         
		
		
		
		
		
	}
	@DataProvider
	public String[][] sendData() throws IOException {
		SalesforceReadExcel ex=new SalesforceReadExcel();
		String[][] data = ex.read();
		return data;
		
		
		

	}

}
