package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.LineNumberReader;
import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create an array of words
        ArrayList<String> words = new ArrayList<String>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");

        // Finds the view (rootView) that is stored in a variable called rootView
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        int index = 0;

        while (index < words.size()) {
            // Creates a TextView object that is stored in a variable called wordView, data type is TextView
            TextView wordsView = new TextView(this);
            // Changes the text that is displayed in the TextView
            wordsView.setText(words.get(index));
            // Adds the child view (TextView) to the parent view (rootView)
            rootView.addView(wordsView);
            // Update counter variable
            index++;
        }
    }
}