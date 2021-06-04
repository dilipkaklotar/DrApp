package com.app.doc.util;

import android.util.Log;

public class Logcat {

	public static void e(String tag, String message) {

		Log.e(tag, message);

	}

	public static void d(String tag, String message) {

		Log.d(tag, message);

	}
}
