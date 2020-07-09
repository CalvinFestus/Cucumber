package steps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class JustDialSteps {
	
	ChromeDriver driver;
	int priceInt,totalPriceInt,diff;
	
	@Given("https://www.justdial.com/")
	public void https_www_justdial_com() {
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		op.merge(cap);
		driver = new ChromeDriver(op);
		driver.get("https://www.justdial.com/");
		driver.manage().window().maximize();
	}

	@Given("Cick on Air Tickets")
	public void cick_on_Air_Tickets() {
	    driver.findElementById("hotkeys_text_4").click();
	}

	@Given("Type Chennai and choose Chennai, IN - Chennai Airport \\(MAA) as Leaving From")
	public void type_Chennai_and_choose_Chennai_IN_Chennai_Airport_MAA_as_Leaving_From() throws InterruptedException {
	    driver.findElementById("departure").sendKeys("Chennai");
	    Thread.sleep(3000);
	    driver.findElementByXPath("//li[contains(text(),'Chennai Airport')]").click();
	    Thread.sleep(2000);
	}

	@Given("Type Toronto and select Toronto, CA - Toronto City Centre Airport \\(YTZ) as Going To")
	public void type_Toronto_and_select_Toronto_CA_Toronto_City_Centre_Airport_YTZ_as_Going_To() throws InterruptedException {
	    driver.findElementById("arrival").sendKeys("Toronto");
	    Thread.sleep(2000);
	    driver.findElementByXPath("//li[contains(text(),'Toronto, CA - Toronto City Centre Airport')]").click();
	    Thread.sleep(2000);
	}

	@Given("Set Departure as 2020, July 22")
	public void set_Departure_as_July() throws InterruptedException {
		driver.findElementByXPath("//span[text()='Next']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[text()='22']").click();
		Thread.sleep(2000);
	}

	@Given("Add Adult 2, Children 1 click and Search")
	public void add_Adult_Children_click_and_Search() throws InterruptedException {
	    driver.findElementByXPath("//input[@id='_dAdultsCountSelectorVal']/following-sibling::span").click();
	    Thread.sleep(2000);
	    driver.findElementByXPath("//input[@id='_dChildrenCountSelectorVal']/following-sibling::span").click();
	    Thread.sleep(2000);
	    driver.findElementByXPath("//input[@value='SEARCH']").click();
	    Thread.sleep(2000);
	}

	@Given("Select Air Canada from multi-airline itineraries")
	public void select_Air_Canada_from_multi_airline_itineraries() throws InterruptedException {
	    driver.findElementByXPath("//input[@name='operating_airline']/following-sibling::label[text()='Air Canada(AC)']").click();
	    Thread.sleep(2000);
	}

	@Given("Click on Price to sort the result")
	public void click_on_Price_to_sort_the_result() throws InterruptedException {
		//driver.findElementById("priceSort").click();
		Thread.sleep(2000);
	}

	@Given("Click on Details of first result under Price")
	public void click_on_Details_of_first_result_under_Price() throws InterruptedException {
	    driver.findElementByXPath("//a[@id='resTD1']").click();
	    Thread.sleep(2000);
	}

	@When("Capture the Flight Arrival times.")
	public void capture_the_Flight_Arrival_times() {
		List<WebElement> timings = driver.findElementsByXPath("//span[@class='dettime']");
		for (WebElement ele : timings) {
			String textTimings = ele.getText();
			System.out.println(textTimings);
		}
	}

	@When("Capture the total price in a list and Click on Book")
	public void capture_the_total_price_in_a_list_and_Click_on_Book() throws InterruptedException {
	   String price = driver.findElementByXPath("//ul[@class='detUL']/li[4]/div/span").getText();
	   Thread.sleep(2000);
	   priceInt = Integer.parseInt(price);
	   System.out.println(priceInt);
	   driver.findElementByXPath("(//a[text()='BOOK'])[1]").click();
	   Thread.sleep(2000);
	}

	@When("Capture the Airport name base on the list of time")
	public void capture_the_Airport_name_base_on_the_list_of_time() {
		//table[@id='innerDiv']/tbody/tr/td[4]
		Map<String, String> mp = new HashMap<String, String>();
		for(int i=1;i<12;i=i+4) {
			String placeDep = driver.findElementByXPath("//table[@id='innerDiv']/tbody/tr["+i+"]/td[3]/span").getText();
			String timeDep = driver.findElementByXPath("//table[@id='innerDiv']/tbody/tr["+i+"]/td[4]/span").getText();
			mp.put(placeDep, timeDep);
			
			String placeArr = driver.findElementByXPath("//table[@id='innerDiv']/tbody/tr["+i+"]/td[7]/span").getText();
			String timeArr = driver.findElementByXPath("//table[@id='innerDiv']/tbody/tr["+i+"]/td[6]/span").getText();
			mp.put(placeArr, timeArr);
		}
	}

	@When("Capture the total fare and print the difference amount from previous total price")
	public void capture_the_total_fare_and_print_the_difference_amount_from_previous_total_price() {
		String totalPriceText = driver.findElementByXPath("//span[@id='totalFare']/b").getText();
		totalPriceInt = Integer.parseInt(totalPriceText);
		System.out.println(totalPriceInt);
		
		diff = Math.abs(totalPriceInt-priceInt);
		System.out.println(diff);
		
		driver.close();
		
	}


}
