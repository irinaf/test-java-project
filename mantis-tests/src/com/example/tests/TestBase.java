package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;




public class TestBase {

	protected ApplicationManager app;
	

	@BeforeTest
		public void setUp() throws Exception {
	    /*Properties properties = new Properties();
	    properties.load(new FileReader (new File( "application.properties")) );
		app=new ApplicationManager(properties); */
		
		String configFile=System.getProperty("configFile","application.properties");
		Properties properties = new Properties();
		 properties.load(new FileReader (new File(configFile))); 
		 app=new ApplicationManager(properties);
		 
	  }

	
	 
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	    
	  }  

	

	
}
