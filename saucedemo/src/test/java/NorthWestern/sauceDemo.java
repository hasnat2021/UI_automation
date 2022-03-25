 package NorthWestern;

 import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

 @Test 
 public class sauceDemo {
	 public void demoSession () {
     
		 WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://www.saucedemo.com/");
	    driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	    driver.findElement(By.xpath("//input[@id='login-button']")).click();
	 
	     WebElement sel = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
	    Select dropdowns = new Select(sel);
		dropdowns.selectByVisibleText("Price (low to high)");
		
		driver.findElement(By.cssSelector("[class='btn btn_primary btn_small btn_inventory']")).click();
		driver.findElement(By.cssSelector("[id='add-to-cart-sauce-labs-bike-light']")).click();
	    driver.findElement(By.className("shopping_cart_link")).click();
	    
	    driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
		WebElement SauceLabsOnesie = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
		if (SauceLabsOnesie.isDisplayed()){
		System.out.println("Sauce Labs Onesie is added");
		}
		else { System.out.println("Sauce Labs Onesie is not added");
		
		}	
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/a/div"));
		WebElement SauceLabsBikeLight = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/a/div"));
		if (SauceLabsBikeLight.isDisplayed()){
		System.out.println("Sauce Labs Bike Light");
		}
		else { System.out.println("Sauce Labs Bike Light is not added");
		}
		driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
		
		driver.findElement(By.id("continue-shopping")).click();
		
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		
		driver.findElement(By.className("shopping_cart_link")).click();
		
		driver.findElement(By.id("checkout")).click();
		
		driver.findElement(By.id("first-name")).sendKeys("Abu");
		
		driver.findElement(By.id("last-name")).sendKeys("Hasnat");
		
		driver.findElement(By.id("postal-code")).sendKeys("11423");
		
		driver.findElement(By.id("continue")).click();
		
		
		String item_1 = driver.findElement(By.xpath("//div[@class='cart_item'][1]/div/a")).getText();
		String item_2 = driver.findElement(By.xpath("//div[@class='cart_item'][2]/div/a")).getText();
	
		
		if (item_1.equalsIgnoreCase("Sauce Labs Onesie")){
			if(item_2.equalsIgnoreCase("Sauce Labs Backpack")) {
				 
					System.out.println("Purchased the right items-Asserted");
				
			}
		}
		
		String summaryTotal = driver.findElement(By.xpath("//div[@class=\"summary_total_label\"]")).getText();
		System.out.println(summaryTotal);
		if(summaryTotal.endsWith("41.02")) {
			System.out.println("total price assurted");
		}
		driver.findElement(By.id("finish")).click();
	 }		
}
