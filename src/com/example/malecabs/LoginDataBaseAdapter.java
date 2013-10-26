package com.example.malecabs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LoginDataBaseAdapter 
{
	private static final String DATABASE_NAME = "users";
	private static final int DATABASE_VERSION = 1;
		public static final int NAME_COLUMN = 1;
		// TODO: Create public field for each column in your table.
		// SQL Statement to create a new database.
		static final String DATABASE_CREATE = "create table "+"LOGIN"+
		                             "( " +"ID"+" integer primary key autoincrement,"+ "TAXI_NUMBER  text,PASSWORD text, LATITUDE real, LONGITUDE real, STATUS text); ";
		// Variable to hold the database instance
		public  SQLiteDatabase db;
		// Context of the application using the database.
		private final Context context;
		// Database open/upgrade helper
		private DataBaseHelper dbHelper;
		public  LoginDataBaseAdapter(Context _context) 
		{
			context = _context;
			dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		public  LoginDataBaseAdapter open() throws SQLException 
		{
			db = dbHelper.getWritableDatabase();
			return this;
		}
		public void close() 
		{
			db.close();
		}

		public  SQLiteDatabase getDatabaseInstance()
		{
			return db;
		}

		public void insertEntry(String taxiNumber,String password,int latitude, int longitude, int status )
		{
	       ContentValues newValues = new ContentValues();
			// Assign values for each row.
			newValues.put("TAXI_NUMBER", taxiNumber);
			newValues.put("PASSWORD",password);
			newValues.put("LATITUDE", latitude);
			newValues.put("LONGITUDE", longitude);
			newValues.put("STATUS", status);

			// Insert the row into your table
			db.insert("LOGIN", null, newValues);
			///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
		}
		public int deleteEntry(String taxiNumber)
		{
			//String id=String.valueOf(ID);
		    String where="TAXI_NUMBER=?";
		    int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{taxiNumber}) ;
	       // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
	        return numberOFEntriesDeleted;
		}	
		public String getSinlgeEntry(String taxiNumber)
		{
			Cursor cursor=db.query("LOGIN", null, " TAXI_NUMBER=?", new String[]{taxiNumber}, null, null, null);
	        if(cursor.getCount()<1) // UserName Not Exist
	        {
	        	cursor.close();
	        	return "NOT EXIST";
	        }
		    cursor.moveToFirst();
			String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
			cursor.close();
			return password;				
		}
		public void  updateEntry(String taxiNumber,String password,int latitude, int longitude, int status)
		{
			// Define the updated row content.
			ContentValues updatedValues = new ContentValues();
			// Assign values for each row.
			updatedValues.put("TAXI_NUMBER", taxiNumber);
			updatedValues.put("PASSWORD",password);
			updatedValues.put("PASSWORD",password);
			updatedValues.put("LATITUDE", latitude);
			updatedValues.put("LONGITUDE", longitude);
			updatedValues.put("STATUS", status);


	        String where="TAXI_NUMBER = ?";
		    db.update("LOGIN",updatedValues, where, new String[]{taxiNumber});			   
		}		
}