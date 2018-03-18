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

public class AlbumAdapter extends ArrayAdapter<Album> {
    /**
     * Create a new {@link AlbumAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param albums is the list of {@link Album}s to be displayed.
     */
    public AlbumAdapter(Context context, ArrayList<Album> albums) {
        super(context, 0, albums);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }

        // Get the {@link Album} object located at this position in the list
        Album currentAlbum = getItem(position);

        // Find the TextView in the list_album.xml layout with the ID albums.
        TextView albumTextView = (TextView) listItemView.findViewById(R.id.albums);
        albumTextView.setText(currentAlbum.getAlbumTitle());

        // Find the TextView in the list_album.xml layout with the ID album_artist.
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.album_artist);
        artistTextView.setText(currentAlbum.getArtistName());

        // Find the TextView in the list_album.xml layout with the ID album_year.
        TextView yearTextView = (TextView) listItemView.findViewById(R.id.album_year);
        yearTextView.setText(currentAlbum.getAlbumYear());

        return listItemView;
    }
}
