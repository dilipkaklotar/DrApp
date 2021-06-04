package com.app.doc.fragments;

// Information view class

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.doc.R;
import com.app.doc.util.TYPEFACE;
import com.app.doc.util.Utill;

public class InfoFragment extends Fragment {
	private TextView dob_id, gdob_id;
	private EditText fname_id, mname_id, lname_id, city_id, feet_id, inches_id,
			weight_id, streetaddress_id, apartmentnumber_id, zipcode_id,
			homephone_id, businessphone_id, mobilephone_id, emailaddress_id,
			occupation_id, ssn_id, gfname_id, gmname_id, glname_id, gssn_id,
			gdayphone_id, gaddress_id, gaptnum_id, gcity_id, gzipcode_id;
	private Spinner state_id, gstate_id;
	private Utill utill;
	private RadioButton single_id, married_id, divorced_id, widow_id;

	// private EditText height_id;
	
	Context context;

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		storeVal();
	}

	public void storeVal() {
		// TODO Auto-generated method stub
		utill.allInfo.f_name = fname_id.getText().toString();
		utill.allInfo.m_name = mname_id.getText().toString();
		utill.allInfo.l_name = lname_id.getText().toString();
		utill.allInfo.city = city_id.getText().toString();
		// utill.allInfo.sp_f_name=sp_fname_id.getText().toString();
		// utill.allInfo.sp_m_name=sp_mname_id.getText().toString();
		// utill.allInfo.sp_l_name=sp_lname_id.getText().toString();
		// utill.allInfo.height = height_id.getText().toString();
		utill.allInfo.feet = feet_id.getText().toString();
		utill.allInfo.inches = inches_id.getText().toString();
		utill.allInfo.weight = weight_id.getText().toString();
		// utill.allInfo.maritalstatus = maritalstatus_id.getText().toString();
		utill.allInfo.streetaddress = streetaddress_id.getText().toString();
		utill.allInfo.apartmentnumber = apartmentnumber_id.getText().toString();
		utill.allInfo.zipcode = zipcode_id.getText().toString();
		utill.allInfo.homephone = homephone_id.getText().toString();
		utill.allInfo.businessphone = businessphone_id.getText().toString();
		utill.allInfo.mobilephone = mobilephone_id.getText().toString();
		utill.allInfo.emailaddress = emailaddress_id.getText().toString();
		utill.allInfo.occupation = occupation_id.getText().toString();
		utill.allInfo.ssn = ssn_id.getText().toString();
		utill.allInfo.gfname = gfname_id.getText().toString();
		utill.allInfo.gmname = gmname_id.getText().toString();
		utill.allInfo.glname = glname_id.getText().toString();
		// utill.allInfo.gdob = gdob_id.getText().toString();
		utill.allInfo.gssn = gssn_id.getText().toString();
		utill.allInfo.gdayphone = gdayphone_id.getText().toString();
		utill.allInfo.gaddress = gaddress_id.getText().toString();
		utill.allInfo.gaptnum = gaptnum_id.getText().toString();
		utill.allInfo.gcity = gcity_id.getText().toString();
		// utill.allInfo.gstate=gstate_id.getText().toString();
		utill.allInfo.gzipcode = gzipcode_id.getText().toString();

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		utill = Utill.getInstance();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		
		
		
		View view = inflater.inflate(R.layout.info_lay, container, false);
		
		context = inflater.getContext();
		
		dob_id = (TextView) view.findViewById(R.id.dob_id);
		dob_id.setText(utill.allInfo.dob);
		fname_id = (EditText) view.findViewById(R.id.fname_id);
		fname_id.setText(utill.allInfo.f_name);
		mname_id = (EditText) view.findViewById(R.id.mname_id);
		mname_id.setText(utill.allInfo.m_name);
		lname_id = (EditText) view.findViewById(R.id.lname_id);
		lname_id.setText(utill.allInfo.l_name);
		city_id = (EditText) view.findViewById(R.id.city_id);
		city_id.setText(utill.allInfo.city);
		feet_id = (EditText) view.findViewById(R.id.feet_id);
		feet_id.setText(utill.allInfo.feet);
		inches_id = (EditText) view.findViewById(R.id.inches_id);
		inches_id.setText(utill.allInfo.inches);
		weight_id = (EditText) view.findViewById(R.id.weight_id);
		weight_id.setText(utill.allInfo.weight);
		// maritalstatus_id = (EditText)
		// view.findViewById(R.id.maritalstatus_id);
		// maritalstatus_id.setText(utill.allInfo.maritalstatus);
		streetaddress_id = (EditText) view.findViewById(R.id.streetaddress_id);
		streetaddress_id.setText(utill.allInfo.streetaddress);
		apartmentnumber_id = (EditText) view
				.findViewById(R.id.apartmentnumber_id);
		apartmentnumber_id.setText(utill.allInfo.apartmentnumber);
		zipcode_id = (EditText) view.findViewById(R.id.zipcode_id);
		zipcode_id.setText(utill.allInfo.zipcode);
		homephone_id = (EditText) view.findViewById(R.id.homephone_id);
		homephone_id.setText(utill.allInfo.homephone);
		businessphone_id = (EditText) view.findViewById(R.id.businessphone_id);
		businessphone_id.setText(utill.allInfo.businessphone);
		mobilephone_id = (EditText) view.findViewById(R.id.mobilephone_id);
		mobilephone_id.setText(utill.allInfo.mobilephone);
		emailaddress_id = (EditText) view.findViewById(R.id.emailaddress_id);
		emailaddress_id.setText(utill.allInfo.emailaddress);
		occupation_id = (EditText) view.findViewById(R.id.occupation_id);
		occupation_id.setText(utill.allInfo.occupation);
		ssn_id = (EditText) view.findViewById(R.id.ssn_id);
		ssn_id.setText(utill.allInfo.ssn);
		gfname_id = (EditText) view.findViewById(R.id.gfname_id);
		gfname_id.setText(utill.allInfo.gfname);
		gmname_id = (EditText) view.findViewById(R.id.gmname_id);
		gmname_id.setText(utill.allInfo.gmname);
		glname_id = (EditText) view.findViewById(R.id.glname_id);
		glname_id.setText(utill.allInfo.glname);
		gdob_id = (TextView) view.findViewById(R.id.gdob_id);
		gdob_id.setText(utill.allInfo.gdob);
		gssn_id = (EditText) view.findViewById(R.id.gssn_id);
		gssn_id.setText(utill.allInfo.gssn);
		gdayphone_id = (EditText) view.findViewById(R.id.gdayphone_id);
		gdayphone_id.setText(utill.allInfo.gdayphone);
		gaddress_id = (EditText) view.findViewById(R.id.gaddress_id);
		gaddress_id.setText(utill.allInfo.gdayphone);
		gaptnum_id = (EditText) view.findViewById(R.id.gaptnum_id);
		gaptnum_id.setText(utill.allInfo.gaptnum);
		gcity_id = (EditText) view.findViewById(R.id.gcity_id);
		gcity_id.setText(utill.allInfo.gcity);
		gzipcode_id = (EditText) view.findViewById(R.id.gzipcode_id);
		gzipcode_id.setText(utill.allInfo.gzipcode);

		state_id = (Spinner) view.findViewById(R.id.state_id);
		List<String> list = Arrays.asList(getResources().getStringArray(
				R.array.statename));
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		state_id.setAdapter(dataAdapter);
		if (utill.allInfo.state.length() > 0) {
			state_id.setSelected(true);
			state_id.setSelection(dataAdapter.getPosition(utill.allInfo.state));
		}
		utill.allInfo.state = state_id.getItemAtPosition(0).toString();
		state_id.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> main, View view,
					int position, long Id) {
				// TODO Auto-generated method stub
				utill.allInfo.state = main.getItemAtPosition(position)
						.toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		single_id = (RadioButton) view.findViewById(R.id.single_id);
		single_id.setTypeface(TYPEFACE.RobotoMedium(context));
		
		if (utill.allInfo.is_maritalstatus == 1)
			single_id.setChecked(true);
		single_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					utill.allInfo.is_maritalstatus = 1;
			}
		});
		married_id = (RadioButton) view.findViewById(R.id.married_id);
		married_id.setTypeface(TYPEFACE.RobotoMedium(context));
		
		if (utill.allInfo.is_maritalstatus == 0)
			married_id.setChecked(true);
		married_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					utill.allInfo.is_maritalstatus = 0;
			}
		});
		divorced_id = (RadioButton) view.findViewById(R.id.divorced_id);
		divorced_id.setTypeface(TYPEFACE.RobotoMedium(context));
		
		if (utill.allInfo.is_maritalstatus == 2)
			divorced_id.setChecked(true);
		divorced_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					utill.allInfo.is_maritalstatus = 2;
			}
		});
		widow_id = (RadioButton) view.findViewById(R.id.widow_id);
		widow_id.setTypeface(TYPEFACE.RobotoMedium(context));
		
		
		if (utill.allInfo.is_maritalstatus == 3)
			widow_id.setChecked(true);
		widow_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					utill.allInfo.is_maritalstatus = 3;
			}
		});

		gstate_id = (Spinner) view.findViewById(R.id.gstate_id);
		List<String> list1 = Arrays.asList(getResources().getStringArray(
				R.array.gstatename));
		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item, list1);
		dataAdapter1
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		gstate_id.setAdapter(dataAdapter1);
		if (utill.allInfo.gstate.length() > 0) {
			gstate_id.setSelected(true);
			gstate_id.setSelection(dataAdapter1
					.getPosition(utill.allInfo.gstate));
		}
		utill.allInfo.gstate = gstate_id.getItemAtPosition(0).toString();
		gstate_id.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> main, View view,
					int position, long Id) {
				// TODO Auto-generated method stub
				utill.allInfo.gstate = main.getItemAtPosition(position)
						.toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		RadioButton male_id = (RadioButton) view.findViewById(R.id.male_id);
		RadioButton female_id = (RadioButton) view.findViewById(R.id.female_id);

		
		male_id.setTypeface(TYPEFACE.RobotoMedium(context));
		female_id.setTypeface(TYPEFACE.RobotoMedium(context));
		
		if (utill.allInfo.sex.equals("M"))
			male_id.setChecked(true);
		else if (utill.allInfo.sex.equals("F"))
			female_id.setChecked(true);
		male_id
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked)
							utill.allInfo.sex = "M";
					}
				});
		female_id
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked)
							utill.allInfo.sex = "F";
					}
				});
		dob_id.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDatePicker();
			}
		});

		gdob_id.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDatePicker1();
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
			dob_id.setText(month + "-" + day + "-" + String.valueOf(year));
			utill.allInfo.dob = month + "-" + day + "-" + String.valueOf(year);
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
			gdob_id.setText(month + "-" + day + "-" + String.valueOf(year));
			utill.allInfo.gdob = month + "-" + day + "-" + String.valueOf(year);
		}
	};
}
