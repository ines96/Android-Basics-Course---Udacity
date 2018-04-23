package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of viewpoints.
 */
public class ViewpointFragment extends Fragment {

    public ViewpointFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.text_list, container, false);

        // Create a list of locals
        final ArrayList<Local> locals = new ArrayList<Local>();
        locals.add(new Local(R.string.jardimCristal_viewpoint, R.drawable.jardim_palacio_cristal));
        locals.add(new Local(R.string.passeio_viewpoint, R.drawable.passeio_das_virtudes));
        locals.add(new Local(R.string.vitoria_viewpoint, R.drawable.miradouro_vitoria));
        locals.add(new Local(R.string.torre_viewpoint, R.drawable.torre_clerigos));
        locals.add(new Local(R.string.serra_viewpoint, R.drawable.serra_pilar));
        locals.add(new Local(R.string.se_viewpoint, R.drawable.se));
        locals.add(new Local(R.string.jardimMorro_viewpoint, R.drawable.jardim_morro_miradouro));
        locals.add(new Local(R.string.bandeirinha_viewpoint, R.drawable.miradouro_bandeirinha_saude));

        LocalAdapter2 adapter = new LocalAdapter2(getActivity(), locals, R.color.activity_viewpoints);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }
}