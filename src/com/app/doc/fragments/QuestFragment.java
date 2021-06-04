package com.app.doc.fragments;

// Questionnaires screen. 

import java.util.Calendar;

import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.app.doc.R;
import com.app.doc.util.Utill;

public class QuestFragment extends Fragment implements OnCheckedChangeListener {
	private CheckBox dpt_chk_id, tetanus_chk_id, mmr_chk_id, flu_chk_id,
			polio_chk_id, hepatitisa_chk_id, hepatitisb_chk_id,
			smallpox_chk_id, blooddisorder_chk_id, spinedisorder_chk_id;
	private EditText emergcontname_id, emergcontrelation_id, emergcontphone_id,
			lastnameprov_id, lastreasonvisit_id, listofmeds_id, listofsupps_id,
			hospitalsurgeries_id, drugallergies_id, pharmacyname_id, mother_id,
			father_id, pharmacynumber_id;
	private Utill utill;
	private TextView lastmedvis_id, lastbloodwork_id, tetanusshot_id,
			dexascan_id, colonoscopy_id, ekg_id, lmp_id, lastpap_id,
			mammogram_id;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		utill = Utill.getInstance();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		storeVal();
	}

	// Storing values within information object.
	public void storeVal() {
		// TODO Auto-generated method stub

		utill.allInfo.emergcontname = emergcontname_id.getText().toString();
		utill.allInfo.emergcontrelation = emergcontrelation_id.getText()
				.toString();
		utill.allInfo.emergcontphone = emergcontphone_id.getText().toString();
		utill.allInfo.lastnameprov = lastnameprov_id.getText().toString();
		utill.allInfo.lastreasonvisit = lastreasonvisit_id.getText().toString();
		utill.allInfo.listofmeds = listofmeds_id.getText().toString();
		utill.allInfo.listofsupps = listofsupps_id.getText().toString();
		utill.allInfo.hospitalsurgeries = hospitalsurgeries_id.getText()
				.toString();
		utill.allInfo.drugallergies = drugallergies_id.getText().toString();
		utill.allInfo.pharmacyname = pharmacyname_id.getText().toString();
		utill.allInfo.mother = mother_id.getText().toString();
		utill.allInfo.father = father_id.getText().toString();
		utill.allInfo.pharmacynumber = pharmacynumber_id.getText().toString();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		
		View view = inflater.inflate(R.layout.ques_lay, container, false);

		emergcontname_id = (EditText) view.findViewById(R.id.emergcontname_id);
		emergcontname_id.setText(utill.allInfo.emergcontname);
		emergcontrelation_id = (EditText) view
				.findViewById(R.id.emergcontrelation_id);
		emergcontrelation_id.setText(utill.allInfo.emergcontrelation);
		emergcontphone_id = (EditText) view
				.findViewById(R.id.emergcontphone_id);
		emergcontphone_id.setText(utill.allInfo.emergcontphone);

		lastmedvis_id = (TextView) view.findViewById(R.id.lastmedvis_id);
		lastmedvis_id.setText(utill.allInfo.lastmedvis);

		lastbloodwork_id = (TextView) view.findViewById(R.id.lastbloodwork_id);
		lastbloodwork_id.setText(utill.allInfo.lastbloodwork);

		tetanusshot_id = (TextView) view.findViewById(R.id.tetanusshot_id);
		tetanusshot_id.setText(utill.allInfo.tetanusshot);

		dexascan_id = (TextView) view.findViewById(R.id.dexascan_id);
		dexascan_id.setText(utill.allInfo.dexascan);

		colonoscopy_id = (TextView) view.findViewById(R.id.colonoscopy_id);
		colonoscopy_id.setText(utill.allInfo.colonoscopy);

		ekg_id = (TextView) view.findViewById(R.id.ekg_id);
		ekg_id.setText(utill.allInfo.ekg);

		lmp_id = (TextView) view.findViewById(R.id.lmp_id);
		lmp_id.setText(utill.allInfo.lmp);

		lastpap_id = (TextView) view.findViewById(R.id.lastpap_id);
		lastpap_id.setText(utill.allInfo.lastpap);

		mammogram_id = (TextView) view.findViewById(R.id.mammogram_id);
		mammogram_id.setText(utill.allInfo.mammogram);

		lastnameprov_id = (EditText) view.findViewById(R.id.lastnameprov_id);
		lastnameprov_id.setText(utill.allInfo.lastnameprov);
		lastreasonvisit_id = (EditText) view
				.findViewById(R.id.lastreasonvisit_id);
		lastreasonvisit_id.setText(utill.allInfo.lastreasonvisit);
		listofmeds_id = (EditText) view.findViewById(R.id.listofmeds_id);
		listofmeds_id.setText(utill.allInfo.listofmeds);
		listofsupps_id = (EditText) view.findViewById(R.id.listofsupps_id);
		listofsupps_id.setText(utill.allInfo.listofsupps);
		hospitalsurgeries_id = (EditText) view
				.findViewById(R.id.hospitalsurgeries_id);
		hospitalsurgeries_id.setText(utill.allInfo.hospitalsurgeries);
		drugallergies_id = (EditText) view.findViewById(R.id.drugallergies_id);
		drugallergies_id.setText(utill.allInfo.drugallergies);

		pharmacyname_id = (EditText) view.findViewById(R.id.pharmacyname_id);
		pharmacyname_id.setText(utill.allInfo.pharmacyname);

		mother_id = (EditText) view.findViewById(R.id.mother_id);
		mother_id.setText(utill.allInfo.mother);

		father_id = (EditText) view.findViewById(R.id.father_id);
		father_id.setText(utill.allInfo.father);

		pharmacynumber_id = (EditText) view
				.findViewById(R.id.pharmacynumber_id);
		pharmacynumber_id.setText(utill.allInfo.pharmacynumber);

		dpt_chk_id = (CheckBox) view.findViewById(R.id.dpt_chk_id);
		dpt_chk_id.setChecked(utill.allInfo.dpt_chk);
		dpt_chk_id.setOnCheckedChangeListener(this);

		tetanus_chk_id = (CheckBox) view.findViewById(R.id.tetanus_chk_id);
		tetanus_chk_id.setChecked(utill.allInfo.tetanus_chk);
		tetanus_chk_id.setOnCheckedChangeListener(this);

		mmr_chk_id = (CheckBox) view.findViewById(R.id.mmr_chk_id);
		mmr_chk_id.setChecked(utill.allInfo.mmr_chk);
		mmr_chk_id.setOnCheckedChangeListener(this);

		flu_chk_id = (CheckBox) view.findViewById(R.id.flu_chk_id);
		flu_chk_id.setChecked(utill.allInfo.flu_chk);
		flu_chk_id.setOnCheckedChangeListener(this);

		polio_chk_id = (CheckBox) view.findViewById(R.id.polio_chk_id);
		polio_chk_id.setChecked(utill.allInfo.polio_chk);
		polio_chk_id.setOnCheckedChangeListener(this);

		hepatitisa_chk_id = (CheckBox) view
				.findViewById(R.id.hepatitisa_chk_id);
		hepatitisa_chk_id.setChecked(utill.allInfo.hepatitisa_chk);
		hepatitisa_chk_id.setOnCheckedChangeListener(this);

		hepatitisb_chk_id = (CheckBox) view
				.findViewById(R.id.hepatitisb_chk_id);
		hepatitisb_chk_id.setChecked(utill.allInfo.hepatitisb_chk);
		hepatitisb_chk_id.setOnCheckedChangeListener(this);

		smallpox_chk_id = (CheckBox) view.findViewById(R.id.smallpox_chk_id);
		smallpox_chk_id.setChecked(utill.allInfo.smallpox_chk);
		smallpox_chk_id.setOnCheckedChangeListener(this);

		blooddisorder_chk_id = (CheckBox) view
				.findViewById(R.id.blooddisorder_chk_id);
		blooddisorder_chk_id.setChecked(utill.allInfo.blooddisorder_chk);
		blooddisorder_chk_id.setOnCheckedChangeListener(this);

		spinedisorder_chk_id = (CheckBox) view
				.findViewById(R.id.spinedisorder_chk_id);
		spinedisorder_chk_id.setChecked(utill.allInfo.spinedisorder_chk);
		spinedisorder_chk_id.setOnCheckedChangeListener(this);

		lastmedvis_id.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDatePicker();
			}
		});

		lastbloodwork_id.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDatePicker1();
			}
		});

		tetanusshot_id.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDatePicker2();
			}
		});

		dexascan_id.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDatePicker3();
			}
		});

		colonoscopy_id.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDatePicker4();
			}
		});

		ekg_id.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDatePicker5();
			}
		});

		lmp_id.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDatePicker6();
			}
		});

		lastpap_id.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDatePicker7();
			}
		});

		mammogram_id.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDatePicker8();
			}
		});

		return view;

	}

	private void showDatePicker() {
		DatePickerFragment date = new DatePickerFragment();
		/**
		 * Set Up Current Date Into dialog
		 */
		Calendar calender = Calendar.getInstance();
		Bundle args = new Bundle();
		args.putInt("year", calender.get(Calendar.YEAR));
		args.putInt("month", calender.get(Calendar.MONTH));
		args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
		date.setArguments(args);
		/**
		 * Set Call back to capture selected date
		 */
		date.setCallBack(ondate);
		date.show(getActivity().getSupportFragmentManager(), "Date Picker");
	}

	OnDateSetListener ondate = new OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			String month = String.valueOf(monthOfYear + 1);
			if (month.length() == 1)
				month = "0" + month;
			String day = String.valueOf(dayOfMonth);
			if (day.length() == 1)
				day = "0" + day;
			lastmedvis_id.setText(month + "-" + day + "-"
					+ String.valueOf(year));
			utill.allInfo.lastmedvis = month + "-" + day + "-"
					+ String.valueOf(year);
		}

	};

	private void showDatePicker1() {
		DatePickerFragment date = new DatePickerFragment();
		/**
		 * Set Up Current Date Into dialog
		 */
		Calendar calender = Calendar.getInstance();
		Bundle args = new Bundle();
		args.putInt("year", calender.get(Calendar.YEAR));
		args.putInt("month", calender.get(Calendar.MONTH));
		args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
		date.setArguments(args);
		/**
		 * Set Call back to capture selected date
		 */
		date.setCallBack(ondate1);
		date.show(getActivity().getSupportFragmentManager(), "Date Picker");
	}

	OnDateSetListener ondate1 = new OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			String month = String.valueOf(monthOfYear + 1);
			if (month.length() == 1)
				month = "0" + month;
			String day = String.valueOf(dayOfMonth);
			if (day.length() == 1)
				day = "0" + day;
			lastbloodwork_id.setText(month + "-" + day + "-"
					+ String.valueOf(year));
			utill.allInfo.lastbloodwork = month + "-" + day + "-"
					+ String.valueOf(year);
		}
	};

	private void showDatePicker2() {
		DatePickerFragment date = new DatePickerFragment();
		/**
		 * Set Up Current Date Into dialog
		 */
		Calendar calender = Calendar.getInstance();
		Bundle args = new Bundle();
		args.putInt("year", calender.get(Calendar.YEAR));
		args.putInt("month", calender.get(Calendar.MONTH));
		args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
		date.setArguments(args);
		/**
		 * Set Call back to capture selected date
		 */
		date.setCallBack(ondate2);
		date.show(getActivity().getSupportFragmentManager(), "Date Picker");
	}

	OnDateSetListener ondate2 = new OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			String month = String.valueOf(monthOfYear + 1);
			if (month.length() == 1)
				month = "0" + month;
			String day = String.valueOf(dayOfMonth);
			if (day.length() == 1)
				day = "0" + day;
			tetanusshot_id.setText(month + "-" + day + "-"
					+ String.valueOf(year));
			utill.allInfo.tetanusshot = month + "-" + day + "-"
					+ String.valueOf(year);
		}
	};

	private void showDatePicker3() {
		DatePickerFragment date = new DatePickerFragment();
		/**
		 * Set Up Current Date Into dialog
		 */
		Calendar calender = Calendar.getInstance();
		Bundle args = new Bundle();
		args.putInt("year", calender.get(Calendar.YEAR));
		args.putInt("month", calender.get(Calendar.MONTH));
		args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
		date.setArguments(args);
		/**
		 * Set Call back to capture selected date
		 */
		date.setCallBack(ondate3);
		date.show(getActivity().getSupportFragmentManager(), "Date Picker");
	}

	OnDateSetListener ondate3 = new OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			String month = String.valueOf(monthOfYear + 1);
			if (month.length() == 1)
				month = "0" + month;
			String day = String.valueOf(dayOfMonth);
			if (day.length() == 1)
				day = "0" + day;
			dexascan_id.setText(month + "-" + day + "-" + String.valueOf(year));
			utill.allInfo.dexascan = month + "-" + day + "-"
					+ String.valueOf(year);
		}
	};

	private void showDatePicker4() {
		DatePickerFragment date = new DatePickerFragment();
		/**
		 * Set Up Current Date Into dialog
		 */
		Calendar calender = Calendar.getInstance();
		Bundle args = new Bundle();
		args.putInt("year", calender.get(Calendar.YEAR));
		args.putInt("month", calender.get(Calendar.MONTH));
		args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
		date.setArguments(args);
		/**
		 * Set Call back to capture selected date
		 */
		date.setCallBack(ondate4);
		date.show(getActivity().getSupportFragmentManager(), "Date Picker");
	}

	OnDateSetListener ondate4 = new OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			String month = String.valueOf(monthOfYear + 1);
			if (month.length() == 1)
				month = "0" + month;
			String day = String.valueOf(dayOfMonth);
			if (day.length() == 1)
				day = "0" + day;
			colonoscopy_id.setText(month + "-" + day + "-"
					+ String.valueOf(year));
			utill.allInfo.colonoscopy = month + "-" + day + "-"
					+ String.valueOf(year);
		}
	};

	private void showDatePicker5() {
		DatePickerFragment date = new DatePickerFragment();
		/**
		 * Set Up Current Date Into dialog
		 */
		Calendar calender = Calendar.getInstance();
		Bundle args = new Bundle();
		args.putInt("year", calender.get(Calendar.YEAR));
		args.putInt("month", calender.get(Calendar.MONTH));
		args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
		date.setArguments(args);
		/**
		 * Set Call back to capture selected date
		 */
		date.setCallBack(ondate5);
		date.show(getActivity().getSupportFragmentManager(), "Date Picker");
	}

	OnDateSetListener ondate5 = new OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			String month = String.valueOf(monthOfYear + 1);
			if (month.length() == 1)
				month = "0" + month;
			String day = String.valueOf(dayOfMonth);
			if (day.length() == 1)
				day = "0" + day;
			ekg_id.setText(month + "-" + day + "-" + String.valueOf(year));
			utill.allInfo.ekg = month + "-" + day + "-" + String.valueOf(year);
		}
	};

	private void showDatePicker6() {
		DatePickerFragment date = new DatePickerFragment();
		/**
		 * Set Up Current Date Into dialog
		 */
		Calendar calender = Calendar.getInstance();
		Bundle args = new Bundle();
		args.putInt("year", calender.get(Calendar.YEAR));
		args.putInt("month", calender.get(Calendar.MONTH));
		args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
		date.setArguments(args);
		/**
		 * Set Call back to capture selected date
		 */
		date.setCallBack(ondate6);
		date.show(getActivity().getSupportFragmentManager(), "Date Picker");
	}

	OnDateSetListener ondate6 = new OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			String month = String.valueOf(monthOfYear + 1);
			if (month.length() == 1)
				month = "0" + month;
			String day = String.valueOf(dayOfMonth);
			if (day.length() == 1)
				day = "0" + day;
			lmp_id.setText(month + "-" + day + "-" + String.valueOf(year));
			utill.allInfo.lmp = month + "-" + day + "-" + String.valueOf(year);
		}
	};

	private void showDatePicker7() {
		DatePickerFragment date = new DatePickerFragment();
		/**
		 * Set Up Current Date Into dialog
		 */
		Calendar calender = Calendar.getInstance();
		Bundle args = new Bundle();
		args.putInt("year", calender.get(Calendar.YEAR));
		args.putInt("month", calender.get(Calendar.MONTH));
		args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
		date.setArguments(args);
		/**
		 * Set Call back to capture selected date
		 */
		date.setCallBack(ondate7);
		date.show(getActivity().getSupportFragmentManager(), "Date Picker");
	}

	OnDateSetListener ondate7 = new OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			String month = String.valueOf(monthOfYear + 1);
			if (month.length() == 1)
				month = "0" + month;
			String day = String.valueOf(dayOfMonth);
			if (day.length() == 1)
				day = "0" + day;
			lastpap_id.setText(month + "-" + day + "-" + String.valueOf(year));
			utill.allInfo.lastpap = month + "-" + day + "-"
					+ String.valueOf(year);
		}
	};

	private void showDatePicker8() {
		DatePickerFragment date = new DatePickerFragment();
		/**
		 * Set Up Current Date Into dialog
		 */
		Calendar calender = Calendar.getInstance();
		Bundle args = new Bundle();
		args.putInt("year", calender.get(Calendar.YEAR));
		args.putInt("month", calender.get(Calendar.MONTH));
		args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
		date.setArguments(args);
		/**
		 * Set Call back to capture selected date
		 */
		date.setCallBack(ondate8);
		date.show(getActivity().getSupportFragmentManager(), "Date Picker");
	}

	OnDateSetListener ondate8 = new OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			String month = String.valueOf(monthOfYear + 1);
			if (month.length() == 1)
				month = "0" + month;
			String day = String.valueOf(dayOfMonth);
			if (day.length() == 1)
				day = "0" + day;
			mammogram_id
					.setText(month + "-" + day + "-" + String.valueOf(year));
			utill.allInfo.mammogram = month + "-" + day + "-"
					+ String.valueOf(year);
		}
	};

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		switch (buttonView.getId()) {
		case R.id.dpt_chk_id:
			if (isChecked)
				utill.allInfo.dpt_chk = true;
			else
				utill.allInfo.dpt_chk = false;
			break;
		case R.id.tetanus_chk_id:
			if (isChecked)
				utill.allInfo.tetanus_chk = true;
			else
				utill.allInfo.tetanus_chk = false;
			break;
		case R.id.mmr_chk_id:
			if (isChecked)
				utill.allInfo.mmr_chk = true;
			else
				utill.allInfo.mmr_chk = false;
			break;
		case R.id.flu_chk_id:
			if (isChecked)
				utill.allInfo.flu_chk = true;
			else
				utill.allInfo.flu_chk = false;
			break;
		case R.id.polio_chk_id:
			if (isChecked)
				utill.allInfo.polio_chk = true;
			else
				utill.allInfo.polio_chk = false;
			break;
		case R.id.hepatitisa_chk_id:
			if (isChecked)
				utill.allInfo.hepatitisa_chk = true;
			else
				utill.allInfo.hepatitisa_chk = false;
			break;
		case R.id.hepatitisb_chk_id:
			if (isChecked)
				utill.allInfo.hepatitisb_chk = true;
			else
				utill.allInfo.hepatitisb_chk = false;
			break;
		case R.id.smallpox_chk_id:
			if (isChecked)
				utill.allInfo.smallpox_chk = true;
			else
				utill.allInfo.smallpox_chk = false;
			break;
		case R.id.blooddisorder_chk_id:
			if (isChecked)
				utill.allInfo.blooddisorder_chk = true;
			else
				utill.allInfo.blooddisorder_chk = false;
			break;
		case R.id.spinedisorder_chk_id:
			if (isChecked)
				utill.allInfo.spinedisorder_chk = true;
			else
				utill.allInfo.spinedisorder_chk = false;
			break;
		default:
			break;
		}
	}
}
