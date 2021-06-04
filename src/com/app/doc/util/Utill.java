package com.app.doc.util;


//This class maintaining the information object to save into database.

public class Utill {
	private static Utill utill;
	public Information allInfo=new Information();
	
	// Creating Utill instance
	public static Utill getInstance() {
		if(utill==null)
			utill=new Utill();
		return utill;
	}
	
	// Set information
	public void setInfo(Information i) {
		allInfo=i;
	}
	
	
	// Reset utill object
	public void restUtill() {
		utill=null;
	}
	
	
	
}
