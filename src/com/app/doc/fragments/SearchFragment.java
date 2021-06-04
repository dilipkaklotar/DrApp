package com.app.doc.fragments;

import java.net.URLDecoder;

import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.doc.R;
import com.app.doc.SearchResultActivity;
import com.app.doc.database.DataBaseHelper;
import com.app.doc.util.Share;

public class SearchFragment extends Fragment {

	private Spinner city_id = null, speciality_id = null;

	private String[] cityid = null, city = null;
	private String[] specialityid = null, speciality_en = null,
			speciality_es = null;

	private Context context;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);

		context = inflater.getContext();

		View view = inflater.inflate(R.layout.search_layout, container, false);

		Share.cid = "";
		Share.sid = "";

		city_id = (Spinner) view.findViewById(R.id.city_id);
		speciality_id = (Spinner) view.findViewById(R.id.speciality_id);

		((TextView) view.findViewById(R.id.txtBrowseAll))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {

						Share.cid = "";
						Share.sid = "";

						startActivityForResult(new Intent(getActivity()
								.getApplicationContext(),
								SearchResultActivity.class), 2);

					}
				});

		getCity();
		getSpeciality();

		((Button) view.findViewById(R.id.btnSearch))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {

						startActivityForResult(new Intent(getActivity()
								.getApplicationContext(),
								SearchResultActivity.class), 2);
					}
				});

		return view;
	}

	private void getCity() {

		try {

			DataBaseHelper.getInstance(getActivity().getApplicationContext())
					.openDataBase();

			Cursor cit = DataBaseHelper.getInstance(
					getActivity().getApplicationContext()).SelectCityDB();

			Log.e("", "count : " + cit.getCount());

			if (cit.getCount() > 0) {

				cityid = new String[cit.getCount() + 1];
				city = new String[cit.getCount() + 1];

				cit.moveToFirst();

				Log.e("",
						"city[0] : "
								+ context.getResources().getString(
										R.string.strallCity));

				cityid[0] = "";
				city[0] = context.getResources().getString(R.string.strallCity);

				int count = 1;

				do {

					cityid[count] = cit.getString(0);
					city[count] = cit.getString(1);
					count++;

				} while (cit.moveToNext());

			}

			cit.close();

			ArrayAdapter<String> dataAdapterCity = new ArrayAdapter<String>(
					getActivity(), android.R.layout.simple_spinner_item, city);
			dataAdapterCity
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			city_id.setAdapter(dataAdapterCity);

			city_id.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> main, View view,
						int position, long Id) {

					Share.cid = cityid[position];

				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {

				}
			});

			DataBaseHelper.getInstance(getActivity().getApplicationContext())
					.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getSpeciality() {

		try {

			DataBaseHelper.getInstance(getActivity().getApplicationContext())
					.openDataBase();

			Cursor spec = DataBaseHelper.getInstance(
					getActivity().getApplicationContext()).SelectSpecialityDB();

			if (spec.getCount() > 0) {

				specialityid = new String[spec.getCount() + 1];
				speciality_en = new String[spec.getCount() + 1];
				speciality_es = new String[spec.getCount() + 1];

				spec.moveToFirst();

				specialityid[0] = "";

				speciality_en[0] = context.getResources().getString(
						R.string.strSpec);
				speciality_es[0] = context.getResources().getString(
						R.string.strSpec);

				int count = 1;

				do {

					specialityid[count] = spec.getString(0);

					String data = URLDecoder.decode(spec.getString(1));

					JSONObject jObject = new JSONObject(data);

					String spec_en = jObject.getString("en");
					String spec_es = jObject.getString("es");

					speciality_en[count] = spec_en;
					speciality_es[count] = spec_es;
					count++;

				} while (spec.moveToNext());

			}

			spec.close();

			ArrayAdapter<String> dataAdapterSpeciality = null;

			if (Share.lang.equalsIgnoreCase("en")) {

				dataAdapterSpeciality = new ArrayAdapter<String>(getActivity(),
						android.R.layout.simple_spinner_item, speciality_en);

			} else {

				dataAdapterSpeciality = new ArrayAdapter<String>(getActivity(),
						android.R.layout.simple_spinner_item, speciality_es);

			}

			dataAdapterSpeciality
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			speciality_id.setAdapter(dataAdapterSpeciality);

			speciality_id
					.setOnItemSelectedListener(new OnItemSelectedListener() {

						@Override
						public void onItemSelected(AdapterView<?> main,
								View view, int position, long Id) {

							Share.sid = specialityid[position];
						}

						@Override
						public void onNothingSelected(AdapterView<?> arg0) {

						}
					});

			DataBaseHelper.getInstance(getActivity().getApplicationContext())
					.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
