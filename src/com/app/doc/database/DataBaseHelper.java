package com.app.doc.database;

// Database controller class

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.app.doc.util.Information;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {

	// The Android's default system path of your application database.
	@SuppressLint("SdCardPath")
	private static String DB_PATH = "/data/data/com.app.doc/databases/";
	private static String DB_NAME = "formdoc.sqlite";

	private static DataBaseHelper _dbHelper;

	private SQLiteDatabase myDataBase;

	private final Context myContext;
	private final String Table_Name = "info";

	/**
	 * Constructor Takes and keeps a reference of the passed context in order to
	 * access to the application assets and resources.
	 * 
	 * @param context
	 */
	private DataBaseHelper(Context context) {

		super(context, DB_NAME, null, 1);
		this.myContext = context;
	}

	/**
	 * Creates a empty database on the system and rewrites it with your own
	 * database.
	 * */
	public void createDataBase() throws IOException {
		boolean dbExist = checkDataBase();

		if (dbExist) {
			// do nothing - database already exist
		} else {

			// By calling this method and empty database will be created into
			// the default system path
			// of your application so we are gonna be able to overwrite that
			// database with our database.
			this.getReadableDatabase();

			try {

				copyDataBase();
			} catch (IOException e) {

				throw new Error("Error copying database " + e);

			}
		}

	}

	/**
	 * Check if the database already exist to avoid re-copying the file each
	 * time you open the application.
	 * 
	 * @return true if it exists, false if it doesn't
	 */
	private boolean checkDataBase() {
		SQLiteDatabase checkDB = null;

		try {
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READONLY);

		} catch (SQLiteException e) {

			// database does't exist yet.
			// Utill.getInstance(false).isFirstTime=true;
			e.printStackTrace();

		}

		if (checkDB != null) {

			checkDB.close();

		}

		return checkDB != null ? true : false;
	}

	/**
	 * Copies your database from your local assets-folder to the just created
	 * empty database in the system folder, from where it can be accessed and
	 * handled. This is done by transfering bytestream.
	 * */
	private void copyDataBase() throws IOException {

		// Open your local db as the input stream
		InputStream myInput = myContext.getAssets().open(DB_NAME);

		// Path to the just created empty db
		String outFileName = DB_PATH + DB_NAME;

		// Open the empty db as the output stream
		OutputStream myOutput = new FileOutputStream(outFileName);

		// transfer bytes from the inputfile to the outputfile
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}

		// Close the streams
		myOutput.flush();
		myOutput.close();
		myInput.close();

	}

	public static DataBaseHelper getInstance(Context context) {
		if (_dbHelper == null) {
			_dbHelper = new DataBaseHelper(context);
		}
		return _dbHelper;
	}

	public void destroyDatabse() {
		_dbHelper.close();
		_dbHelper = null;
	}

	public void openDataBase() throws SQLException {

		// Open the database
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null,
				SQLiteDatabase.OPEN_READWRITE);

	}

	public SQLiteDatabase getDatabase() {
		return myDataBase;
	}

	@Override
	public synchronized void close() {

		if (myDataBase != null)
			myDataBase.close();

		super.close();

	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	public void ExecuteRequest(String query) {
		myDataBase.execSQL(query);
	}

	public Cursor rawRequest(String query) {
		return myDataBase.rawQuery(query, null);
	}

	public ArrayList<Information> getListInfo() {
		Cursor c = myDataBase.rawQuery("SELECT * FROM " + Table_Name, null);
		ArrayList<Information> infolist = new ArrayList<Information>();

		if (c.moveToFirst()) {
			do {
				try {
					Information info = new Information();
					info.setContentValues(c);
					infolist.add(info);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} while (c.moveToNext());
			c.close();
			return infolist;
		} else {
			c.close();
			return infolist;
		}

	}

	public int getMaxcount() {

		int count = 0;

		try {

			String sqlQuery = "SELECT MAX(id) FROM info";

			Log.e("", "query : " + sqlQuery);

			Cursor c = myDataBase.rawQuery(sqlQuery, null);

			if (c.getCount() > 0) {

				Log.e("", "c.getCount() >> " + c.getCount());

				c.moveToFirst();

				Log.e("", "Count >> " + c.getInt(0));

				count = c.getInt(0);

			} else {
				Log.e("", "Count = 0");
				count = 0;

			}

			c.close();

		} catch (Exception e) {

			e.printStackTrace();

			count = 0;

			Log.e("", "Count else >> " + count);

		}

		return count;

	}

	public void InsertIntoDB(int id, ContentValues cv) throws Exception {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM " + Table_Name + " WHERE id =" + id;
		Cursor cursor = myDataBase.rawQuery(sql, null);
		if (cursor.moveToFirst()) {
			// myDataBase.update(Table_Name, cv, "id="+id, null);
			myDataBase.update(Table_Name, cv, "id='" + id + "'", null);
		} else {
			myDataBase.insert(Table_Name, null, cv);
		}
	}

	public void InsertIntoCityDB(String city_id, String city) throws Exception {

		String sqlmain = "SELECT * FROM city WHERE city_id=" + city_id;

		Cursor cursor = myDataBase.rawQuery(sqlmain, null);

		if (cursor.getCount() > 0) {

		} else {
			String sql = "INSERT INTO city(city_id,city) values(" + city_id
					+ ",'" + city + "')";
			myDataBase.execSQL(sql);
		}

		cursor.close();

	}

	public void InsertIntoSpecialityDB(String speciality_id, String speciality)
			throws Exception {

		String sqlmain = "SELECT * FROM speciality WHERE speciality_id="
				+ speciality_id;

		Cursor cursor = myDataBase.rawQuery(sqlmain, null);

		if (cursor.getCount() > 0) {

		} else {
			String sql = "INSERT INTO speciality(speciality_id,speciality) values('"
					+ speciality_id + "','" + speciality + "')";
			myDataBase.execSQL(sql);
		}

		cursor.close();
	}

	public void deleteIntoSpecialityDB(String speciality_id) throws Exception {

		String sql = "delete from speciality where speciality_id='"
				+ speciality_id + "'";
		myDataBase.execSQL(sql);

	}

	public void updateIntoSpecialityDB(String speciality_id, String speciality)
			throws Exception {

		ContentValues cv = new ContentValues();
		cv.put("speciality", speciality);

		myDataBase.update("speciality", cv, "speciality_id='" + speciality_id
				+ "'", null);

	}

	public Cursor SelectCityDB() throws Exception {

		String sql = "SELECT * FROM city";
		Cursor cursor = myDataBase.rawQuery(sql, null);
		if (cursor != null) {
			return cursor;
		} else {
			return null;
		}
	}

	public Cursor SelectSpecialityDB() throws Exception {

		String sql = "SELECT * FROM speciality";
		Cursor cursor = myDataBase.rawQuery(sql, null);
		if (cursor != null) {
			return cursor;
		} else {
			return null;
		}
	}

	public void delAll(String deleteIdss) throws Exception {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM " + Table_Name + " WHERE id IN ("
				+ deleteIdss + ")";
		myDataBase.execSQL(sql);
	}

	public void InsertIntoQuestionDB(final String profileid, final String did,
			final String pid, final String question_mendatory,
			final String qid, final String question_type, final String aid,
			final String question_content) throws Exception {

		String sqlmain = "SELECT * FROM question WHERE profileid=" + profileid
				+ " and did=" + did + " and qid=" + qid;

		Cursor cursor = myDataBase.rawQuery(sqlmain, null);

		if (cursor.getCount() > 0) {

		} else {

			String sql = "INSERT INTO question(profileid,did,pid,question_mendatory,qid,question_type,aid,question_content) values("
					+ profileid
					+ ","
					+ did
					+ ","
					+ pid
					+ ","
					+ question_mendatory
					+ ","
					+ qid
					+ ",'"
					+ question_type
					+ "'," + aid + ",'" + question_content + "')";
			myDataBase.execSQL(sql);
		}

		cursor.close();

	}

	public void InsertIntoAnswerDB(final String profileid, final String did,
			final String qid, final String answer) throws Exception {

		String sqlmain = "SELECT * FROM answer WHERE profileid=" + profileid
				+ " AND doctorid=" + did + " AND qid=" + qid;

		Log.e("", "sqlmain : " + sqlmain);

		Cursor cursor = myDataBase.rawQuery(sqlmain, null);

		Log.e("", "sqlmain cursor : " + cursor.getCount());

		if (cursor.getCount() > 0) {

			Log.e("", "Inside update");

			ContentValues cv = new ContentValues();
			cv.put("answer", answer);

			myDataBase.update("answer", cv, "profileid='" + profileid
					+ "' AND doctorid='" + did + "' AND qid='" + qid + "'",
					null);

		} else {

			Log.e("", "Inside Insert");

			String sql = "INSERT INTO answer(profileid,doctorid,qid,answer) values("
					+ profileid + "," + did + "," + qid + ",'" + answer + "')";

			Log.e("", "sql : " + sql);

			myDataBase.execSQL(sql);
		}

		cursor.close();

	}

	public Cursor SelectAnswerDB(final String profileid, final String did)
			throws Exception {

		String sql = "SELECT * FROM answer WHERE profileid=" + profileid
				+ " and doctorid=" + did;

		Log.e("", "SQL : " + sql);

		Cursor cursor = myDataBase.rawQuery(sql, null);
		if (cursor != null) {
			return cursor;
		} else {
			return null;
		}
	}

	public void updateSpecialityDateDB(String specialityDate) throws Exception {

		ContentValues cv = new ContentValues();
		cv.put("speciality", specialityDate);

		myDataBase.update("storedate", cv, null, null);

	}

	public String getSpecialityDate() {

		String value = "";

		try {

			String sqlQuery = "SELECT * FROM storedate";

			Cursor c = myDataBase.rawQuery(sqlQuery, null);

			if (c.getCount() > 0) {

				c.moveToFirst();

				Log.e("", "Store Date >> " + c.getString(0));

				value = c.getString(0);

			}
			c.close();

		} catch (Exception e) {

			e.printStackTrace();

			value = "";

		}

		return value;

	}

}
