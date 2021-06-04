package com.app.doc.util;

// Information class based on database

import java.lang.reflect.Field;

import android.content.ContentValues;
import android.database.Cursor;

public class Information {
	public int id = 1;
	public String f_name = "";
	public String m_name = "";
	public String l_name = "";
	public String dob = "";
	public String sex = "";

	public String city = "";
	public String state = "";
	public String sp_f_name = "";
	public String sp_m_name = "";
	public String sp_l_name = "";
	// public String sp_dob = "";
	public boolean is_book = false;
	public int book_type;
	public boolean is_magazine = false;
	public String magazine_name = "";
	public String q_name = "";
	public String relation = "";
	public String phone = "";
	public String last_visit = "";
	public String lib_name = "";
	public boolean is_inter_book = false;
	public boolean is_child_book = false;
	public boolean is_self_book = false;
	public boolean is_science_book = false;
	public boolean is_satire_book = false;
	public boolean is_drama_book = false;
	public boolean is_romance_book = false;
	public boolean is_mystery_book = false;
	public boolean is_comedy_book = false;
	public boolean is_comics_book = false;
	public boolean is_fantasy_book = false;
	// public String energy = "";
	public String hrs_read = "";
	public boolean want_rest = false;
	public int is_smoke = 0;
	public int is_alcho = 0;
	public int is_recdrug = 0;
	public int is_maritalstatus = 0;

	public String days_week = "";
	public String saved = "";
	// public String height = "";
	public String feet = "";
	public String inches = "";
	public String weight = "";
	public String maritalstatus = "";
	public String streetaddress = "";
	public String apartmentnumber = "";
	public String zipcode = "";
	public String homephone = "";
	public String businessphone = "";
	public String mobilephone = "";
	public String emailaddress = "";
	public String occupation = "";
	public String ssn = "";
	public String gfname = "";
	public String gmname = "";
	public String glname = "";
	public String gdob = "";
	public String gssn = "";
	public String gdayphone = "";
	public String gaddress = "";
	public String gaptnum = "";
	public String gcity = "";
	public String gstate = "";
	public String gzipcode = "";
	public String medins = "";
	public String patientrelat = "";
	public String policyhname = "";
	public String policyhdob = "";
	public String policyhssn = "";
	public String policyhadd = "";
	public String policythruemp = "";
	public String policyhemployer = "";
	public String policyhempaddress = "";
	public String policyhempcity = "";
	public String policyhempstate = "";
	public String priminsname = "";
	public String primpolnum = "";
	public String primgroupnum = "";
	public String primauthnum = "";
	public String priminsadd = "";
	public String priminsphone = "";
	public String secmedins = "";
	public String secinsname = "";
	public String secpolnum = "";
	public String secgroupnum = "";
	public String secauthnum = "";
	public String secinsadd = "";
	public String secinsphone = "";
	public String secrelationship = "";
	public String emergcontname = "";
	public String emergcontrelation = "";
	public String emergcontphone = "";
	public String lastmedvis = "";
	public String lastnameprov = "";
	public String lastreasonvisit = "";
	public String listofmeds = "";
	public String listofsupps = "";
	public String hospitalsurgeries = "";
	public String drugallergies = "";
	
	
	public String lastbloodwork = "";
	public String tetanusshot = "";
	public String dexascan = "";
	public String colonoscopy = "";
	public String ekg = "";
	public String lmp = "";
	public String lastpap = "";
	public String mammogram = "";
	public String pharmacyname = "";
	public String mother = "";
	public String father = "";
	public String pharmacynumber = "";
	
	
	
