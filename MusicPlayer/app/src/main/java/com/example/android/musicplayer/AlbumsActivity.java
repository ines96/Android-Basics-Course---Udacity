package com.example.android.musicplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by InesL on 2/28/2018.
 */

public class AlbumsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        // Create a list of albums
        ArrayList<Album> albums = new ArrayList<Album>();
        albums.add(new Album("Salto", "Fernando Daniel", "2018"));
        albums.add(new Album("Espelho", "Diogo Piçarra", "2015"));
        albums.add(new Album("+", "HMB", "2017"));
        albums.add(new Album("Mi Sangre", "Juanes", "2004"));
        albums.add(new Album("SIM", "Klepht", "2016"));
        albums.add(new Album("One More Light", "Linkin Park", "2017"));
        albums.add(new Album("Post Traumatic EP", "Mike Shinoda", "2018"));
        albums.add(new Album("Ocean Eyes", "Owl City", "2009"));
        albums.add(new Album("Lisboa", "Richie Campbell", "2017"));
        albums.add(new Album("The Hunting Party", "Linkin Park", "2014"));
        AlbumAdapter adapter = new AlbumAdapter(this, albums);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}