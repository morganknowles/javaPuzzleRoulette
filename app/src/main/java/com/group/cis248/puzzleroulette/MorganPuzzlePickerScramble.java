package com.group.cis248.puzzleroulette;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import static com.group.cis248.puzzleroulette.R.layout.morgan_puzzle_picker_scramble;

/**
 * Created by Morgan Knowles
 * Android Studio
 * Puzzle Picker Final Project
 * 12/15/2016
 */

public class MorganPuzzlePickerScramble extends AppCompatActivity {

    private EditText text;
    private Button sButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(morgan_puzzle_picker_scramble);

        //create an on click listener to listen for a button click
        text = (EditText) findViewById(R.id.wordToScramble);
        sButton = (Button) findViewById(R.id.scrambleButton);
        sButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String word = text.getText().toString();
                goToUnscramble(word, v);

            }
        });
    }

    /**
     * Go to the unscramble activity and pass along the user's word
     */
    public void goToUnscramble(String word, View v) {
        Intent go = new Intent(MorganPuzzlePickerScramble.this, MorganPuzzlePickerUnscramble.class);
        go.putExtra("scram", word);
        startActivity(go);
    }
}


