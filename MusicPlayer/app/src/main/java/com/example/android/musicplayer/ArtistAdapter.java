package com.example.android.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by InesL on 3/10/2018.
 */

public class ArtistAdapter extends ArrayAdapter<Artist> {
    /**
     * Create a new {@link ArtistAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param artists  is the list of {@link Artist}s to be displayed.
     */
    public ArtistAdapter(Context context, ArrayList<Artist> artists) {
        super(context, 0, artists);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }

        // Get the {@link Artist} object located at this position in the list
        Artist currentArtist = getItem(position);

        // Find the TextView in the list_artist.xml layout with the ID artists.
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artists);
        artistTextView.setText(currentArtist.getArtistName());

        // Find the TextView in the list_artist.xml layout with the ID artists_country.
        TextView countryTextView = (TextView) listItemView.findViewById(R.id.artists_country);
        countryTextView.setText(currentArtist.getArtistCountry());

        // Find the TextView in the list_artist.xml layout with the ID artists_year.
        TextView byearTextView = (TextView) listItemView.findViewById(R.id.artists_year);
        byearTextView.setText(currentArtist.getArtistSince());

        return listItemView;

    }
}