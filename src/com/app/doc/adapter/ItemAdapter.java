package com.app.doc.adapter;

// ItemAdapter class

import java.util.ArrayList;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.doc.HomeActivity;
import com.app.doc.R;
import com.app.doc.util.Information;
import com.app.doc.util.TYPEFACE;
import com.app.doc.util.Utill;

public class ItemAdapter extends ArrayAdapter<Information> {
	private ArrayList<Information> info;
	private Context ctx;

	public ItemAdapter(Context ctx, int textViewResourceId,
			ArrayList<Information> info) {
		super(ctx, textViewResourceId, info);
		this.info = info;
		this.ctx = ctx;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		LayoutInflater vi = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final Information i = info.get(position);
		
		v = vi.inflate(R.layout.prof_row, null);
		
		TextView name_id = (TextView) v.findViewById(R.id.name_id);
		name_id.setTypeface(TYPEFACE.RobotoMedium(ctx));
		name_id.setText(i.f_name + "'s "
				+ ctx.getString(R.string.prof_txt));
		
		if (i.dob != null && i.dob.length() > 0) {
			String dob[] = i.dob.split("-");
			
			TextView age_id = (TextView) v.findViewById(R.id.age_id);
			age_id.setTypeface(TYPEFACE.RobotoMedium(ctx));
			age_id.setText(ctx
					.getString(R.string.age_txt)
					+ getAge(dob[2], dob[0], dob[1]));
		}
		
		TextView save_id = (TextView) v.findViewById(R.id.save_id);
		save_id.setTypeface(TYPEFACE.RobotoMedium(ctx));
		save_id.setText(ctx
				.getString(R.string.save_txt) + i.saved);
		
		
		((ImageView) v.findViewById(R.id.shrtcut_btn))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						
						Utill.getInstance().allInfo = i;
						Intent i = new Intent(ctx, HomeActivity.class);
						i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						i.putExtra("id", 1);
						ctx.startActivity(i);
						
					}
				});
		return v;
	}

	@SuppressLint("UseValueOf")
	private String getAge(String year, String month, String day) {
		Calendar calDOB = Calendar.getInstance();
		calDOB.set(Integer.parseInt(year), Integer.parseInt(month),
				Integer.parseInt(day));
		// setup calNow as today.
		Calendar calNow = Calendar.getInstance();
		calNow.setTime(new java.util.Date());
		// calculate age in years.
		int ageYr = (calNow.get(Calendar.YEAR) - calDOB.get(Calendar.YEAR));
		// calculate additional age in months, possibly adjust years.
		int ageMo = (calNow.get(Calendar.MONTH) - calDOB.get(Calendar.MONTH));
		if (ageMo < 0) {
			// adjust years by subtracting one
			ageYr--;
		}
		return ageYr + "";
	}
}