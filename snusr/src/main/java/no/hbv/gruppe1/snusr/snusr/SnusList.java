package no.hbv.gruppe1.snusr.snusr;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import no.hbv.gruppe1.snusr.snusr.dataclasses.DatabaseInteractor;


/**
 * A placeholder fragment containing a simple view.
 */
public class SnusList extends Fragment {

    ListView listview;
    /**
     * Inneholder våre favorittsnus, alle snus og snus med bokmerke
     */
    public SnusList() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_snuslist, container, false);

        listview = (ListView) view.findViewById(R.id.snuslist);
        DatabaseInteractor db = new DatabaseInteractor();
        Cursor cur = db.fetchSnus(getActivity(), null, null);

        SnusAdapter adapter = new SnusAdapter(getActivity(), cur, 0);
        listview.setAdapter(adapter);

        return view;
    }
}
