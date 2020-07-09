package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CRMSteps {
	ChromeDriver driver;
	WebDriverWait wait;
	Actions builder;
	
	@Given("Go to https://demo.1crmcloud.com/")
	public void go_to_https_demo_crmcloud_com() {
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		op.merge(cap);
		driver = new ChromeDriver(op);
		driver.get("https://demo.1crmcloud.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
	}

	@Given("Give username as admin and password as admin")
	public void give_username_as_admin_and_password_as_admin() {
	    driver.findElementById("login_user").sendKeys("admin");
	    driver.findElementById("login_pass").sendKeys("admin");
	}

	@Given("Choose theme as Claro Theme and Click Login")
	public void choose_theme_as_Claro_Theme() {
	    Select theme = new Select(driver.findElementById("login_theme"));
	    theme.selectByValue("Claro");
	    
	    driver.findElementByClassName("btn-label").click();
	    
	}

	@Given("Go to Sales and Marketing and click Sales Home")
	public void go_to_Sales_and_Marketing_and_click_Sales_Home() {
		WebElement salesAndMarketing = driver.findElementById("grouptab-1");
		builder = new Actions(driver);
		builder.moveToElement(salesAndMarketing).perform();
		
		WebElement salesHome = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Sales Home']")));
		salesHome.click();
	}

	@Given("Click Create contact")
	public void click_Create_contact() {
		
		WebElement createContact = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='page-shortcuts']/div/div[1]/div[2]")));
		createContact.click();
		
	}

	@Given("Select Title and type First name, Last Name, Email and Phone Numbers")
	public void select_Title_and_type_First_name_Last_Name_Email_and_Phone_Numbers() {
		
		WebElement title = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DetailFormsalutation-input")));
		title.click();
		
		WebElement salutation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Mr.']")));
		salutation.click();
		
		WebElement firstName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DetailFormfirst_name-input")));
		firstName.sendKeys("Calvin");
		
		WebElement lastName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DetailFormlast_name-input")));
		lastName.sendKeys("Festus");
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DetailFormemail1-input")));
		email.sendKeys("calvinfestus@yahoo.com");
		
		WebElement phoneNum = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DetailFormphone_work-input")));
		phoneNum.sendKeys("9177347542");
	}

	@Given("Select Lead Source as Public Relations and Business Roles")
	public void select_Lead_Source_as_Public_Relations_and_Business_Roles() {
		
		WebElement leadSource = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DetailFormlead_source-input")));
		leadSource.click();
		
		WebElement pubRel = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Public Relations']")));
		pubRel.click();
		
		WebElement busRole = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DetailFormbusiness_role-input-label")));
		busRole.click();
		
		WebElement sales = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Sales']")));
		sales.click();
	}

	@Given("Fill the Primary Address, City, State, Country and Postal Code and click Save")
	public void fill_the_Primary_Address_City_State_Country_and_Postal_Code_and_click_Save() {
		
		WebElement primAdd = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DetailFormprimary_address_street-input")));
		primAdd.sendKeys("No.6 Vivekanandar Street");
		
		WebElement city = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DetailFormprimary_address_city-input")));
		city.sendKeys("AbuDhabi");
		
		WebElement state = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DetailFormprimary_address_state-input")));
		state.sendKeys("Dubai");
		/*
		 * WebElement stateSelect =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
		 * "//div[contains(text(),'Dubayy')]"))); stateSelect.click();
		 */
		
		WebElement country = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DetailFormprimary_address_country-input")));
		country.sendKeys("United Arab Emirates");
		
		WebElement postalCode = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DetailFormprimary_address_postalcode-input")));
		postalCode.sendKeys("00000");
		
		WebElement save = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DetailForm_save2-label")));
		save.click();
	}

	@Given("Click create and Leads")
	public void click_create_and_Leads() {
		
		WebElement create = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@name='SubPanel_create'])[2]/span[text()='Create']")));
		create.click();
			
	}

	@Given("Fill First & Last name, Status as In Process, Title as Manager and Department as Sales")
	public void fill_First_Last_name_Status_as_In_Process_Title_as_Manager_and_Department_as_Sales() {
	    
		WebElement fName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("QuickCreateForm_0first_name-input")));
		fName.sendKeys("Anu");
		
		WebElement lName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("QuickCreateForm_0last_name-input")));
		lName.sendKeys("Paramesh");
		
		WebElement title = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("QuickCreateForm_0title-input")));
		title.sendKeys("Manager");
		
		WebElement dept = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("QuickCreateForm_0department-input")));
		dept.sendKeys("Sales");
	}

	@Given("Select Lead as Public Relations and fill department, Email and Phone Number")
	public void select_Lead_as_Public_Relations_and_fill_department_Email_and_Phone_Number() {
		
		WebElement leadSource = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("QuickCreateForm_0lead_source-input")));
		leadSource.click();
		
		WebElement leadSourceVal = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='menu-option single']/div[text()='Public Relations']")));
		leadSourceVal.click();
		
		WebElement phone = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("QuickCreateForm_0phone_work-input")));
		phone.sendKeys("1234567890");
		
		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("QuickCreateForm_0email1-input")));
		email.sendKeys("anu.parmesh@hotmail.com");
	}

	@Given("Click Save and View")
	public void click_Save_and_View() {
		
		WebElement saveAndView = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("QuickCreateForm_0_save_view-label")));
		saveAndView.click();
	}

	@Given("Mouse over on Today's Activities and click Meetings")
	public void mouse_over_on_Today_s_Activities_and_click_Meetings() {
		
		WebElement todaysActivity = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='menu-label'])[1]")));
	    builder.moveToElement(todaysActivity).perform();
	    
	    WebElement meetings = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Meetings']")));
	    meetings.click();
	}

	@Given("Type Subject as Project Status Status as Planned and Time as tomorrow {int} pm")
	public void type_Subject_as_Project_Status_Status_as_Planned_and_Time_as_tomorrow_pm(Integer int1) throws InterruptedException {
		
		Thread.sleep(5000);
		WebElement create = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='SubPanel_create']/span")));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(create)));
		Thread.sleep(5000);
		// create.click();
		
		WebElement subject = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DetailFormname-input")));
		subject.sendKeys("Project Status");
		
		WebElement timeBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='input-label datetime-label text-number']")));
		timeBtn.click();
		
		WebElement date = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='grid-cell number-cell text-right day inside current selected responsive']/following::div[1]")));
		date.click();
		
		WebElement timeInp = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='DetailFormdate_start-calendar-text']/input")));
		timeInp.clear();
		timeInp.sendKeys("15:00");
		
		WebElement tickBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='active-icon uii-accept uii-lg uii']")));
		tickBtn.click();
	}

	@Given("Click Add paricipants, add your created Lead name and click Save")
	public void click_Add_paricipants_add_your_created_Lead_name_and_click_Save() {
		
		WebElement addParticipants = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='addInvitee']")));
	    addParticipants.click();
	    
	    WebElement enterPartName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='app-search-text']/input")));
	    enterPartName.sendKeys("Calvin Festus");
	    
	    WebElement nameSugg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='app-search-list']//div[contains(text(),'Calvin Festus')]")));
	    nameSugg.click();
	    
	    WebElement save = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DetailForm_save2")));
	    save.click();
	}

	@When("Click contacts under Sales and Marketting, search the lead Name and click the name from the result")
	public void click_contacts_under_Sales_and_Marketting_search_the_lead_Name_and_click_the_name_from_the_result() {
		
		WebElement salesAndMarketing = driver.findElementById("grouptab-1");
		builder = new Actions(driver);
		builder.moveToElement(salesAndMarketing).perform();
		
		WebElement contacts = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Contacts']")));
		contacts.click();
	    
	}

	@Then("Check weather the Meeting is assigned to the contact.")
	public void check_weather_the_Meeting_is_assigned_to_the_contact() {
		
		WebElement name = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Calvin')]")));
		name.click();
		
		WebElement activities = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Project Status']")));
		String actName = activities.getText();
		System.out.println("Meeting Planned is :" +actName);
	    
	}

	@Then("Close the Browser")
	public void close_the_Browser() {
	    driver.close();
	}



}
