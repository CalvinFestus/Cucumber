package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TrivagoSteps {
	
	ChromeDriver driver;	
	JavascriptExecutor js;
	Actions builder;
	
	@Given("Go to https:\\/\\/www.trivago.com\\/")
	public void go_to_https_www_trivago_com() {
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		op.merge(cap);
		driver = new ChromeDriver(op);
		driver.get("https://www.trivago.com/");
		driver.manage().window().maximize();
	}

	@Given("Type Agra in Destination and select Agra, Uttar Pradesh.")
	public void type_Agra_in_Destination_and_select_Agra_Uttar_Pradesh() throws InterruptedException {
		driver.findElementById("querytext").sendKeys("Agra",Keys.TAB,Keys.TAB);
		Thread.sleep(2000);
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
	}

	@Given("Choose June 15 as check in and June 30 as check out")
	public void choose_May_as_check_in_and_June_as_check_out() throws InterruptedException {
		
		driver.findElementByXPath("//time[@datetime='2020-06-15']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//time[@datetime='2020-06-30']").click();
		Thread.sleep(2000);
	}

	@Given("Select Room as Family Room")
	public void select_Room_as_Family_Room() throws InterruptedException {
		driver.findElementByXPath("//span[text()='Family rooms']").click();
		Thread.sleep(2000);
	}

	@Given("Choose Number of Adults 2, Childern 1 and set Child's Age as 4")
	public void choose_Number_of_Adults_Childern_and_set_Child_s_Age_as() throws InterruptedException {
		Select children = new Select(driver.findElementById("select-num-children-2"));
		children.selectByValue("1");
		Thread.sleep(2000);
		
		WebElement ageEle = driver.findElementByXPath("//select[@class='df-select js-select-child-age']");
		Select ages = new Select(ageEle);
		ages.selectByValue("4");
		Thread.sleep(2000);

	}

	@Given("Click Confirm button and click Search")
	public void click_Confirm_button_and_click_Search() throws InterruptedException {
		driver.findElementByXPath("//button[@type='button']/span[text()='Confirm']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//span[text()='Search']").click();
		Thread.sleep(2000);
	}

	@Given("Select Accommodation type as Hotels only and choose 4 stars")
	public void select_Accommodation_type_as_Hotels_only_and_choose_stars() throws InterruptedException {
		WebElement hotelEle = driver.findElementByXPath("//button[@title='All types']");
		builder = new Actions(driver);
		builder.moveToElement(hotelEle).perform();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//label[text()='Hotels only']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//button[@title='4-star hotels']").click();
		Thread.sleep(2000);
	}

	@Given("Select Guest rating as Very Good")
	public void select_Guest_rating_as_Very_Good() throws InterruptedException {
		WebElement allEle = driver.findElementByXPath("//button[@title='All']");
		builder.moveToElement(allEle).perform();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//span[text()='Very good']").click();
		Thread.sleep(2000);
		
	}

	@Given("Set Hotel Location as Agra Fort and click Done")
	public void set_Hotel_Location_as_Agra_Fort_and_click_Done() throws InterruptedException {
		WebElement locEle = driver.findElementByXPath("//button[@title='City centre']");
		builder.moveToElement(locEle).perform();
		Thread.sleep(2000);
		
		Select place = new Select(driver.findElementByXPath("//select[@id='pois']"));
		place.selectByVisibleText("Agra Fort");
		Thread.sleep(2000);
		
		driver.findElementByXPath("//button[text()='Done']").click();
		Thread.sleep(2000);
	}

	@Given("In more Filters, select Air conditioning, Restaurant and WiFi and click Done")
	public void in_more_Filters_select_Air_conditioning_Restaurant_and_WiFi_and_click_Done() throws InterruptedException {
		WebElement moreEle = driver.findElementByXPath("//button[@title='Select']");
		builder.moveToElement(moreEle).perform();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//label[text()='Air conditioning']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//label[text()='WiFi']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//button[text()='Show more']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//label[text()='Restaurant']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//button[text()='Done']").click();
		Thread.sleep(2000);
		
	}

	@Given("Sort the result as Rating & Recommended")
	public void sort_the_result_as_Rating_Recommended() throws InterruptedException {
		Select sort = new Select(driver.findElementByXPath("//select[@id='mf-select-sortby']"));
		sort.selectByValue("7");
		Thread.sleep(2000);
	}

	@Given("Print the Hotel name, Rating, Number of Reviews and Click View Deal")
	public void print_the_Hotel_name_Rating_Number_of_Reviews_and_Click_View_Deal() throws InterruptedException {
		String hotelName = driver.findElementByXPath("(//span[@class='item-link name__copytext'])[1]").getText();
		Thread.sleep(2000);
		System.out.println(hotelName);
		
		String rating = driver.findElementByXPath("(//span[@itemprop='ratingValue'])[1]").getText();
		Thread.sleep(2000);
		System.out.println(rating);
		
		String reviews = driver.findElementByXPath("//span[@class='details-paragraph details-paragraph--rating']").getText();
		Thread.sleep(2000);
		System.out.println(reviews);
		
		driver.findElementByXPath("(//span[text()='View Deal'])[1]").click();
		Thread.sleep(2000);
	}

	@Given("Print the URL of the Page")
	public void print_the_URL_of_the_Page() throws InterruptedException {
		List<String> l1 = new ArrayList<String>();		
		Set<String> winHan = driver.getWindowHandles();		
		l1.addAll(winHan);
		driver.switchTo().window(l1.get(1));
		
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(2000);
	
	}

	@Given("Print the Price of the Room and click Choose Your Room")
	public void print_the_Price_of_the_Room_and_click_Choose_Your_Room() throws InterruptedException {
		String price = driver.findElementByXPath("(//div[@class='prco-ltr-right-align-helper'])[2]/div").getText();
		Thread.sleep(2000);
		System.out.println(price);
		
		driver.findElementByXPath("(//a[@class='txp-cta bui-button bui-button--primary sr_cta_button'])[1]").click();
		Thread.sleep(2000);
		
	}

	@When("Click Reserve and I'll Reserve")
	public void click_Reserve_and_I_ll_Reserve() throws InterruptedException {
		driver.findElementByXPath("(//span[contains(text(),'Reserve')])[1]").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//button[@type='submit']/span[@class='bui-button__text'])[3]").click();
		Thread.sleep(2000);
	}

	@Then("Close the browser")
	public void close_the_browser() {
		driver.quit();
	}


}
