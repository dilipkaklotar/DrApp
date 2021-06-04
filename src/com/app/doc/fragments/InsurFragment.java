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

public class InsurFragment extends Fragment {
	private EditText priminsname_id, primpolnum_id, primgroupnum_id,
			primauthnum_id, priminsadd_id, priminsphone_id, patientrelat_id,
			policyhname_id, policyhssn_id, policyhadd_id, policyhemployer_id,
			policyhempaddress_id, policyhempcity_id, secinsname_id,
			secpolnum_id, secgroupnum_id, secauthnum_id, secinsadd_id,
			secinsphone_id, secrelationship_id;
	private TextView policyhdob_id;
	private Spinner policyhempstate_id;
	private Context context;

	private Utill utill;

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		storeVal();
	}

	public void storeVal() {
		// TODO Auto-generated method stub
		utill.allInfo.priminsname = priminsname_id.getText().toString();
		utill.allInfo.primpolnum = primpolnum_id.getText().toString();
		utill.allInfo.primgroupnum = primgroupnum_id.getText().toString();
		utill.allInfo.primauthnum = primauthnum_id.getText().toString();
		utill.allInfo.priminsadd = priminsadd_id.getText().toString();
		utill.allInfo.priminsphone = priminsphone_id.getText().toString();
		utill.allInfo.patientrelat = patientrelat_id.getText().toString();
		utill.allInfo.policyhname = policyhname_id.getText().toString();
		utill.allInfo.policyhssn = policyhssn_id.getText().toString();
		utill.allInfo.policyhadd = policyhadd_id.getText().toString();
		utill.allInfo.policyhemployer = policyhemployer_id.getText().toString();
		utill.allInfo.policyhempaddress = policyhempaddress_id.getText()
				.toString();
		utill.allInfo.policyhempcity = policyhempcity_id.getText().toString();
		utill.allInfo.secinsname = secinsname_id.getText().toString();
		utill.allInfo.secpolnum = secpolnum_id.getText().toString();
		utill.allInfo.secgroupnum = secgroupnum_id.getText().toString();
		utill.allInfo.secauthnum = secauthnum_id.getText().toString();
		utill.allInfo.secinsadd = secinsadd_id.getText().toString();
		utill.allInfo.secinsphone = secinsphone_id.getText().toString();
		utill.allInfo.secrelationship = secrelationship_id.getText().toString();

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
		View view = inflater.inflate(R.layout.insur_lay, container, false);

		context = inflater.getContext();

		priminsname_id = (EditText) view.findViewById(R.id.priminsname_id);
		priminsname_id.setText(utill.allInfo.priminsname);
		primpolnum_id = (EditText) view.findViewById(R.id.primpolnum_id);
		primpolnum_id.setText(utill.allInfo.primpolnum);
		primgroupnum_id = (EditText) view.findViewById(R.id.primgroupnum_id);
		primgroupnum_id.setText(utill.allInfo.primgroupnum);
		primauthnum_id = (EditText) view.findViewById(R.id.primauthnum_id);
		primauthnum_id.setText(utill.allInfo.primauthnum);
		priminsadd_id = (EditText) view.findViewById(R.id.priminsadd_id);
		priminsadd_id.setText(utill.allInfo.priminsadd);
		priminsphone_id = (EditText) view.findViewById(R.id.priminsphone_id);
		priminsphone_id.setText(utill.allInfo.priminsphone);

		patientrelat_id = (EditText) view.findViewById(R.id.patientrelat_id);
		patientrelat_id.setText(utill.allInfo.patientrelat);
		policyhname_id = (EditText) view.findViewById(R.id.policyhname_id);
		policyhname_id.setText(utill.allInfo.policyhname);
		policyhdob_id = (TextView) view.findViewById(R.id.policyhdob_id);
		policyhdob_id.setText(utill.allInfo.policyhdob);
		policyhssn_id = (EditText) view.findViewById(R.id.policyhssn_id);
		policyhssn_id.setText(utill.allInfo.policyhssn);
		policyhadd_id = (EditText) view.findViewById(R.id.policyhadd_id);
		policyhadd_id.setText(utill.allInfo.policyhadd);
		policyhemployer_id = (EditText) view
				.findViewById(R.id.policyhemployer_id);
		policyhemployer_id.setText(utill.allInfo.policyhemployer);
		policyhempaddress_id = (EditText) view
				.findViewById(R.id.policyhempaddress_id);
		policyhempaddress_id.setText(utill.allInfo.policyhempaddress);
		policyhempcity_id = (EditText) view
				.findViewById(R.id.policyhempcity_id);
		policyhempcity_id.setText(utill.allInfo.policyhempcity);
		secinsname_id = (EditText) view.findViewById(R.id.secinsname_id);
		secinsname_id.setText(utill.allInfo.secinsname);
		secpolnum_id = (EditText) view.findViewById(R.id.secpolnum_id);
		secpolnum_id.setText(utill.allInfo.secpolnum);
		secgroupnum_id = (EditText) view.findViewById(R.id.secgroupnum_id);
		secgroupnum_id.setText(utill.allInfo.secgroupnum);
		secauthnum_id = (EditText) view.findViewById(R.id.secauthnum_id);
		secauthnum_id.setText(utill.allInfo.secauthnum);
		secinsadd_id = (EditText) view.findViewById(R.id.secinsadd_id);
		secinsadd_id.setText(utill.allInfo.secinsadd);
		secinsphone_id = (EditText) view.findViewById(R.id.secinsphone_id);
		secinsphone_id.setText(utill.allInfo.secinsphone);
		secrelationship_id = (EditText) view
				.findViewById(R.id.secrelationship_id);
		secrelationship_id.setText(utill.allInfo.secrelationship);

		policyhempstate_id = (Spinner) view
				.findViewById(R.id.policyhempstate_id);
		List<String> list = Arrays.asList(getResources().getStringArray(
				R.array.policyhempstatename));
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		policyhempstate_id.setAdapter(dataAdapter);
		if (utill.allInfo.policyhempstate.length() > 0) {
			policyhempstate_id.setSelected(true);
			policyhempstate_id.setSelection(dataAdapter
					.getPosition(utill.allInfo.policyhempstate));
		}
		utill.allInfo.policyhempstate = policyhempstate_id.getItemAtPosition(0)
				.toString();
		policyhempstate_id
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> main, View view,
							int position, long Id) {
						// TODO Auto-generated method stub
						utill.allInfo.policyhempstate = main.getItemAtPosition(
								position).toString();
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		RadioButton myes_id = (RadioButton) view.findViewById(R.id.myes_id);
		myes_id.setTypeface(TYPEFACE.RobotoMedium(context));

		RadioButton mno_id = (RadioButton) view.findViewById(R.id.mno_id);
		mno_id.setTypeface(TYPEFACE.RobotoMedium(context));

		if (utill.allInfo.medins.equals("Y"))
			myes_id.setChecked(true);
		else if (utill.allInfo.medins.equals("N"))
			mno_id.setChecked(true);

		myes_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					utill.allInfo.medins = "Y";
			}
		});
		mno_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					utill.allInfo.medins = "N";
			}
		});

		RadioButton secmyes_id = (RadioButton) view
				.findViewById(R.id.secmyes_id);
		RadioButton secmno_id = (RadioButton) view.findViewById(R.id.secmno_id);

		secmyes_id.setTypeface(TYPEFACE.RobotoMedium(context));
		secmno_id.setTypeface(TYPEFACE.RobotoMedium(context));

		if (utill.allInfo.secmedins.equals("Y"))
			secmyes_id.setChecked(true);
		else if (utill.allInfo.secmedins.equals("N"))
			secmno_id.setChecked(true);

		secmyes_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					utill.allInfo.secmedins = "Y";
			}
		});
		secmno_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					utill.allInfo.secmedins = "N";
			}
		});

		RadioButton policyyes_id = (RadioButton) view
				.findViewById(R.id.policyyes_id);
		RadioButton policyno_id = (RadioButton) view
				.findViewById(R.id.policyno_id);

		if (utill.allInfo.policythruemp.equals("Y"))
			policyyes_id.setChecked(true);
		else if (utill.allInfo.policythruemp.equals("N"))
			policyno_id.setChecked(true);
		
		policyyes_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					utill.allInfo.policythruemp = "Y";
			}
		});
		
		policyno_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					utill.allInfo.policythruemp = "N";
			}
		});
		
		policyhdob_id.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDatePicker();
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
			policyhdob_id.setText(month + "-" + day + "-"
					+ String.valueOf(year));
			utill.allInfo.policyhdob = month + "-" + day + "-"
					+ String.valueOf(year);
		}
	};

}
