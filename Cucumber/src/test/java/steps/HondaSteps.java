package steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HondaSteps {

	ChromeDriver driver;
	Actions builder;
	WebDriverWait wait;
	Map<String, String> activaMap;
	Map<String, String> dioMap;

	@Given("Go to https://www.honda2wheelersindia.com/")
	public void go_to_https_www_honda_wheelersindia_com() {
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		driver = new ChromeDriver();
		driver.get("https://www.honda2wheelersindia.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//button[@class='close']").click();

	}

	@Given("Click on scooters and click dio")
	public void click_on_scooters_and_click_dio() {

		wait = new WebDriverWait(driver, 10);

		WebElement scooters = wait.until(ExpectedConditions.elementToBeClickable(By.id("link_Scooter")));
		scooters.click();

		WebElement dio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='menu_Scooter']/div[1]/div/div[1]/div[1]/div/a")));
		dio.click();

	}

	@Given("Click on Specifications and mouseover on Engine")
	public void click_on_Specifications_and_mouseover_on_Engine() {

		WebElement Specifications = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Specifications")));
		Specifications.click();

		WebElement Engine = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@name='2']")));

		builder = new Actions(driver);
		builder.moveToElement(Engine).perform();

	}

	@Given("Put all the details as key and value into Map")
	public void put_all_the_details_as_key_and_value_into_Map() {

		dioMap = new HashMap<String, String>();

		List<WebElement> dioEngineSpecs = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='body-dimensions specifications-active part-1 axx']//ul[@class='tab_content']/li")));

		for(int i=1;i<dioEngineSpecs.size();i++) {

			String dioKey = driver.findElementByXPath("(//div[@class='engine part-2 axx']//ul[@class='tab_content']/li)["+(i+1)+"]/span[1]").getText();
			String dioValue = driver.findElementByXPath("(//div[@class='engine part-2 axx']//ul[@class='tab_content']/li)["+(i+1)+"]/span[2]").getText();

			dioMap.put(dioKey, dioValue);
		}

		//System.out.println(dioMap);

	}

	@Given("Go to Scooters and click Activa 125")
	public void go_to_Scooters_and_click_Activa() {

		WebElement scooters = wait.until(ExpectedConditions.elementToBeClickable(By.id("link_Scooter")));
		scooters.click();

		WebElement activa = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='menu_Scooter']/div[1]/div/div[1]/div[3]/div/a")));
		activa.click();
		
		WebElement Specifications = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Specifications")));
		Specifications.click();

		WebElement Engine = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@name='4']")));

		builder = new Actions(driver);
		builder.moveToElement(Engine).perform();

	}

	@Given("Put All its Engine Specification into another Map same as like dio")
	public void put_All_its_Engine_Specification_into_another_Map_same_as_like_dio() {

		activaMap = new HashMap<String, String>();

		List<WebElement> activaEngineSpecs = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='body-dimensions specifications-active part-1 axx']//ul[@class='tab_content']/li")));

		for(int i=1;i<activaEngineSpecs.size();i++) {

			String dioKey = driver.findElementByXPath("(//div[@class='engine part-4 axx']//ul[@class='tab_content']/li)["+(i+1)+"]/span[1]").getText();
			String dioValue = driver.findElementByXPath("(//div[@class='engine part-4 axx']//ul[@class='tab_content']/li)["+(i+1)+"]/span[2]").getText();

			activaMap.put(dioKey, dioValue);
		}

		//System.out.println(activaMap);

	}

	@Given("Compare Dio and Activa Maps and print the different values of the samekeys.")
	public void compare_Dio_and_Activa_Maps_and_print_the_different_values_of_the_samekeys() {
		
		Iterator<Entry<String, String>> it1 = dioMap.entrySet().iterator();
		Iterator<Entry<String, String>> it2 = activaMap.entrySet().iterator();
		
		while(it1.hasNext() && it2.hasNext()) {
			Entry<String, String> e1 = it1.next();
			Entry<String, String> e2 = it2.next();
			
			if(!e1.getValue().equals(e2.getValue())) {
				System.out.println("Different Values are: "+e1.getKey() +" " +e1.getValue() + " " + e2.getValue());
			}
			
		}

	}

	@Given("Click FAQ from Menu and Click dio under Browse By Product")
	public void click_FAQ_from_Menu_and_Click_dio_under_Browse_By_Product() {
		
		WebElement faq = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("FAQ")));
		faq.click();
		
		WebElement dioBS6 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Dio BS-VI")));
		dioBS6.click();
	}

	@Given("Click  Vehicle Price and Select scooter, Dio BS-VI from the dropdown and click submit")
	public void click_Vehicle_Price_and_Select_scooter_Dio_BS_VI_from_the_dropdown_and_click_submit() {
		
		WebElement vehiclePrice = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='li6']/a")));
		vehiclePrice.click();
		
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit6")));
		submit.click();

	}

	@Given("click the price link,  Go to the new Window and select the state, city")
	public void click_the_price_link_Go_to_the_new_Window_and_select_the_state_city() {
		
		WebElement priceLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Click here to know the price of Dio BS-VI.")));
		priceLink.click();
		
		Set<String> winHan = driver.getWindowHandles();
		List<String> l1 = new ArrayList<String>();
		l1.addAll(winHan);
		
		driver.switchTo().window(l1.get(1));
		
		WebElement stateEle = wait.until(ExpectedConditions.elementToBeClickable(By.id("StateID")));
		Select state = new Select(stateEle);
		state.selectByVisibleText("Tamil Nadu");
		
		WebElement cityEle = wait.until(ExpectedConditions.elementToBeClickable(By.id("CityID")));
		Select city = new Select(cityEle);
		city.selectByVisibleText("Chennai");
		
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Search']")));
		search.click();
		
	}

	@Given("Print the price and model")
	public void print_the_price_and_model() {
		
		WebElement eleTable = driver.findElementByXPath("//table[@id='gvshow']");
		
		List<WebElement> allRows = eleTable.findElements(By.tagName("tr"));
		
		for(int i=0;i<allRows.size();i++) {
			List<WebElement> allCols = allRows.get(i).findElements(By.tagName("td"));
			
			for(int j=0;j<allCols.size();j++) {				
				System.out.println(allCols.get(j).getText());				
			}
			
		}
		

	}

	@Given("Click Product Enquiry and Fill all the * field except Mobile, check the terms and conditions box and click submit")
	public void click_Product_Enquiry_and_Fill_all_the_field_except_Mobile_check_the_terms_and_conditions_box_and_click_submit() {
		
		WebElement enquiry = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Enquiry")));
		enquiry.click();
		
		WebElement titleEle = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("TitleID")));
		Select title = new Select(titleEle);
		title.selectByVisibleText("Mr.");
		
		WebElement name = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Name")));
		name.sendKeys("Calvin");
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Email")));
		email.sendKeys("calvin.festus@gmail.com");
		
		WebElement stateEle = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("StateID")));
		Select state = new Select(stateEle);
		state.selectByVisibleText("Tamil Nadu");
		
		WebElement cityEle = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("CityID")));
		Select city = new Select(cityEle);
		city.selectByVisibleText("Chennai");
		
		WebElement dealerEle = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DealerID")));
		Select dealer = new Select(dealerEle);
		dealer.selectByVisibleText(" Global Honda");
		
		WebElement termsNconditions = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("TermsAndConditions")));
		termsNconditions.click();
		
		WebElement submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Submit']")));
		submit.click();
		
	}

	@When("Verify the error message under the mobile number field.")
	public void verify_the_error_message_under_the_mobile_number_field() {
		
		WebElement errorMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='text-danger field-validation-error']/span")));
		System.out.println(errorMsg.getText());
	}

	@Then("Close the Browsers")
	public void close_the_Browsers() {
		
		driver.quit();

	}


}
