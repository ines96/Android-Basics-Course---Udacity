package com.example.android.trickyquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1st Question
    RadioButton quest1_2;

    //2nd Question
    EditText quest2_answer;

    //3rd Question
    RadioButton quest3_3;

    //4th Question
    RadioButton quest4_2;

    //5th Question
    CheckBox quest5_1;
    CheckBox quest5_2;
    CheckBox quest5_3;
    CheckBox quest5_4;

    //6th Question
    CheckBox quest6_1;
    CheckBox quest6_2;
    CheckBox quest6_3;
    CheckBox quest6_4;

    //7th Question
    RadioButton quest7_3;

    //8th Question
    RadioButton quest8_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the keyboard when it is not needed
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);

    }

    // Checks which are the wrongs and right answers, and shows the final score
    public void submitAnswers(View v) {
        // -- Score text that will be displayed --
        String display_score;

        // -- Each answer score, depending if it is right (1) or wrong (0) --
        int answer1_points;
        int answer2_points;
        int answer3_points;
        int answer4_points;
        int answer5_points;
        int answer6_points;
        int answer7_points;
        int answer8_points;

        // -- Score of all the questions together --
        int total_score;


        // ------ Question 1 - Answer is "His breath" ------
        //If the correct answer is checked (quest1_2) it'll give 1 point
        //If not the player will not receive any points

        Boolean answer_q1;

        quest1_2 = (RadioButton) this.findViewById(R.id.answer12);
        answer_q1 = quest1_2.isChecked();

        if (answer_q1) {
            answer1_points = 1;
        } else {
            answer1_points = 0;
        }

        // ------ Question 2 - Answer is "Second" ------
        //If the answer given is "second" it'll give 1 point
        //If not nothing is given

        String answer_q2;

        quest2_answer = (EditText) this.findViewById(R.id.answer21);
        answer_q2 = quest2_answer.getText().toString().toLowerCase();

        if(answer_q2.equals("second")) {
            answer2_points = 1;
        } else {
            answer2_points = 0;
        }

        // ------ Question 3 - Answer is "Halfway" ------
        //If the correct answer is checked (quest3_3) it'll give 1 point
        //If not the player will not receive any points

        Boolean answer_q3;

        quest3_3 = (RadioButton) this.findViewById(R.id.answer33);
        answer_q3 = quest3_3.isChecked();

        if (answer_q3) {
            answer3_points = 1;
        } else {
            answer3_points = 0;
        }

        // ------ Question 4 - Answer is "Stop Imagining" ------
        //If the correct answer is checked (quest4_2) it'll give 1 point
        //If not the player will not receive any points

        Boolean answer_q4;

        quest4_2 = (RadioButton) this.findViewById(R.id.answer42);
        answer_q4 = quest4_2.isChecked();

        if (answer_q4) {
            answer4_points = 1;
        } else {
            answer4_points = 0;
        }

        // ------ Question 5 - Answer is "Minie & Buzz Lightyear" ------
        //If the correct boxes are checked (answer_q53 && answer_q54) it'll give 1 point
        //If not 0 points

        Boolean answer_q51;
        Boolean answer_q52;
        Boolean answer_q53;
        Boolean answer_q54;
        quest5_1 = (CheckBox) this.findViewById(R.id.answer51);
        quest5_2 = (CheckBox) this.findViewById(R.id.answer52);
        quest5_3 = (CheckBox) this.findViewById(R.id.answer53);
        quest5_4 = (CheckBox) this.findViewById(R.id.answer54);
        answer_q51 = quest5_1.isChecked();
        answer_q52 = quest5_2.isChecked();
        answer_q53 = quest5_3.isChecked();
        answer_q54 = quest5_4.isChecked();

        if(!answer_q51 && !answer_q52 && answer_q53 && answer_q54) {
            answer5_points = 1;
        } else {
            answer5_points = 0;
        }

        // ------ Question 6 - Answer is "First 6 months of the year & Last 6 months of the year" ------
        //If the correct boxes are checked (answer_q63 && answer_q64) it'll give 1 point
        //If not 0 points

        Boolean answer_q61;
        Boolean answer_q62;
        Boolean answer_q63;
        Boolean answer_q64;
        quest6_1 = (CheckBox) this.findViewById(R.id.answer61);
        quest6_2 = (CheckBox) this.findViewById(R.id.answer62);
        quest6_3 = (CheckBox) this.findViewById(R.id.answer63);
        quest6_4 = (CheckBox) this.findViewById(R.id.answer64);
        answer_q61 = quest6_1.isChecked();
        answer_q62 = quest6_2.isChecked();
        answer_q63 = quest6_3.isChecked();
        answer_q64 = quest6_4.isChecked();

        if(!answer_q61 && !answer_q62 && answer_q63 && answer_q64) {
            answer6_points = 1;
        } else {
            answer6_points = 0;
        }

        // ------ Question 7 - Answer is "Neither" ------
        //If the correct answer is checked (quest7_3) it'll give 1 point
        //If not the player will not receive any points

        Boolean answer_q7;

        quest7_3 = (RadioButton) this.findViewById(R.id.answer73);
        answer_q7 = quest7_3.isChecked();

        if (answer_q7) {
            answer7_points = 1;
        } else {
            answer7_points = 0;
        }

        // ------ Question 8 - Answer is "Equal" ------
        //If the correct answer is checked (quest8_4) it'll give 1 point
        //If not the player will not receive any points

        Boolean answer_q8;

        quest8_4 = (RadioButton) this.findViewById(R.id.answer84);
        answer_q8 = quest8_4.isChecked();

        if (answer_q8) {
            answer8_points = 1;
        } else {
            answer8_points = 0;
        }

        // ------ Total Score ------

        total_score = answer1_points + answer2_points + answer3_points +
                      answer4_points + answer5_points + answer6_points +
                      answer7_points + answer8_points;

        if(total_score == 8) {
            display_score = "Urrraaayyy!! Your score is 8/8";
        } else {
            display_score = "You could've done better. \n" +
                    "Your score is " + total_score + "/8";
        }

        // When submit button is clicked, shows a toast with the quiz score
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, display_score, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();

        ViewGroup group = (ViewGroup) toast.getView();
        TextView messageTextView = (TextView) group.getChildAt(0);
        messageTextView.setTextSize(18);
    }

    public void scrollTop (View v){
        ScrollView scrollView = (ScrollView) findViewById(R.id.scroll);
        scrollView.setScrollY(0);
    }
}
