package com.ashu.aniket;

import java.util.ArrayList;
import java.util.List;

import com.ashu.aniket.Mpbyname;





import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
/**
 * 
 * @author manish.s
 *
 */

public class SQLiteConnector extends Activity{
	
	private SQLiteDatabase database;
	private SQLiteHelper sqlHelper;
	private Cursor cursor;
	private String mpname=Mpbyname.mpnamesearch;
	private String constituency=Constituency.Constituencysearch;
	private String all=Mpbyname.mp1;
	private String state=Statewise.Statewisesearch;
	private static final String TABLE_RECORD = "mp";
	
	
	public SQLiteConnector(Context context) {
		sqlHelper = new SQLiteHelper(context);
		
	}
	
	// Getting All records
	public List<String> getall() {
	
		List<String> studentList = new ArrayList<String>();
		
		String selectQuery = "SELECT  name, Attendance, Political_party, Constituency, State, Gender, Age,Educational_qualifications, Educational_qualifications_d FROM " + TABLE_RECORD + " where name LIKE '%"+all+"%' ; ";

		database = sqlHelper.getReadableDatabase();
		cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				studentList.add("NAME"+"\n"+cursor.getString(0));
				studentList.add("ATTENDANCE"+"\n"+cursor.getString(1));
				studentList.add("POLITICAL PARTY"+"\n"+cursor.getString(2));
				studentList.add("CONSTITUENCY"+"\n"+cursor.getString(3));
				studentList.add("STATE"+"\n"+cursor.getString(4));
				studentList.add("GENDER"+"\n"+cursor.getString(5));
				studentList.add("AGE"+"\n"+cursor.getString(6));
				studentList.add("EDUCATIONAL QUALIFICATION"+"\n"+cursor.getString(7));
				studentList.add("EDUCATIONAL QUALIFICATION DETAIL"+"\n"+cursor.getString(8));
			} while (cursor.moveToNext());
		}
		
		database.close();
		return studentList;
	}
	
	
	public List<String> party() {
		
		List<String> studentList = new ArrayList<String>();
		
		String selectQuery = "SELECT  name FROM " + TABLE_RECORD + " where State LIKE '%delhi%' ; ";

		database = sqlHelper.getReadableDatabase();
		cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				studentList.add(cursor.getString(0));
			
			} while (cursor.moveToNext());
		}
		
		database.close();
		return studentList;
	}
	
	
	// Getting All records
			public List<String> mpname() {
			
				List<String> studentList = new ArrayList<String>();
				
				String selectQuery = "SELECT  name FROM " + TABLE_RECORD + " where name LIKE '%"+mpname+"%' ; ";

				database = sqlHelper.getReadableDatabase();
				cursor = database.rawQuery(selectQuery, null);
				if (cursor.moveToFirst()) {
					do {
						studentList.add(cursor.getString(0));
						
					} while (cursor.moveToNext());
				}
				else
				{
					studentList.add("NO RESULT FOUND");
				}
				database.close();
				return studentList;
			}
			
			public List<String> constituency() {
				
				List<String> studentList = new ArrayList<String>();
				
				String selectQuery = "SELECT  name FROM " + TABLE_RECORD + " where Constituency LIKE '%"+constituency+"%' ; ";

				database = sqlHelper.getReadableDatabase();
				cursor = database.rawQuery(selectQuery, null);
				if (cursor.moveToFirst()) {
					do {
						studentList.add(cursor.getString(0));
					} while (cursor.moveToNext());
				}
				else
				{
					studentList.add("NO RESULT FOUND");
				}
				database.close();
				return studentList;
			}
			
public List<String> statewise() {
				
				List<String> studentList = new ArrayList<String>();
				
				String selectQuery = "SELECT  name FROM " + TABLE_RECORD + " where State LIKE '%"+state+"%' ; ";

				database = sqlHelper.getReadableDatabase();
				cursor = database.rawQuery(selectQuery, null);
				if (cursor.moveToFirst()) {
					do {
						studentList.add(cursor.getString(0));
					} while (cursor.moveToNext());
				}
				else
				{
					studentList.add("NO RESULT FOUND");
				}
				database.close();
				return studentList;
			}


public List<String> partyfirstrun() {
	
	List<String> studentList = new ArrayList<String>();
	
	String selectQuery = "SELECT  party FROM " + TABLE_RECORD + " ; ";

	database = sqlHelper.getReadableDatabase();
	cursor = database.rawQuery(selectQuery, null);
	if (cursor.moveToFirst()) {
		do {if(cursor.getString(0)==null){
			break;
		}
			studentList.add(cursor.getString(0));
		
		} while (cursor.moveToNext());
	}
	
	database.close();
	return studentList;
}


public List<String> auto() {
	
	List<String> studentList = new ArrayList<String>();
	
	String selectQuery = "SELECT  party FROM " + TABLE_RECORD + " ; ";

	database = sqlHelper.getReadableDatabase();
	cursor = database.rawQuery(selectQuery, null);
	if (cursor.moveToFirst()) {
		do {
			studentList.add(cursor.getString(0));
		
		} while (cursor.moveToNext());
	}
	
	database.close();
	return studentList;
}
	
}
