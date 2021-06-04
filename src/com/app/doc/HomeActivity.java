package com.app.doc;

// Home screen layout view

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.app.doc.database.DataBaseHelper;
import com.app.doc.fragments.EncoderFragment;
import com.app.doc.fragments.InfoFragment;
import com.app.doc.fragments.MenuFragment;
import com.app.doc.util.Information;
import com.app.doc.util.Share;
import com.app.doc.util.Utill;
import com.slidingmenu.lib.SlidingMenu;

public class HomeActivity extends SlidingFragmentActivity {
	private Fragment hFrag = null; // Main fragment content
	private SlidingMenu sm = null; // Sliding menu view
	private int width = 0;
	private MenuFragment mFrag = null; // Menu fragment content
	private int i = -1; // Check for screen start with QR screen view or menu
						// view
	private boolean isDel = false; // Check for profile deleting or not
	@SuppressLint("SimpleDateFormat")
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); // For
																		// data
																		// formatting

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			// Do Stuff
			toggle(); // Switching menu
			return true;
		}

		// Saving when press back key
		else if (keyCode == KeyEvent.KEYCODE_BACK) {
			// Do Stuff

			super.onStop();

			// Saving profile to database
			if (!isDel) {
				try {
					Utill.getInstance().allInfo.saved = sdf.format(new Date());
					Information i = Utill.getInstance().allInfo;
					DataBaseHelper.getInstance(getApplicationContext())
							.openDataBase();
					DataBaseHelper.getInstance(getApplicationContext())
							.InsertIntoDB(i.id, i.getContentValues());
					DataBaseHelper.getInstance(getApplicationContext()).close();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			finish();
			return true;
		} else
			return super.onKeyDown(keyCode, event);

	}

	// Check for whether the device is tablet or phone
	@SuppressLint("InlinedApi")
	private boolean isTabletDevice() {
		// Verifies if the Generalized Size of the device is XLARGE to be
		// considered a Tablet
		boolean xlarge = ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE);

		// If XLarge, checks if the Generalized Density is at least MDPI
		// (160dpi)
		if (xlarge) {
			DisplayMetrics metrics = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(metrics);

			// MDPI=160, DEFAULT=160, DENSITY_HIGH=240, DENSITY_MEDIUM=160,
			// DENSITY_TV=213, DENSITY_XHIGH=320
			if (metrics.densityDpi == DisplayMetrics.DENSITY_DEFAULT
					|| metrics.densityDpi == DisplayMetrics.DENSITY_HIGH
					|| metrics.densityDpi == DisplayMetrics.DENSITY_MEDIUM
					|| metrics.densityDpi == DisplayMetrics.DENSITY_TV
					|| metrics.densityDpi == DisplayMetrics.DENSITY_XHIGH) {

				// Yes, this is a tablet!
				return true;
			}
		}
		// No, this is not a tablet!
		return false;
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);

		// /// Calculating screen width and height for redrawing sliding menu
		// panel.

		Display display = ((WindowManager) getBaseContext().getSystemService(
				Context.WINDOW_SERVICE)).getDefaultDisplay();
		try {
			Class<?> cls = Display.class;
			Class<?>[] parameterTypes = { Point.class };
			Point parameter = new Point();
			Method method = cls.getMethod("getSize", parameterTypes);
			method.invoke(display, parameter);
			width = parameter.x;
		} catch (Exception e) {
			width = display.getWidth();
		}
		if (isTabletDevice()) {
			if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
				sm.setBehindWidth((int) (width * 0.3));
			} else
				sm.setBehindWidth((int) (width * 0.5));
		} else {
			if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
				sm.setBehindWidth((int) (width * 0.5));
			} else
				sm.setBehindWidth((int) (width * 0.7));
		}
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_bar_del:
			new AlertDialog.Builder(this)
					.setMessage(R.string.delete_msg)
					.setPositiveButton(R.string.yes_txt,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {

									// Delete profile

									try {

										isDel = true;

										Log.e("",
												"Log ID : "
														+ Utill.getInstance().allInfo.id);

										DataBaseHelper.getInstance(
												getApplicationContext())
												.openDataBase();
										DataBaseHelper
												.getInstance(
														getApplicationContext())
												.delAll(Utill.getInstance().allInfo.id
														+ "");
										DataBaseHelper.getInstance(
												getApplicationContext())
												.close();

										finish();

									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								}
							})
					.setNegativeButton(R.string.no_txt,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
								}
							}).create().show();
			return true;
		case android.R.id.home:
			toggle();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);

		setContentView(R.layout.responsive_content_frame);

		try {
			i = getIntent().getExtras().getInt("id");
		} catch (Exception e) {
			i = -1;
		}

		// Setting the Sliding menu
		if (findViewById(R.id.menu_frame) == null) {
			setBehindContentView(R.layout.menu_frame);
			getSlidingMenu().setTouchModeAbove(SlidingMenu.SLIDING_CONTENT);
			// show home as up so we can toggle
			getActionBar().setDisplayHomeAsUpEnabled(true);
		} else {
			// add a dummy view
			View v = new View(this);
			setBehindContentView(v);
			getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		}
		getActionBar().setIcon(
				new ColorDrawable(getResources().getColor(
						android.R.color.transparent)));

		getActionBar().setBackgroundDrawable(
				new ColorDrawable(Color.parseColor("#009688")));

		mFrag = new MenuFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, mFrag).commit();
		sm = getSlidingMenu();
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindScrollScale(0.25f);
		sm.setFadeDegree(0.25f);
		Display display = ((WindowManager) getBaseContext().getSystemService(
				Context.WINDOW_SERVICE)).getDefaultDisplay();
		try {
			Class<?> cls = Display.class;
			Class<?>[] parameterTypes = { Point.class };
			Point parameter = new Point();
			Method method = cls.getMethod("getSize", parameterTypes);
			method.invoke(display, parameter);
			width = parameter.x;
		} catch (Exception e) {
			width = display.getWidth();
		}
		if (isTabletDevice()) {
			if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
				sm.setBehindWidth((int) (width * 0.3));
			} else
				sm.setBehindWidth((int) (width * 0.5));
		} else {
			if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
				sm.setBehindWidth((int) (width * 0.5));
			} else
				sm.setBehindWidth((int) (width * 0.7));
		}
		this.setSlidingActionBarEnabled(false);

		onload();

	}

	private void onload() {

		// set the fragment content view
		if (i == 1) {
			hFrag = new EncoderFragment();
			switchContent(hFrag);
		} else {
			hFrag = new InfoFragment();
			switchContent(hFrag);
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					toggle();
				}
			}, 100);
		}
	}

	public void switchContent(final Fragment fragment) {

		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, fragment).commit();
		getSlidingMenu().showContent();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 2 && resultCode == RESULT_OK) {

			onload();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();

		Log.e("", "Hello on resume");

		if (Share.flgSurveryFinished) {
			Share.flgSurveryFinished = false;
			onload();
		}
	}
}
