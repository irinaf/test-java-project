package com.example.fw;



import java.util.Properties;
import java.util.concurrent.TimeUnit;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {


	public  WebDriver driver;
	public  String baseUrl;
	
	
	private NavigationHelper navigatonHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private Properties properties;
	
	
	public ApplicationManager(Properties properties) {
		
		this.properties = properties;
		String brouser=properties.getProperty("brouser");
		if ("chrome".equals(brouser)){
			driver= new ChromeDriver();
		}
		else if("firefox".equals(brouser)){
			driver= new FirefoxDriver();
		}
		else throw new Error("Unsupported brouser " +brouser);
		//driver = new FirefoxDriver();
	    //baseUrl = "http://localhost";
	   baseUrl=properties.getProperty("baseUrl");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    //driver.get(baseUrl + "/addressbookv4.1.4/");
	   driver.get(baseUrl);
	   // navigatonHelper=new NavigationHelper(this);
	   // groupHelper=new GroupHelper(this);
	   // contactHelper=new ContactHelper(this);
	    
	}
	
	
	public void stop() {
		
		driver.quit();
	  
		
	}

	
	public NavigationHelper navigateTo(){
		
		if (navigatonHelper==null)
		{
			navigatonHelper=new NavigationHelper(this);
		}
		return navigatonHelper;
		
	}
	

	public GroupHelper getGroupHelper(){
		
		if (groupHelper==null)
		{
			groupHelper=new GroupHelper(this);
		}
		return groupHelper;
		
	}

	

	public ContactHelper getContactHelper(){
		
		if (contactHelper==null)
		{
			contactHelper=new ContactHelper(this);
		}
		return contactHelper;
		
	}
}
