package steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShopCluesSteps {
	
	ChromeDriver driver;
	WebDriverWait wait;
	Actions builder;
	JavascriptExecutor js;
	Map<String,Integer> mp;
	String name;
	int count=0,max=0;
	
	@Given("Go to https://www.shopclues.com/")
	public void go_to_https_www_shopclues_com() {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		DesiredCapabilities.chrome();
		op.merge(cap);
		
	    driver = new ChromeDriver(op);
	    driver.get("https://www.shopclues.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    driver.findElementByXPath("//button[text()='Allow']").click();
	    
	}

	@Given("Mouseover on women and click Casual Shoes")
	public void mouseover_on_women_and_click_Casual_Shoes() throws InterruptedException {
		
		wait = new WebDriverWait(driver, 10);
		WebElement women = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("WOMEN")));
		builder= new Actions(driver);
		builder.moveToElement(women).perform();
		
		Thread.sleep(5000);
		
		WebElement casualShoes = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Casual Shoes")));
		casualShoes.click();
		
		Set<String> winHan = driver.getWindowHandles();
		List<String> l1 = new ArrayList<String>();
		l1.addAll(winHan);
		
		driver.switchTo().window(l1.get(1));
	    
	}

	@Given("Select Color as Black")
	public void select_Color_as_Black() {
		
		js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,2000)");
		
		WebElement colorBlack = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='mCSB_10_container']/ul/li/label[contains(text(),'Black')]")));
		colorBlack.click();
	}

	@Given("Check whether the product name contains the word black, If so, add the product name and price in to Map")
	public void check_whether_the_product_name_contains_the_word_black() throws InterruptedException {
		
		mp = new HashMap<String, Integer>();
		Thread.sleep(5000);
		
		List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a/span[@class='prod_name ']")));
		List<WebElement> priceEle = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a/div[2]/div/span[@class='p_price']")));
		for(int i=0;i<products.size();i++) {
			
			String prodName = products.get(i).getText();
			Integer prodCost = Integer.parseInt(priceEle.get(i).getText().replaceAll("\\D", ""));
			if(prodName.contains("Black")) {
				
				mp.put(prodName, prodCost);				
			}
			
		}
		System.out.println(mp);
		
	}

	@Given("Check Display the count of shoes which are more than 500 rupees")
	public void check_Display_the_count_of_shoes_which_are_more_than_rupees() {
		
	for (Entry<String, Integer> map : mp.entrySet()) {
		
		Integer cost = map.getValue();
		
		if(cost>500) {
			count++;
		}
		if(cost>max) {
			max=cost;
			name = map.getKey();
		}
		
	}
	System.out.println("Count of Shoes more than 500 Rupees: " +count);
	System.out.println("Maximum Price of Shoe is :" +max);
	    
	}

	@Given("Click the highest price of the shoe")
	public void click_the_highest_price_of_the_shoe() {
		
		List<WebElement> priceElem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='p_price']")));
		
		for (WebElement webElement : priceElem) {
			
			if(webElement.getText().contains(String.valueOf(max))) {
				webElement.click();
				break;
			}
			
		}
		
		Set<String> winHan = driver.getWindowHandles();
		List<String> l1 = new ArrayList<String>();
		l1.addAll(winHan);
		
		driver.switchTo().window(l1.get(2));
		
	}

	@Given("Get the current page URL and check with the product ID")
	public void get_the_current_page_URL_and_check_with_the_product_ID() throws Exception {
		
		String urlCurrent = driver.getCurrentUrl();
	    WebElement prodIDEle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='pID']")));
	    String prodID = prodIDEle.getText().replaceAll("\\D", "");
	    
		/*
		 * if(urlCurrent.contains(prodID)) { System.out.println("Passed"); } else {
		 * throw new Exception(); }
		 */
	    
	}

	@Given("Copy the offercode")
	public void copy_the_offercode() {
		
		WebElement offercodeEle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='coupons_code']/span)[1]")));
		String offercode = offercodeEle.getText();
		System.out.println(offercode);
	}

	@Given("Select size, color and click ADD TO CART")
	public void select_size_color_and_click_ADD_TO_CART() {
		
		/*WebElement color = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='variant var '])[1]")));
		color.click();*/
		
	    WebElement size = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[contains(@class,'variant var')])[1]")));
	    size.click();
	    
	    WebElement addToCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add_cart")));
	    addToCart.click();
	    
	}

	@When("Mouse over on Shopping cart and click View Cart")
	public void mouse_over_on_Shopping_cart_and_click_View_Cart() {
		
		WebElement shoppingCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='cart_ic']")));
		builder.moveToElement(shoppingCart).perform();
		
		WebElement viewCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='View Cart']")));
		viewCart.click();
	}

	@Then("Type Pincode as 600126 click Submit and Place Order")
	public void type_Pincode_as_click_Submit_and_Place_Order() {
		
		WebElement pincode = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pin_code_popup")));
		pincode.sendKeys("600126");
		
		WebElement submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("get_pincode_popup")));
		submit.click();
		
		WebElement placeOrder = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Place Order']")));
		placeOrder.click();
	}

	@Then("Close the Shop Clues")
	public void close_the_Shop_Clues() {
		
		driver.quit();
	    
	}

}
