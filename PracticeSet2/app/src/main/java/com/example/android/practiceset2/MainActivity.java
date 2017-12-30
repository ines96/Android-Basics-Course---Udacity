package com.example.android.practiceset2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int weekday = 5;
        int weekend = 9;
        int optimalHours = 7 * 8;

        int actualHours = weekend * 2 + weekday * 5;
        int solution = optimalHours - actualHours;
        display(solution);
    }

    /**
     * Display methods that allow the text to appear on the screen. Don't worry if you don't know
     * how these work yet. We'll be covering them in lesson 3.
     */
    public void display (int i) {
        TextView t = (TextView) findViewById(R.id.display_text_view);
        t.setText(""+i);
    }
}