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
 * {@link Fragment} that displays a list of restaurants.
 */
public class RestaurantFragment extends Fragment {

    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.text_list, container, false);

        // Create a list of locals
        final ArrayList<Local> locals = new ArrayList<Local>();
        locals.add(new Local(R.string.abadia_res, R.string.portuguese_food, R.string.hours, R.string.phone1, R.drawable.abadia_porto_res));
        locals.add(new Local(R.string.cafeina_res, R.string.portuguese_food, R.string.hours, R.string.phone2, R.drawable.cafeina_res));
        locals.add(new Local(R.string.costume_res, R.string.portuguese_food, R.string.hours, R.string.phone3, R.drawable.costume_bistro_res));
        locals.add(new Local(R.string.cruel_res, R.string.portuguese_food, R.string.hours, R.string.phone4, R.drawable.cruel_res));
        locals.add(new Local(R.string.madureira_res, R.string.portuguese_food, R.string.hours, R.string.phone5, R.drawable.madureira_res));
        locals.add(new Local(R.string.porto_novo_res, R.string.portuguese_food, R.string.hours, R.string.phone6, R.drawable.portonovo_res));
        locals.add(new Local(R.string.portucale_res, R.string.portuguese_food, R.string.hours, R.string.phone7, R.drawable.portucale_res));
        locals.add(new Local(R.string.taberna_res, R.string.portuguese_food, R.string.hours, R.string.phone8, R.drawable.taberna_mercadores_res));

        LocalAdapter adapter = new LocalAdapter(getActivity(), locals, R.color.activity_restaurants);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }
}