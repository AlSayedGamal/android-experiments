package com.egamal.cat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CATAdaptor {
	private final String DB_NAME = "CATDB";
	public final static String DB_TABLE = "USERS";
	private final int DB_VERSION = 1;

	public final String USER_F_NAME = "first_name";
	public final String USER_L_NAME = "last_name";
	public final String USER_ID = "_id";
	private Context context;
	public CATDBHelper dbHelper;
	public SQLiteDatabase db;

	public static final String TABLE_CREATE = "create table " + DB_TABLE
			+ " ( _id integer primary key autoincrement,"
			+ "first_name text not null, last_name text not null);";

	public CATAdaptor(Context _context) {
		context = _context;
		dbHelper = new CATDBHelper(context, DB_NAME, null, DB_VERSION);
	}

	public CATAdaptor open() throws SQLException {
		db = dbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		db.close();
	}

	public String[] GetLastUser() {
		Cursor allUsers = qAllUsers();
		String userId = "";
		String userFirstName = "";
		String userLastName = "";
		if (allUsers.moveToFirst()) {
			do {
				userId = allUsers.getString(allUsers.getColumnIndex(USER_ID));
				userFirstName = allUsers.getString(allUsers
						.getColumnIndex(USER_F_NAME));
				userLastName = allUsers.getString(allUsers
						.getColumnIndex(USER_F_NAME));
			} while (allUsers.moveToNext());
		}
		return new String[] { userId, userFirstName, userLastName };
	}

	public Cursor qAllUsers() {
		return db.query(DB_TABLE, new String[] { USER_ID, USER_F_NAME,
				USER_L_NAME }, null, null, null, null, null);
	}

	public long insert(ContentValues cv) {
		return this.db.insert(DB_TABLE, null, cv);
	}
}
