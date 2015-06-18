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
	
	
	
	private Properties properties;
	private HibernateHelper hibernateHelper;
	public AccountHelper accountHelper;
	private MailHelper mailHelper;
	private JamesHelper jamesHelper;
	
	
	
	public ApplicationManager(Properties properties) {
		
		this.properties = properties;
		
	    
	}
	
	
	public void stop() {
		
		driver.quit();
	  
		
	}

	
	

	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper==null)
		{
			hibernateHelper=new HibernateHelper(this);
		}
		return hibernateHelper;
		
		
	}
	
	public AccountHelper getAccountHelper() {
		if (accountHelper==null)
		{
			accountHelper=new AccountHelper(this);
		}
		return accountHelper;
		
		
	}
	
	

	public MailHelper getMailHelper() {
		if (mailHelper==null)
		{
			mailHelper=new MailHelper(this);
		}
		return mailHelper;
	}
	

	public JamesHelper getJamesHelper() {
		if (jamesHelper==null)
		{
			jamesHelper=new JamesHelper(this);
		}
		return jamesHelper;
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

	public void openUrl(String string){
		driver.get(baseUrl+ string);
	}
	

	public void openAbsoluteUrl(String string){
		driver.get(string);
	}
	
	
	
	public String getProperty(String key){
		return properties.getProperty(key);
	}




}