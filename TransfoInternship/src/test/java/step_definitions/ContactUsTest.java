package step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsTest {
	WebDriver driver;
	@BeforeMethod
	@Given("user loads  Transfotech application")
	public void user_loads_transfotech_application(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sahina\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://transfotechacademy.com/");}
	
	
	
	@When("user clicks on Contact Us link")
	public void user_clicks_on_contact_us_link() {
		WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
	    contactUs.click();
	    driver.getCurrentUrl();
	   
	}

	@Then("user should see Contact information")
	public void user_should_see_contact_information() {
	  WebElement address = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/section[2]/div/div[1]/div/div[4]/div/div/div[2]/p"));
	  String actualtextaddress = address.getText();
	  String expectedtextaddress= "17221 Hillside Ave, # 207, New York 11432, USA";
	  Assert.assertEquals(actualtextaddress, expectedtextaddress);
	  
	  WebElement emailTr = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/section[2]/div/div[1]/div/div[5]/div/div/div[2]/p"));
	  emailTr.getText();
	  
	  WebElement pn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/section[2]/div/div[1]/div/div[6]/div/div/div[2]/p"));
	  pn.getText();
	}

	@And("user should see message form box")
	public void user_should_see_message_form_box() {
	    WebElement msgForm = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/section[2]/div/div[2]/div"));
	    msgForm.getLocation();
	    System.out.println(msgForm);
	}

	@And("user should fill out form and send message")
	public void user_should_fill_out_form_and_send_message() {
		WebElement firstName = driver.findElement(By.id("form-field-name"));
		firstName.sendKeys("Helen");
		WebElement lastName = driver.findElement(By.id("form-field-field_4f0ea0e"));
		lastName.sendKeys("Smith");
		WebElement phone = driver.findElement(By.id("form-field-field_b82ee72"));
		phone.sendKeys("2221113333");
		WebElement email = driver.findElement(By.id("form-field-email"));
		email.sendKeys("Helen.Smith@gmail.com");
		WebElement courseBtn = driver.findElement(By.id("form-field-field_3a0f002-1"));
		courseBtn.click();
		WebElement msgText = driver.findElement(By.id("form-field-message"));
		msgText.sendKeys("Hi, Im interested in the QA course offered.");
		WebElement sendmsgbtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/section[2]/div/div[2]/div/div[2]/div/form/div/div[7]/button"));
		sendmsgbtn.click();
		
	
	    driver.close();
		
	}

}
