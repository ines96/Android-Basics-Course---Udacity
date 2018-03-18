package com.example.android.musicplayer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the now category
        TextView now = (TextView) findViewById(R.id.now_text_view);

        // Set a click listener on that View
        now.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the now View is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NowActivity}
                Intent nowIntent = new Intent(MainActivity.this, NowActivity.class);
                // Start the new activity
                startActivity(nowIntent);
            }
        });

        // Find the View that shows the song category
        TextView song = (TextView) findViewById(R.id.details_text_view);

        // Set a click listener on that View
        song.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the song View is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SongActivity}
                Intent songIntent = new Intent(MainActivity.this, SongActivity.class);
                // Start the new activity
                startActivity(songIntent);
            }
        });

        // Find the View that shows the search category
        TextView search = (TextView) findViewById(R.id.search_text_view);

        // Set a click listener on that View
        search.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the search View is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SearchActivity}
                Intent searchIntent = new Intent(MainActivity.this, SearchableActivity.class);
                // Start the new activity
                startActivity(searchIntent);
            }
        });

        // Find the View that shows the artists category
        TextView artists = (TextView) findViewById(R.id.artist_text_view);

        // Set a click listener on that View
        artists.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the search View is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ArtistsActivity}
                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);
                // Start the new activity
                startActivity(artistsIntent);
            }
        });

        // Find the View that shows the albums category
        TextView albums = (TextView) findViewById(R.id.album_text_view);

        // Set a click listener on that View
        albums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the search View is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link AlbumsActivity}
                Intent albumsIntent = new Intent(MainActivity.this, AlbumsActivity.class);
                // Start the new activity
                startActivity(albumsIntent);
            }
        });
    }
}
