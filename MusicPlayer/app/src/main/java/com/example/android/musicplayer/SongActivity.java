package com.example.android.musicplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by InesL on 2/26/2018.
 */

public class SongActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        // Create a list of songs
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Amantes", "Greeicy", "Amantes"));
        songs.add(new Song("Espera", "Fernando Daniel", "Salto"));
        songs.add(new Song("Peito", "HMB", "+"));
        songs.add(new Song("La Camisa Negra", "Juanes", "Mi Sangre"));
        songs.add(new Song("21-6", "Klepht", "SIM"));
        songs.add(new Song("For You", "Rita Ora/Liam Payne", "Fifty Shades Freed Soundtrack"));
        songs.add(new Song("One More Light", "Linkin Park", "One More Light"));
        songs.add(new Song("Watching As I Fall", "Mike Shinoda", "Post Traumatic EP"));
        songs.add(new Song("Fireflies", "OwlCity", "Ocean Eyes"));
        songs.add(new Song("Midnight in Lisbon", "Richie Campbell", "Lisboa"));

        SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
