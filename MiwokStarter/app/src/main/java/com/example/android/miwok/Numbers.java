package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Create an array of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti", R.drawable.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight));
        words.add(new Word("nine", "wo’e", R.drawable.number_nine));
        words.add(new Word("ten", "na’aacha", R.drawable.number_ten));


        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

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