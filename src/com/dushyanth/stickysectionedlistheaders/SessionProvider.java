package com.dushyanth.stickysectionedlistheaders;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class SessionProvider extends ContentProvider {
    private SessionDb mDb;

    private static final String PATH_SESSIONS = "sessions";
    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final String AUTHORITY = "com.dushyanth.stickysectionedlistheaders.SessionProvider";
    private static final int SESSIONS = 1000;

    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY).buildUpon().appendPath(PATH_SESSIONS).build();
    public static final String[] SESSIONS_PROJECTION;

    static {
        sURIMatcher.addURI(AUTHORITY, PATH_SESSIONS, SESSIONS);

        SESSIONS_PROJECTION = new String[]{
            SessionsTable.COL_ID,
            SessionsTable.COL_TITLE,
            SessionsTable.COL_TRACK_NAME,
            SessionsTable.COL_TRACK_COLOR,
            SessionsTable.COL_TIME,
            SessionsTable.COL_LOCATION
        };
    }

    @Override
    public boolean onCreate() {
        mDb = new SessionDb(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri,  String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        final int match = sURIMatcher.match(uri);

        switch(match) {
            case SESSIONS:
                return getSessions(projection, selection, selectionArgs, sortOrder);
        }

        return null;
    }

    public Cursor getSessions(String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = mDb.getReadableDatabase();

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(SessionsTable.TABLE_NAME);

        Cursor resultCursor = queryBuilder.query(db, projection, selection,
                selectionArgs, null, null, sortOrder);
        return resultCursor;
    }

    @Override
    public String getType(Uri uri) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Uri insert(Uri uri, ContentValues cv) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(Uri uri, String string, String[] strings) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update(Uri uri, ContentValues cv, String string, String[] strings) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
