package com.example.android.musicplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by InesL on 2/28/2018.
 */

public class ArtistsActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        // Create a list of artists
        ArrayList<Artist> artists = new ArrayList<Artist>();
        artists.add(new Artist("Fernando Daniel", "Portugal", "2016"));
        artists.add(new Artist("Diogo Piçarra", "Portugal", "2012"));
        artists.add(new Artist("HMB", "Portugal", "2007"));
        artists.add(new Artist("Juanes", "Colombia", "1988"));
        artists.add(new Artist("Klepht", "Portugal", "2001"));
        artists.add(new Artist("Linkin Park", "USA", "1996"));
        artists.add(new Artist("Mike Shinoda", "USA", "1996"));
        artists.add(new Artist("Owl City", "USA", "2007"));
        artists.add(new Artist("Richie Campbell", "Portugal", "2010"));
        artists.add(new Artist("Scorpions", "Germany", "1965"));
        ArtistAdapter adapter = new ArtistAdapter(this, artists);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
