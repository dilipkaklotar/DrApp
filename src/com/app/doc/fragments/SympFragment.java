package com.app.doc.fragments;

// Information view class

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

public class SympFragment extends Fragment implements OnCheckedChangeListener {
	// medins_id,patientrelat_id,policyhname_id,policyhdob_id,policyhssn_id,policyhadd_id,policythruemp_id,policyhemployer_id,policyhempaddress_id,policyhempcity_id,policyhempstate_id,secmedins_id,secinsname_id,secpolnum_id,secgroupnum_id,secauthnum_id,secinsadd_id,secinsphone_id,secrelationship_id;
	private CheckBox weightchng_chk_id, weakness_chk_id, fatigue_chk_id,
			fever_chk_id, cancer_chk_id, headache_chk_id, headinjury_chk_id,
			dizziness_chk_id, lightheadedness_chk_id, visionchange_chk_id,
			eyepain_chk_id, doublevision_chk_id, spotsflashinglights_chk_id,
			glaucoma_chk_id, cataracts_chk_id, hearingchange_chk_id,
			ringing_chk_id, vertigo_chk_id, earaches_chk_id, infection_chk_id,
			frequentcold_chk_id, nasalcongestion_chk_id, discharge_chk_id,
			hayfever_chk_id, nosebleed_chk_id, sinus_chk_id, lumpsneck_chk_id,
			swollenglands_chk_id, goiter_chk_id, painneck_chk_id, cough_chk_id,
			coughingblood_chk_id, shortnessbreath_chk_id, wheezing_chk_id,
			sleepapnea_chk_id, troublebreathing_chk_id, dentalproblems_chk_id,
			soretongue_chk_id, drymouth_chk_id, freqsorethroat_chk_id,
			hoarseness_chk_id, chestpain_chk_id, highbloodpressure_chk_id,
			murmus_chk_id, rheumaticfever_chk_id, palpitations_chk_id,
			difficultyswallow_chk_id, heartburn_chk_id, nauseavomit_chk_id,
			regurgitation_chk_id, vomitingblood_chk_id, indigestion_chk_id,
			rectalbleeding_chk_id, blacktarrystools_chk_id, hemorrhoids_chk_id,
			constipation_chk_id, diarrhea_chk_id, abdominal_chk_id,
			foodintolerance_chk_id, excessivebelchgas_chk_id,
			yellowingskin_chk_id, livergallbladderprobs_chk_id,
			hepatitis_chk_id, bladderinfection_chk_id,
			urinaryfrequrgency_chk_id, bloodurine_chk_id,
			painfulurination_chk_id, dribblingstream_chk_id,
			reducedforcestream_chk_id, hesitancy_chk_id, incontinence_chk_id,
			bladderkidneystone_chk_id, irregularmenses_chk_id,
			breakthroughbleeding_chk_id, painfulmenses_chk_id, pms_chk_id,
			vaginaldischargeitch_chk_id, vaginalsorelumpsSTD_chk_id,
			menopausal_chk_id, postmenopausalbleeding_chk_id, hernias_chk_id,
			dischargessorespeni_chk_id, testicularpainmasses_chk_id,
			std_chk_id, musclepain_chk_id, stiffness_chk_id, arthritis_chk_id,
			gout_chk_id, backache_chk_id, fainting_chk_id, blackouts_chk_id,
			seizures_chk_id, weaknessparalysis_chk_id, numbnessloss_chk_id,
			tingling_chk_id, tremors_chk_id, memoryloss_chk_id, trouble_chk_id,
			rasheslumpssores_chk_id, itchingdryness_chk_id, colorchange_chk_id,
			changehairnails_chk_id, breastlumps_chk_id, breastpain_chk_id,
			nippledischarge_chk_id, thyroidproblems_chk_id,
			heatcoldintolerance_chk_id, excessivesweating_chk_id,
			diabetes_chk_id, excessivethirsthunger_chk_id,
			frequenturination_chk_id, anemia_chk_id,
			easybruisingbleeding_chk_id, pasttransfusion_chk_id,
			intermittent_chk_id, leg_chk_id, varicose_chk_id, past_chk_id,
			nervousness_chk_id, tension_chk_id, depression_chk_id,
			insomnia_chk_id, defect_chk_id, diseasecolon_chk_id,
			kidneyd_chk_id, hearttrb_chk_id, lifethreatcondition_chk_id;
	private Spinner energy_id;
	private EditText hrs_id, times_id;
	private Utill utill;
	private RadioButton sm_yes_chk_id, sm_no_chk_id, sm_past_chk_id,
			alc_yes_chk_id, alc_no_chk_id, alc_past_chk_id, recdrug_yes_chk_id,
			recdrug_no_chk_id, recdrug_past_chk_id;

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
		View view = inflater.inflate(R.layout.symp_lay, container, false);
		weightchng_chk_id = (CheckBox) view
				.findViewById(R.id.weightchng_chk_id);
		weightchng_chk_id.setChecked(utill.allInfo.weightchng_chk);
		weightchng_chk_id.setOnCheckedChangeListener(this);
		weakness_chk_id = (CheckBox) view.findViewById(R.id.weakness_chk_id);
		weakness_chk_id.setChecked(utill.allInfo.weakness_chk);
		weakness_chk_id.setOnCheckedChangeListener(this);
		fatigue_chk_id = (CheckBox) view.findViewById(R.id.fatigue_chk_id);
		fatigue_chk_id.setChecked(utill.allInfo.fatigue_chk);
		fatigue_chk_id.setOnCheckedChangeListener(this);
		fever_chk_id = (CheckBox) view.findViewById(R.id.fever_chk_id);
		fever_chk_id.setChecked(utill.allInfo.fever_chk);
		fever_chk_id.setOnCheckedChangeListener(this);
		cancer_chk_id = (CheckBox) view.findViewById(R.id.cancer_chk_id);
		cancer_chk_id.setChecked(utill.allInfo.cancer_chk);
		cancer_chk_id.setOnCheckedChangeListener(this);
		headache_chk_id = (CheckBox) view.findViewById(R.id.headache_chk_id);
		headache_chk_id.setChecked(utill.allInfo.headache_chk);
		headache_chk_id.setOnCheckedChangeListener(this);
		headinjury_chk_id = (CheckBox) view
				.findViewById(R.id.headinjury_chk_id);
		headinjury_chk_id.setChecked(utill.allInfo.headinjury_chk);
		headinjury_chk_id.setOnCheckedChangeListener(this);
		dizziness_chk_id = (CheckBox) view.findViewById(R.id.dizziness_chk_id);
		dizziness_chk_id.setChecked(utill.allInfo.dizziness_chk);
		dizziness_chk_id.setOnCheckedChangeListener(this);
		lightheadedness_chk_id = (CheckBox) view
				.findViewById(R.id.lightheadedness_chk_id);
		lightheadedness_chk_id.setChecked(utill.allInfo.lightheadedness_chk);
		lightheadedness_chk_id.setOnCheckedChangeListener(this);
		visionchange_chk_id = (CheckBox) view
				.findViewById(R.id.visionchange_chk_id);
		visionchange_chk_id.setChecked(utill.allInfo.visionchange_chk);
		visionchange_chk_id.setOnCheckedChangeListener(this);
		eyepain_chk_id = (CheckBox) view.findViewById(R.id.eyepain_chk_id);
		eyepain_chk_id.setChecked(utill.allInfo.eyepain_chk);
		eyepain_chk_id.setOnCheckedChangeListener(this);
		doublevision_chk_id = (CheckBox) view
				.findViewById(R.id.doublevision_chk_id);
		doublevision_chk_id.setChecked(utill.allInfo.doublevision_chk);
		doublevision_chk_id.setOnCheckedChangeListener(this);
		spotsflashinglights_chk_id = (CheckBox) view
				.findViewById(R.id.spotsflashinglights_chk_id);
		spotsflashinglights_chk_id
				.setChecked(utill.allInfo.spotsflashinglights_chk);
		spotsflashinglights_chk_id.setOnCheckedChangeListener(this);
		glaucoma_chk_id = (CheckBox) view.findViewById(R.id.glaucoma_chk_id);
		glaucoma_chk_id.setChecked(utill.allInfo.glaucoma_chk);
		glaucoma_chk_id.setOnCheckedChangeListener(this);
		cataracts_chk_id = (CheckBox) view.findViewById(R.id.cataracts_chk_id);
		cataracts_chk_id.setChecked(utill.allInfo.cataracts_chk);
		cataracts_chk_id.setOnCheckedChangeListener(this);
		hearingchange_chk_id = (CheckBox) view
				.findViewById(R.id.hearingchange_chk_id);
		hearingchange_chk_id.setChecked(utill.allInfo.hearingchange_chk);
		hearingchange_chk_id.setOnCheckedChangeListener(this);
		ringing_chk_id = (CheckBox) view.findViewById(R.id.ringing_chk_id);
		ringing_chk_id.setChecked(utill.allInfo.ringing_chk);
		ringing_chk_id.setOnCheckedChangeListener(this);
		vertigo_chk_id = (CheckBox) view.findViewById(R.id.vertigo_chk_id);
		vertigo_chk_id.setChecked(utill.allInfo.vertigo_chk);
		vertigo_chk_id.setOnCheckedChangeListener(this);
		earaches_chk_id = (CheckBox) view.findViewById(R.id.earaches_chk_id);
		earaches_chk_id.setChecked(utill.allInfo.earaches_chk);
		earaches_chk_id.setOnCheckedChangeListener(this);
		infection_chk_id = (CheckBox) view.findViewById(R.id.infection_chk_id);
		infection_chk_id.setChecked(utill.allInfo.infection_chk);
		infection_chk_id.setOnCheckedChangeListener(this);
		frequentcold_chk_id = (CheckBox) view
				.findViewById(R.id.frequentcold_chk_id);
		frequentcold_chk_id.setChecked(utill.allInfo.frequentcold_chk);
		frequentcold_chk_id.setOnCheckedChangeListener(this);
		nasalcongestion_chk_id = (CheckBox) view
				.findViewById(R.id.nasalcongestion_chk_id);
		nasalcongestion_chk_id.setChecked(utill.allInfo.nasalcongestion_chk);
		nasalcongestion_chk_id.setOnCheckedChangeListener(this);
		discharge_chk_id = (CheckBox) view.findViewById(R.id.discharge_chk_id);
		discharge_chk_id.setChecked(utill.allInfo.discharge_chk);
		discharge_chk_id.setOnCheckedChangeListener(this);
		hayfever_chk_id = (CheckBox) view.findViewById(R.id.hayfever_chk_id);
		hayfever_chk_id.setChecked(utill.allInfo.hayfever_chk);
		hayfever_chk_id.setOnCheckedChangeListener(this);
		nosebleed_chk_id = (CheckBox) view.findViewById(R.id.nosebleed_chk_id);
		nosebleed_chk_id.setChecked(utill.allInfo.nosebleed_chk);
		nosebleed_chk_id.setOnCheckedChangeListener(this);
		sinus_chk_id = (CheckBox) view.findViewById(R.id.sinus_chk_id);
		sinus_chk_id.setChecked(utill.allInfo.sinus_chk);
		sinus_chk_id.setOnCheckedChangeListener(this);
		lumpsneck_chk_id = (CheckBox) view.findViewById(R.id.lumpsneck_chk_id);
		lumpsneck_chk_id.setChecked(utill.allInfo.lumpsneck_chk);
		lumpsneck_chk_id.setOnCheckedChangeListener(this);
		swollenglands_chk_id = (CheckBox) view
				.findViewById(R.id.swollenglands_chk_id);
		swollenglands_chk_id.setChecked(utill.allInfo.swollenglands_chk);
		swollenglands_chk_id.setOnCheckedChangeListener(this);
		goiter_chk_id = (CheckBox) view.findViewById(R.id.goiter_chk_id);
		goiter_chk_id.setChecked(utill.allInfo.goiter_chk);
		goiter_chk_id.setOnCheckedChangeListener(this);
		painneck_chk_id = (CheckBox) view.findViewById(R.id.painneck_chk_id);
		painneck_chk_id.setChecked(utill.allInfo.painneck_chk);
		painneck_chk_id.setOnCheckedChangeListener(this);
		cough_chk_id = (CheckBox) view.findViewById(R.id.cough_chk_id);
		cough_chk_id.setChecked(utill.allInfo.cough_chk);
		cough_chk_id.setOnCheckedChangeListener(this);
		coughingblood_chk_id = (CheckBox) view
				.findViewById(R.id.coughingblood_chk_id);
		coughingblood_chk_id.setChecked(utill.allInfo.coughingblood_chk);
		coughingblood_chk_id.setOnCheckedChangeListener(this);
		shortnessbreath_chk_id = (CheckBox) view
				.findViewById(R.id.shortnessbreath_chk_id);
		shortnessbreath_chk_id.setChecked(utill.allInfo.shortnessbreath_chk);
		shortnessbreath_chk_id.setOnCheckedChangeListener(this);
		wheezing_chk_id = (CheckBox) view.findViewById(R.id.wheezing_chk_id);
		wheezing_chk_id.setChecked(utill.allInfo.wheezing_chk);
		wheezing_chk_id.setOnCheckedChangeListener(this);
		sleepapnea_chk_id = (CheckBox) view
				.findViewById(R.id.sleepapnea_chk_id);
		sleepapnea_chk_id.setChecked(utill.allInfo.sleepapnea_chk);
		sleepapnea_chk_id.setOnCheckedChangeListener(this);
		troublebreathing_chk_id = (CheckBox) view
				.findViewById(R.id.troublebreathing_chk_id);
		troublebreathing_chk_id.setChecked(utill.allInfo.troublebreathing_chk);
		troublebreathing_chk_id.setOnCheckedChangeListener(this);
		dentalproblems_chk_id = (CheckBox) view
				.findViewById(R.id.dentalproblems_chk_id);
		dentalproblems_chk_id.setChecked(utill.allInfo.dentalproblems_chk);
		dentalproblems_chk_id.setOnCheckedChangeListener(this);
		soretongue_chk_id = (CheckBox) view
				.findViewById(R.id.soretongue_chk_id);
		soretongue_chk_id.setChecked(utill.allInfo.soretongue_chk);
		soretongue_chk_id.setOnCheckedChangeListener(this);
		drymouth_chk_id = (CheckBox) view.findViewById(R.id.drymouth_chk_id);
		drymouth_chk_id.setChecked(utill.allInfo.drymouth_chk);
		drymouth_chk_id.setOnCheckedChangeListener(this);
		freqsorethroat_chk_id = (CheckBox) view
				.findViewById(R.id.freqsorethroat_chk_id);
		freqsorethroat_chk_id.setChecked(utill.allInfo.freqsorethroat_chk);
		freqsorethroat_chk_id.setOnCheckedChangeListener(this);
		hoarseness_chk_id = (CheckBox) view
				.findViewById(R.id.hoarseness_chk_id);
		hoarseness_chk_id.setChecked(utill.allInfo.hoarseness_chk);
		hoarseness_chk_id.setOnCheckedChangeListener(this);
		chestpain_chk_id = (CheckBox) view.findViewById(R.id.chestpain_chk_id);
		chestpain_chk_id.setChecked(utill.allInfo.chestpain_chk);
		chestpain_chk_id.setOnCheckedChangeListener(this);
		highbloodpressure_chk_id = (CheckBox) view
				.findViewById(R.id.highbloodpressure_chk_id);
		highbloodpressure_chk_id
				.setChecked(utill.allInfo.highbloodpressure_chk);
		highbloodpressure_chk_id.setOnCheckedChangeListener(this);
		murmus_chk_id = (CheckBox) view.findViewById(R.id.murmus_chk_id);
		murmus_chk_id.setChecked(utill.allInfo.murmus_chk);
		murmus_chk_id.setOnCheckedChangeListener(this);
		rheumaticfever_chk_id = (CheckBox) view
				.findViewById(R.id.rheumaticfever_chk_id);
		rheumaticfever_chk_id.setChecked(utill.allInfo.rheumaticfever_chk);
		rheumaticfever_chk_id.setOnCheckedChangeListener(this);
		palpitations_chk_id = (CheckBox) view
				.findViewById(R.id.palpitations_chk_id);
		palpitations_chk_id.setChecked(utill.allInfo.palpitations_chk);
		palpitations_chk_id.setOnCheckedChangeListener(this);
		difficultyswallow_chk_id = (CheckBox) view
				.findViewById(R.id.difficultyswallow_chk_id);
		difficultyswallow_chk_id
				.setChecked(utill.allInfo.difficultyswallow_chk);
		difficultyswallow_chk_id.setOnCheckedChangeListener(this);
		heartburn_chk_id = (CheckBox) view.findViewById(R.id.heartburn_chk_id);
		heartburn_chk_id.setChecked(utill.allInfo.heartburn_chk);
		heartburn_chk_id.setOnCheckedChangeListener(this);
		nauseavomit_chk_id = (CheckBox) view
				.findViewById(R.id.nauseavomit_chk_id);
		nauseavomit_chk_id.setChecked(utill.allInfo.nauseavomit_chk);
		nauseavomit_chk_id.setOnCheckedChangeListener(this);
		regurgitation_chk_id = (CheckBox) view
				.findViewById(R.id.regurgitation_chk_id);
		regurgitation_chk_id.setChecked(utill.allInfo.regurgitation_chk);
		regurgitation_chk_id.setOnCheckedChangeListener(this);
		vomitingblood_chk_id = (CheckBox) view
				.findViewById(R.id.vomitingblood_chk_id);
		vomitingblood_chk_id.setChecked(utill.allInfo.vomitingblood_chk);
		vomitingblood_chk_id.setOnCheckedChangeListener(this);
		indigestion_chk_id = (CheckBox) view
				.findViewById(R.id.indigestion_chk_id);
		indigestion_chk_id.setChecked(utill.allInfo.indigestion_chk);
		indigestion_chk_id.setOnCheckedChangeListener(this);
		rectalbleeding_chk_id = (CheckBox) view
				.findViewById(R.id.rectalbleeding_chk_id);
		rectalbleeding_chk_id.setChecked(utill.allInfo.rectalbleeding_chk);
		rectalbleeding_chk_id.setOnCheckedChangeListener(this);
		blacktarrystools_chk_id = (CheckBox) view
				.findViewById(R.id.blacktarrystools_chk_id);
		blacktarrystools_chk_id.setChecked(utill.allInfo.blacktarrystools_chk);
		blacktarrystools_chk_id.setOnCheckedChangeListener(this);
		hemorrhoids_chk_id = (CheckBox) view
				.findViewById(R.id.hemorrhoids_chk_id);
		hemorrhoids_chk_id.setChecked(utill.allInfo.hemorrhoids_chk);
		hemorrhoids_chk_id.setOnCheckedChangeListener(this);
		constipation_chk_id = (CheckBox) view
				.findViewById(R.id.constipation_chk_id);
		constipation_chk_id.setChecked(utill.allInfo.constipation_chk);
		constipation_chk_id.setOnCheckedChangeListener(this);
		diarrhea_chk_id = (CheckBox) view.findViewById(R.id.diarrhea_chk_id);
		diarrhea_chk_id.setChecked(utill.allInfo.diarrhea_chk);
		diarrhea_chk_id.setOnCheckedChangeListener(this);
		abdominal_chk_id = (CheckBox) view.findViewById(R.id.abdominal_chk_id);
		abdominal_chk_id.setChecked(utill.allInfo.abdominal_chk);
		abdominal_chk_id.setOnCheckedChangeListener(this);
		foodintolerance_chk_id = (CheckBox) view
				.findViewById(R.id.foodintolerance_chk_id);
		foodintolerance_chk_id.setChecked(utill.allInfo.foodintolerance_chk);
		foodintolerance_chk_id.setOnCheckedChangeListener(this);
		excessivebelchgas_chk_id = (CheckBox) view
				.findViewById(R.id.excessivebelchgas_chk_id);
		excessivebelchgas_chk_id
				.setChecked(utill.allInfo.excessivebelchgas_chk);
		excessivebelchgas_chk_id.setOnCheckedChangeListener(this);
		yellowingskin_chk_id = (CheckBox) view
				.findViewById(R.id.yellowingskin_chk_id);
		yellowingskin_chk_id.setChecked(utill.allInfo.yellowingskin_chk);
		yellowingskin_chk_id.setOnCheckedChangeListener(this);
		livergallbladderprobs_chk_id = (CheckBox) view
				.findViewById(R.id.livergallbladderprobs_chk_id);
		livergallbladderprobs_chk_id
				.setChecked(utill.allInfo.livergallbladderprobs_chk);
		livergallbladderprobs_chk_id.setOnCheckedChangeListener(this);
		hepatitis_chk_id = (CheckBox) view.findViewById(R.id.hepatitis_chk_id);
		hepatitis_chk_id.setChecked(utill.allInfo.hepatitis_chk);
		hepatitis_chk_id.setOnCheckedChangeListener(this);
		bladderinfection_chk_id = (CheckBox) view
				.findViewById(R.id.bladderinfection_chk_id);
		bladderinfection_chk_id.setChecked(utill.allInfo.bladderinfection_chk);
		bladderinfection_chk_id.setOnCheckedChangeListener(this);
		urinaryfrequrgency_chk_id = (CheckBox) view
				.findViewById(R.id.urinaryfrequrgency_chk_id);
		urinaryfrequrgency_chk_id
				.setChecked(utill.allInfo.urinaryfrequrgency_chk);
		urinaryfrequrgency_chk_id.setOnCheckedChangeListener(this);
		bloodurine_chk_id = (CheckBox) view
				.findViewById(R.id.bloodurine_chk_id);
		bloodurine_chk_id.setChecked(utill.allInfo.bloodurine_chk);
		bloodurine_chk_id.setOnCheckedChangeListener(this);
		painfulurination_chk_id = (CheckBox) view
				.findViewById(R.id.painfulurination_chk_id);
		painfulurination_chk_id.setChecked(utill.allInfo.painfulurination_chk);
		painfulurination_chk_id.setOnCheckedChangeListener(this);
		dribblingstream_chk_id = (CheckBox) view
				.findViewById(R.id.dribblingstream_chk_id);
		dribblingstream_chk_id.setChecked(utill.allInfo.dribblingstream_chk);
		dribblingstream_chk_id.setOnCheckedChangeListener(this);
		reducedforcestream_chk_id = (CheckBox) view
				.findViewById(R.id.reducedforcestream_chk_id);
		reducedforcestream_chk_id
				.setChecked(utill.allInfo.reducedforcestream_chk);
		reducedforcestream_chk_id.setOnCheckedChangeListener(this);
		hesitancy_chk_id = (CheckBox) view.findViewById(R.id.hesitancy_chk_id);
		hesitancy_chk_id.setChecked(utill.allInfo.hesitancy_chk);
		hesitancy_chk_id.setOnCheckedChangeListener(this);
		incontinence_chk_id = (CheckBox) view
				.findViewById(R.id.incontinence_chk_id);
		incontinence_chk_id.setChecked(utill.allInfo.incontinence_chk);
		incontinence_chk_id.setOnCheckedChangeListener(this);
		bladderkidneystone_chk_id = (CheckBox) view
				.findViewById(R.id.bladderkidneystone_chk_id);
		bladderkidneystone_chk_id
				.setChecked(utill.allInfo.bladderkidneystone_chk);
		bladderkidneystone_chk_id.setOnCheckedChangeListener(this);
		irregularmenses_chk_id = (CheckBox) view
				.findViewById(R.id.irregularmenses_chk_id);
		irregularmenses_chk_id.setChecked(utill.allInfo.irregularmenses_chk);
		irregularmenses_chk_id.setOnCheckedChangeListener(this);
		breakthroughbleeding_chk_id = (CheckBox) view
				.findViewById(R.id.breakthroughbleeding_chk_id);
		breakthroughbleeding_chk_id
				.setChecked(utill.allInfo.breakthroughbleeding_chk);
		breakthroughbleeding_chk_id.setOnCheckedChangeListener(this);
		painfulmenses_chk_id = (CheckBox) view
				.findViewById(R.id.painfulmenses_chk_id);
		painfulmenses_chk_id.setChecked(utill.allInfo.painfulmenses_chk);
		painfulmenses_chk_id.setOnCheckedChangeListener(this);
		pms_chk_id = (CheckBox) view.findViewById(R.id.pms_chk_id);
		pms_chk_id.setChecked(utill.allInfo.pms_chk);
		pms_chk_id.setOnCheckedChangeListener(this);
		vaginaldischargeitch_chk_id = (CheckBox) view
				.findViewById(R.id.vaginaldischargeitch_chk_id);
		vaginaldischargeitch_chk_id
				.setChecked(utill.allInfo.vaginaldischargeitch_chk);
		vaginaldischargeitch_chk_id.setOnCheckedChangeListener(this);
		vaginalsorelumpsSTD_chk_id = (CheckBox) view
				.findViewById(R.id.vaginalsorelumpsSTD_chk_id);
		vaginalsorelumpsSTD_chk_id
				.setChecked(utill.allInfo.vaginalsorelumpsSTD_chk);
		vaginalsorelumpsSTD_chk_id.setOnCheckedChangeListener(this);
		menopausal_chk_id = (CheckBox) view
				.findViewById(R.id.menopausal_chk_id);
		menopausal_chk_id.setChecked(utill.allInfo.menopausal_chk);
		menopausal_chk_id.setOnCheckedChangeListener(this);
		postmenopausalbleeding_chk_id = (CheckBox) view
				.findViewById(R.id.postmenopausalbleeding_chk_id);
		postmenopausalbleeding_chk_id
				.setChecked(utill.allInfo.postmenopausalbleeding_chk);
		postmenopausalbleeding_chk_id.setOnCheckedChangeListener(this);
		hernias_chk_id = (CheckBox) view.findViewById(R.id.hernias_chk_id);
		hernias_chk_id.setChecked(utill.allInfo.hernias_chk);
		hernias_chk_id.setOnCheckedChangeListener(this);
		dischargessorespeni_chk_id = (CheckBox) view
				.findViewById(R.id.dischargessorespeni_chk_id);
		dischargessorespeni_chk_id
				.setChecked(utill.allInfo.dischargessorespeni_chk);
		dischargessorespeni_chk_id.setOnCheckedChangeListener(this);
		testicularpainmasses_chk_id = (CheckBox) view
				.findViewById(R.id.testicularpainmasses_chk_id);
		testicularpainmasses_chk_id
				.setChecked(utill.allInfo.testicularpainmasses_chk);
		testicularpainmasses_chk_id.setOnCheckedChangeListener(this);
		std_chk_id = (CheckBox) view.findViewById(R.id.std_chk_id);
		std_chk_id.setChecked(utill.allInfo.std_chk);
		std_chk_id.setOnCheckedChangeListener(this);
		musclepain_chk_id = (CheckBox) view
				.findViewById(R.id.musclepain_chk_id);
		musclepain_chk_id.setChecked(utill.allInfo.musclepain_chk);
		musclepain_chk_id.setOnCheckedChangeListener(this);
		stiffness_chk_id = (CheckBox) view.findViewById(R.id.stiffness_chk_id);
		stiffness_chk_id.setChecked(utill.allInfo.stiffness_chk);
		stiffness_chk_id.setOnCheckedChangeListener(this);
		arthritis_chk_id = (CheckBox) view.findViewById(R.id.arthritis_chk_id);
		arthritis_chk_id.setChecked(utill.allInfo.arthritis_chk);
		arthritis_chk_id.setOnCheckedChangeListener(this);
		gout_chk_id = (CheckBox) view.findViewById(R.id.gout_chk_id);
		gout_chk_id.setChecked(utill.allInfo.gout_chk);
		gout_chk_id.setOnCheckedChangeListener(this);
		backache_chk_id = (CheckBox) view.findViewById(R.id.backache_chk_id);
		backache_chk_id.setChecked(utill.allInfo.backache_chk);
		backache_chk_id.setOnCheckedChangeListener(this);
		fainting_chk_id = (CheckBox) view.findViewById(R.id.fainting_chk_id);
		fainting_chk_id.setChecked(utill.allInfo.fainting_chk);
		fainting_chk_id.setOnCheckedChangeListener(this);
		blackouts_chk_id = (CheckBox) view.findViewById(R.id.blackouts_chk_id);
		blackouts_chk_id.setChecked(utill.allInfo.blackouts_chk);
		blackouts_chk_id.setOnCheckedChangeListener(this);
		seizures_chk_id = (CheckBox) view.findViewById(R.id.seizures_chk_id);
		seizures_chk_id.setChecked(utill.allInfo.seizures_chk);
		seizures_chk_id.setOnCheckedChangeListener(this);
		weaknessparalysis_chk_id = (CheckBox) view
				.findViewById(R.id.weaknessparalysis_chk_id);
		weaknessparalysis_chk_id
				.setChecked(utill.allInfo.weaknessparalysis_chk);
		weaknessparalysis_chk_id.setOnCheckedChangeListener(this);
		numbnessloss_chk_id = (CheckBox) view
				.findViewById(R.id.numbnessloss_chk_id);
		numbnessloss_chk_id.setChecked(utill.allInfo.numbnessloss_chk);
		numbnessloss_chk_id.setOnCheckedChangeListener(this);
		tingling_chk_id = (CheckBox) view.findViewById(R.id.tingling_chk_id);
		tingling_chk_id.setChecked(utill.allInfo.tingling_chk);
		tingling_chk_id.setOnCheckedChangeListener(this);
		tremors_chk_id = (CheckBox) view.findViewById(R.id.tremors_chk_id);
		tremors_chk_id.setChecked(utill.allInfo.tremors_chk);
		tremors_chk_id.setOnCheckedChangeListener(this);
		memoryloss_chk_id = (CheckBox) view
				.findViewById(R.id.memoryloss_chk_id);
		memoryloss_chk_id.setChecked(utill.allInfo.memoryloss_chk);
		memoryloss_chk_id.setOnCheckedChangeListener(this);
		trouble_chk_id = (CheckBox) view.findViewById(R.id.trouble_chk_id);
		trouble_chk_id.setChecked(utill.allInfo.trouble_chk);
		trouble_chk_id.setOnCheckedChangeListener(this);
		rasheslumpssores_chk_id = (CheckBox) view
				.findViewById(R.id.rasheslumpssores_chk_id);
		rasheslumpssores_chk_id.setChecked(utill.allInfo.rasheslumpssores_chk);
		rasheslumpssores_chk_id.setOnCheckedChangeListener(this);
		itchingdryness_chk_id = (CheckBox) view
				.findViewById(R.id.itchingdryness_chk_id);
		itchingdryness_chk_id.setChecked(utill.allInfo.itchingdryness_chk);
		itchingdryness_chk_id.setOnCheckedChangeListener(this);
		colorchange_chk_id = (CheckBox) view
				.findViewById(R.id.colorchange_chk_id);
		colorchange_chk_id.setChecked(utill.allInfo.colorchange_chk);
		colorchange_chk_id.setOnCheckedChangeListener(this);
		changehairnails_chk_id = (CheckBox) view
				.findViewById(R.id.changehairnails_chk_id);
		changehairnails_chk_id.setChecked(utill.allInfo.changehairnails_chk);
		changehairnails_chk_id.setOnCheckedChangeListener(this);
		breastlumps_chk_id = (CheckBox) view
				.findViewById(R.id.breastlumps_chk_id);
		breastlumps_chk_id.setChecked(utill.allInfo.breastlumps_chk);
		breastlumps_chk_id.setOnCheckedChangeListener(this);
		breastpain_chk_id = (CheckBox) view
				.findViewById(R.id.breastpain_chk_id);
		breastpain_chk_id.setChecked(utill.allInfo.breastpain_chk);
		breastpain_chk_id.setOnCheckedChangeListener(this);
		nippledischarge_chk_id = (CheckBox) view
				.findViewById(R.id.nippledischarge_chk_id);
		nippledischarge_chk_id.setChecked(utill.allInfo.nippledischarge_chk);
		nippledischarge_chk_id.setOnCheckedChangeListener(this);
		thyroidproblems_chk_id = (CheckBox) view
				.findViewById(R.id.thyroidproblems_chk_id);
		thyroidproblems_chk_id.setChecked(utill.allInfo.thyroidproblems_chk);
		thyroidproblems_chk_id.setOnCheckedChangeListener(this);
		heatcoldintolerance_chk_id = (CheckBox) view
				.findViewById(R.id.heatcoldintolerance_chk_id);
		heatcoldintolerance_chk_id
				.setChecked(utill.allInfo.heatcoldintolerance_chk);
		heatcoldintolerance_chk_id.setOnCheckedChangeListener(this);
		excessivesweating_chk_id = (CheckBox) view
				.findViewById(R.id.excessivesweating_chk_id);
		excessivesweating_chk_id
				.setChecked(utill.allInfo.excessivesweating_chk);
		excessivesweating_chk_id.setOnCheckedChangeListener(this);
		diabetes_chk_id = (CheckBox) view.findViewById(R.id.diabetes_chk_id);
		diabetes_chk_id.setChecked(utill.allInfo.diabetes_chk);
		diabetes_chk_id.setOnCheckedChangeListener(this);
		excessivethirsthunger_chk_id = (CheckBox) view
				.findViewById(R.id.excessivethirsthunger_chk_id);
		excessivethirsthunger_chk_id
				.setChecked(utill.allInfo.excessivethirsthunger_chk);
		excessivethirsthunger_chk_id.setOnCheckedChangeListener(this);
		frequenturination_chk_id = (CheckBox) view
				.findViewById(R.id.frequenturination_chk_id);
		frequenturination_chk_id
				.setChecked(utill.allInfo.frequenturination_chk);
		frequenturination_chk_id.setOnCheckedChangeListener(this);
		anemia_chk_id = (CheckBox) view.findViewById(R.id.anemia_chk_id);
		anemia_chk_id.setChecked(utill.allInfo.anemia_chk);
		anemia_chk_id.setOnCheckedChangeListener(this);
		easybruisingbleeding_chk_id = (CheckBox) view
				.findViewById(R.id.easybruisingbleeding_chk_id);
		easybruisingbleeding_chk_id
				.setChecked(utill.allInfo.easybruisingbleeding_chk);
		easybruisingbleeding_chk_id.setOnCheckedChangeListener(this);
		pasttransfusion_chk_id = (CheckBox) view
				.findViewById(R.id.pasttransfusion_chk_id);
		pasttransfusion_chk_id.setChecked(utill.allInfo.pasttransfusion_chk);
		pasttransfusion_chk_id.setOnCheckedChangeListener(this);
		intermittent_chk_id = (CheckBox) view
				.findViewById(R.id.intermittent_chk_id);
		intermittent_chk_id.setChecked(utill.allInfo.intermittent_chk);
		intermittent_chk_id.setOnCheckedChangeListener(this);
		leg_chk_id = (CheckBox) view.findViewById(R.id.leg_chk_id);
		leg_chk_id.setChecked(utill.allInfo.leg_chk);
		leg_chk_id.setOnCheckedChangeListener(this);
		varicose_chk_id = (CheckBox) view.findViewById(R.id.varicose_chk_id);
		varicose_chk_id.setChecked(utill.allInfo.varicose_chk);
		varicose_chk_id.setOnCheckedChangeListener(this);
		past_chk_id = (CheckBox) view.findViewById(R.id.past_chk_id);
		past_chk_id.setChecked(utill.allInfo.past_chk);
		past_chk_id.setOnCheckedChangeListener(this);
		nervousness_chk_id = (CheckBox) view
				.findViewById(R.id.nervousness_chk_id);
		nervousness_chk_id.setChecked(utill.allInfo.nervousness_chk);
		nervousness_chk_id.setOnCheckedChangeListener(this);
		tension_chk_id = (CheckBox) view.findViewById(R.id.tension_chk_id);
		tension_chk_id.setChecked(utill.allInfo.tension_chk);
		tension_chk_id.setOnCheckedChangeListener(this);
		depression_chk_id = (CheckBox) view
				.findViewById(R.id.depression_chk_id);
		depression_chk_id.setChecked(utill.allInfo.depression_chk);
		depression_chk_id.setOnCheckedChangeListener(this);
		insomnia_chk_id = (CheckBox) view.findViewById(R.id.insomnia_chk_id);
		insomnia_chk_id.setChecked(utill.allInfo.insomnia_chk);
		insomnia_chk_id.setOnCheckedChangeListener(this);
		defect_chk_id = (CheckBox) view.findViewById(R.id.defect_chk_id);
		defect_chk_id.setChecked(utill.allInfo.defect_chk);
		defect_chk_id.setOnCheckedChangeListener(this);
		diseasecolon_chk_id = (CheckBox) view
				.findViewById(R.id.diseasecolon_chk_id);
		diseasecolon_chk_id.setChecked(utill.allInfo.diseasecolon_chk);
		diseasecolon_chk_id.setOnCheckedChangeListener(this);
		kidneyd_chk_id = (CheckBox) view.findViewById(R.id.kidneyd_chk_id);
		kidneyd_chk_id.setChecked(utill.allInfo.kidneyd_chk);
		kidneyd_chk_id.setOnCheckedChangeListener(this);
		hearttrb_chk_id = (CheckBox) view.findViewById(R.id.hearttrb_chk_id);
		hearttrb_chk_id.setChecked(utill.allInfo.hearttrb_chk);
		hearttrb_chk_id.setOnCheckedChangeListener(this);
		lifethreatcondition_chk_id = (CheckBox) view
				.findViewById(R.id.lifethreatcondition_chk_id);
		lifethreatcondition_chk_id
				.setChecked(utill.allInfo.lifethreatcondition_chk);
		lifethreatcondition_chk_id.setOnCheckedChangeListener(this);
		energy_id = (Spinner) view.findViewById(R.id.energy_id);
		hrs_id = (EditText) view.findViewById(R.id.hrs_id);
		hrs_id.setFilters(new InputFilter[] { new InputFilterMinMax("1", "24") });
		hrs_id.setText(utill.allInfo.hrs_read);
		times_id = (EditText) view.findViewById(R.id.times_id);
		times_id.setFilters(new InputFilter[] { new InputFilterMinMax("1", "7") });
		times_id.setText(utill.allInfo.days_week);

