package com.example.fw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountHelper extends WebDriverHelperBase {

	public AccountHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void signup(User user)  {
		manager.openUrl("/");
		
		//click(By.cssSelector("span.bracket-link"));
		
		driver.findElement(By.linkText("Signup for a new account")).click();
		
				
		type(By.name("username"),user.login);
		type(By.name("email"),user.email);
	    click(By.cssSelector("input.button"));
			    
	   if( driver.findElements(By.cssSelector("table.width50 tbody tr td p")).size()>0){ 
	  	   throw new RuntimeException("That username is already being used"); 
	   }
	    
	  	    
	    pause(25000);
	    //Msg msg= manager.getMailHelper().getNewMail(user.login,user.password);
	    String msg= manager.getMailHelper().getNewMail(user.login,user.password);
	   // String confirmationLink = msg.getConfirmationLink(msg);
	    System.out.println("Letter "+ msg);
	    String confirmationLink =getConfirmationLink(msg);
	    manager.openAbsoluteUrl(confirmationLink);
	    
	    type(By.name("password"),user.password);
	    type(By.name("password_confirm"),user.password);
	    click(By.cssSelector("input.button"));
	}


	private String getConfirmationLink(String text) {
		Pattern regex = Pattern.compile("http\\S*");
		Matcher matcher = regex.matcher(text);
		if (matcher.find()) {
			return matcher.group();
		} else {
			return "";
		}
	}
		
	public String loggedUser(User user) {
	WebElement element =driver.findElement(By.cssSelector("td.login-info-left span" ));
		return element.getText();
	}

	public void login(User user) {
		manager.openUrl("/");
		type(By.name("username"),user.login);
		type(By.name("password"),user.password);
		click(By.cssSelector("input.button"));
		
		
	}

}
