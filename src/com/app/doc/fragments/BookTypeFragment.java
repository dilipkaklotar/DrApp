package com.app.doc.fragments;

// BookType form view class

import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.app.doc.R;
import com.app.doc.util.Utill;

public class BookTypeFragment extends Fragment {
	private EditText magz_name_id;
	private RadioButton pyes_id,pno_id,syes_id,sno_id;
	private Utill utill;
	private Spinner type_id;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		utill=Utill.getInstance();
	}
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		storeVal();
	}
	
	public void storeVal() {
		// TODO Auto-generated method stub
		utill.allInfo.magazine_name=magz_name_id.getText().toString();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.book_info, container, false);
		magz_name_id=(EditText)view.findViewById(R.id.magz_name_id);
		magz_name_id.setText(utill.allInfo.magazine_name);
		pyes_id=(RadioButton)view.findViewById(R.id.pyes_id);
		pyes_id=(RadioButton)view.findViewById(R.id.pyes_id);			
		pyes_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)
					utill.allInfo.is_book=true;
			}
		});
		pno_id=(RadioButton)view.findViewById(R.id.pno_id);		
		pno_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)	
					utill.allInfo.is_book=false;
			}
		});
		if(utill.allInfo.is_book)
			pyes_id.setChecked(true);
		else
			pno_id.setChecked(true);
		syes_id=(RadioButton)view.findViewById(R.id.syes_id);
			
		syes_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)	
					utill.allInfo.is_magazine=true;
			}
		});
		sno_id=(RadioButton)view.findViewById(R.id.sno_id);
			
		sno_id.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked)	
					utill.allInfo.is_magazine=false;
			}
		});
		if(utill.allInfo.is_magazine)
			syes_id.setChecked(true);
		else
			sno_id.setChecked(true);
		type_id=(Spinner)view.findViewById(R.id.type_id);
		List<String> list=Arrays.asList(getResources().getStringArray(R.array.booktype));
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_id.setAdapter(dataAdapter);
        if((utill.allInfo.book_type-1)>0) {
        	type_id.setSelected(true);
        	type_id.setSelection(utill.allInfo.book_type-1);
        }
        utill.allInfo.book_type= 1;
        type_id.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> main, View view, int position,
		            long Id) {
				// TODO Auto-generated method stub
				utill.allInfo.book_type= position+1;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		return view;
	} 
	
}
