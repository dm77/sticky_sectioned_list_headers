package com.dushyanth.stickysectionedlistheaders;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dushyanth.stickysectionedlistheaders.R;

public class SessionListAdapter extends CursorAdapter {
    private static final String TAG = "SessionListAdapter";

    private static final int VIEW_TYPE_COUNT = 2;
    private static final int VIEW_TYPE_HEADER_ITEM = 0;
    private static final int VIEW_TYPE_NORMAL_ITEM = 1;

    private LayoutInflater mInflater;

    public SessionListAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, flags);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        Cursor cursor = getCursor();
        cursor.moveToPosition(position);

        if(isNewGroup(cursor, position)) {
            return VIEW_TYPE_HEADER_ITEM;
        } else {
            return VIEW_TYPE_NORMAL_ITEM;
        }
    }

    private boolean isNewGroup(Cursor cursor, int position) {
        if(position == 0) {
            return false;
        }

        String currentTrack = cursor.getString(cursor.getColumnIndex(SessionsTable.COL_TRACK_NAME));
        String oldTrack = "";

        if(position > 0) {
            cursor.moveToPosition(position - 1);
            oldTrack = cursor.getString(cursor.getColumnIndex(SessionsTable.COL_TRACK_NAME));
            cursor.moveToPosition(position);
        }

        if(TextUtils.isEmpty(currentTrack)) {
            currentTrack = "";
        }

        if(TextUtils.isEmpty(oldTrack)) {
            oldTrack = "";
        }

        if(currentTrack.equals(oldTrack)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String title = cursor.getString(cursor.getColumnIndex(SessionsTable.COL_TITLE));
        String time = cursor.getString(cursor.getColumnIndex(SessionsTable.COL_TIME));
        String location = cursor.getString(cursor.getColumnIndex(SessionsTable.COL_LOCATION));
        String trackName = cursor.getString(cursor.getColumnIndex(SessionsTable.COL_TRACK_NAME));
        String trackColor = cursor.getString(cursor.getColumnIndex(SessionsTable.COL_TRACK_COLOR));

        TextView titleView = (TextView) view.findViewById(R.id.session_title);
        titleView.setText(title);

        TextView timeView = (TextView) view.findViewById(R.id.session_time_and_location);
        timeView.setText(time + " in " + location);

        TextView trackHeaderView = (TextView) view.findViewById(R.id.track_header);
        if(trackHeaderView != null) {
            trackHeaderView.setText(trackName);

            trackHeaderView.setBackgroundColor(Color.parseColor(trackColor));
            trackHeaderView.setTextColor(getInverseColor(Color.parseColor(trackColor)));
        }
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        int position = cursor.getPosition();
        int viewType;


        boolean newGroup = isNewGroup(cursor, position);

        if(newGroup) {
            viewType = VIEW_TYPE_HEADER_ITEM;
        } else {
            viewType = VIEW_TYPE_NORMAL_ITEM;
        }

        View view = null;
        switch(viewType) {
            case VIEW_TYPE_HEADER_ITEM:
                view = mInflater.inflate(R.layout.session_list_item_with_header, parent, false);
                View header = view.findViewById(R.id.track_header);
                header.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;
            case VIEW_TYPE_NORMAL_ITEM:
                view = mInflater.inflate(R.layout.session_list_item, parent, false);
                break;
        }

        return view;
    }

    public void setTrackHeader(int position, TextView topTrackHeader) {
        Cursor cursor = (Cursor)getItem(position);
        if(cursor != null && topTrackHeader != null) {
            String name = cursor.getString(cursor.getColumnIndex(SessionsTable.COL_TRACK_NAME));
            String color = cursor.getString(cursor.getColumnIndex(SessionsTable.COL_TRACK_COLOR));
            topTrackHeader.setText(name);
            int backgroundColor = Color.parseColor(color);
            topTrackHeader.setBackgroundColor(backgroundColor);
            topTrackHeader.setTextColor(getInverseColor(backgroundColor));
        }
    }

    // http://stackoverflow.com/questions/7260989/how-to-pick-good-contrast-rgb-colors-programmatically
    // http://stackoverflow.com/questions/5760671/how-to-control-the-contrast-of-text
    public int getInverseColor(int color) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = Color.alpha(color);

        int max = red > green ? red : green;
        max = max > blue ? max : blue;

        int low = red < green ? red : green;
        low = low < blue ? low : blue;

        int total = max + low;
        if(total > 255) {
            return Color.argb(alpha, 0, 0, 0);
        } else {
            return Color.argb(alpha, 255, 255, 255);
        }
    }
}
