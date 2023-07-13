package genUtility;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public static WebDriver sdriver;
	public WebDriver driver=null;

	@BeforeSuite
	public void connectionToDatabase() {
		System.out.println("DATABASE CONNECTED");
	

}   
	
	@BeforeClass(groups= {"SmokeSuite","RegionalRegressionSuite"})
	@Parameters("BROWSER")
	public void launchBrowser(/*String BROWSER*/) throws IOException{
		String  URL =pUtil.readDataFromPropertyFile("url");
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		//WebDriverManager.chromedriver().setup();
		//String BROWSER=System.getProperty("browser");
		//String URL=System.getProperty("url");
		//Step 3: Launch the Browser - RUNTIME POLYMORPHISM
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} 
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else 
		{

			System.out.println("invalid browser name");
		}
		driver.manage().window().maximize();
		driver.get(URL);	
		sdriver=driver;
	}
	
		
	@BeforeMethod(groups={"SmokeSuite","RegionalRegressionSuite"})
	public void loginToApplication() throws Throwable{
		//WebDriverUtility wUtil=new WebDriverUtility();
			String USERNAME = pUtil.readDataFromPropertyFile("username");
			String PASSWORD=pUtil.readDataFromPropertyFile("password");
			//EstronLoginPage lp=new EstronLoginPage(driver);
			//lp.loginTOApp(USERNAME, PASSWORD);
			//wUtil.swithToAlertWindowAndAccept(driver );
			System.out.println("Login Successfull");
		} 
		
		
		
		
	
	@AfterMethod(groups={"SmokeSuite","RegionalRegressionSuite"})
	public void logoutFromApplication() {
		//WebDriverUtility wUtil=new WebDriverUtility();
		//EstronDashboardPage dp=new EstronDashboardPage(driver);
		//dp.logOutFromApp();
		//wUtil.swithToAlertWindowAndAccept(driver );
		
	}
	@AfterClass(groups= {"SmokeSuite","RegionalRegressionSuite"})
	public void closeBrowser() {
		 driver.quit();
		
	}
	
	@AfterSuite
	public void disconnectFromDatabase() {
		System.out.println("DATABASE CLOSED");
		
	}
}
