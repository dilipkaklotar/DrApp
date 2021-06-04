package com.app.doc.fragments;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.app.doc.DoctorSurveryActivity;
import com.app.doc.R;
import com.app.doc.database.DataBaseHelper;
import com.app.doc.util.Contents;
import com.app.doc.util.Information;
import com.app.doc.util.QRCodeEncoder;
import com.app.doc.util.Share;
import com.app.doc.util.Utill;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

public final class EncoderFragment extends Fragment {
	private QRCodeEncoder qrCodeEncoder = null;
	private String qrStr; // for storing formated string
	private Information info;
	private Context context;
	private Utill utill;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.encoder, container, false);

		context = view.getContext();

		WindowManager manager = (WindowManager) getActivity().getSystemService(
				Context.WINDOW_SERVICE);
		Display display = manager.getDefaultDisplay();
		int width = display.getWidth();
		int height = display.getHeight();
		int smallerDimension = width < height ? width : height;
		smallerDimension = smallerDimension * 7 / 8;
		info = Utill.getInstance().allInfo;
		utill = Utill.getInstance();

		makeQrString();

		if (qrStr.length() > 0)
			try {
				qrCodeEncoder = new QRCodeEncoder(qrStr, null,
						Contents.Type.TEXT, BarcodeFormat.QR_CODE.toString(),
						smallerDimension);
				Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();
				ImageView img = (ImageView) view.findViewById(R.id.image_view);
				img.setImageBitmap(bitmap);
			} catch (WriterException e) {

			} catch (IllegalArgumentException e) {

			}
		return view;
	}

	// creating QR string
	private void makeQrString() {
		// TODO Auto-generated method stub

		if (info.f_name.length() > 0)
			qrStr = "A0," + info.f_name + ";";
		if (info.m_name.length() > 0)
			qrStr = qrStr + "A1," + info.m_name + ";";
		if (info.l_name.length() > 0)
			qrStr = qrStr + "A2," + info.l_name + ";";
		if (info.dob.length() > 0)
			qrStr = qrStr + "A3," + info.dob + ";";
		if (info.sex.length() > 0)
			qrStr = qrStr + "A4," + info.sex + ";";
		// if(info.height.length()>0) qrStr=qrStr+"A5,"+info.height+";";
		if (info.feet.length() > 0)
			qrStr = qrStr + "A5," + info.feet + ".";
		if (info.inches.length() > 0)
			qrStr = qrStr + "" + info.inches + ";";
		// else
		// qrStr = qrStr + "" + 0 + ";";
		if (info.weight.length() > 0)
			qrStr = qrStr + "A6," + info.weight + ";";
		if (info.maritalstatus.length() > 0)
			qrStr = qrStr + "A7," + info.maritalstatus + ";";
		// if (info.maritalstatus_chk)
		// qrStr = qrStr + "A7," + 1 + ";";
		if (info.is_maritalstatus == 1)
			qrStr = qrStr + "A7,S" + ";";
		else if (info.is_maritalstatus == 0)
			qrStr = qrStr + "A7,M" + ";";
		else if (info.is_maritalstatus == 2)
			qrStr = qrStr + "A7,D" + ";";
		else if (info.is_maritalstatus == 3)
			qrStr = qrStr + "A7,W" + ";";

		if (info.streetaddress.length() > 0)
			qrStr = qrStr + "A8," + info.streetaddress + ";";
		if (info.apartmentnumber.length() > 0)
			qrStr = qrStr + "A9," + info.apartmentnumber + ";";
		if (info.city.length() > 0)
			qrStr = qrStr + "B0," + info.city + ";";
		if (info.state.length() > 0)
			qrStr = qrStr + "B1," + info.state + ";";
		if (info.zipcode.length() > 0)
			qrStr = qrStr + "B2," + info.zipcode + ";";
		if (info.homephone.length() > 0)
			qrStr = qrStr + "B3," + info.homephone + ";";
		if (info.businessphone.length() > 0)
			qrStr = qrStr + "B4," + info.businessphone + ";";
		if (info.mobilephone.length() > 0)
			qrStr = qrStr + "B5," + info.mobilephone + ";";
		if (info.emailaddress.length() > 0)
			qrStr = qrStr + "B6," + info.emailaddress + ";";
		if (info.occupation.length() > 0)
			qrStr = qrStr + "B7," + info.occupation + ";";
		if (info.ssn.length() > 0)
			qrStr = qrStr + "B8," + info.ssn + ";";
		if (info.gfname.length() > 0)
			qrStr = qrStr + "B9," + info.gfname + ";";
		if (info.gmname.length() > 0)
			qrStr = qrStr + "C0," + info.gmname + ";";
		if (info.glname.length() > 0)
			qrStr = qrStr + "C1," + info.glname + ";";
		if (info.gdob.length() > 0)
			qrStr = qrStr + "C2," + info.gdob + ";";
		if (info.gssn.length() > 0)
			qrStr = qrStr + "C3," + info.gssn + ";";
		if (info.gdayphone.length() > 0)
			qrStr = qrStr + "C4," + info.gdayphone + ";";
		if (info.gaddress.length() > 0)
			qrStr = qrStr + "C5," + info.gaddress + ";";
		if (info.gaptnum.length() > 0)
			qrStr = qrStr + "C6," + info.gaptnum + ";";
		if (info.gcity.length() > 0)
			qrStr = qrStr + "C7," + info.gcity + ";";
		if (info.gstate.length() > 0)
			qrStr = qrStr + "C8," + info.gstate + ";";
		if (info.gzipcode.length() > 0)
			qrStr = qrStr + "C9," + info.gzipcode + ";";
		if (info.medins.length() > 0)
			qrStr = qrStr + "D0," + info.medins + ";";
		if (info.priminsname.length() > 0)
			qrStr = qrStr + "T7," + info.priminsname + ";";
		if (info.primpolnum.length() > 0)
			qrStr = qrStr + "T8," + info.primpolnum + ";";
		if (info.primgroupnum.length() > 0)
			qrStr = qrStr + "T9," + info.primgroupnum + ";";
		if (info.primauthnum.length() > 0)
			qrStr = qrStr + "U0," + info.primauthnum + ";";
		if (info.priminsadd.length() > 0)
			qrStr = qrStr + "U1," + info.priminsadd + ";";
		if (info.priminsphone.length() > 0)
			qrStr = qrStr + "U2," + info.priminsphone + ";";
		if (info.patientrelat.length() > 0)
			qrStr = qrStr + "D1," + info.patientrelat + ";";
		if (info.policyhname.length() > 0)
			qrStr = qrStr + "D2," + info.policyhname + ";";
		if (info.policyhdob.length() > 0)
			qrStr = qrStr + "D3," + info.policyhdob + ";";
		if (info.policyhssn.length() > 0)
			qrStr = qrStr + "D4," + info.policyhssn + ";";
		if (info.policyhadd.length() > 0)
			qrStr = qrStr + "D5," + info.policyhadd + ";";
		if (info.policythruemp.length() > 0)
			qrStr = qrStr + "D6," + info.policythruemp + ";";
		if (info.policyhemployer.length() > 0)
			qrStr = qrStr + "D7," + info.policyhemployer + ";";
		if (info.policyhempaddress.length() > 0)
			qrStr = qrStr + "D8," + info.policyhempaddress + ";";
		if (info.policyhempcity.length() > 0)
			qrStr = qrStr + "D9," + info.policyhempcity + ";";
		if (info.policyhempstate.length() > 0)
			qrStr = qrStr + "E0," + info.policyhempstate + ";";
		if (info.secmedins.length() > 0)
			qrStr = qrStr + "E1," + info.secmedins + ";";
		if (info.secinsname.length() > 0)
			qrStr = qrStr + "E2," + info.secinsname + ";";
		if (info.secpolnum.length() > 0)
			qrStr = qrStr + "E3," + info.secpolnum + ";";
		if (info.secgroupnum.length() > 0)
			qrStr = qrStr + "E4," + info.secgroupnum + ";";
		if (info.secauthnum.length() > 0)
			qrStr = qrStr + "E5," + info.secauthnum + ";";
		if (info.secinsadd.length() > 0)
			qrStr = qrStr + "E6," + info.secinsadd + ";";
		if (info.secinsphone.length() > 0)
			qrStr = qrStr + "E7," + info.secinsphone + ";";
		if (info.secrelationship.length() > 0)
			qrStr = qrStr + "E8," + info.secrelationship + ";";
		if (info.emergcontname.length() > 0)
			qrStr = qrStr + "E9," + info.emergcontname + ";";
		if (info.emergcontrelation.length() > 0)
			qrStr = qrStr + "F0," + info.emergcontrelation + ";";
		if (info.emergcontphone.length() > 0)
			qrStr = qrStr + "F1," + info.emergcontphone + ";";
		if (info.lastmedvis.length() > 0)
			qrStr = qrStr + "F2," + info.lastmedvis + ";";
		if (info.lastnameprov.length() > 0)
			qrStr = qrStr + "F3," + info.lastnameprov + ";";
		if (info.lastreasonvisit.length() > 0)
			qrStr = qrStr + "F4," + info.lastreasonvisit + ";";
		if (info.listofmeds.length() > 0)
			qrStr = qrStr + "F5," + info.listofmeds + ";";
		if (info.listofsupps.length() > 0)
			qrStr = qrStr + "F6," + info.listofsupps + ";";
		if (info.hospitalsurgeries.length() > 0)
			qrStr = qrStr + "F7," + info.hospitalsurgeries + ";";
		if (info.drugallergies.length() > 0)
			qrStr = qrStr + "F8," + info.drugallergies + ";";
		if (info.dpt_chk)
			qrStr = qrStr + "F9," + 1 + ";";
		if (info.tetanus_chk)
			qrStr = qrStr + "G0," + 1 + ";";
		if (info.mmr_chk)
			qrStr = qrStr + "G1," + 1 + ";";
		if (info.flu_chk)
			qrStr = qrStr + "G2," + 1 + ";";
		if (info.polio_chk)
			qrStr = qrStr + "G3," + 1 + ";";
		if (info.hepatitisa_chk)
			qrStr = qrStr + "G4," + 1 + ";";
		if (info.hepatitisb_chk)
			qrStr = qrStr + "G5," + 1 + ";";
		if (info.smallpox_chk)
			qrStr = qrStr + "G6," + 1 + ";";

		if (info.weightchng_chk)
			qrStr = qrStr + "G7," + 1 + ";";
		if (info.weakness_chk)
			qrStr = qrStr + "G8," + 1 + ";";
		if (info.fatigue_chk)
			qrStr = qrStr + "G9," + 1 + ";";
		if (info.fever_chk)
			qrStr = qrStr + "H0," + 1 + ";";
		if (info.cancer_chk)
			qrStr = qrStr + "H1," + 1 + ";";
		if (info.headache_chk)
			qrStr = qrStr + "H2," + 1 + ";";
		if (info.headinjury_chk)
			qrStr = qrStr + "H3," + 1 + ";";
		if (info.dizziness_chk)
			qrStr = qrStr + "H4," + 1 + ";";
		if (info.lightheadedness_chk)
			qrStr = qrStr + "H5," + 1 + ";";
		if (info.visionchange_chk)
			qrStr = qrStr + "H6," + 1 + ";";
		if (info.eyepain_chk)
			qrStr = qrStr + "H7," + 1 + ";";
		if (info.doublevision_chk)
			qrStr = qrStr + "H8," + 1 + ";";
		if (info.spotsflashinglights_chk)
			qrStr = qrStr + "H9," + 1 + ";";
		if (info.glaucoma_chk)
			qrStr = qrStr + "I0," + 1 + ";";
		if (info.cataracts_chk)
			qrStr = qrStr + "I1," + 1 + ";";
		if (info.hearingchange_chk)
			qrStr = qrStr + "I2," + 1 + ";";
		if (info.ringing_chk)
			qrStr = qrStr + "I3," + 1 + ";";
		if (info.vertigo_chk)
			qrStr = qrStr + "I4," + 1 + ";";
		if (info.earaches_chk)
			qrStr = qrStr + "I5," + 1 + ";";
		if (info.infection_chk)
			qrStr = qrStr + "I6," + 1 + ";";
		if (info.frequentcold_chk)
			qrStr = qrStr + "I7," + 1 + ";";
		if (info.nasalcongestion_chk)
			qrStr = qrStr + "I8," + 1 + ";";
		if (info.discharge_chk)
			qrStr = qrStr + "I9," + 1 + ";";
		if (info.hayfever_chk)
			qrStr = qrStr + "J0," + 1 + ";";
		if (info.nosebleed_chk)
			qrStr = qrStr + "J1," + 1 + ";";
		if (info.sinus_chk)
			qrStr = qrStr + "J2," + 1 + ";";
		if (info.lumpsneck_chk)
			qrStr = qrStr + "J3," + 1 + ";";
		if (info.swollenglands_chk)
			qrStr = qrStr + "J4," + 1 + ";";
		if (info.goiter_chk)
			qrStr = qrStr + "J5," + 1 + ";";
		if (info.painneck_chk)
			qrStr = qrStr + "J6," + 1 + ";";
		if (info.cough_chk)
			qrStr = qrStr + "J7," + 1 + ";";
		if (info.coughingblood_chk)
			qrStr = qrStr + "J8," + 1 + ";";
		if (info.shortnessbreath_chk)
			qrStr = qrStr + "J9," + 1 + ";";
		if (info.wheezing_chk)
			qrStr = qrStr + "K0," + 1 + ";";
		if (info.sleepapnea_chk)
			qrStr = qrStr + "K1," + 1 + ";";
		if (info.troublebreathing_chk)
			qrStr = qrStr + "K2," + 1 + ";";
		if (info.dentalproblems_chk)
			qrStr = qrStr + "K3," + 1 + ";";
		if (info.soretongue_chk)
			qrStr = qrStr + "K4," + 1 + ";";
		if (info.drymouth_chk)
			qrStr = qrStr + "K5," + 1 + ";";
		if (info.freqsorethroat_chk)
			qrStr = qrStr + "K6," + 1 + ";";
		if (info.hoarseness_chk)
			qrStr = qrStr + "K7," + 1 + ";";
		if (info.chestpain_chk)
			qrStr = qrStr + "K8," + 1 + ";";
		if (info.highbloodpressure_chk)
			qrStr = qrStr + "K9," + 1 + ";";
		if (info.murmus_chk)
			qrStr = qrStr + "L0," + 1 + ";";
		if (info.rheumaticfever_chk)
			qrStr = qrStr + "L1," + 1 + ";";
		if (info.palpitations_chk)
			qrStr = qrStr + "L2," + 1 + ";";
		if (info.difficultyswallow_chk)
			qrStr = qrStr + "L3," + 1 + ";";
		if (info.heartburn_chk)
			qrStr = qrStr + "L4," + 1 + ";";
		if (info.nauseavomit_chk)
			qrStr = qrStr + "L5," + 1 + ";";
		if (info.regurgitation_chk)
			qrStr = qrStr + "L6," + 1 + ";";
		if (info.vomitingblood_chk)
			qrStr = qrStr + "L7," + 1 + ";";
		if (info.indigestion_chk)
			qrStr = qrStr + "L8," + 1 + ";";
		if (info.rectalbleeding_chk)
			qrStr = qrStr + "L9," + 1 + ";";
		if (info.blacktarrystools_chk)
			qrStr = qrStr + "M0," + 1 + ";";
		if (info.hemorrhoids_chk)
			qrStr = qrStr + "M1," + 1 + ";";
		if (info.constipation_chk)
			qrStr = qrStr + "M2," + 1 + ";";
		if (info.diarrhea_chk)
			qrStr = qrStr + "M3," + 1 + ";";
		if (info.abdominal_chk)
			qrStr = qrStr + "M4," + 1 + ";";
		if (info.foodintolerance_chk)
			qrStr = qrStr + "M5," + 1 + ";";
		if (info.excessivebelchgas_chk)
			qrStr = qrStr + "M6," + 1 + ";";
		if (info.yellowingskin_chk)
			qrStr = qrStr + "M7," + 1 + ";";
		if (info.livergallbladderprobs_chk)
			qrStr = qrStr + "M8," + 1 + ";";
		if (info.hepatitis_chk)
			qrStr = qrStr + "M9," + 1 + ";";
		if (info.bladderinfection_chk)
			qrStr = qrStr + "N0," + 1 + ";";
		if (info.urinaryfrequrgency_chk)
			qrStr = qrStr + "N1," + 1 + ";";
		if (info.bloodurine_chk)
			qrStr = qrStr + "N2," + 1 + ";";
		if (info.painfulurination_chk)
			qrStr = qrStr + "N3," + 1 + ";";
		if (info.dribblingstream_chk)
			qrStr = qrStr + "N4," + 1 + ";";
		if (info.reducedforcestream_chk)
			qrStr = qrStr + "N5," + 1 + ";";
		if (info.hesitancy_chk)
			qrStr = qrStr + "N6," + 1 + ";";
		if (info.incontinence_chk)
			qrStr = qrStr + "N7," + 1 + ";";
		if (info.bladderkidneystone_chk)
			qrStr = qrStr + "N8," + 1 + ";";
		if (info.irregularmenses_chk)
			qrStr = qrStr + "N9," + 1 + ";";
		if (info.breakthroughbleeding_chk)
			qrStr = qrStr + "O0," + 1 + ";";
		if (info.painfulmenses_chk)
			qrStr = qrStr + "O1," + 1 + ";";
		if (info.pms_chk)
			qrStr = qrStr + "O2," + 1 + ";";
		if (info.vaginaldischargeitch_chk)
			qrStr = qrStr + "O3," + 1 + ";";
		if (info.vaginalsorelumpsSTD_chk)
			qrStr = qrStr + "O4," + 1 + ";";
		if (info.menopausal_chk)
			qrStr = qrStr + "O5," + 1 + ";";
		if (info.postmenopausalbleeding_chk)
			qrStr = qrStr + "O6," + 1 + ";";
		if (info.hernias_chk)
			qrStr = qrStr + "O7," + 1 + ";";
		if (info.dischargessorespeni_chk)
			qrStr = qrStr + "O8," + 1 + ";";
		if (info.testicularpainmasses_chk)
			qrStr = qrStr + "O9," + 1 + ";";
		if (info.std_chk)
			qrStr = qrStr + "P0," + 1 + ";";
		if (info.musclepain_chk)
			qrStr = qrStr + "P1," + 1 + ";";
		if (info.stiffness_chk)
			qrStr = qrStr + "P2," + 1 + ";";
		if (info.arthritis_chk)
			qrStr = qrStr + "P3," + 1 + ";";
		if (info.gout_chk)
			qrStr = qrStr + "P4," + 1 + ";";
		if (info.backache_chk)
			qrStr = qrStr + "P5," + 1 + ";";
		if (info.fainting_chk)
			qrStr = qrStr + "P6," + 1 + ";";
		if (info.blackouts_chk)
			qrStr = qrStr + "P7," + 1 + ";";
		if (info.seizures_chk)
			qrStr = qrStr + "P8," + 1 + ";";
		if (info.weaknessparalysis_chk)
			qrStr = qrStr + "P9," + 1 + ";";
		if (info.numbnessloss_chk)
			qrStr = qrStr + "Q0," + 1 + ";";
		if (info.tingling_chk)
			qrStr = qrStr + "Q1," + 1 + ";";
		if (info.tremors_chk)
			qrStr = qrStr + "Q2," + 1 + ";";
		if (info.memoryloss_chk)
			qrStr = qrStr + "Q3," + 1 + ";";
		if (info.trouble_chk)
			qrStr = qrStr + "Q4," + 1 + ";";
		if (info.rasheslumpssores_chk)
			qrStr = qrStr + "Q5," + 1 + ";";
		if (info.itchingdryness_chk)
			qrStr = qrStr + "Q6," + 1 + ";";
		if (info.colorchange_chk)
			qrStr = qrStr + "Q7," + 1 + ";";
		if (info.changehairnails_chk)
			qrStr = qrStr + "Q8," + 1 + ";";
		if (info.breastlumps_chk)
			qrStr = qrStr + "Q9," + 1 + ";";
		if (info.breastpain_chk)
			qrStr = qrStr + "R0," + 1 + ";";
		if (info.nippledischarge_chk)
			qrStr = qrStr + "R1," + 1 + ";";
		if (info.thyroidproblems_chk)
			qrStr = qrStr + "R2," + 1 + ";";
		if (info.heatcoldintolerance_chk)
			qrStr = qrStr + "R3," + 1 + ";";
		if (info.excessivesweating_chk)
			qrStr = qrStr + "R4," + 1 + ";";
		if (info.diabetes_chk)
			qrStr = qrStr + "R5," + 1 + ";";
		if (info.excessivethirsthunger_chk)
			qrStr = qrStr + "R6," + 1 + ";";
		if (info.frequenturination_chk)
			qrStr = qrStr + "R7," + 1 + ";";
		if (info.anemia_chk)
			qrStr = qrStr + "R8," + 1 + ";";
		if (info.easybruisingbleeding_chk)
			qrStr = qrStr + "R9," + 1 + ";";
		if (info.pasttransfusion_chk)
			qrStr = qrStr + "S0," + 1 + ";";
		if (info.intermittent_chk)
			qrStr = qrStr + "S1," + 1 + ";";
		if (info.leg_chk)
			qrStr = qrStr + "S2," + 1 + ";";
		if (info.varicose_chk)
			qrStr = qrStr + "S3," + 1 + ";";
		if (info.past_chk)
			qrStr = qrStr + "S4," + 1 + ";";
		if (info.nervousness_chk)
			qrStr = qrStr + "S5," + 1 + ";";
		if (info.tension_chk)
			qrStr = qrStr + "S6," + 1 + ";";
		if (info.depression_chk)
			qrStr = qrStr + "S7," + 1 + ";";
		if (info.insomnia_chk)
			qrStr = qrStr + "S8," + 1 + ";";
		if (info.energy.length() > 0)
			qrStr = qrStr + "S9," + info.energy + ";";
		if (info.hrs_read.length() > 0)
			qrStr = qrStr + "T0," + info.hrs_read + ";";
		if (info.dowakerested_chk.length() > 0)
			qrStr = qrStr + "T1," + info.dowakerested_chk + ";";
		if (info.is_smoke == 1)
			qrStr = qrStr + "T2,Y" + ";";
		else if (info.is_smoke == 0)
			qrStr = qrStr + "T2,N" + ";";
		else if (info.is_smoke == 2)
			qrStr = qrStr + "T2,P" + ";";
		if (info.is_alcho == 1)
			qrStr = qrStr + "T3,Y" + ";";
		else if (info.is_alcho == 0)
			qrStr = qrStr + "T3,N" + ";";
		else if (info.is_alcho == 2)
			qrStr = qrStr + "T3,P" + ";";
		if (info.is_recdrug == 1)
			qrStr = qrStr + "T4,Y" + ";";
		else if (info.is_recdrug == 0)
			qrStr = qrStr + "T4,N" + ";";
		else if (info.is_recdrug == 2)
			qrStr = qrStr + "T4,P" + ";";

		if (info.doexercise_chk.length() > 0)
			qrStr = qrStr + "T5," + info.doexercise_chk + ";";

		// if (info.howdaysweekexcercise_chk)
		// qrStr = qrStr + "T6," + 1 + ";";
		if (info.days_week.length() > 0)
			qrStr = qrStr + "T6," + info.days_week + ";";

		if (info.blooddisorder_chk)
			qrStr = qrStr + "U3," + 1 + ";";
		if (info.defect_chk)
			qrStr = qrStr + "U4," + 1 + ";";
		if (info.diseasecolon_chk)
			qrStr = qrStr + "U5," + 1 + ";";
		if (info.kidneyd_chk)
			qrStr = qrStr + "U6," + 1 + ";";
		if (info.hearttrb_chk)
			qrStr = qrStr + "U7," + 1 + ";";
		if (info.lifethreatcondition_chk)
			qrStr = qrStr + "U8," + 1 + ";";
		if (info.spinedisorder_chk)
			qrStr = qrStr + "U9," + 1 + ";";

		if (info.lastbloodwork.length() > 0)
			qrStr = qrStr + "V1," + info.lastbloodwork + ";";

		if (info.tetanusshot.length() > 0)
			qrStr = qrStr + "V2," + info.tetanusshot + ";";

		if (info.lmp.length() > 0)
			qrStr = qrStr + "V3," + info.lmp + ";";

		if (info.lastpap.length() > 0)
			qrStr = qrStr + "V4," + info.lastpap + ";";

		if (info.mammogram.length() > 0)
			qrStr = qrStr + "V5," + info.mammogram + ";";

		if (info.dexascan.length() > 0)
			qrStr = qrStr + "V6," + info.dexascan + ";";

		if (info.colonoscopy.length() > 0)
			qrStr = qrStr + "V7," + info.colonoscopy + ";";

		if (info.ekg.length() > 0)
			qrStr = qrStr + "V8," + info.ekg + ";";

		if (info.mother.length() > 0)
			qrStr = qrStr + "V9," + info.mother + ";";

		if (info.father.length() > 0)
			qrStr = qrStr + "W0," + info.father + ";";

		if (info.pharmacyname.length() > 0)
			qrStr = qrStr + "W1," + info.pharmacyname + ";";

		if (info.pharmacynumber.length() > 0)
			qrStr = qrStr + "W2," + info.pharmacynumber + ";";

		if (!Share.did.equalsIgnoreCase("")) {

			String temp = "";

			try {

				DataBaseHelper.getInstance(context).openDataBase();

				Cursor cc = DataBaseHelper.getInstance(context).SelectAnswerDB(
						String.valueOf(utill.allInfo.id), Share.did);

				if (cc.getCount() > 0) {

					cc.moveToFirst();

					do {

						if (!cc.getString(3).equalsIgnoreCase("")
								&& !cc.getString(4).equalsIgnoreCase(""))
							
							temp = temp + "Z" + cc.getString(3) + ","
									+ cc.getString(4) + ";";

					} while (cc.moveToNext());

				}

				cc.close();

				DataBaseHelper.getInstance(context).close();

			} catch (Exception e) {

			}

			qrStr = qrStr + temp;

		}

		Log.e("", "QRCODE STRING : " + qrStr);

	}

}
