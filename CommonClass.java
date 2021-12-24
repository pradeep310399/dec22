package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonClass {
	public ChromeDriver driver;
	@Parameters({"url","username","password"})//parameter name matters;order doesnt matters
	
	@BeforeMethod
	public void precondition(String url,String uName,String pWord) {//order matters;but argument name can be anything
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
	    driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//enter the url
		driver.get(url);
		//Enter the username and password
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pWord);
		//click the login button
		driver.findElement(By.id("Login")).click();
		//click the toggle button
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//click the view all button
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//click the sales option
		driver.findElement(By.xpath("//p[text()='Manage your sales process with accounts, leads, opportunities, and...']")).click();
		//click on the opportunities tab
		WebElement opp = driver.findElement(By.xpath("//span[contains(@class,'slds-truncate')]/parent::a[@title='Opportunities']"));
        driver.executeScript("arguments[0].click();", opp);
	}
	

	
	@AfterMethod
	public void postcondition() {
		driver.close();
	}

}
