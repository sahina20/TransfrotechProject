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

public class ChatBoxTest {
WebDriver driver;
   @BeforeMethod
   @Given("user loads application")
	public void user_loads_application() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sahina\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://transfotechacademy.com/");
	    
	    
	}

   @When("user clicks on live chat button")
   public void user_clicks_on_live_chat_button() {
	   
	   WebElement liveChatroom = driver.findElement(By.id("hubspot-messages-iframe-container"));
	   liveChatroom.click();
   }
   
   @And("user types in message")
	public void user_types_in_message() {
		WebElement msgTxtBox= driver.findElement(By.className("VizExExpandingInput__StyledInput-sc-1i7nq0s-0 fjvlWY widget-textarea message-box"));
		 msgTxtBox.sendKeys("Hi, I'm interested in QA courses");
		
	}

	@And("user clicks send button")
	public void user_clicks_send_button() {
		WebElement sendBtn= driver.findElement(By.className("VizExIconButton__AbstractVizExIconButton-qn2ivo-0 kCeawo chat-send-button"));
		sendBtn.click();
	}

	@Then("user should see message populate in chatroom")
	public void user_should_see_message_populate_in_chatroom() {
	    Assert.assertEquals(driver.findElement(By.className("PrimaryMessage__PrimaryMessageWrapper-a47ua2-0 hNrHUv")).getText().trim(),
	    		"Hi, I'm interested in QA courses");
	    driver.close();
	}
	
	@And("user should be able to click on attachment button")
	public void user_should_be_able_to_click_on_attachment_button() {
	   WebElement attachBtn = driver.findElement(By.className("VizExIconButton__AbstractVizExIconButton-qn2ivo-0 kCeawo chat-send-button"));
	   attachBtn.click();
	   
	   driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
