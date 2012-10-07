package com.dushyanth.stickysectionedlistheaders;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

public class SessionListFragment extends ListFragment
        implements LoaderManager.LoaderCallbacks<Cursor>, ListView.OnScrollListener {

    private static final int SESSION_LOADER = 0x01;
    private SessionListAdapter mAdapter;
    private TextView mTopTrackHeaderView;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListShown(false);
        getLoaderManager().initLoader(SESSION_LOADER, null, this);
        mTopTrackHeaderView = (TextView) getActivity().findViewById(R.id.top_track_header);
        mAdapter = new SessionListAdapter(getActivity(), null, 0);
        setListAdapter(mAdapter);
        getListView().setOnScrollListener(this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String sortBy = SessionsTable.COL_TRACK_NAME + " ASC";
        CursorLoader cursorLoader = new CursorLoader(getActivity(),
                SessionProvider.CONTENT_URI, SessionProvider.SESSIONS_PROJECTION, null, null,
                sortBy);

        return cursorLoader;
    }

    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        mAdapter.swapCursor(cursor);
        setListShown(true);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }

    public void onScrollStateChanged(AbsListView alv, int i) {

    }

    public void onScroll(AbsListView alv, int firstItemPosition, int i1, int i2) {
        mAdapter.setTrackHeader(firstItemPosition, mTopTrackHeaderView);
    }
}
