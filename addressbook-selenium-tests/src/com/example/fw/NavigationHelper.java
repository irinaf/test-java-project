package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void mainPage() {
		if(!onMainPage())
		click(By.linkText("home"));
	}

	private boolean onMainPage() {
	return	driver.findElements(By.id("maintable")).size()>0;
		
	}

	public void groupsPage() {
		if(!onGroupsPage()) 				
		click(By.linkText("groups"));
	}

	private boolean onGroupsPage() {
			
		return (driver.getCurrentUrl().contains("/group.php") &&
				driver.findElements(By.name("new")).size()>0);
	}


	public void contactPage() {
		if(!onContactPage()) 				
		click(By.linkText("add new"));
	}

	private boolean onContactPage() {
			return (driver.getCurrentUrl().contains("/edit.php") &&
				driver.findElements(By.name("submit")).size()>0);
	}


	
}
