package com.app.doc;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.app.doc.database.DataBaseHelper;
import com.app.doc.util.AlertMessage;
import com.app.doc.util.Share;
import com.app.doc.util.TYPEFACE;
import com.app.doc.util.Urls;
import com.app.doc.util.Utill;
import com.app.doc.util.Utils;
import com.app.doc.webservice.Parsing;

public class DoctorSurveryActivity extends Activity {

	LinearLayout lnrSurvey;

	AlertMessage alert;

	Parsing parsing;

	String respQues = "", respAns = "";

	LayoutInflater linf;
	LinearLayout lnrQuestion;

	String[] question, answer;

	String[] stored_ans;

	private Utill utill;

	String pid, question_mandatory, docid, questionid, question_type = "";

	int year = 0;
	int month = 0;
	int day = 0;

	boolean flagData = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_docsurvey);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		getActionBar().setIcon(
				new ColorDrawable(getResources().getColor(
						android.R.color.transparent)));

		getActionBar().setBackgroundDrawable(
				new ColorDrawable(Color.parseColor("#009688")));

		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		utill = Utill.getInstance();

		linf = (LayoutInflater) getApplicationContext().getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
		linf = LayoutInflater.from(this);

		lnrSurvey = (LinearLayout) findViewById(R.id.lnrSurvey);
		lnrSurvey.removeAllViews();

		alert = new AlertMessage(this);
		parsing = new Parsing(this);

		setView();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.savemenu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case R.id.action_bar_save:

			saveData();

			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onBackPressed() {

		saveData();

	}

	private void saveData() {
		if (question.length > 0) {

			for (int i = 0; i < question.length; i++) {

				if (question[i] == null) {

					Log.e("", "question[" + i + "] : " + question[i]);
					Log.e("", "answer[" + i + "] : " + answer[i]);

					question[i] = "";
					answer[i] = "";
				}

				try {

					DataBaseHelper.getInstance(DoctorSurveryActivity.this)
							.openDataBase();
					DataBaseHelper.getInstance(DoctorSurveryActivity.this)
							.InsertIntoAnswerDB(
									String.valueOf(utill.allInfo.id),
									Share.did, question[i], answer[i]);
					DataBaseHelper.getInstance(DoctorSurveryActivity.this)
							.close();

				} catch (Exception e) {

					e.printStackTrace();
				}

			}

			AlertDialog.Builder alertDialog = new AlertDialog.Builder(
					DoctorSurveryActivity.this, AlertDialog.THEME_HOLO_LIGHT);
			alertDialog.setMessage(getResources().getString(
					R.string.save_data_message));
			alertDialog.setPositiveButton(
					getResources().getString(R.string.strAlertYes),
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							Share.flgSurveryFinished = true;

							setResult(RESULT_OK);
							finish();

						}
					});
			alertDialog.setNegativeButton(
					getResources().getString(R.string.strAlertNo),
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {

							// finish();

						}
					});
			alertDialog.show();

		} else {

			finish();

		}
	}

	private void setView() {

		if (Utils.isOnline(this)) {

			new getQuestions().execute();

		} else {

			alert.showNetworkAlert();
		}
	}

	private class getQuestions extends AsyncTask<String, Void, Boolean> {

		ProgressDialog pd1;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pd1 = new ProgressDialog(DoctorSurveryActivity.this,
					AlertDialog.THEME_HOLO_LIGHT);
			pd1.setMessage(getResources().getString(R.string.loading_txt));
			pd1.setCancelable(false);
			pd1.show();

			try {

				DataBaseHelper.getInstance(DoctorSurveryActivity.this)
						.openDataBase();

				Cursor cc = DataBaseHelper.getInstance(
						DoctorSurveryActivity.this).SelectAnswerDB(
						String.valueOf(utill.allInfo.id), Share.did);

				if (cc.getCount() > 0) {

					flagData = true;

					cc.moveToFirst();

					stored_ans = new String[cc.getCount()];
					question = new String[cc.getCount()];
					answer = new String[cc.getCount()];

					Log.e("", "Stored Answer : " + stored_ans.length);

					int count = 0;

					do {

						question[count] = cc.getString(3);
						answer[count] = cc.getString(4);
						stored_ans[count] = cc.getString(4);

						count++;

					} while (cc.moveToNext());

				} else {

					flagData = false;

					Log.e("", "Stored Answer : No data");
				}

				cc.close();

				DataBaseHelper.getInstance(DoctorSurveryActivity.this).close();

			} catch (Exception e) {

			}
		}

		@Override
		protected Boolean doInBackground(String... params) {

			Boolean success = false;

			String URL = Urls.questions + "&did=" + Share.did;

			Log.e("", "URL QUES : " + URL);

			respQues = parsing.getResponse(URL);

			return success;
		}

		@Override
		protected void onPostExecute(Boolean success) {
			super.onPostExecute(success);

			try {

				if (!respQues.equalsIgnoreCase("")) {

					JSONObject jResp = new JSONObject(respQues);

					JSONArray jArray = new JSONArray(
							jResp.getString("questions"));

					if (!flagData) {

						question = new String[jArray.length()];
						answer = new String[jArray.length()];

					}
					if (jArray.length() > 0) {

						DataBaseHelper.getInstance(DoctorSurveryActivity.this)
								.openDataBase();

						for (int i = 0; i < jArray.length(); i++) {

							JSONObject jObject = (JSONObject) jArray.get(i);

							String pid = jObject.getString("pid");
							String question_mandatory = jObject
									.getString("question_mandatory");
							String docid = jObject.getString("docid");
							String questionid = jObject.getString("questionid");
							String question_type = jObject
									.getString("question_type");
							String question_content = jObject
									.getString("question_content");

							DataBaseHelper
									.getInstance(DoctorSurveryActivity.this)
									.InsertIntoQuestionDB(
											String.valueOf(utill.allInfo.id),
											docid, pid, question_mandatory,
											questionid, question_type, "0",
											URLEncoder.encode(question_content));

							question[i] = questionid;
							answer[i] = "";

							setRow(i, questionid, questionid, question_content,
									question_type);

						}

						DataBaseHelper.getInstance(DoctorSurveryActivity.this)
								.close();

					}

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

			pd1.dismiss();

		}
	}

	private void setRow(final int index, final String aid,
			final String question_id, final String question_content,
			final String question_type) {

		try {

			Log.e("", "index : " + index);

			final View v = linf.inflate(R.layout.activity_docsurvey_querow,
					null);

			TextView txtQuestion = (TextView) v.findViewById(R.id.txtQuestion);
			txtQuestion.setTypeface(TYPEFACE.RobotoRegular(this));

			LinearLayout lnrAnswerContent = (LinearLayout) v
					.findViewById(R.id.lnrAnswerContent);

			JSONObject jsonQType = new JSONObject(
					URLDecoder.decode(question_content));

			JSONObject jQuestion = new JSONObject(jsonQType.getString("text"));

			if (Share.lang.equalsIgnoreCase("en")) {
				txtQuestion.setText(jQuestion.getString("en"));
			} else {
				txtQuestion.setText(jQuestion.getString("es"));
			}

			if (question_type.equalsIgnoreCase("TEXT")) {

				final View editText = linf.inflate(R.layout.row_text, null);

				final EditText edt = (EditText) editText
						.findViewById(R.id.edtContent);

				if (flagData)
					edt.setText(stored_ans[index]);

				edt.addTextChangedListener(new TextWatcher() {

					@Override
					public void onTextChanged(CharSequence s, int start,
							int before, int count) {
						// TODO Auto-generated method stub

					}

					@Override
					public void beforeTextChanged(CharSequence s, int start,
							int count, int after) {

					}

					@Override
					public void afterTextChanged(Editable s) {

						Log.e("", "index: " + index + " = " + s.toString());

						question[index] = question_id;
						answer[index] = s.toString();

					}
				});

				lnrAnswerContent.addView(editText);

			} else if (question_type.equalsIgnoreCase("TEXTAREA")) {

				final View editTextArea = linf.inflate(R.layout.row_textarea,
						null);

				final EditText edt = (EditText) editTextArea
						.findViewById(R.id.edtContent);

				if (flagData)
					edt.setText(stored_ans[index]);

				edt.addTextChangedListener(new TextWatcher() {

					@Override
					public void onTextChanged(CharSequence s, int start,
							int before, int count) {
						// TODO Auto-generated method stub

					}

					@Override
					public void beforeTextChanged(CharSequence s, int start,
							int count, int after) {
						// TODO Auto-generated method stub

					}

					@Override
					public void afterTextChanged(Editable s) {

						Log.e("", "index: " + index + " = " + s.toString());

						question[index] = question_id;
						answer[index] = s.toString().toString();

					}
				});

				lnrAnswerContent.addView(editTextArea);

			} else if (question_type.equalsIgnoreCase("GENDER")) {

				String strMale = "", strFemale = "";

				JSONObject values = new JSONObject(
						jsonQType.getString("values"));

				Log.e("", "values : " + values.toString());

				if (Share.lang.equalsIgnoreCase("en")) {

					JSONObject jmale = new JSONObject(values.getString("male"));
					strMale = jmale.getString("en");

					JSONObject jfemale = new JSONObject(
							values.getString("female"));
					strFemale = jfemale.getString("en");

				} else {

					JSONObject jmale = new JSONObject(values.getString("male"));
					strMale = jmale.getString("es");

					JSONObject jfemale = new JSONObject(
							values.getString("female"));
					strFemale = jfemale.getString("es");

				}

				final View gender = linf.inflate(R.layout.row_gender, null);

				final RadioButton male_id = (RadioButton) gender
						.findViewById(R.id.male_id);

				if (flagData) {
					if (stored_ans[index].equalsIgnoreCase("M")) {
						male_id.setChecked(true);
					}
				}

				male_id.setTypeface(TYPEFACE.RobotoRegular(this));
				male_id.setText(strMale);
				male_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {

						if (isChecked) {

							question[index] = question_id;
							answer[index] = "M";
						}

					}
				});
				final RadioButton female_id = ((RadioButton) gender
						.findViewById(R.id.female_id));

				if (flagData) {
					if (stored_ans[index].equalsIgnoreCase("F")) {
						female_id.setChecked(true);
					}
				}

				female_id.setTypeface(TYPEFACE.RobotoRegular(this));
				female_id.setText(strFemale);
				female_id
						.setOnCheckedChangeListener(new OnCheckedChangeListener() {

							@Override
							public void onCheckedChanged(
									CompoundButton buttonView, boolean isChecked) {

								if (isChecked) {

									question[index] = question_id;
									answer[index] = "F";
								}

							}
						});

				lnrAnswerContent.addView(gender);

			} else if (question_type.equalsIgnoreCase("YES_NO")) {

				String strYes = "", strNo = "";

				JSONObject values = new JSONObject(
						jsonQType.getString("values"));

				if (Share.lang.equalsIgnoreCase("en")) {

					JSONObject yes = new JSONObject(values.getString("yes"));
					strYes = yes.getString("en");

					JSONObject no = new JSONObject(values.getString("no"));
					strNo = no.getString("en");

				} else {

					JSONObject yes = new JSONObject(values.getString("yes"));
					strYes = yes.getString("es");

					JSONObject no = new JSONObject(values.getString("no"));
					strNo = no.getString("es");

				}

				final View yes_no = linf.inflate(R.layout.row_yesno, null);

				final RadioButton yes_id = (RadioButton) yes_no
						.findViewById(R.id.yes_id);

				if (flagData) {
					if (stored_ans[index].equalsIgnoreCase("Y")) {
						yes_id.setChecked(true);
					}
				}

				yes_id.setTypeface(TYPEFACE.RobotoRegular(this));
				yes_id.setText(strYes);
				yes_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {

						if (isChecked) {

							question[index] = question_id;
							answer[index] = "Y";

						}

					}
				});

				final RadioButton no_id = (RadioButton) yes_no
						.findViewById(R.id.no_id);

				if (flagData) {
					if (stored_ans[index].equalsIgnoreCase("N")) {
						no_id.setChecked(true);
					}
				}

				no_id.setTypeface(TYPEFACE.RobotoRegular(this));
				no_id.setText(strNo);
				no_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {

						if (isChecked) {

							question[index] = question_id;
							answer[index] = "N";

						}

					}
				});

				lnrAnswerContent.addView(yes_no);

			} else if (question_type.equalsIgnoreCase("CHECKBOX")) {

				if (flagData) {
					Log.e("", "CHECKBOX ANS TEXT : " + stored_ans[index]);
				}
				JSONArray values = new JSONArray(jsonQType.getString("values"));

				final ArrayList<String> arr = new ArrayList<String>();

				for (int i = 0; i < values.length(); i++) {

					JSONObject jObject = (JSONObject) values.get(i);

					String data = "";

					if (Share.lang.equalsIgnoreCase("en")) {

						data = jObject.getString("en");

					} else {

						data = jObject.getString("es");

					}

					final View checkbox = linf.inflate(R.layout.row_checkbox,
							null);

					final CheckBox chkbox = (CheckBox) checkbox
							.findViewById(R.id.chkbox);
					chkbox.setText(data);
					if (flagData) {
						if (stored_ans[index].contains(data)) {
							chkbox.setChecked(true);

						}
					}

					chkbox.setTypeface(TYPEFACE.RobotoRegular(this));

					chkbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

						@Override
						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {

							if (isChecked) {

								if (!arr.contains(chkbox.getText().toString()))
									arr.add(chkbox.getText().toString());

								question[index] = question_id;
								answer[index] = arr.toString();

							} else {

								if (arr.contains(chkbox.getText().toString()))
									arr.remove(chkbox.getText().toString());

								question[index] = question_id;
								answer[index] = arr.toString();

							}

						}
					});

					lnrAnswerContent.addView(checkbox);

				}

			} else if (question_type.equalsIgnoreCase("DATE")) {

				final View dateText = linf.inflate(R.layout.row_date, null);

				String current_date = String.valueOf(year) + "/"
						+ String.valueOf(month + 1) + "/" + String.valueOf(day);

				final TextView txtContent = (TextView) dateText
						.findViewById(R.id.txtContent);

				txtContent.setText(current_date);

				if (flagData) {
					txtContent.setText(answer[index]);

				} else {
					question[index] = question_id;
					answer[index] = current_date;
				}

				txtContent.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {

						new DatePickerDialog(DoctorSurveryActivity.this,
								AlertDialog.THEME_HOLO_LIGHT,

								new DatePickerDialog.OnDateSetListener() {

									public void onDateSet(DatePicker view,
											int selectedYear,
											int selectedMonth, int selectedDay) {

										int year = selectedYear;
										int month = selectedMonth;
										int day = selectedDay;

										String selected_date = String
												.valueOf(year)
												+ "/"
												+ String.valueOf(month + 1)
												+ "/" + String.valueOf(day);

										txtContent.setText(selected_date);

										question[index] = question_id;
										answer[index] = selected_date;

									}
								}, year, month, day).show();

					}
				});

				lnrAnswerContent.addView(dateText);

			}

			lnrSurvey.addView(v);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
