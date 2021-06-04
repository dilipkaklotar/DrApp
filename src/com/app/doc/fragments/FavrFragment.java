package com.app.doc.fragments;

// Favorite form view class

import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.app.doc.R;
import com.app.doc.util.InputFilterMinMax;
import com.app.doc.util.Utill;

public class FavrFragment extends Fragment implements OnCheckedChangeListener {
	private CheckBox sci_chk_id, sat_chk_id, drama_chk_id, roman_chk_id,
			myst_chk_id, comd_chk_id, comc_chk_id, fant_chk_id;
	private Utill utill;
	private Spinner energy_id;
	private EditText hrs_id, times_id;
	private RadioButton pyes_id, pno_id, sm_yes_chk_id, sm_no_chk_id,
			sm_past_chk_id, alc_yes_chk_id, alc_no_chk_id, alc_past_chk_id;

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

	public void storeVal() {
		// TODO Auto-generated method stub
		utill.allInfo.hrs_read = hrs_id.getText().toString();
		utill.allInfo.days_week = times_id.getText().toString();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fav_lay, container, false);
		sci_chk_id = (CheckBox) view.findViewById(R.id.sci_chk_id);
		sci_chk_id.setChecked(utill.allInfo.is_science_book);
		sci_chk_id.setOnCheckedChangeListener(this);
		sat_chk_id = (CheckBox) view.findViewById(R.id.sat_chk_id);
		sat_chk_id.setChecked(utill.allInfo.is_satire_book);
		sat_chk_id.setOnCheckedChangeListener(this);
		drama_chk_id = (CheckBox) view.findViewById(R.id.drama_chk_id);
		drama_chk_id.setChecked(utill.allInfo.is_drama_book);
		drama_chk_id.setOnCheckedChangeListener(this);
		roman_chk_id = (CheckBox) view.findViewById(R.id.roman_chk_id);
		roman_chk_id.setChecked(utill.allInfo.is_romance_book);
		roman_chk_id.setOnCheckedChangeListener(this);
		myst_chk_id = (CheckBox) view.findViewById(R.id.myst_chk_id);
		myst_chk_id.setChecked(utill.allInfo.is_mystery_book);
		myst_chk_id.setOnCheckedChangeListener(this);
		comd_chk_id = (CheckBox) view.findViewById(R.id.comd_chk_id);
		comd_chk_id.setChecked(utill.allInfo.is_comedy_book);
		comd_chk_id.setOnCheckedChangeListener(this);
		comc_chk_id = (CheckBox) view.findViewById(R.id.comc_chk_id);
		comc_chk_id.setChecked(utill.allInfo.is_comics_book);
		comc_chk_id.setOnCheckedChangeListener(this);
		fant_chk_id = (CheckBox) view.findViewById(R.id.fant_chk_id);
		fant_chk_id.setChecked(utill.allInfo.is_fantasy_book);
		fant_chk_id.setOnCheckedChangeListener(this);
		energy_id = (Spinner) view.findViewById(R.id.energy_id);
		hrs_id = (EditText) view.findViewById(R.id.hrs_id);
		hrs_id.setFilters(new InputFilter[] { new InputFilterMinMax("1", "24") });
		hrs_id.setText(utill.allInfo.hrs_read);
		times_id = (EditText) view.findViewById(R.id.times_id);
		times_id.setFilters(new InputFilter[] { new InputFilterMinMax("1", "7") });
		times_id.setText(utill.allInfo.days_week);
		List<String> list = Arrays.asList(getResources().getStringArray(
				R.array.energy));
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		energy_id.setAdapter(dataAdapter);
		if (utill.allInfo.energy.length() > 0) {
			energy_id.setSelected(true);
			energy_id.setSelection(dataAdapter
					.getPosition(utill.allInfo.energy));
		}
		utill.allInfo.energy = energy_id.getItemAtPosition(0).toString();
		energy_id.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> main, View view,
					int position, long Id) {
				// TODO Auto-generated method stub
				utill.allInfo.energy = main.getItemAtPosition(position)
						.toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});
		pyes_id = (RadioButton) view.findViewById(R.id.pyes_id);
		if (utill.allInfo.want_rest)
			pyes_id.setChecked(true);
		pyes_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					utill.allInfo.want_rest = true;
			}
		});
		pno_id = (RadioButton) view.findViewById(R.id.pno_id);
		if (!utill.allInfo.want_rest)
			pno_id.setChecked(true);
		pno_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					utill.allInfo.want_rest = false;
			}
		});
		sm_yes_chk_id = (RadioButton) view.findViewById(R.id.sm_yes_chk_id);
		if (utill.allInfo.is_smoke == 1)
			sm_yes_chk_id.setChecked(true);
		sm_yes_chk_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					utill.allInfo.is_smoke = 1;
			}
		});
		sm_no_chk_id = (RadioButton) view.findViewById(R.id.sm_no_chk_id);
		if (utill.allInfo.is_smoke == 0)
			sm_no_chk_id.setChecked(true);
		sm_no_chk_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					utill.allInfo.is_smoke = 0;
			}
		});
		sm_past_chk_id = (RadioButton) view.findViewById(R.id.sm_past_chk_id);
		if (utill.allInfo.is_smoke == 2)
			sm_past_chk_id.setChecked(true);
		sm_past_chk_id
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked)
							utill.allInfo.is_smoke = 2;
					}
				});
		alc_yes_chk_id = (RadioButton) view.findViewById(R.id.alc_yes_chk_id);
		if (utill.allInfo.is_alcho == 1)
			alc_yes_chk_id.setChecked(true);
		alc_yes_chk_id
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked)
							utill.allInfo.is_alcho = 1;
					}
				});
		alc_no_chk_id = (RadioButton) view.findViewById(R.id.alc_no_chk_id);
		if (utill.allInfo.is_alcho == 0)
			alc_no_chk_id.setChecked(true);
		alc_no_chk_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked)
					utill.allInfo.is_alcho = 0;
			}
		});
		alc_past_chk_id = (RadioButton) view.findViewById(R.id.alc_past_chk_id);
		if (utill.allInfo.is_alcho == 2)
			alc_past_chk_id.setChecked(true);
		alc_past_chk_id
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked)
							utill.allInfo.is_alcho = 2;
					}
				});
		return view;
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		switch (buttonView.getId()) {
		case R.id.sci_chk_id:
			if (isChecked)
				utill.allInfo.is_science_book = true;
			else
				utill.allInfo.is_science_book = false;
			break;
		case R.id.sat_chk_id:
			if (isChecked)
				utill.allInfo.is_satire_book = true;
			else
				utill.allInfo.is_satire_book = false;
			break;
		case R.id.drama_chk_id:
			if (isChecked)
				utill.allInfo.is_drama_book = true;
			else
				utill.allInfo.is_drama_book = false;
			break;
		case R.id.roman_chk_id:
			if (isChecked)
				utill.allInfo.is_romance_book = true;
			else
				utill.allInfo.is_romance_book = false;
			break;
		case R.id.myst_chk_id:
			if (isChecked)
				utill.allInfo.is_mystery_book = true;
			else
				utill.allInfo.is_mystery_book = false;
			break;
		case R.id.comd_chk_id:
			if (isChecked)
				utill.allInfo.is_comedy_book = true;
			else
				utill.allInfo.is_comedy_book = false;
			break;
		case R.id.comc_chk_id:
			if (isChecked)
				utill.allInfo.is_comics_book = true;
			else
				utill.allInfo.is_comics_book = false;
			break;
		case R.id.fant_chk_id:
			if (isChecked)
				utill.allInfo.is_fantasy_book = true;
			else
				utill.allInfo.is_fantasy_book = false;
			break;
		default:
			break;
		}
	}
}
