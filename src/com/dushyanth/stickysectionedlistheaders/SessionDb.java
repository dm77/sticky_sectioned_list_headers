package com.dushyanth.stickysectionedlistheaders;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SessionDb extends SQLiteOpenHelper {
    public static final String DB_NAME = "sessions.db";
    public static final int DB_VERSION = 1;

    public SessionDb(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SessionsTable.getCreateSql());
        SessionsTable.seedData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
