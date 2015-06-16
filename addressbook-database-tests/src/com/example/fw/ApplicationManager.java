package com.example.fw;



import java.util.Properties;
import java.util.concurrent.TimeUnit;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {


	private  WebDriver driver;
	public  String baseUrl;
	
	
	private NavigationHelper navigatonHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private Properties properties;
	private HibernateHelper hibernateHelper;
	private ApplicationModel model;
	
	
	public ApplicationManager(Properties properties) {
		
		this.properties = properties;
		model= new ApplicationModel();
		model.setGroups(getHibernateHelper().listGroups());
	    
	}
	
	
	public void stop() {
		
		driver.quit();
	  
		
	}

	public ApplicationModel getModel(){
		return model;
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

	
	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper==null)
		{
			hibernateHelper=new HibernateHelper(this);
		}
		return hibernateHelper;
		
		
	}
	

	public WebDriver getDriver() {
		String brouser=properties.getProperty("brouser");
		if (driver==null)
		{
		if ("chrome".equals(brouser)){
			driver= new ChromeDriver();
		}
		else if("firefox".equals(brouser)){
			driver= new FirefoxDriver();
		}
		else throw new Error("Unsupported brouser " +brouser);
		
	   baseUrl=properties.getProperty("baseUrl");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		   driver.get(baseUrl);
	  	
   }
     return driver;
  }


	public String getProperty(String key){
		return properties.getProperty(key);
	}
}