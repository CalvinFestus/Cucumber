package steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CarWaleSteps {
	
	ChromeDriver driver;
	JavascriptExecutor js;
	
	@Given("Go to https:\\/\\/www.carwale.com\\/")
	public void go_to_https_www_carwale_com() {
	    System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		op.merge(cap);
		driver = new ChromeDriver(op);
		driver.get("https://www.carwale.com/");
		driver.manage().window().maximize();
	}

	@Given("Click on Used")
	public void click_on_Used() throws InterruptedException {
		driver.findElementByXPath("//li[@data-tabs='usedCars']").click();
		Thread.sleep(2000);	    
	}

	@Given("Select the City as Chennai")
	public void select_the_City_as_Chennai() throws InterruptedException {
		driver.findElementByXPath("//input[@id='usedCarsList']").sendKeys("Chennai");
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']").click();
		Thread.sleep(2000);
	}

	@Given("Select budget min 8L and max 12L and Click Search")
	public void select_budget_min_L_and_max_L_and_Click_Search() throws InterruptedException {
		driver.findElementByXPath("//li[text()='8 Lakh']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//li[text()='12 Lakh'])[2]").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//button[@id='btnFindCar']").click();
		Thread.sleep(2000);
	}

	@Given("Select Cars with Photos under Only Show Cars With")
	public void select_Cars_with_Photos_under_Only_Show_Cars_With() throws InterruptedException {
		driver.findElementByXPath("//div[@name='filterbyadditional']/div//li[1]").click();
		Thread.sleep(2000);
	}

	@Given("Select Manufacturer as Hyundai Creta")
	public void select_Manufacturer_as_Hyundai_Creta() throws InterruptedException {
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		
		driver.findElementByXPath("//span[text()=' Hyundai ']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//span[text()='Creta']").click();
		Thread.sleep(2000);
	}

	@Given("Select Fuel Type as Petrol")
	public void select_Fuel_Type_as_Petrol() throws InterruptedException {
		driver.findElementByXPath("//div[@name='fuel']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//span[text()='Petrol']").click();
		Thread.sleep(2000);
	}

	@Given("Select Best Match as KM: Low to High")
	public void select_Best_Match_as_KM_Low_to_High() throws InterruptedException {
		WebElement sortDrpDwn = driver.findElementByXPath("//select[@id='sort']");
		Thread.sleep(2000);
		Select sort = new Select(sortDrpDwn);
		sort.selectByVisibleText("KM: Low to High");
	}

	@When("Print the First Car")
	public void print_the_First_Car() {
	   String text = driver.findElementByXPath("(//a[@id='linkToDetails'])[1]/span").getText();
	   System.out.println(text);
	}

	@Then("Close the browser.")
	public void close_the_browser() {
	   driver.close();
	}

}
