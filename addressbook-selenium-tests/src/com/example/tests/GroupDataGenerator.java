package com.example.tests;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class GroupDataGenerator {

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
	
	List<GroupData> groups =generateRandomGroups(amount);
		if(format.equals("csv")) saveGroupsToCsvFile(groups,file);
		else if (format.equals("xml"))saveGroupsToXmlFile(groups,file);
	else
		System.out.println("Uknown format"+format);
}

	private static void saveGroupsToXmlFile(List<GroupData> groups, File file) throws IOException {
	 XStream xstream=new XStream();
	 xstream.alias("group", GroupData.class);
	 String xml = xstream.toXML(groups);
	 FileWriter writer= new FileWriter(file);
	 writer.write(xml);
	 writer.close();
	}
	

	public static List<GroupData> loadGroupsFromXmlFile( File file) {
		XStream xstream=new XStream();
		 xstream.alias("group", GroupData.class);
		 return (List<GroupData>) xstream.fromXML(file);
	}

	private static void saveGroupsToCsvFile(List<GroupData> groups, File file) throws IOException {
		
		FileWriter writer= new FileWriter(file);
		for (GroupData group: groups){
			writer.write(group.getName()+","+ group.getFooter()+","+group.getHeader()+ ",!"+"\n");
		}
			
		writer.close();
		
		
	}

	
	
public static List<GroupData> loadGroupsFromCsvFile(File file) throws IOException {
	List<GroupData>list= new ArrayList<GroupData>();
	FileReader reader = new FileReader(file);
	BufferedReader bufferedReader= new BufferedReader(reader);
	String line= bufferedReader.readLine();
	while(line !=null) {
		String [] part = line.split(",");
		GroupData group =new GroupData()
		.withName(part[0])
		.withHeader(part[1])
		.withFooter(part[2]);
		list.add(group);
				
		line=bufferedReader.readLine();
	}
		
	bufferedReader.close();
		return list;
	}

	
	public static List<GroupData> generateRandomGroups(int amount) {
		List<GroupData>list= new ArrayList<GroupData>();
 		
		for( int i =0;i<amount;i++){
			GroupData group = new GroupData()
			.withName(generateRandomString())	
			.withHeader(generateRandomString())
			.withFooter(generateRandomString());
			
			list.add(group);
		}
			
		return list;
	}
	
	
	



public static String generateRandomString(){
	
	Random rnd =new Random();
	if(rnd.nextInt(3)==0){
		return"";
	}
	
	else return "test"+ rnd.nextInt();
	
 }

}