		if (utill.allInfo.dowakerested_chk.equals("Y"))
			((RadioButton) view.findViewById(R.id.dowakeyes_id))
					.setChecked(true);
		else if (utill.allInfo.dowakerested_chk.equals("N"))
			((RadioButton) view.findViewById(R.id.dowakeno_id))
					.setChecked(true);
		((RadioButton) view.findViewById(R.id.dowakeyes_id))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked)
							utill.allInfo.dowakerested_chk = "Y";
					}
				});
		((RadioButton) view.findViewById(R.id.dowakeno_id))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked)
							utill.allInfo.dowakerested_chk = "N";
					}
				});

		if (utill.allInfo.doexercise_chk.equals("Y"))
			((RadioButton) view.findViewById(R.id.doexerciseyes_id))
					.setChecked(true);
		else if (utill.allInfo.doexercise_chk.equals("N"))
			((RadioButton) view.findViewById(R.id.doexerciseno_id))
					.setChecked(true);
		((RadioButton) view.findViewById(R.id.doexerciseyes_id))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked)
							utill.allInfo.doexercise_chk = "Y";
					}
				});
		((RadioButton) view.findViewById(R.id.doexerciseno_id))
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked)
							utill.allInfo.doexercise_chk = "N";
					}
				});

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

				// if (position > 0)
				// {
				utill.allInfo.energy = main.getItemAtPosition(position)
						.toString();
				// }
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

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

		recdrug_yes_chk_id = (RadioButton) view
				.findViewById(R.id.recdrug_yes_chk_id);
		if (utill.allInfo.is_recdrug == 1)
			recdrug_yes_chk_id.setChecked(true);
		recdrug_yes_chk_id
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked)
							utill.allInfo.is_recdrug = 1;
					}
				});
		recdrug_no_chk_id = (RadioButton) view
				.findViewById(R.id.recdrug_no_chk_id);
		if (utill.allInfo.is_recdrug == 0)
			recdrug_no_chk_id.setChecked(true);
		recdrug_no_chk_id
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked)
							utill.allInfo.is_recdrug = 0;
					}
				});
		recdrug_past_chk_id = (RadioButton) view
				.findViewById(R.id.recdrug_past_chk_id);
		if (utill.allInfo.is_recdrug == 2)
			recdrug_past_chk_id.setChecked(true);
		recdrug_past_chk_id
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked)
							utill.allInfo.is_recdrug = 2;
					}
				});
		return view;
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		switch (buttonView.getId()) {
		case R.id.weightchng_chk_id:
			if (isChecked)
				utill.allInfo.weightchng_chk = true;
			else
				utill.allInfo.weightchng_chk = false;
			break;
		case R.id.weakness_chk_id:
			if (isChecked)
				utill.allInfo.weakness_chk = true;
			else
				utill.allInfo.weakness_chk = false;
			break;
		case R.id.fatigue_chk_id:
			if (isChecked)
				utill.allInfo.fatigue_chk = true;
			else
				utill.allInfo.fatigue_chk = false;
			break;
		case R.id.fever_chk_id:
			if (isChecked)
				utill.allInfo.fever_chk = true;
			else
				utill.allInfo.fever_chk = false;
			break;
		case R.id.cancer_chk_id:
			if (isChecked)
				utill.allInfo.cancer_chk = true;
			else
				utill.allInfo.cancer_chk = false;
			break;
		case R.id.headache_chk_id:
			if (isChecked)
				utill.allInfo.headache_chk = true;
			else
				utill.allInfo.headache_chk = false;
			break;
		case R.id.headinjury_chk_id:
			if (isChecked)
				utill.allInfo.headinjury_chk = true;
			else
				utill.allInfo.headinjury_chk = false;
			break;
		case R.id.dizziness_chk_id:
			if (isChecked)
				utill.allInfo.dizziness_chk = true;
			else
				utill.allInfo.dizziness_chk = false;
			break;
		case R.id.lightheadedness_chk_id:
			if (isChecked)
				utill.allInfo.lightheadedness_chk = true;
			else
				utill.allInfo.lightheadedness_chk = false;
			break;
		case R.id.visionchange_chk_id:
			if (isChecked)
				utill.allInfo.visionchange_chk = true;
			else
				utill.allInfo.visionchange_chk = false;
			break;
		case R.id.eyepain_chk_id:
			if (isChecked)
				utill.allInfo.eyepain_chk = true;
			else
				utill.allInfo.eyepain_chk = false;
			break;
		case R.id.doublevision_chk_id:
			if (isChecked)
				utill.allInfo.doublevision_chk = true;
			else
				utill.allInfo.doublevision_chk = false;
			break;
		case R.id.spotsflashinglights_chk_id:
			if (isChecked)
				utill.allInfo.spotsflashinglights_chk = true;
			else
				utill.allInfo.spotsflashinglights_chk = false;
			break;
		case R.id.glaucoma_chk_id:
			if (isChecked)
				utill.allInfo.glaucoma_chk = true;
			else
				utill.allInfo.glaucoma_chk = false;
			break;
		case R.id.cataracts_chk_id:
			if (isChecked)
				utill.allInfo.cataracts_chk = true;
			else
				utill.allInfo.cataracts_chk = false;
			break;
		case R.id.hearingchange_chk_id:
			if (isChecked)
				utill.allInfo.hearingchange_chk = true;
			else
				utill.allInfo.hearingchange_chk = false;
			break;
		case R.id.ringing_chk_id:
			if (isChecked)
				utill.allInfo.ringing_chk = true;
			else
				utill.allInfo.ringing_chk = false;
			break;
		case R.id.vertigo_chk_id:
			if (isChecked)
				utill.allInfo.vertigo_chk = true;
			else
				utill.allInfo.vertigo_chk = false;
			break;
		case R.id.earaches_chk_id:
			if (isChecked)
				utill.allInfo.earaches_chk = true;
			else
				utill.allInfo.earaches_chk = false;
			break;
		case R.id.infection_chk_id:
			if (isChecked)
				utill.allInfo.infection_chk = true;
			else
				utill.allInfo.infection_chk = false;
			break;
		case R.id.frequentcold_chk_id:
			if (isChecked)
				utill.allInfo.frequentcold_chk = true;
			else
				utill.allInfo.frequentcold_chk = false;
			break;
		case R.id.nasalcongestion_chk_id:
			if (isChecked)
				utill.allInfo.nasalcongestion_chk = true;
			else
				utill.allInfo.nasalcongestion_chk = false;
			break;
		case R.id.discharge_chk_id:
			if (isChecked)
				utill.allInfo.discharge_chk = true;
			else
				utill.allInfo.discharge_chk = false;
			break;
		case R.id.hayfever_chk_id:
			if (isChecked)
				utill.allInfo.hayfever_chk = true;
			else
				utill.allInfo.hayfever_chk = false;
			break;
		case R.id.nosebleed_chk_id:
			if (isChecked)
				utill.allInfo.nosebleed_chk = true;
			else
				utill.allInfo.nosebleed_chk = false;
			break;
		case R.id.sinus_chk_id:
			if (isChecked)
				utill.allInfo.sinus_chk = true;
			else
				utill.allInfo.sinus_chk = false;
			break;
		case R.id.lumpsneck_chk_id:
			if (isChecked)
				utill.allInfo.lumpsneck_chk = true;
			else
				utill.allInfo.lumpsneck_chk = false;
			break;
		case R.id.swollenglands_chk_id:
			if (isChecked)
				utill.allInfo.swollenglands_chk = true;
			else
				utill.allInfo.swollenglands_chk = false;
			break;
		case R.id.goiter_chk_id:
			if (isChecked)
				utill.allInfo.goiter_chk = true;
			else
				utill.allInfo.goiter_chk = false;
			break;
		case R.id.painneck_chk_id:
			if (isChecked)
				utill.allInfo.painneck_chk = true;
			else
				utill.allInfo.painneck_chk = false;
			break;
		case R.id.cough_chk_id:
			if (isChecked)
				utill.allInfo.cough_chk = true;
			else
				utill.allInfo.cough_chk = false;
			break;
		case R.id.coughingblood_chk_id:
			if (isChecked)
				utill.allInfo.coughingblood_chk = true;
			else
				utill.allInfo.coughingblood_chk = false;
			break;
		case R.id.shortnessbreath_chk_id:
			if (isChecked)
				utill.allInfo.shortnessbreath_chk = true;
			else
				utill.allInfo.shortnessbreath_chk = false;
			break;
		case R.id.wheezing_chk_id:
			if (isChecked)
				utill.allInfo.wheezing_chk = true;
			else
				utill.allInfo.wheezing_chk = false;
			break;
		case R.id.sleepapnea_chk_id:
			if (isChecked)
				utill.allInfo.sleepapnea_chk = true;
			else
				utill.allInfo.sleepapnea_chk = false;
			break;
		case R.id.troublebreathing_chk_id:
			if (isChecked)
				utill.allInfo.troublebreathing_chk = true;
			else
				utill.allInfo.troublebreathing_chk = false;
			break;
		case R.id.dentalproblems_chk_id:
			if (isChecked)
				utill.allInfo.dentalproblems_chk = true;
			else
				utill.allInfo.dentalproblems_chk = false;
			break;
		case R.id.soretongue_chk_id:
			if (isChecked)
				utill.allInfo.soretongue_chk = true;
			else
				utill.allInfo.soretongue_chk = false;
			break;
		case R.id.drymouth_chk_id:
			if (isChecked)
				utill.allInfo.drymouth_chk = true;
			else
				utill.allInfo.drymouth_chk = false;
			break;
		case R.id.freqsorethroat_chk_id:
			if (isChecked)
				utill.allInfo.freqsorethroat_chk = true;
			else
				utill.allInfo.freqsorethroat_chk = false;
			break;
		case R.id.hoarseness_chk_id:
			if (isChecked)
				utill.allInfo.hoarseness_chk = true;
			else
				utill.allInfo.hoarseness_chk = false;
			break;
		case R.id.chestpain_chk_id:
			if (isChecked)
				utill.allInfo.chestpain_chk = true;
			else
				utill.allInfo.chestpain_chk = false;
			break;
		case R.id.highbloodpressure_chk_id:
			if (isChecked)
				utill.allInfo.highbloodpressure_chk = true;
			else
				utill.allInfo.highbloodpressure_chk = false;
			break;
		case R.id.murmus_chk_id:
			if (isChecked)
				utill.allInfo.murmus_chk = true;
			else
				utill.allInfo.murmus_chk = false;
			break;
		case R.id.rheumaticfever_chk_id:
			if (isChecked)
				utill.allInfo.rheumaticfever_chk = true;
			else
				utill.allInfo.rheumaticfever_chk = false;
			break;
		case R.id.palpitations_chk_id:
			if (isChecked)
				utill.allInfo.palpitations_chk = true;
			else
				utill.allInfo.palpitations_chk = false;
			break;
		case R.id.difficultyswallow_chk_id:
			if (isChecked)
				utill.allInfo.difficultyswallow_chk = true;
			else
				utill.allInfo.difficultyswallow_chk = false;
			break;
		case R.id.heartburn_chk_id:
			if (isChecked)
				utill.allInfo.heartburn_chk = true;
			else
				utill.allInfo.heartburn_chk = false;
			break;
		case R.id.nauseavomit_chk_id:
			if (isChecked)
				utill.allInfo.nauseavomit_chk = true;
			else
				utill.allInfo.nauseavomit_chk = false;
			break;
		case R.id.regurgitation_chk_id:
			if (isChecked)
				utill.allInfo.regurgitation_chk = true;
			else
				utill.allInfo.regurgitation_chk = false;
			break;
		case R.id.vomitingblood_chk_id:
			if (isChecked)
				utill.allInfo.vomitingblood_chk = true;
			else
				utill.allInfo.vomitingblood_chk = false;
			break;
		case R.id.indigestion_chk_id:
			if (isChecked)
				utill.allInfo.indigestion_chk = true;
			else
				utill.allInfo.indigestion_chk = false;
			break;
		case R.id.rectalbleeding_chk_id:
			if (isChecked)
				utill.allInfo.rectalbleeding_chk = true;
			else
				utill.allInfo.rectalbleeding_chk = false;
			break;
		case R.id.blacktarrystools_chk_id:
			if (isChecked)
				utill.allInfo.blacktarrystools_chk = true;
			else
				utill.allInfo.blacktarrystools_chk = false;
			break;
		case R.id.hemorrhoids_chk_id:
			if (isChecked)
				utill.allInfo.hemorrhoids_chk = true;
			else
				utill.allInfo.hemorrhoids_chk = false;
			break;
		case R.id.constipation_chk_id:
			if (isChecked)
				utill.allInfo.constipation_chk = true;
			else
				utill.allInfo.constipation_chk = false;
			break;
		case R.id.diarrhea_chk_id:
			if (isChecked)
				utill.allInfo.diarrhea_chk = true;
			else
				utill.allInfo.diarrhea_chk = false;
			break;
		case R.id.abdominal_chk_id:
			if (isChecked)
				utill.allInfo.abdominal_chk = true;
			else
				utill.allInfo.abdominal_chk = false;
			break;
		case R.id.foodintolerance_chk_id:
			if (isChecked)
				utill.allInfo.foodintolerance_chk = true;
			else
				utill.allInfo.foodintolerance_chk = false;
			break;
		case R.id.excessivebelchgas_chk_id:
			if (isChecked)
				utill.allInfo.excessivebelchgas_chk = true;
			else
				utill.allInfo.excessivebelchgas_chk = false;
			break;
		case R.id.yellowingskin_chk_id:
			if (isChecked)
				utill.allInfo.yellowingskin_chk = true;
			else
				utill.allInfo.yellowingskin_chk = false;
			break;
		case R.id.livergallbladderprobs_chk_id:
			if (isChecked)
				utill.allInfo.livergallbladderprobs_chk = true;
			else
				utill.allInfo.livergallbladderprobs_chk = false;
			break;
		case R.id.hepatitis_chk_id:
			if (isChecked)
				utill.allInfo.hepatitis_chk = true;
			else
				utill.allInfo.hepatitis_chk = false;
			break;
		case R.id.bladderinfection_chk_id:
			if (isChecked)
				utill.allInfo.bladderinfection_chk = true;
			else
				utill.allInfo.bladderinfection_chk = false;
			break;
		case R.id.urinaryfrequrgency_chk_id:
			if (isChecked)
				utill.allInfo.urinaryfrequrgency_chk = true;
			else
				utill.allInfo.urinaryfrequrgency_chk = false;
			break;
		case R.id.bloodurine_chk_id:
			if (isChecked)
				utill.allInfo.bloodurine_chk = true;
			else
				utill.allInfo.bloodurine_chk = false;
			break;
		case R.id.painfulurination_chk_id:
			if (isChecked)
				utill.allInfo.painfulurination_chk = true;
			else
				utill.allInfo.painfulurination_chk = false;
			break;
		case R.id.dribblingstream_chk_id:
			if (isChecked)
				utill.allInfo.dribblingstream_chk = true;
			else
				utill.allInfo.dribblingstream_chk = false;
			break;
		case R.id.reducedforcestream_chk_id:
			if (isChecked)
				utill.allInfo.reducedforcestream_chk = true;
			else
				utill.allInfo.reducedforcestream_chk = false;
			break;
		case R.id.hesitancy_chk_id:
			if (isChecked)
				utill.allInfo.hesitancy_chk = true;
			else
				utill.allInfo.hesitancy_chk = false;
			break;
		case R.id.incontinence_chk_id:
			if (isChecked)
				utill.allInfo.incontinence_chk = true;
			else
				utill.allInfo.incontinence_chk = false;
			break;
		case R.id.bladderkidneystone_chk_id:
			if (isChecked)
				utill.allInfo.bladderkidneystone_chk = true;
			else
				utill.allInfo.bladderkidneystone_chk = false;
			break;
		case R.id.irregularmenses_chk_id:
			if (isChecked)
				utill.allInfo.irregularmenses_chk = true;
			else
				utill.allInfo.irregularmenses_chk = false;
			break;
		case R.id.breakthroughbleeding_chk_id:
			if (isChecked)
				utill.allInfo.breakthroughbleeding_chk = true;
			else
				utill.allInfo.breakthroughbleeding_chk = false;
			break;
		case R.id.painfulmenses_chk_id:
			if (isChecked)
				utill.allInfo.painfulmenses_chk = true;
			else
				utill.allInfo.painfulmenses_chk = false;
			break;
		case R.id.pms_chk_id:
			if (isChecked)
				utill.allInfo.pms_chk = true;
			else
				utill.allInfo.pms_chk = false;
			break;
		case R.id.vaginaldischargeitch_chk_id:
			if (isChecked)
				utill.allInfo.vaginaldischargeitch_chk = true;
			else
				utill.allInfo.vaginaldischargeitch_chk = false;
			break;
		case R.id.vaginalsorelumpsSTD_chk_id:
			if (isChecked)
				utill.allInfo.vaginalsorelumpsSTD_chk = true;
			else
				utill.allInfo.vaginalsorelumpsSTD_chk = false;
			break;
		case R.id.menopausal_chk_id:
			if (isChecked)
				utill.allInfo.menopausal_chk = true;
			else
				utill.allInfo.menopausal_chk = false;
			break;
		case R.id.postmenopausalbleeding_chk_id:
			if (isChecked)
				utill.allInfo.postmenopausalbleeding_chk = true;
			else
				utill.allInfo.postmenopausalbleeding_chk = false;
			break;
		case R.id.hernias_chk_id:
			if (isChecked)
				utill.allInfo.hernias_chk = true;
			else
				utill.allInfo.hernias_chk = false;
			break;
		case R.id.dischargessorespeni_chk_id:
			if (isChecked)
				utill.allInfo.dischargessorespeni_chk = true;
			else
				utill.allInfo.dischargessorespeni_chk = false;
			break;
		case R.id.testicularpainmasses_chk_id:
			if (isChecked)
				utill.allInfo.testicularpainmasses_chk = true;
			else
				utill.allInfo.testicularpainmasses_chk = false;
			break;
		case R.id.std_chk_id:
			if (isChecked)
				utill.allInfo.std_chk = true;
			else
				utill.allInfo.std_chk = false;
			break;
		case R.id.musclepain_chk_id:
			if (isChecked)
				utill.allInfo.musclepain_chk = true;
			else
				utill.allInfo.musclepain_chk = false;
			break;
		case R.id.stiffness_chk_id:
			if (isChecked)
				utill.allInfo.stiffness_chk = true;
			else
				utill.allInfo.stiffness_chk = false;
			break;
		case R.id.arthritis_chk_id:
			if (isChecked)
				utill.allInfo.arthritis_chk = true;
			else
				utill.allInfo.arthritis_chk = false;
			break;
		case R.id.gout_chk_id:
			if (isChecked)
				utill.allInfo.gout_chk = true;
			else
				utill.allInfo.gout_chk = false;
			break;
		case R.id.backache_chk_id:
			if (isChecked)
				utill.allInfo.backache_chk = true;
			else
				utill.allInfo.backache_chk = false;
			break;
		case R.id.fainting_chk_id:
			if (isChecked)
				utill.allInfo.fainting_chk = true;
			else
				utill.allInfo.fainting_chk = false;
			break;
		case R.id.blackouts_chk_id:
			if (isChecked)
				utill.allInfo.blackouts_chk = true;
			else
				utill.allInfo.blackouts_chk = false;
			break;
		case R.id.seizures_chk_id:
			if (isChecked)
				utill.allInfo.seizures_chk = true;
			else
				utill.allInfo.seizures_chk = false;
			break;
		case R.id.weaknessparalysis_chk_id:
			if (isChecked)
				utill.allInfo.weaknessparalysis_chk = true;
			else
				utill.allInfo.weaknessparalysis_chk = false;
			break;
		case R.id.numbnessloss_chk_id:
			if (isChecked)
				utill.allInfo.numbnessloss_chk = true;
			else
				utill.allInfo.numbnessloss_chk = false;
			break;
		case R.id.tingling_chk_id:
			if (isChecked)
				utill.allInfo.tingling_chk = true;
			else
				utill.allInfo.tingling_chk = false;
			break;
		case R.id.tremors_chk_id:
			if (isChecked)
				utill.allInfo.tremors_chk = true;
			else
				utill.allInfo.tremors_chk = false;
			break;
		case R.id.memoryloss_chk_id:
			if (isChecked)
				utill.allInfo.memoryloss_chk = true;
			else
				utill.allInfo.memoryloss_chk = false;
			break;
		case R.id.trouble_chk_id:
			if (isChecked)
				utill.allInfo.trouble_chk = true;
			else
				utill.allInfo.trouble_chk = false;
			break;
		case R.id.rasheslumpssores_chk_id:
			if (isChecked)
				utill.allInfo.rasheslumpssores_chk = true;
			else
				utill.allInfo.rasheslumpssores_chk = false;
			break;
		case R.id.itchingdryness_chk_id:
			if (isChecked)
				utill.allInfo.itchingdryness_chk = true;
			else
				utill.allInfo.itchingdryness_chk = false;
			break;
		case R.id.colorchange_chk_id:
			if (isChecked)
				utill.allInfo.colorchange_chk = true;
			else
				utill.allInfo.colorchange_chk = false;
			break;
		case R.id.changehairnails_chk_id:
			if (isChecked)
				utill.allInfo.changehairnails_chk = true;
			else
				utill.allInfo.changehairnails_chk = false;
			break;
		case R.id.breastlumps_chk_id:
			if (isChecked)
				utill.allInfo.breastlumps_chk = true;
			else
				utill.allInfo.breastlumps_chk = false;
			break;
		case R.id.breastpain_chk_id:
			if (isChecked)
				utill.allInfo.breastpain_chk = true;
			else
				utill.allInfo.breastpain_chk = false;
			break;
		case R.id.nippledischarge_chk_id:
			if (isChecked)
				utill.allInfo.nippledischarge_chk = true;
			else
				utill.allInfo.nippledischarge_chk = false;
			break;
		case R.id.thyroidproblems_chk_id:
			if (isChecked)
				utill.allInfo.thyroidproblems_chk = true;
			else
				utill.allInfo.thyroidproblems_chk = false;
			break;
		case R.id.heatcoldintolerance_chk_id:
			if (isChecked)
				utill.allInfo.heatcoldintolerance_chk = true;
			else
				utill.allInfo.heatcoldintolerance_chk = false;
			break;
		case R.id.excessivesweating_chk_id:
			if (isChecked)
				utill.allInfo.excessivesweating_chk = true;
			else
				utill.allInfo.excessivesweating_chk = false;
			break;
		case R.id.diabetes_chk_id:
			if (isChecked)
				utill.allInfo.diabetes_chk = true;
			else
				utill.allInfo.diabetes_chk = false;
			break;
		case R.id.excessivethirsthunger_chk_id:
			if (isChecked)
				utill.allInfo.excessivethirsthunger_chk = true;
			else
				utill.allInfo.excessivethirsthunger_chk = false;
			break;
		case R.id.frequenturination_chk_id:
			if (isChecked)
				utill.allInfo.frequenturination_chk = true;
			else
				utill.allInfo.frequenturination_chk = false;
			break;
		case R.id.anemia_chk_id:
			if (isChecked)
				utill.allInfo.anemia_chk = true;
			else
				utill.allInfo.anemia_chk = false;
			break;
		case R.id.easybruisingbleeding_chk_id:
			if (isChecked)
				utill.allInfo.easybruisingbleeding_chk = true;
			else
				utill.allInfo.easybruisingbleeding_chk = false;
			break;
		case R.id.pasttransfusion_chk_id:
			if (isChecked)
				utill.allInfo.pasttransfusion_chk = true;
			else
				utill.allInfo.pasttransfusion_chk = false;
			break;
		case R.id.intermittent_chk_id:
			if (isChecked)
				utill.allInfo.intermittent_chk = true;
			else
				utill.allInfo.intermittent_chk = false;
			break;
		case R.id.leg_chk_id:
			if (isChecked)
				utill.allInfo.leg_chk = true;
			else
				utill.allInfo.leg_chk = false;
			break;
		case R.id.varicose_chk_id:
			if (isChecked)
				utill.allInfo.varicose_chk = true;
			else
				utill.allInfo.varicose_chk = false;
			break;
		case R.id.past_chk_id:
			if (isChecked)
				utill.allInfo.past_chk = true;
			else
				utill.allInfo.past_chk = false;
			break;
		case R.id.nervousness_chk_id:
			if (isChecked)
				utill.allInfo.nervousness_chk = true;
			else
				utill.allInfo.nervousness_chk = false;
			break;
		case R.id.tension_chk_id:
			if (isChecked)
				utill.allInfo.tension_chk = true;
			else
				utill.allInfo.tension_chk = false;
			break;
		case R.id.depression_chk_id:
			if (isChecked)
				utill.allInfo.depression_chk = true;
			else
				utill.allInfo.depression_chk = false;
			break;
		case R.id.insomnia_chk_id:
			if (isChecked)
				utill.allInfo.insomnia_chk = true;
			else
				utill.allInfo.insomnia_chk = false;
			break;
		case R.id.defect_chk_id:
			if (isChecked)
				utill.allInfo.defect_chk = true;
			else
				utill.allInfo.defect_chk = false;
			break;
		case R.id.diseasecolon_chk_id:
			if (isChecked)
				utill.allInfo.diseasecolon_chk = true;
			else
				utill.allInfo.diseasecolon_chk = false;
			break;

		case R.id.kidneyd_chk_id:
			if (isChecked)
				utill.allInfo.kidneyd_chk = true;
			else
				utill.allInfo.kidneyd_chk = false;
			break;

		case R.id.hearttrb_chk_id:
			if (isChecked)
				utill.allInfo.hearttrb_chk = true;
			else
				utill.allInfo.hearttrb_chk = false;
			break;

		case R.id.lifethreatcondition_chk_id:
			if (isChecked)
				utill.allInfo.lifethreatcondition_chk = true;
			else
				utill.allInfo.lifethreatcondition_chk = false;
			break;

		default:
			break;
		}
	}

}
