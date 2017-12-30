package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.android.scorekeeper.R;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int foulsTeamA = 0;
    int foulsTeamB = 0;
    int yellowsTeamA = 0;
    int yellowsTeamB = 0;
    int redsTeamA = 0;
    int redsTeamB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addScoreForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayScoreForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addScoreForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayScoreForTeamB(scoreTeamB);
    }

       /**
     * Increase the fouls for Team A.
     */
    public void addFoulForTeamA(View v) {
        foulsTeamA = foulsTeamA + 1;
        displayFoulsForTeamA(foulsTeamA);
    }

    /**
     * Increase the fouls for Team B.
     */
    public void addFoulForTeamB(View v) {
        foulsTeamB = foulsTeamB + 1;
        displayFoulsForTeamB(foulsTeamB);
    }

    /**
     * Increase the yellows for Team A.
     */
    public void addYellowForTeamA(View v) {
        yellowsTeamA = yellowsTeamA + 1;
        displayYellowsForTeamA(yellowsTeamA);
    }

    /**
     * Increase the yellows for Team B.
     */
    public void addYellowForTeamB(View v) {
        yellowsTeamB = yellowsTeamB + 1;
        displayYellowsForTeamB(yellowsTeamB);
    }

    /**
     * Increase the reds for Team A.
     */
    public void addRedForTeamA(View v) {
        redsTeamA = redsTeamA + 1;
        displayRedsForTeamA(redsTeamA);
    }

    /**
     * Increase the reds for Team B.
     */
    public void addRedForTeamB(View v) {
        redsTeamB = redsTeamB + 1;
        displayRedsForTeamB(redsTeamB);
    }


    /*
     * Reset the score, fouls, yellows and reds for both teams back to 0.
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulsTeamA = 0;
        foulsTeamB = 0;
        yellowsTeamA = 0;
        yellowsTeamB = 0;
        redsTeamA = 0;
        redsTeamB = 0;
        displayScoreForTeamA(scoreTeamA);
        displayScoreForTeamB(scoreTeamB);
        displayFoulsForTeamA(foulsTeamA);
        displayFoulsForTeamB(foulsTeamB);
        displayYellowsForTeamA(yellowsTeamA);
        displayYellowsForTeamB(yellowsTeamB);
        displayRedsForTeamA(redsTeamA);
        displayRedsForTeamB(redsTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given foul for Team A.
     */
    public void displayFoulsForTeamA(int foul) {
        TextView foulView = (TextView) findViewById(R.id.team_a_fouls);
        foulView.setText(String.valueOf(foul));
    }

    /**
     * Displays the given foul for Team B.
     */
    public void displayFoulsForTeamB(int foul) {
        TextView foulView = (TextView) findViewById(R.id.team_b_fouls);
        foulView.setText(String.valueOf(foul));
    }

    /**
     * Displays the given yellow card for Team A.
     */
    public void displayYellowsForTeamA(int yellow) {
        TextView yellowView = (TextView) findViewById(R.id.team_a_yellow_cards);
        yellowView.setText(String.valueOf(yellow));
    }

    /**
     * Displays the given yellow card for Team B.
     */
    public void displayYellowsForTeamB(int yellow) {
        TextView yellowView = (TextView) findViewById(R.id.team_b_yellow_cards);
        yellowView.setText(String.valueOf(yellow));
    }

    /**
     * Displays the given red card for Team A.
     */
    public void displayRedsForTeamA(int red) {
        TextView redView = (TextView) findViewById(R.id.team_a_red_cards);
        redView.setText(String.valueOf(red));
    }

    /**
     * Displays the given red card for Team B.
     */
    public void displayRedsForTeamB(int red) {
        TextView redView = (TextView) findViewById(R.id.team_b_red_cards);
        redView.setText(String.valueOf(red));
    }
}