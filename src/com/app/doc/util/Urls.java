package com.app.doc.util;

import android.os.Environment;

public class Urls {

	//
	public static final String city = "http://www.arstica.com/drapp_webservices/index.php?op=getCity";
	public static final String speciality = "http://www.arstica.com/drapp_webservices/index.php?op=getSpeciality";
	
	public static final String speciality1="http://www.arstica.com/drapp_webservices/index.php?op=getSpeciality1&set2=";
	
	public static final String doc_information = "http://www.arstica.com/drapp_webservices/index.php?op=getDoctorInformation";
	public static final String questions = "http://www.arstica.com/drapp_webservices/index.php?op=getQuestions";
	public static final String answers = "http://www.arstica.com/drapp_webservices/index.php?op=getAnswers";
	
	public static final String FOLDERNAME = Environment
			.getExternalStorageDirectory().toString() + "/LifeWireHRM";

}
