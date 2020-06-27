package steps;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BikeWaleSteps {

	EdgeDriver driver;

	WebDriverWait wait;

	@Given("Go to https://www.bikewale.com/")
	public void go_to_https_www_bikewale_com() throws AWTException {
		System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("disable-infobars", true);
		caps.setCapability("--disable-notifications", true);
		
		EdgeOptions op = new EdgeOptions();
		op.merge(caps);
		
		driver = new EdgeDriver(op);	
		driver.get("https://www.bikewale.com/");	
		driver.manage().window().maximize();
		
		

	}

	@Given("Go to menu and click new bikes")
	public void go_to_menu_and_click_new_bikes() {
		
		wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='navbarBtn nav-icon']")));
		driver.findElementByXPath("//*[@class='navbarBtn nav-icon']").click();
		
		WebElement newBikes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='New Bikes']")));
		newBikes.click();
	}

	@Given("Click New Bikes Then compare bikes")
	public void click_New_Bikes_Then_compare_bikes() {
		
		WebElement compareBikes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Compare Bikes']")));
		compareBikes.click();
		
	}

	@Given("Add first bike as Royal Enfield and model as Thunderbird 350")
	public void add_first_bike_as_Royal_Enfield_and_model_as_Thunderbird() {
		
		WebElement addBike1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='add-icon'])[1]")));
		addBike1.click();
		
		WebElement brandClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='chosen-container chosen-container-single']")));
		brandClick.click();
		
		WebElement royalEnfield = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Royal Enfield']")));
		royalEnfield.click();
		
		WebElement modelClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'select-model')]/div")));
		modelClick.click();
		
		WebElement thunderBird = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Thunderbird 350']")));
		thunderBird.click();
	}

	@Given("Add second bike Jawa, model as 42 and version Dual Channel ABS - BS VI")
	public void add_second_bike_Jawa_model_as_and_version_Dual_Channel_ABS_BS_VI() {
		
		WebElement addBike2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='add-icon'])[2]")));
		addBike2.click();
		
		WebElement brandClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'select-brand')])[2]/div")));
		brandClick.click();
		
		WebElement brandSend = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='chosen-search']/input)[4]")));
		brandSend.sendKeys("Jawa");
		
		WebElement jawa = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='chosen-results']/li/em")));
		jawa.click();
		
		WebElement modelClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'select-model')]/div)[2]")));
		modelClick.click();
		
		WebElement FortyTwo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='42']")));
		FortyTwo.click();
		
		WebElement versionClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'select-version')]/div)[2]")));
		versionClick.click();
		
		WebElement versionName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Dual Channel ABS - BS VI']")));
		versionName.click();
	}


	@Given("Add bike brand Kawasaki model as Ninja 300")
	public void add_bike_brand_Kawasaki_model_as_Ninja() {
		
		WebElement addBike2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='add-icon'])[3]")));
		addBike2.click();
		
		WebElement brandClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'select-brand')])[3]/div")));
		brandClick.click();
		
		WebElement brandSend = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='chosen-search']/input)[7]")));
		brandSend.sendKeys("Kawasaki");
		
		WebElement kawasaki = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class='chosen-results']/li/em)[2]")));
		kawasaki.click();
		
		WebElement modelClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'select-model')]/div)[3]")));
		modelClick.click();
		
		WebElement Ninja300 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Ninja 300']")));
		Ninja300.click();

	}

	@When("click compare")
	public void click_compare() {
		
		WebElement compareBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnCompare")));
		compareBtn.click();
	}

	@Then("Find and print the maximum overall rating of all the bikes and find the max")
	public void find_and_print_the_maximum_overall_rating_of_all_the_bikes_and_find_the_max() {
		
		List<String> s1 = new ArrayList<String>();
		
		WebElement review = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='overall-tabs']/ul/li[5]")));
		review.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='rating-block']/span/span[2]")));
		
		List<WebElement> ratingOverall = driver.findElementsByXPath("//div[@class='rating-block']/span/span[2]");
		
		for(int i =0;i<ratingOverall.size();i++) {
			
			String ratingVal = ratingOverall.get(i).getText();
			s1.add(ratingVal);
			
		}
		
		Collections.sort(s1);
		
		System.out.println(s1.get(ratingOverall.size()-1));
		
		driver.close();

	}


}