	public boolean dpt_chk = false;
	public boolean tetanus_chk = false;
	public boolean mmr_chk = false;
	public boolean flu_chk = false;
	public boolean polio_chk = false;
	public boolean hepatitisa_chk = false;
	public boolean hepatitisb_chk = false;
	public boolean smallpox_chk = false;
	public boolean weightchng_chk = false;
	public boolean weakness_chk = false;
	public boolean fatigue_chk = false;
	public boolean fever_chk = false;
	public boolean cancer_chk = false;
	public boolean headache_chk = false;
	public boolean headinjury_chk = false;
	public boolean dizziness_chk = false;
	public boolean lightheadedness_chk = false;
	public boolean visionchange_chk = false;
	public boolean eyepain_chk = false;
	public boolean doublevision_chk = false;
	public boolean spotsflashinglights_chk = false;
	public boolean glaucoma_chk = false;
	public boolean cataracts_chk = false;
	public boolean hearingchange_chk = false;
	public boolean ringing_chk = false;
	public boolean vertigo_chk = false;
	public boolean earaches_chk = false;
	public boolean infection_chk = false;
	public boolean frequentcold_chk = false;
	public boolean nasalcongestion_chk = false;
	public boolean discharge_chk = false;
	public boolean hayfever_chk = false;
	public boolean nosebleed_chk = false;
	public boolean sinus_chk = false;
	public boolean lumpsneck_chk = false;
	public boolean swollenglands_chk = false;
	public boolean goiter_chk = false;
	public boolean painneck_chk = false;
	public boolean cough_chk = false;
	public boolean coughingblood_chk = false;
	public boolean shortnessbreath_chk = false;
	public boolean wheezing_chk = false;
	public boolean sleepapnea_chk = false;
	public boolean troublebreathing_chk = false;
	public boolean dentalproblems_chk = false;
	public boolean soretongue_chk = false;
	public boolean drymouth_chk = false;
	public boolean freqsorethroat_chk = false;
	public boolean hoarseness_chk = false;
	public boolean chestpain_chk = false;
	public boolean highbloodpressure_chk = false;
	public boolean murmus_chk = false;
	public boolean rheumaticfever_chk = false;
	public boolean palpitations_chk = false;
	public boolean difficultyswallow_chk = false;
	public boolean heartburn_chk = false;
	public boolean nauseavomit_chk = false;
	public boolean regurgitation_chk = false;
	public boolean vomitingblood_chk = false;
	public boolean indigestion_chk = false;
	public boolean rectalbleeding_chk = false;
	public boolean blacktarrystools_chk = false;
	public boolean hemorrhoids_chk = false;
	public boolean constipation_chk = false;
	public boolean diarrhea_chk = false;
	public boolean abdominal_chk = false;
	public boolean foodintolerance_chk = false;
	public boolean excessivebelchgas_chk = false;
	public boolean yellowingskin_chk = false;
	public boolean livergallbladderprobs_chk = false;
	public boolean hepatitis_chk = false;
	public boolean bladderinfection_chk = false;
	public boolean urinaryfrequrgency_chk = false;
	public boolean bloodurine_chk = false;
	public boolean painfulurination_chk = false;
	public boolean dribblingstream_chk = false;
	public boolean reducedforcestream_chk = false;
	public boolean hesitancy_chk = false;
	public boolean incontinence_chk = false;
	public boolean bladderkidneystone_chk = false;
	public boolean irregularmenses_chk = false;
	public boolean breakthroughbleeding_chk = false;
	public boolean painfulmenses_chk = false;
	public boolean pms_chk = false;
	public boolean vaginaldischargeitch_chk = false;
	public boolean vaginalsorelumpsSTD_chk = false;
	public boolean menopausal_chk = false;
	public boolean postmenopausalbleeding_chk = false;
	public boolean hernias_chk = false;
	public boolean dischargessorespeni_chk = false;
	public boolean testicularpainmasses_chk = false;
	public boolean std_chk = false;
	public boolean musclepain_chk = false;
	public boolean stiffness_chk = false;
	public boolean arthritis_chk = false;
	public boolean gout_chk = false;
	public boolean backache_chk = false;
	public boolean fainting_chk = false;
	public boolean blackouts_chk = false;
	public boolean seizures_chk = false;
	public boolean weaknessparalysis_chk = false;
	public boolean numbnessloss_chk = false;
	public boolean tingling_chk = false;
	public boolean tremors_chk = false;
	public boolean memoryloss_chk = false;
	public boolean trouble_chk = false;
	public boolean rasheslumpssores_chk = false;
	public boolean itchingdryness_chk = false;
	public boolean colorchange_chk = false;
	public boolean changehairnails_chk = false;
	public boolean breastlumps_chk = false;
	public boolean breastpain_chk = false;
	public boolean nippledischarge_chk = false;
	public boolean thyroidproblems_chk = false;
	public boolean heatcoldintolerance_chk = false;
	public boolean excessivesweating_chk = false;
	public boolean diabetes_chk = false;
	public boolean excessivethirsthunger_chk = false;
	public boolean frequenturination_chk = false;
	public boolean anemia_chk = false;
	public boolean easybruisingbleeding_chk = false;
	public boolean pasttransfusion_chk = false;
	public boolean intermittent_chk = false;
	public boolean leg_chk = false;
	public boolean varicose_chk = false;
	public boolean past_chk = false;
	public boolean nervousness_chk = false;
	public boolean tension_chk = false;
	public boolean depression_chk = false;
	public boolean insomnia_chk = false;
	public String energy = "";
	public String hrs = "";
	
	
	public boolean defect_chk = false;
	public boolean diseasecolon_chk = false;
	public boolean kidneyd_chk = false;
	public boolean hearttrb_chk = false;
	public boolean lifethreatcondition_chk = false;
	public boolean blooddisorder_chk = false;
	public boolean spinedisorder_chk = false;
	
	public String dowakerested_chk = "";

	public boolean dosmoke_chk = false;
	public boolean doalcohol_chk = false;
	// public boolean doexercise_chk = false;
	public String doexercise_chk = "";

	public boolean howdaysweekexcercise_chk = false;
	public boolean recreationaldrug_chk = false;
	public boolean maritalstatus_chk = false;

	public ContentValues getContentValues() throws IllegalArgumentException,
			IllegalAccessException {
		Field[] fields = this.getClass().getDeclaredFields();
		ContentValues cv = new ContentValues();
		for (Field f : fields) {
			if (f.getType().getName().equals("java.lang.String"))
				cv.put(f.getName(), (String) f.get(this));
			else if (f.getType().getName().equals("boolean"))
				cv.put(f.getName(), (Boolean) f.get(this));
			else if (f.getType().getName().equals("int"))
				cv.put(f.getName(), (Integer) f.get(this));
		}
		return cv;
	}

	public void setContentValues(Cursor cv) throws Exception {
		Field[] fields = this.getClass().getDeclaredFields();

		for (Field f : fields) {
			if (f.getType().getName().equals("java.lang.String"))
				f.set(this, cv.getString(cv.getColumnIndex(f.getName())));
			else if (f.getType().getName().equals("boolean"))
				f.set(this, cv.getInt(cv.getColumnIndex(f.getName())) > 0);
			else if (f.getType().getName().equals("int"))
				f.set(this, cv.getInt(cv.getColumnIndex(f.getName())));
		}
	}
}
