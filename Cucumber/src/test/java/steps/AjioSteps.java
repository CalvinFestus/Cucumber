package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AjioSteps {
	
	FirefoxDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	@Given("Go to https:\\/\\/www.ajio.com\\/")
	public void go_to_https_www_ajio_com() {
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
	    driver = new FirefoxDriver();
	    driver.get("https://www.ajio.com/shop/sale");
	    driver.manage().window().maximize();	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    wait = new WebDriverWait(driver, 30);
	    js = (JavascriptExecutor)driver;
	    
	    WebElement close = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ic-close-quickview']")));
	    close.click();
	    
	}

	@Given("Mouseover on Women, CATEGORIES and click on Kurtas")
	public void mouseover_on_Women_CATEGORIES_and_click_on_Kurtas() {
		
		
		WebElement women = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='level-first false']/li[3]/a")));
		Actions builder = new Actions(driver);
		builder.moveToElement(women).perform();
		
		WebElement kurtas = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Kurtas")));
		kurtas.click();
		
	}

	@Given("Click on Brands and choose Ajio")
	public void click_on_Brands_and_choose_Ajio() {
		
		WebElement brands = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='brands']")));
		brands.click();
		
		WebElement ajioBrand = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='facet-linkhead']/label[contains(@class,'AJIO')]")));
		ajioBrand.click();
	    
	}

	@Given("Check all the results are Ajio")
	public void check_all_the_results_are_Ajio() {
		
		WebElement checkFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='fnl-plp-appliedFliters ']/div/div/span")));
		String filter = checkFilter.getText();
		
		if(filter.equals("AJIO")) {
			System.out.println("Only AJIO Products");
		}
		
	}

	@Given("Set Sort by the result as Discount")
	public void set_Sort_by_the_result_as_Discount() {
		
		WebElement sortBy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='filter-dropdown']/select")));
		
		Select sort = new Select(sortBy);
		sort.selectByIndex(4);
	    
	}

	@Given("Select the Color and click ADD TO BAG")
	public void select_the_Color_and_click_ADD_TO_BAG() {
		
		WebElement firstProd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='item rilrtl-products-list__item item'])[1]/a/div/div[2]/div[2]")));
		js.executeScript("arguments[0].click();", firstProd);
		
		Set<String> winHan = driver.getWindowHandles();
		List<String> l1 = new ArrayList<String>();
		l1.addAll(winHan);
		System.out.println(winHan);
		
		driver.switchTo().window(l1.get(1));
		
		WebElement addToBag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='btn-gold']")));
		addToBag.click();
		
	}

	@Given("Verify the error message Select your size to know your estimated delivery date")
	public void verify_the_error_message_Select_your_size_to_know_your_estimated_delivery_date() {
		
		WebElement errMsg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='err-msg-blk']/div/span[2]")));
		String errMsgText = errMsg.getText();
		if(errMsgText.equals("Please select a size")) {
			System.out.println("Error Message is :"+errMsgText);
		}
	}

	@Given("Select size and click ADD TO BAG")
	public void select_size_and_click_ADD_TO_BAG() {
		
		WebElement size = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='size-swatch'])[4]/div")));
		size.click();
		
		WebElement addToBag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='btn-gold']")));
		addToBag.click();
	   
	}

	@Given("click on Enter pin-code to know estimated delivery date")
	public void click_on_Enter_pin_code_to_know_estimated_delivery_date() {
		
		WebElement pincodeMsgEle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='edd-pincode-msg-container']/span[2]")));
		js.executeScript("arguments[0].click();", pincodeMsgEle);
	   
	}

	@When("Enter the pincode as 603103 and click Confirm pincode")
	public void enter_the_pincode_as_and_click_Confirm_pincode() throws InterruptedException {
		
		Thread.sleep(5000);
		
		WebElement pincodeBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='edd-pincode-modal-text']")));
		pincodeBox.sendKeys("600126");
		
		Thread.sleep(5000);
		
		WebElement confirmPincode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='edd-pincode-modal-submit-btn']")));
		confirmPincode.click();
	}

	@Then("Print the message and click Go to  Bag")
	public void print_the_message_and_click_Go_to_Bag() {
		
		WebElement pincodeMessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='edd-pincode-msg-container']/div")));
		String pincodeMessageText = pincodeMessage.getText();
		System.out.println(pincodeMessageText);
		
		WebElement goToBag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='btn-cart']/span[2]")));
		goToBag.click();
	}

	@Then("Click on Proceed to Shipping and clode the browser")
	public void click_on_Proceed_to_Shipping_and_clode_the_browser() {
		
		WebElement proceedToShipping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Proceed to shipping']")));
		proceedToShipping.click();
		
		driver.quit();
	    
	}

}
