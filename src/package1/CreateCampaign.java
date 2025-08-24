package package1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCampaign {

	public static void main(String[] args) throws InterruptedException {
		
		//Setting up chrome browser
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Launching URL
		driver.get("https://dev.reelo.io/login");
		Thread.sleep(2000);
		
		// Step 1 - Login with valid credentials 
		driver.findElement(By.id("email")).sendKeys("maheshpatil7277@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Venom@3875");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/form/div[5]/button")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[1]/div[1]/ul/li[2]/div[2]/span")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[contains(text(),'Template Library')]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/main/div[2]/div[2]/div/div[2]/div/div[4]/div/div")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class ='secondary-btn']")).click();
		
		//Step 2- Provide a custom campaign title of your choice
		driver.findElement(By.xpath("//h4[contains(text(),'Rs.75 Off to Celebrate New Beginnings')]")).click();
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//span[contains (text(), 'Customise and Send')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[2]/div/div/div[3]/div[2]/label/input")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		Thread.sleep(2000);
		
		WebElement input =driver.findElement(By.xpath("//input[@class = 'field-input']"));
		input.sendKeys(Keys.CONTROL + "a");  // Select all text
		input.sendKeys(Keys.DELETE);         // Delete selected text
		input.sendKeys("Rs.75 Off to Celebrate Ganesh Chaturthi festival enjoy with your family");   // Enter new value
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		Thread.sleep(3000); 

		//Step 3 Enter your own phone number
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		Thread.sleep(3000);
		
		// Step 4( Additional step)- Upload a logo image as part of the campaign creative.
		WebElement uploadLogo = driver.findElement(By.xpath("//input[@type='file']"));
		uploadLogo.sendKeys("C:\\Users\\Mahesh\\Downloads\\Ganesh Murti.jpeg");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Wait for "Next" button inside campaign flow
		WebElement nextButton = wait.until(
		        ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Next')]"))
		);

		// Scroll and click "Next"
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton);
		Thread.sleep(3000);
		
		//Step 5 - Modify the SMS content to include your name within the message body
		WebElement input2 =driver.findElement(By.xpath("//input[@value ='Mahesh']"));
		input2.sendKeys(Keys.CONTROL + "a");  // Select all text
		input2.sendKeys(Keys.DELETE);         // Delete selected text
		input2.sendKeys("Mahesh Patil");   // Enter new value
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		Thread.sleep(3000);
		
		//Step 6 - Trigger the "Test the campaign" action and verify receipt SMS on Your device and click on Save and Exit
		driver.findElement(By.xpath("//span[contains(text(),'Test campaign')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),'Save and exit')]")).click();
		
		System.out.println("The task of compaign creation is completed");
		driver.close();
		
	}

}
