package com.app.doc;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.app.doc.database.DataBaseHelper;
import com.app.doc.util.AlertMessage;
import com.app.doc.util.Share;
import com.app.doc.util.TYPEFACE;
import com.app.doc.util.Urls;
import com.app.doc.util.Utils;
import com.app.doc.webservice.Parsing;

@SuppressLint("SimpleDateFormat")
public class MainActivity extends Activity {

	private Configuration config = new Configuration(); // For localization

	Parsing parsing;

	AlertMessage alert;

	static SharedPreferences munch_pref;

	DataBaseHelper myDbHelper;

	Button eng_btn, esp_btn;

	String specialityDate = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		alert = new AlertMessage(MainActivity.this);

		parsing = new Parsing(this);

		munch_pref = PreferenceManager.getDefaultSharedPreferences(this);

		myDbHelper = DataBaseHelper.getInstance(getApplicationContext());

		eng_btn = (Button) findViewById(R.id.eng_btn);
		eng_btn.setTypeface(TYPEFACE.RobotoMedium(this));
		eng_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setLanguage("en");
				startActivity(new Intent(getApplicationContext(),
						PreHomeActivity.class));
			}
		});

		esp_btn = (Button) findViewById(R.id.esp_btn);
		esp_btn.setTypeface(TYPEFACE.RobotoMedium(this));
		esp_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setLanguage("es");
				startActivity(new Intent(getApplicationContext(),
						PreHomeActivity.class));
			}
		});

		new getCopyDatabase().execute("");

	}

	// set language
	private void setLanguage(String str) {

		Share.lang = str;
		Locale locale = new Locale(str);
		Locale.setDefault(locale);
		config.locale = locale;
		getBaseContext().getResources().updateConfiguration(config,
				getBaseContext().getResources().getDisplayMetrics());
	}

	private class getCopyDatabase extends AsyncTask<String, Void, Boolean> {

		ProgressDialog pd;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pd = new ProgressDialog(MainActivity.this,
					AlertDialog.THEME_HOLO_LIGHT);
			pd.setMessage(getResources().getString(R.string.loading_txt));
			pd.setCancelable(false);
			pd.show();

			try {

				myDbHelper.createDataBase(); // Copy database from asset folder

				myDbHelper.openDataBase();
				myDbHelper.close();

			} catch (IOException ioe) {

				throw new Error("Unable to create database");

			}

		}

		@Override
		protected Boolean doInBackground(String... params) {

			Boolean success = false;

			return success;
		}

		@Override
		protected void onPostExecute(Boolean success) {
			super.onPostExecute(success);

			pd.dismiss();

			if (Utils.isOnline(MainActivity.this)) {

				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date date = new Date();
				String today = dateFormat.format(date);

				Log.e("", "val 1 : " + munch_pref.getString("current_date", ""));
				Log.e("", "val 2 : " + today);

//				if (munch_pref.getString("current_date", "").equalsIgnoreCase(
//						"")
//						|| !munch_pref.getString("current_date", "")
//								.equalsIgnoreCase(today)) {

					SharedPreferences.Editor prefEditor = munch_pref.edit();
					prefEditor.putString("current_date", today);
					prefEditor.commit();

					new getCity().execute();

//				}

			} else {

				alert.showNetworkAlert();
			}

		}
	}

	private class getCity extends AsyncTask<String, Void, Boolean> {

		ProgressDialog pd;

		String city_response = "";

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pd = new ProgressDialog(MainActivity.this,
					AlertDialog.THEME_HOLO_LIGHT);
			pd.setMessage(getResources().getString(R.string.loading_txt));
			pd.setCancelable(false);
			pd.show();
		}

		@Override
		protected Boolean doInBackground(String... params) {

			Boolean success = false;

			String URL = Urls.city;

			Log.e("", "City URL : " + URL);

			city_response = parsing.getResponse(URL);

			Log.e("", "city_response : " + city_response);

			return success;
		}

		@Override
		protected void onPostExecute(Boolean success) {
			super.onPostExecute(success);

			try {

				if (!city_response.equalsIgnoreCase("")) {

					JSONObject jCity = new JSONObject(city_response);

					JSONArray jArray = new JSONArray(jCity.getString("city"));

					if (jArray.length() > 0) {

						for (int i = 0; i < jArray.length(); i++) {

							JSONObject jObject = (JSONObject) jArray.get(i);

							String city_id = jObject.getString("city_id");
							String city = jObject.getString("city");
							myDbHelper.openDataBase();
							DataBaseHelper.getInstance(MainActivity.this)
									.InsertIntoCityDB(city_id, city);
							myDbHelper.close();

						}

					}

				}
			} catch (Exception e) {
				e.printStackTrace();

			}
			
			pd.dismiss();

			new getSpeciality().execute("");
		}
	}

	private class getSpeciality extends AsyncTask<String, Void, Boolean> {

		ProgressDialog pdS;

		String speciality_response = "";

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pdS = new ProgressDialog(MainActivity.this,
					AlertDialog.THEME_HOLO_LIGHT);
			pdS.setMessage(getResources().getString(R.string.loading_txt));
			pdS.setCancelable(false);
			pdS.show();
		}

		@Override
		protected Boolean doInBackground(String... params) {

			Boolean success = false;

			myDbHelper.openDataBase();
			specialityDate = DataBaseHelper.getInstance(MainActivity.this)
					.getSpecialityDate();
			myDbHelper.close();

			String URL = Urls.speciality1 + specialityDate.trim();

			Log.e("", "Speciality URL : " + URL.replace(" ", "%20"));

			speciality_response = parsing.getResponse(URL.replace(" ", "%20"));

			Log.e("", "speciality_response : " + speciality_response);

			return success;
		}

		@Override
		protected void onPostExecute(Boolean success) {
			super.onPostExecute(success);

			try {

				if (!speciality_response.equalsIgnoreCase("")) {

					JSONObject jCity = new JSONObject(speciality_response);

					specialityDate = jCity.getString("SynchDateTime");

					myDbHelper.openDataBase();
					DataBaseHelper.getInstance(MainActivity.this)
							.updateSpecialityDateDB(specialityDate);
					myDbHelper.close();

					if (jCity.has("INSERT")) {

						JSONArray jArray = new JSONArray(
								jCity.getString("INSERT"));

						if (jArray.length() > 0) {

							for (int i = 0; i < jArray.length(); i++) {

								JSONObject jObject = (JSONObject) jArray.get(i);

								String specialty_id = jObject
										.getString("specialty_id");
								String specialty = jObject
										.getString("specialty");

								myDbHelper.openDataBase();
								DataBaseHelper.getInstance(MainActivity.this)
										.InsertIntoSpecialityDB(specialty_id,
												specialty);
								myDbHelper.close();

							}

						}

					} else if (jCity.has("UPDATE")) {

						JSONArray jArray = new JSONArray(
								jCity.getString("UPDATE"));

						if (jArray.length() > 0) {

							for (int i = 0; i < jArray.length(); i++) {

								JSONObject jObject = (JSONObject) jArray.get(i);

								String specialty_id = jObject
										.getString("specialty_id");
								String specialty = jObject
										.getString("specialty");

								myDbHelper.openDataBase();
								DataBaseHelper.getInstance(MainActivity.this)
										.updateIntoSpecialityDB(specialty_id,
												specialty);
								myDbHelper.close();

							}

						}
					} else if (jCity.has("DELETE")) {
						JSONArray jArray = new JSONArray(
								jCity.getString("DELETE"));

						if (jArray.length() > 0) {

							for (int i = 0; i < jArray.length(); i++) {

								JSONObject jObject = (JSONObject) jArray.get(i);

								String specialty_id = jObject
										.getString("specialty_id");

								myDbHelper.openDataBase();
								DataBaseHelper.getInstance(MainActivity.this)
										.deleteIntoSpecialityDB(specialty_id);
								myDbHelper.close();

							}

						}
					}
				}

			} catch (Exception e) {
				e.printStackTrace();

			}
			
			pdS.dismiss();
		}
	}
}
