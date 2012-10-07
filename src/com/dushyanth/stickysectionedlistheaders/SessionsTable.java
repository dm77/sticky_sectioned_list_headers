package com.dushyanth.stickysectionedlistheaders;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class SessionsTable {
    public static final String TABLE_NAME = "sessions";
    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "title";
    public static final String COL_TRACK_NAME = "track_name";
    public static final String COL_TRACK_COLOR = "track_color";
    public static final String COL_TIME = "time";
    public static final String COL_LOCATION = "location";

    public static final String Q_COL_ID = TABLE_NAME + "." + COL_ID;
    public static final String Q_COL_TITLE = TABLE_NAME + "." + COL_TITLE;
    public static final String Q_COL_TRACK_NAME = TABLE_NAME + "." + COL_TRACK_NAME;
    public static final String Q_COL_TRACK_COLOR = TABLE_NAME + "." + COL_TRACK_COLOR;
    public static final String Q_COL_TIME = TABLE_NAME + "." + COL_TIME;
    public static final String Q_COL_LOCATION = TABLE_NAME + "." + COL_LOCATION;

    public static String getCreateSql() {
        return "CREATE TABLE " + TABLE_NAME + "("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_TITLE + " TEXT NOT NULL, "
                + COL_TRACK_NAME + " TEXT NOT NULL, "
                + COL_TRACK_COLOR + " TEXT NOT NULL, "
                + COL_TIME + " TEXT NOT NULL, "
                + COL_LOCATION + " TEXT);";
    }

    public static void seedData(SQLiteDatabase db) {

//        #99a6af
//#6a4ca2
//#2da9e5
//#f39526
//#1e62b2
//#afd53b
//#b3232f
//#f2d31f

        ContentValues values = new ContentValues();
        values.put(COL_TITLE, "What's New in Google Maps");
        values.put(COL_TRACK_NAME, "Google Maps");
        values.put(COL_TRACK_COLOR, "#99a6af");
        values.put(COL_LOCATION, "Room 5");
        values.put(COL_TIME, "1:30pm - 2:30pm, Wed");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "Spacial Data Visualization");
        values.put(COL_TRACK_NAME, "Google Maps");
        values.put(COL_TRACK_COLOR, "#99a6af");
        values.put(COL_LOCATION, "Room 6");
        values.put(COL_TIME, "2:30pm - 3:00pm, Wed");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "Not Just a Map");
        values.put(COL_TRACK_NAME, "Google Maps");
        values.put(COL_TRACK_COLOR, "#99a6af");
        values.put(COL_LOCATION, "Room 5");
        values.put(COL_TIME, "2:30pm - 3:30pm, Wed");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "Computing Map Tiles with Go on App Engine");
        values.put(COL_TRACK_NAME, "Google Maps");
        values.put(COL_TRACK_COLOR, "#99a6af");
        values.put(COL_LOCATION, "Room 1");
        values.put(COL_TIME, "12:30pm - 1:30pm, Thu");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "A Master Class in Styling");
        values.put(COL_TRACK_NAME, "Google Maps");
        values.put(COL_TRACK_COLOR, "#99a6af");
        values.put(COL_LOCATION, "Room 5");
        values.put(COL_TIME, "1:30pm - 2:30pm, Thu");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "What's New in Chrome");
        values.put(COL_TRACK_NAME, "Chrome");
        values.put(COL_TRACK_COLOR, "#6a4ca2");
        values.put(COL_LOCATION, "Room 5");
        values.put(COL_TIME, "1:30pm - 2:30pm, Wed");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "Spacial Data Visualization");
        values.put(COL_TRACK_NAME, "Chrome");
        values.put(COL_TRACK_COLOR, "#6a4ca2");
        values.put(COL_LOCATION, "Room 6");
        values.put(COL_TIME, "2:30pm - 3:00pm, Wed");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "Not Just a Map");
        values.put(COL_TRACK_NAME, "Chrome");
        values.put(COL_TRACK_COLOR, "#6a4ca2");
        values.put(COL_LOCATION, "Room 5");
        values.put(COL_TIME, "2:30pm - 3:30pm, Wed");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "Computing Map Tiles with Go on App Engine");
        values.put(COL_TRACK_NAME, "Chrome");
        values.put(COL_TRACK_COLOR, "#6a4ca2");
        values.put(COL_LOCATION, "Room 1");
        values.put(COL_TIME, "12:30pm - 1:30pm, Thu");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "A Master Class in Styling");
        values.put(COL_TRACK_NAME, "Chrome");
        values.put(COL_TRACK_COLOR, "#6a4ca2");
        values.put(COL_LOCATION, "Room 5");
        values.put(COL_TIME, "1:30pm - 2:30pm, Thu");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "What's New in Commerce");
        values.put(COL_TRACK_NAME, "Commerce");
        values.put(COL_TRACK_COLOR, "#2da9e5");
        values.put(COL_LOCATION, "Room 5");
        values.put(COL_TIME, "1:30pm - 2:30pm, Wed");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "Spacial Data Visualization");
        values.put(COL_TRACK_NAME, "Commerce");
        values.put(COL_TRACK_COLOR, "#2da9e5");
        values.put(COL_LOCATION, "Room 6");
        values.put(COL_TIME, "2:30pm - 3:00pm, Wed");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "Not Just a Map");
        values.put(COL_TRACK_NAME, "Commerce");
        values.put(COL_TRACK_COLOR, "#2da9e5");
        values.put(COL_LOCATION, "Room 5");
        values.put(COL_TIME, "2:30pm - 3:30pm, Wed");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "Computing Map Tiles with Go on App Engine");
        values.put(COL_TRACK_NAME, "Commerce");
        values.put(COL_TRACK_COLOR, "#2da9e5");
        values.put(COL_LOCATION, "Room 1");
        values.put(COL_TIME, "12:30pm - 1:30pm, Thu");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "A Master Class in Styling");
        values.put(COL_TRACK_NAME, "Commerce");
        values.put(COL_TRACK_COLOR, "#2da9e5");
        values.put(COL_LOCATION, "Room 5");
        values.put(COL_TIME, "1:30pm - 2:30pm, Thu");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "What's New in Google Drive");
        values.put(COL_TRACK_NAME, "Google Drive");
        values.put(COL_TRACK_COLOR, "#1e62b2");
        values.put(COL_LOCATION, "Room 5");
        values.put(COL_TIME, "1:30pm - 2:30pm, Wed");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "Spacial Data Visualization");
        values.put(COL_TRACK_NAME, "Google Drive");
        values.put(COL_TRACK_COLOR, "#1e62b2");
        values.put(COL_LOCATION, "Room 6");
        values.put(COL_TIME, "2:30pm - 3:00pm, Wed");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "Not Just a Map");
        values.put(COL_TRACK_NAME, "Google Drive");
        values.put(COL_TRACK_COLOR, "#1e62b2");
        values.put(COL_LOCATION, "Room 5");
        values.put(COL_TIME, "2:30pm - 3:30pm, Wed");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "Computing Map Tiles with Go on App Engine");
        values.put(COL_TRACK_NAME, "Google Drive");
        values.put(COL_TRACK_COLOR, "#1e62b2");
        values.put(COL_LOCATION, "Room 1");
        values.put(COL_TIME, "12:30pm - 1:30pm, Thu");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "A Master Class in Styling");
        values.put(COL_TRACK_NAME, "Google Drive");
        values.put(COL_TRACK_COLOR, "#1e62b2");
        values.put(COL_LOCATION, "Room 5");
        values.put(COL_TIME, "1:30pm - 2:30pm, Thu");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "What's New in YouTube");
        values.put(COL_TRACK_NAME, "YouTube");
        values.put(COL_TRACK_COLOR, "#afd53b");
        values.put(COL_LOCATION, "Room 5");
        values.put(COL_TIME, "1:30pm - 2:30pm, Wed");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "Spacial Data Visualization");
        values.put(COL_TRACK_NAME, "YouTube");
        values.put(COL_TRACK_COLOR, "#afd53b");
        values.put(COL_LOCATION, "Room 6");
        values.put(COL_TIME, "2:30pm - 3:00pm, Wed");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "Not Just a Map");
        values.put(COL_TRACK_NAME, "YouTube");
        values.put(COL_TRACK_COLOR, "#afd53b");
        values.put(COL_LOCATION, "Room 5");
        values.put(COL_TIME, "2:30pm - 3:30pm, Wed");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "Computing Map Tiles with Go on App Engine");
        values.put(COL_TRACK_NAME, "YouTube");
        values.put(COL_TRACK_COLOR, "#afd53b");
        values.put(COL_LOCATION, "Room 1");
        values.put(COL_TIME, "12:30pm - 1:30pm, Thu");
        db.insert(TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(COL_TITLE, "A Master Class in Styling");
        values.put(COL_TRACK_NAME, "YouTube");
        values.put(COL_TRACK_COLOR, "#afd53b");
        values.put(COL_LOCATION, "Room 5");
        values.put(COL_TIME, "1:30pm - 2:30pm, Thu");
        db.insert(TABLE_NAME, null, values);
    }
}
