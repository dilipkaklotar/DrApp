package com.app.doc.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.app.doc.R;

public class RobotoTextView extends TextView {

	public RobotoTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs);
	}

	public RobotoTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);

	}

	public RobotoTextView(Context context) {
		super(context);
		init(null, null);

	}

	private void init(Context context, AttributeSet attrs) {

		if (attrs != null) {
			TypedArray a = getContext().obtainStyledAttributes(attrs,
					R.styleable.MyTextView);

			setTypeface(TYPEFACE.RobotoRegular(context));

			a.recycle();
		}
	}

}
