package jenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import genUtility.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookTest  {
	@Test
	public void facebook() {
		WebDriverManager.chromedriver().setup();
//		ChromeOptions co=new ChromeOptions();
//		co.addArguments("--remote-allow-origin=*");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		System.out.println("hello");
		
		
	}

}
