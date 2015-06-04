package com.example.tests;



import org.testng.annotations.Test;

import com.example.fw.Folder;

import  static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class TestFolderCreation extends TestBase {

	@Test
	public void testFolderCreation()  {
		String folder="newfolder";
	Folder oldFolders=app.getFolderHelper().getFolders();
	app.getFolderHelper().createFolder(folder);
	
	Folder newFolders=app.getFolderHelper().getFolders();
		assertThat(newFolders,equalTo(oldFolders.withAdded(folder)));
	
		
	}
	
	@Test
	public void testVariousFolderCreation() {
		String folder1="newfolder1";
		String folder2 ="newfolder2";
	    Folder oldFolders=app.getFolderHelper().getFolders();
		assertThat(app.getFolderHelper().createFolder(folder1),is(nullValue()));
		//Thread.sleep(5000);
	    Folder newFolders=app.getFolderHelper().getFolders();
		assertThat(newFolders,equalTo(oldFolders.withAdded(folder1)));
		assertThat(app.getFolderHelper().createFolder(folder2),is(nullValue()));
		Folder newFolders2 =app.getFolderHelper().getFolders();
		assertThat(newFolders2,equalTo(newFolders.withAdded(folder2)));

	}
	

	@Test
	public void testFoldersWithSameNameCreation() {
		String folder="newfolder3";
	    Folder oldFolders=app.getFolderHelper().getFolders();
	    assertThat(app.getFolderHelper().createFolder(folder),is(nullValue()));
		//Thread.sleep(5000);
	    Folder newFolders=app.getFolderHelper().getFolders();
		assertThat(newFolders,equalTo(oldFolders.withAdded(folder)));
		 assertThat(app.getFolderHelper().createFolder(folder),containsString("Duplicated folder name"));
		Folder newFolders2 =app.getFolderHelper().getFolders();
		assertThat(newFolders2,equalTo(newFolders));
		
	}
	
}
