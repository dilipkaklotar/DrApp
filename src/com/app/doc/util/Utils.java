package com.app.doc.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.widget.Toast;

@SuppressLint("SimpleDateFormat")
public class Utils {

	public static File cacheDir;

	public static Boolean isOnline(Context context) {
		boolean connected = false;
		final ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		final NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			connected = true;
		} else if (netInfo != null && netInfo.isConnected()
				&& cm.getActiveNetworkInfo().isAvailable()) {
			connected = true;
		} else if (netInfo != null && netInfo.isConnected()) {
			try {
				URL url = new URL("http://www.google.com");
				HttpURLConnection urlc = (HttpURLConnection) url
						.openConnection();
				urlc.setConnectTimeout(3000);
				urlc.connect();
				if (urlc.getResponseCode() == 200) {
					connected = true;
				}
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (cm != null) {
			final NetworkInfo[] netInfoAll = cm.getAllNetworkInfo();
			for (NetworkInfo ni : netInfoAll) {
				System.out.println("get network type :::" + ni.getTypeName());
				if ((ni.getTypeName().equalsIgnoreCase("WIFI") || ni
						.getTypeName().equalsIgnoreCase("MOBILE"))
						&& ni.isConnected() && ni.isAvailable()) {
					connected = true;
					if (connected) {
						break;
					}
				}
			}
		}
		return connected;
	}

	public static String getDeviceID(TelephonyManager phonyManager) {

		String id = phonyManager.getDeviceId();
		if (id == null) {
			id = "not available";
		}

		int phoneType = phonyManager.getPhoneType();
		switch (phoneType) {
		case TelephonyManager.PHONE_TYPE_NONE:
			return id;

		case TelephonyManager.PHONE_TYPE_GSM:
			return id;

		case TelephonyManager.PHONE_TYPE_CDMA:
			return id;

			/*
			 * for API Level 11 or above case TelephonyManager.PHONE_TYPE_SIP:
			 * return "SIP";
			 */

		default:
			return id;
		}

	}

	public static String downloadImageAsync(String url, String title,
			Context ctx) {

		String response = "";
		File storeImageInSFolder = new File(Urls.FOLDERNAME + File.separator
				+ title);

		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED))
			cacheDir = new File(Urls.FOLDERNAME);
		else
			cacheDir = ctx.getCacheDir();

		if (!cacheDir.exists())
			cacheDir.mkdirs();

		// Log.e("", "yes there : " + storeImageInSFolder.exists());

		if (!storeImageInSFolder.exists()) {
			response = Utils.downloadFile(url, title, Urls.FOLDERNAME);
		} else {
			response = "exist";
		}
		return response;
	}

	public static String downloadFile(final String url, final String name,
			final String foldername) {
		File file;
		FileOutputStream os = null;
		Bitmap myBitmap;
		try {

			URL url1 = new URL(url.replaceAll(" ", "%20"));
			HttpURLConnection urlConnection = (HttpURLConnection) url1
					.openConnection();
			urlConnection.setDoOutput(false);
			urlConnection.setRequestMethod("GET");
			urlConnection.connect();
			file = new File(cacheDir, name);
			InputStream inputStream = urlConnection.getInputStream();
			byte[] buffer = new byte[1024];
			int bufferLength = 0;
			os = new FileOutputStream(file);
			while ((bufferLength = inputStream.read(buffer)) > 0) {
				os.write(buffer, 0, bufferLength);
			}

			os.flush();
			os.close();

			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = true;
			myBitmap = BitmapFactory
					.decodeFile(file.getAbsolutePath(), options);
			if (options.outWidth > 3000 || options.outHeight > 2000) {
				options.inSampleSize = 4;
			} else if (options.outWidth > 2000 || options.outHeight > 1500) {
				options.inSampleSize = 3;
			} else if (options.outWidth > 1000 || options.outHeight > 1000) {
				options.inSampleSize = 2;
			}
			options.inJustDecodeBounds = false;
			myBitmap = BitmapFactory
					.decodeFile(file.getAbsolutePath(), options);

			os = new FileOutputStream(file);
			myBitmap.compress(CompressFormat.JPEG, 90, os);
			os.flush();
			os.close();
			myBitmap.recycle();
			System.gc();
			return "complete";
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "error";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	public static void displayMessage(String msg, Context mContext) {
		try {
			Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
		} catch (Exception e) {
		}
	}

	public static String dateChange(final String current_date) {

		String dt = "";

		try {

			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			Date newdate = df.parse(current_date);

			dt = new SimpleDateFormat("dd/MM/yyyy").format(newdate);

		} catch (Exception e) {
			dt = "";
			e.printStackTrace();
		}
		return dt;
	}

	public final static Pattern EMAIL_ADDRESS_PATTERN = Pattern
			.compile("[a-zA-Z0-9+._%-+]{1,256}" + "@"
					+ "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" + "(" + "."
					+ "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" + ")+");

	public static boolean isEmailValid(String email) {
		return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
	}

	public static String getMonthName(int a) {

		if (a == 1)
			return "January";
		else if (a == 2)
			return "February";
		else if (a == 3)
			return "March";
		else if (a == 4)
			return "April";
		else if (a == 5)
			return "May";
		else if (a == 6)
			return "Jun";
		else if (a == 7)
			return "July";
		else if (a == 8)
			return "August";
		else if (a == 9)
			return "September";
		else if (a == 10)
			return "October";
		else if (a == 11)
			return "November";
		else if (a == 12)
			return "December";
		else
			return "";

	}

}
