package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.tourguideapp.R;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of monuments.
 */
public class MonumentFragment extends Fragment {

    public MonumentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.text_list, container, false);

        // Create a list of locals
        final ArrayList<Local> locals = new ArrayList<Local>();
        locals.add(new Local(R.string.casa_musica_mon, R.string.hours1, R.string.phone9, R.drawable.casadamusica));
        locals.add(new Local(R.string.dpedro_mon, R.string.hours1, R.string.phone12, R.drawable.monumento_dompedro));
        locals.add(new Local(R.string.dragao_mon, R.string.hours1, R.string.phone16, R.drawable.dragao));
        locals.add(new Local(R.string.igreja_sclara_mon, R.string.hours1, R.string.phone15, R.drawable.igreja_santaclara));
        locals.add(new Local(R.string.mosteiro_mon, R.string.hours1, R.string.phone13, R.drawable.mosteiro));
        locals.add(new Local(R.string.palacio_bolsa_mon, R.string.hours1, R.string.phone14, R.drawable.palacio_bolsa));
        locals.add(new Local(R.string.se_mon, R.string.hours1, R.string.phone11, R.drawable.se_catedral));
        locals.add(new Local(R.string.torre_mon, R.string.hours1, R.string.phone10, R.drawable.torre));

        LocalAdapter1 adapter = new LocalAdapter1(getActivity(), locals, R.color.activity_monuments);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }
}