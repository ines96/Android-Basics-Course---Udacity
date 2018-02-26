package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.LineNumberReader;
import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create an array of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti"));
        words.add(new Word("two", "otiiko"));
        words.add(new Word("three", "tolookosu"));
        words.add(new Word("four", "oyyisa"));
        words.add(new Word("five", "massokka"));
        words.add(new Word("six", "temmokka"));
        words.add(new Word("seven", "kenekaku"));
        words.add(new Word("eight", "kawinta"));
        words.add(new Word("nine", "wo’e"));
        words.add(new Word("ten", "na’aacha"));


        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        /**Finds the view (rootView) that is stored in a variable called rootView
         *  LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
         */

        // ---------- For loop version ----------
        /**
         *for (int index = 0; index < words.size(); index++) {
         *   // Creates a TextView object that is stored in a variable called wordView, data type is TextView
         *   TextView wordsView = new TextView(this);
         *   // Changes the text that is displayed in the TextView
         *   wordsView.setText(words.get(index));
         *   //Adds the child view (TextView) to the parent view (rootView)
         *   rootView.addView(wordsView);
         *}
         */

        // ---------- While loop version ----------
        /**
         * int index = 0;
         * while (index < words.size()) {
         *      TextView wordsView = new TextView(this);
         *      wordsView.setText(words.get(index));
         *      rootView.addView(wordsView);
         *      index++;
         * }
         */

    }
}