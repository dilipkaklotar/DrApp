package com.app.doc;

// This is profile list view class

import java.util.ArrayList;

import com.app.doc.adapter.ItemAdapter;
import com.app.doc.database.DataBaseHelper;
import com.app.doc.util.Information;
import com.app.doc.util.TYPEFACE;
import com.app.doc.util.Utill;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class PreHomeActivity extends FragmentActivity {
	private ItemAdapter adapetr;
	private ListView list;
	private Utill utill; // Utill object
	private ArrayList<Information> iData; // Information list
	private ProgressDialog dialog; // Progress dialog

	private Button add_id;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.home_layout);
		utill = Utill.getInstance();
		list = ((ListView) findViewById(R.id.list));

		add_id = (Button) findViewById(R.id.add_id);
		add_id.setTypeface(TYPEFACE.RobotoMedium(this));
		add_id.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				utill.restUtill();
				utill = Utill.getInstance();

				DataBaseHelper.getInstance(getApplicationContext())
						.openDataBase();

				utill.allInfo.id = DataBaseHelper.getInstance(
						getApplicationContext()).getMaxcount() + 1;

				DataBaseHelper.getInstance(getApplicationContext()).close();

				Log.e("",
						"Max count : "
								+ DataBaseHelper.getInstance(
										getApplicationContext()).getMaxcount());
				Log.e("", "utill.allInfo.id : " + utill.allInfo.id);
				startActivity(new Intent(getApplicationContext(),
						HomeActivity.class));
			}
		});
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				utill.allInfo = iData.get(arg2);
				startActivity(new Intent(getApplicationContext(),
						HomeActivity.class));
			}
		});

	}

	@Override
	protected void onResume() {
		super.onResume();

		dialog = new ProgressDialog(PreHomeActivity.this,
				AlertDialog.THEME_HOLO_LIGHT);
		dialog.setMessage(getString(R.string.loading_txt));
		dialog.setCancelable(false);
		dialog.show();
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {

				DataBaseHelper.getInstance(getApplicationContext())
						.openDataBase();
				iData = DataBaseHelper.getInstance(getApplicationContext())
						.getListInfo();
				adapetr = new ItemAdapter(getApplicationContext(),
						android.R.layout.simple_list_item_1, iData);
				list.setAdapter(adapetr);

				DataBaseHelper.getInstance(getApplicationContext()).close();

				dialog.cancel();
			}
		}, 400);

	}
}
