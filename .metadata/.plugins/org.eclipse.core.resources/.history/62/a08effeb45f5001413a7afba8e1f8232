package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;


public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void gotoContactPage() {
		click(By.linkText("add new"));
	}

	public void fillContactForm( ContactData contacts) {
	   type(By.name("firstname"), contacts.f_name);	    
	   type(By.name("lastname"), contacts.l_name);  
	   type(By.name("address"), contacts.addr);
	   type(By.name("home"), contacts.phone);
	   type(By.name("email"), contacts.e_mail);	    
	   selectByText(By.name("bday"), contacts.b_day);
	   selectByText(By.name("bmonth"), contacts.b_month);
	   type(By.name("byear"), contacts.b_year);
	
	    
	}

	
	public void submitContact() {
		click(By.name("submit"));
	}

	public void gotoHomePage() {
		click(By.linkText("home"));
	}

	

	
public void deleteContact(int index) {
		
	    selectContactByIndex(index);
		click(By.xpath("//input[@value='Delete']"));
		
	}

	private void selectContactByIndex(int index) {
		
		index++;
		click(By.xpath("//tr["+index+"]/td[7]/a/img"));
		
		
	}

	public void initContactModification(int index) {
		
		selectContactByIndex(index);
		
		
	}

	public void submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		
	}
	
	

}
