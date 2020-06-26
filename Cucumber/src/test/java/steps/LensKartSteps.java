package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LensKartSteps {
	
	EdgeDriver driver;
	
	WebDriverWait wait;
	
	@Given("Go to https://www.lenskart.com/")
	public void go_to_https_www_lenskart_com() {
	    System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
	    driver = new EdgeDriver();
	    driver.get("https://www.lenskart.com/");
	    driver.manage().window().maximize();
	    
	    /*WebElement noThanks = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='No thanks']")));
	    noThanks.click();*/
	}

	@Given("Mouseover on Contact Lenses")
	public void mouseover_on_Contact_Lenses() {
		
		wait = new WebDriverWait(driver, 10);
		WebElement contactLens = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Contact Lenses']")));
		Actions builder = new Actions(driver);			
		builder.moveToElement(contactLens).perform();
	    
	}

	@Given("Click on Monthly under Explore By Disposability")
	public void click_on_Monthly_under_Explore_By_Disposability() {
	    WebElement monthly = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Monthly']")));
	    monthly.click();
	}

	@Given("Select brand as Aqualens")
	public void select_brand_as_Aqualens() {
		WebElement aquaLens = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'Aqualens')])[2]")));
	    aquaLens.click();
	}

	@Given("Click on the first product")
	public void click_on_the_first_product() {
	   WebElement firstProd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'product-info')])[1]/div/div[1]")));
	   firstProd.click();
	}

	@Given("Click Buy Now")
	public void click_Buy_Now() {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='q']"))).click();
		
	    WebElement buyNow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='BUY NOW']")));
	    buyNow.click();
	}

	@Given("Select No of boxes as {int} and Power as {int} for both eyes.")
	public void select_No_of_boxes_as_and_Power_as_for_both_eyes(int box, int power) {
		
		String boxText = String.valueOf(box);
		String powerText = String.valueOf(power);
		
	    WebElement rightbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='boxes'])[1]")));
		Select rightEye = new Select(rightbox);
		rightEye.selectByValue(boxText);
		
		WebElement rightArr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=' dropdown-display cl-dd'])[1]/i")));
		rightArr.click();
		
		WebElement rightPower = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='"+powerText+".00']")));
		rightPower.click();
		
		WebElement leftbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='boxes'])[2]")));
		Select leftEye = new Select(leftbox);
		leftEye.selectByValue(boxText);
		
		WebElement leftArr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=' dropdown-display cl-dd'])[2]/i")));
		leftArr.click();
		
		WebElement leftPower = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='"+powerText+".00']")));
		leftPower.click();
		
	}

	@Given("Type your (.*) in User's name")
	public void type_your_name_in_User_s_name(String username) {
	  WebElement userNameEle = wait.until(ExpectedConditions.elementToBeClickable(By.id("example-text-input")));
	  userNameEle.sendKeys(username);
	}

	@When("And click Save and continue")
	public void and_click_Save_and_continue() {
		
		WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='SAVE & CONTINUE'])[1]")));
	    save.click();
	}

	@Then("Print total amount and click Proceed to Checkout")
	public void print_total_amount_and_click_Proceed_to_Checkout() {
		
		WebElement total = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='span6 color-yellow text-left']")));
	    String textTotal = total.getText();
	    System.out.println(textTotal);
	    
	    WebElement checkOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Proceed To Checkout']")));
	    checkOut.click();
	    
	    driver.close();
	}


}
