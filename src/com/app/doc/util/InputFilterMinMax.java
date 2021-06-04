package com.app.doc.util;

// Class for input limitation for EditText input value.

import android.text.InputFilter;
import android.text.Spanned;

public class InputFilterMinMax implements InputFilter {

	private int min, max;

	public InputFilterMinMax(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public InputFilterMinMax(String min, String max) {
		this.min = Integer.parseInt(min);
		this.max = Integer.parseInt(max);
	}

	// Filter text
	@Override
	public CharSequence filter(CharSequence source, int start, int end,
			Spanned dest, int dstart, int dend) {
		try {
			int input = Integer.parseInt(dest.toString() + source.toString());
			if (isInRange(min, max, input))
				return null;
		} catch (NumberFormatException nfe) {
		}
		return "";
	}

	// Set range
	private boolean isInRange(int a, int b, int c) {
		return b > a ? c >= a && c <= b : c >= b && c <= a;
	}
}
