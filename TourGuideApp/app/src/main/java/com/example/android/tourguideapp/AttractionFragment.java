package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of attractions.
 */
public class AttractionFragment extends Fragment {

    public AttractionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.text_list, container, false);

        // Create a list of locals
        final ArrayList<Local> locals = new ArrayList<Local>();
        locals.add(new Local(R.string.parque_att, R.drawable.parque_da_cidade_att));
        locals.add(new Local(R.string.cais_att, R.drawable.cais_da_ribeira_att));
        locals.add(new Local(R.string.ponte_maria_att, R.drawable.ponte_dmaria_att));
        locals.add(new Local(R.string.ponte_sjoao_att, R.drawable.ponte_sjoao_att));
        locals.add(new Local(R.string.ponte_infante_att, R.drawable.ponte_infante_att));
        locals.add(new Local(R.string.ponte_freixo_att, R.drawable.ponte_freixo_att));
        locals.add(new Local(R.string.ponte_arrabida_att, R.drawable.ponte_arrabida_att));
        locals.add(new Local(R.string.ponte_luis_att, R.drawable.ponte_dluis_att));

        LocalAdapter2 adapter = new LocalAdapter2(getActivity(), locals, R.color.activity_attractions);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }
}