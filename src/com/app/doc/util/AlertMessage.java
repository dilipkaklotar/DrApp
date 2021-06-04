package com.app.doc.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.app.doc.R;

public class AlertMessage {

	Context context;

	public AlertMessage(Context context) {

		this.context = context;

	}

	public void showNetworkAlert() {

		AlertDialog.Builder builder = new AlertDialog.Builder(context,
				AlertDialog.THEME_HOLO_LIGHT);

		builder.setMessage(
				context.getResources().getString(R.string.netconnection))
				.setPositiveButton(
						context.getResources().getString(R.string.strOk),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});

		AlertDialog alert = builder.create();
		alert.setTitle(context.getResources().getString(
				R.string.connection_problem));
		alert.show();

	}

	public void alertCustomMessage(String message) {

		AlertDialog.Builder builder = new AlertDialog.Builder(context,
				AlertDialog.THEME_HOLO_LIGHT);

		builder.setMessage(message).setPositiveButton(
				context.getResources().getString(R.string.strOk),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();

					}
				});

		AlertDialog alert = builder.create();

		alert.show();
	}

	public void alertCustomMessagewithfinish(String message) {

		AlertDialog.Builder builder = new AlertDialog.Builder(context,
				AlertDialog.THEME_HOLO_LIGHT);

		builder.setMessage(message).setPositiveButton(
				context.getResources().getString(R.string.strOk),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();

						((Activity) context).finish();

					}
				});

		AlertDialog alert = builder.create();

		alert.show();
	}

}
