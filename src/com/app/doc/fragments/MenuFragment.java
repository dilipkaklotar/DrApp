// Sliding menu class

package com.app.doc.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.doc.HomeActivity;
import com.app.doc.R;
import com.app.doc.database.DataBaseHelper;
import com.app.doc.util.TYPEFACE;
import com.app.doc.util.Utill;

public class MenuFragment extends Fragment implements OnClickListener {

	protected Fragment hFrag = null; // Fragment view

	// Menu views
	private TextView info_view = null;
	// private TextView type_view=null;
	private TextView q_view = null;
	private TextView insur_view = null;
	// private TextView fav_view=null;
	private TextView symp_view = null;
	private TextView search_view = null;
	private TextView scan_view = null;
	private TextView delete_profile = null;

	private RelativeLayout rel_info_view, rel_q_view, rel_insur_view,
			rel_symp_view, rel_search_view, rel_scan_view, rel_delete_profile;

	Context context;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.menufrag, container, false);

		context = inflater.getContext();

		info_view = (TextView) view.findViewById(R.id.info_view);
		insur_view = ((TextView) view.findViewById(R.id.insur_view));
		q_view = ((TextView) view.findViewById(R.id.q_view));
		symp_view = ((TextView) view.findViewById(R.id.symp_view));
		search_view = ((TextView) view.findViewById(R.id.search_view));
		scan_view = ((TextView) view.findViewById(R.id.scan_view));
		delete_profile = ((TextView) view.findViewById(R.id.delete_profile));

		info_view.setTypeface(TYPEFACE.RobotoRegular(context));
		insur_view.setTypeface(TYPEFACE.RobotoRegular(context));
		q_view.setTypeface(TYPEFACE.RobotoRegular(context));
		symp_view.setTypeface(TYPEFACE.RobotoRegular(context));
		search_view.setTypeface(TYPEFACE.RobotoRegular(context));
		scan_view.setTypeface(TYPEFACE.RobotoRegular(context));
		delete_profile.setTypeface(TYPEFACE.RobotoRegular(context));

		rel_info_view = (RelativeLayout) view.findViewById(R.id.rel_info_view);
		rel_q_view = (RelativeLayout) view.findViewById(R.id.rel_q_view);
		rel_insur_view = (RelativeLayout) view
				.findViewById(R.id.rel_insur_view);
		rel_symp_view = (RelativeLayout) view.findViewById(R.id.rel_symp_view);
		rel_search_view = (RelativeLayout) view
				.findViewById(R.id.rel_search_view);
		rel_scan_view = (RelativeLayout) view.findViewById(R.id.rel_scan_view);
		rel_delete_profile = (RelativeLayout) view
				.findViewById(R.id.rel_delete_profile);

		rel_info_view.setOnClickListener(this);
		rel_insur_view.setOnClickListener(this);
		rel_q_view.setOnClickListener(this);
		rel_symp_view.setOnClickListener(this);
		rel_search_view.setOnClickListener(this);
		rel_scan_view.setOnClickListener(this);
		rel_delete_profile.setOnClickListener(this);

		return view;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.rel_info_view:
			hFrag = new InfoFragment();
			switchContent(hFrag);
			break;
		case R.id.rel_insur_view:
			hFrag = new InsurFragment();
			switchContent(hFrag);
			break;
		case R.id.rel_q_view:
			hFrag = new QuestFragment();
			switchContent(hFrag);
			break;
		case R.id.rel_symp_view:
			hFrag = new SympFragment();
			switchContent(hFrag);
			break;

		case R.id.rel_search_view:
			hFrag = new SearchFragment();
			switchContent(hFrag);
			break;

		case R.id.rel_scan_view:
			hFrag = new EncoderFragment();
			switchContent(hFrag);
			break;
		case R.id.rel_delete_profile:

			new AlertDialog.Builder(context)
					.setMessage(R.string.delete_msg)
					.setPositiveButton(R.string.yes_txt,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {

									// Delete profile

									try {

										Log.e("",
												"Log ID : "
														+ Utill.getInstance().allInfo.id);

										DataBaseHelper.getInstance(context)
												.openDataBase();
										DataBaseHelper
												.getInstance(context)
												.delAll(Utill.getInstance().allInfo.id
														+ "");
										DataBaseHelper.getInstance(context)
												.close();

										((Activity) context).finish();

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

			break;

		default:
			break;
		}

	}

	private void switchContent(Fragment fragment) {
		if (getActivity() == null)
			return;

		if (getActivity() instanceof HomeActivity) {
			HomeActivity home = (HomeActivity) getActivity();
			home.switchContent(fragment);
		}
	}
}
