package com.app.doc.webservice;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Parsing {

	Context c;

	URL url;

	HttpRequest httpRequest = new HttpRequest();

	String jsonResponse = null;

	public static String TAG = "Parsing";

	SharedPreferences munch_pref;

	public Parsing(Context c) {
		this.c = c;
		munch_pref = PreferenceManager.getDefaultSharedPreferences(c);

	}

	public String getResponse(String url) {

		HttpPost httppost = new HttpPost(url);
		HttpResponse httpResponse = null;

		String data = "";

		HttpClient httpclient = new DefaultHttpClient();

		try {

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(4);

			nameValuePairs.add(new BasicNameValuePair("uid", munch_pref
					.getString("user_id", "")));

			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			// Execute HTTP Post Request
			httpResponse = httpclient.execute(httppost);

			jsonResponse = EntityUtils.toString(httpResponse.getEntity(),
					"UTF-8");

			data = jsonResponse;

		} catch (Exception e) {
			e.printStackTrace();
			return data;
		}
		return data;
	}
 

	 

}
