package com.app.doc.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
 

public class DKScrollView extends ScrollView {

	private ScrollViewListener scrollViewListener = null;

	public DKScrollView(Context context) {
		super(context);
	}

	public DKScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public DKScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void setScrollViewListener(ScrollViewListener scrollViewListener) {
		this.scrollViewListener = scrollViewListener;
	}

	@Override
	protected void onScrollChanged(int x, int y, int oldx, int oldy) {
		super.onScrollChanged(x, y, oldx, oldy);
		if (scrollViewListener != null) {
			scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
		}
	}
}