package steps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NaukriSteps {
	
	ChromeDriver driver;
	
	@Given("Open naukri.com")
	public void open_naukri_com() {
		
		System.setProperty("webdriver.chrome.silentOutput", "true");
	    System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	    
	    ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		
	    driver = new ChromeDriver(op);
	    driver.get("https://www.naukri.com/");
	    driver.manage().window().maximize();
	}

	@When("Get the company names from each pop up window and close it")
	public void get_the_company_names_from_each_pop_up_window_and_close_it() throws InterruptedException {
	    String firstWin = driver.getWindowHandle();
	    Set<String> winHan = driver.getWindowHandles();
	    System.out.println(winHan);
	    List<String> l1 = new ArrayList<String>();
	    l1.addAll(winHan);
	    
	    Thread.sleep(5000);
	    
	    driver.switchTo().window(l1.get(1));
	    driver.manage().window().maximize();
	    String comp1 = driver.findElementByXPath("(//img)[1]").getAttribute("alt");
	    System.out.println(comp1);
	    
	    driver.switchTo().window(l1.get(2));
	    driver.manage().window().maximize();
	    String comp2 = driver.findElementByXPath("(//img)[1]").getAttribute("alt");
	    System.out.println(comp2);
	    
	    driver.switchTo().window(firstWin);
	    
	}

	@When("Click on the upload cv button and upload some random image.")
	public void click_on_the_upload_cv_button_and_upload_some_random_image() throws AWTException, InterruptedException {
		
		driver.findElementById("wdgt-file-upload").click();
		
		Thread.sleep(5000);
		
		StringSelection sl = new StringSelection("C:\\Users\\hp\\Desktop\\25 June 2020\\Alex Talk.mp4");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sl, null);
		
		Robot bot = new Robot();
		bot.keyPress(KeyEvent.VK_CONTROL);
		bot.keyPress(KeyEvent.VK_V);
		
		Thread.sleep(5000);
		
		bot.keyRelease(KeyEvent.VK_V);
		bot.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(5000);
		
		bot.keyPress(KeyEvent.VK_ENTER);
		bot.keyRelease(KeyEvent.VK_ENTER);
	}

	@Then("the error message printed")
	public void the_error_message_printed() throws InterruptedException {
		Thread.sleep(5000);
	    String errMsg = driver.findElementByXPath("//div[@class='error-header-desc error']").getText();
	    System.out.println(errMsg);
	    
	    driver.quit();
	}

}
