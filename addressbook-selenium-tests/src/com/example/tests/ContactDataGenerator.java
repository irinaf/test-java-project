package com.example.tests;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;





import org.testng.annotations.DataProvider;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {


	private static String[] split;






	public static void main(String[] args) throws IOException {
		if (args.length <3){
		System.out.println("Please, specify  parameters:<amount of testdata> <file> <format>");
       return;
	}

	int amount=Integer.parseInt(args[0]);
	File file=new File (args[1]);
	String format = args[2];
	if(file.exists()) 	System.out.println("File exists, please, delete file "+file);
	
	List<ContactData> contacts =generateRandomContacts(amount);
		if(format.equals("csv")) saveContactsToCsvFile(contacts,file);
		else if (format.equals("xml"))saveContactsToXmlFile(contacts,file);
	else
		System.out.println("Uknown format"+format);
}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
	 XStream xstream=new XStream();
	 xstream.alias("contact", ContactData.class);
	 String xml = xstream.toXML(contacts);
	 FileWriter writer= new FileWriter(file);
	 writer.write(xml);
	 writer.close();
	}
	

	public static List<ContactData> loadContactsFromXmlFile( File file) {
		XStream xstream=new XStream();
		 xstream.alias("contact", ContactData.class);
		 return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		
		FileWriter writer= new FileWriter(file);
		for (ContactData contact: contacts){
			writer.write(contact.getF_name()+","+ contact.getL_name()+","+contact.getAddr()+ ","+contact.getPhone()+","+ contact.getE_mail()+","+contact.getB_day()+
					","+contact.getB_month()+","+contact.getB_year()+",!"+"\n");
		}
			
		writer.close();
		
		
	}

	
	
public static List<ContactData> loadContactFromCsvFile(File file) throws IOException {
	List<ContactData>list= new ArrayList<ContactData>();
	FileReader reader = new FileReader(file);
	BufferedReader bufferedReader= new BufferedReader(reader);
	String line= bufferedReader.readLine();
	while(line !=null) {
		String [] part = line.split(",");
		ContactData contacts =new ContactData()
		.withFirstName(part[0])	
		.withLastName(part[1])
		.withAddr(part[3])
		.withEmail(part[4])
		.withPhone(part[5])
		.withBirthDay(Integer.parseInt(part[6]))
		.withBirthMonth(part[7])
		.withBirthYear(Integer.parseInt(part[8]));
			
		list.add(contacts);
				
		line=bufferedReader.readLine();
	}
		
	bufferedReader.close();
		return list;
	}

	
	
	
	
	

	public  static List<ContactData> generateRandomContacts(int amount){
		List<ContactData>list= new ArrayList<ContactData>();
	 		
		for( int i =0;i<amount;i++){
			ContactData contacts = new ContactData()
			.withFirstName(generateRandomString())	
			.withLastName(generateRandomString())
			.withAddr(generateRandomString())
			.withEmail(generateRandomString())
			.withPhone(generateRandomString())
			.withBirthDay(generateRandomDate().get(Calendar.DAY_OF_MONTH))
			.withBirthMonth(generateRandomDate().getDisplayName(Calendar.MONTH, Calendar.LONG,new Locale("eng", "US")))
			.withBirthYear(generateRandomDate().get(Calendar.YEAR));
						
			list.add(contacts);
		}
			
		return list;
	}


	
	
	
	public static Calendar generateRandomDate(){

		GregorianCalendar gc = new GregorianCalendar();
		   int year = randBetween(2000, 2015);
		   gc.set(Calendar.YEAR, year);
		   int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
		   gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
		    return gc;
		 }

		public static int randBetween(int start, int end) {
		return start + (int)Math.round(Math.random() * (end - start));
		}
	
	



public static String generateRandomString(){
	
	Random rnd =new Random();
	if(rnd.nextInt(3)==0){
		return"";
	}
	
	else return "test"+ rnd.nextInt();
	
 }

}




