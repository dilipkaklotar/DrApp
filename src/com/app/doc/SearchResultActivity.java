package com.app.doc;

import java.net.URLDecoder;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.doc.util.AlertMessage;
import com.app.doc.util.DKScrollView;
import com.app.doc.util.ScrollViewListener;
import com.app.doc.util.Share;
import com.app.doc.util.TYPEFACE;
import com.app.doc.util.Urls;
import com.app.doc.util.Utils;
import com.app.doc.webservice.Parsing;

public class SearchResultActivity extends Activity {

	String response = "";

	Parsing parsing;

	LayoutInflater linf;
	LinearLayout lnrDoctorList;

	Context context = null;

	String sc_speciality = "", sc_city = "";

	AlertMessage alert;

	private DKScrollView scrollview;
	private boolean flagTimer = false;
	Timer timer;

	int start = 0, count = 10;

	boolean flgRun = true;

	// ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_searchresult);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		getActionBar().setIcon(
				new ColorDrawable(getResources().getColor(
						android.R.color.transparent)));

		getActionBar().setBackgroundDrawable(
				new ColorDrawable(Color.parseColor("#009688")));

		alert = new AlertMessage(this);
		parsing = new Parsing(this);

		linf = (LayoutInflater) getApplicationContext().getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
		linf = LayoutInflater.from(this);

		// progressBar = (ProgressBar) findViewById(R.id.progressBar);

		lnrDoctorList = (LinearLayout) findViewById(R.id.lnrDoctorList);
		lnrDoctorList.removeAllViews();

		scrollview = (DKScrollView) findViewById(R.id.scrollview);
		scrollview.setScrollViewListener(new ScrollViewListener() {

			@Override
			public void onScrollChanged(DKScrollView scrollView, int x, int y,
					int oldx, int oldy) {

				int diff = (lnrDoctorList.getBottom() - (scrollView.getHeight() + scrollView
						.getScrollY()));

				Log.e("", "diff : " + diff);

				if (diff == 0) {

					if (!flagTimer) {

						flagTimer = true;

						try {

							if (timer != null) {

								timer.cancel();

							}

							timer = new Timer();

							timer.schedule(new TimerTask() {
								public void run() {

									handler1.sendEmptyMessage(0);
								}

							}, 2000, 2000);

						} catch (Exception e) {

						}

						start = start + 10;

						if (flgRun)
							setView();

					}

				}
			}
		});

		setView();

	}

	@SuppressLint("HandlerLeak")
	private Handler handler1 = new Handler() {
		public void handleMessage(Message msg) {

			if (msg.what == 0) {

				if (timer != null) {

					timer.cancel();

				}

				flagTimer = false;
			}
		}

	};

	private void setView() {

		if (Utils.isOnline(this)) {

			new getContactList().execute();

		} else {

			alert.showNetworkAlert();
		}
	}

	private class getContactList extends AsyncTask<String, Void, Boolean> {

		ProgressDialog pd;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pd = new ProgressDialog(SearchResultActivity.this,
					AlertDialog.THEME_HOLO_LIGHT);
			pd.setMessage(getResources().getString(R.string.loading_txt));
			pd.setCancelable(false);
			pd.show();
		}

		@Override
		protected Boolean doInBackground(String... params) {

			Boolean success = false;

			String URL = Urls.doc_information + "&sid=" + Share.sid + "&cid="
					+ Share.cid + "&start=" + start + "&limit=" + count;

			Log.e("", "URL : " + URL);

			response = parsing.getResponse(URL);

			return success;
		}

		@Override
		protected void onPostExecute(Boolean success) {
			super.onPostExecute(success);

			try {

				if (!response.equalsIgnoreCase("")) {

					JSONObject jResp = new JSONObject(response);

					if (jResp.has("doctors")) {

						JSONArray jArray = new JSONArray(
								jResp.getString("doctors"));

						if (jArray.length() > 0) {

							for (int i = 0; i < jArray.length(); i++) {

								JSONObject jObject = (JSONObject) jArray.get(i);

								String did = jObject.getString("did");
								String dname = jObject.getString("dname");
								String specialty_id = jObject
										.getString("specialty_id");
								String specialty = jObject
										.getString("specialty");
								String address = jObject.getString("address");
								String city_id = jObject.getString("city_id");
								String city_name = jObject
										.getString("city_name");
								String state = jObject.getString("state");
								String zipcode = jObject.getString("zipcode");
								String docid = jObject.getString("docid");
								String question_status = jObject
										.getString("question_status");

								row(did, dname, specialty_id, specialty,
										address, city_id, city_name, state,
										zipcode, docid, question_status);

							}

						}

					} else {

						if (jResp.getString("message").equalsIgnoreCase(
								"No Data available")) {

							flgRun = false;

							alert.alertCustomMessage(getResources().getString(
									R.string.strResultEnd));

						}

					}

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

			pd.dismiss();

		}
	}

	private void row(final String did, final String dname,
			final String specialty_id, final String specialty,
			final String address, final String city_id, final String city_name,
			final String state, final String zipcode, final String docid,
			final String question_status) {

		final View v = linf.inflate(R.layout.search_layout_row, null);

		try {

			TextView sr_txtDrName = (TextView) v
					.findViewById(R.id.sr_txtDrName);
			sr_txtDrName.setTypeface(TYPEFACE.RobotoMedium(this));
			sr_txtDrName.setText(dname);

			//

			TextView sr_txtDrSpeciality = (TextView) v
					.findViewById(R.id.sr_txtDrSpeciality);
			sr_txtDrSpeciality.setTypeface(TYPEFACE.RobotoRegular(this));
			JSONObject jOb = new JSONObject(URLDecoder.decode(specialty));

			if (Share.lang.equalsIgnoreCase("en")) {
				sr_txtDrSpeciality.setText(jOb.getString("en"));
			} else {
				sr_txtDrSpeciality.setText(jOb.getString("es"));
			}

			//

			TextView sr_txtDrAddress = (TextView) v
					.findViewById(R.id.sr_txtDrAddress);
			sr_txtDrAddress.setTypeface(TYPEFACE.RobotoRegular(this));
			sr_txtDrAddress.setText(address);

			//

			TextView sr_txtDrState = (TextView) v
					.findViewById(R.id.sr_txtDrState);
			sr_txtDrState.setTypeface(TYPEFACE.RobotoRegular(this));
			sr_txtDrState.setText(city_name + " " + state + " " + zipcode);

		} catch (Exception e) {

			e.printStackTrace();

		}

		v.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				if (question_status.equalsIgnoreCase("1")) {

					Intent next = new Intent(SearchResultActivity.this,
							DoctorSurveryActivity.class);
					Share.did = docid;
					startActivityForResult(next, 2);

				} else {

					alertMessage();

				}

			}
		});

		lnrDoctorList.addView(v);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 2 && resultCode == RESULT_OK) {
			setResult(RESULT_OK);
			finish();
		}
	}

	private void alertMessage() {

		AlertDialog.Builder alertDialog = new AlertDialog.Builder(
				SearchResultActivity.this, AlertDialog.THEME_HOLO_LIGHT);
		alertDialog.setMessage(getResources().getString(
				R.string.strNoDoctorQuestionMessage));
		alertDialog.setPositiveButton(getResources().getString(R.string.strOk),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

					}
				});
		alertDialog.show();
	}
}
