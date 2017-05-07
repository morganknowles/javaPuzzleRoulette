package com.group.cis248.puzzleroulette;

import java.util.Random;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by Morgan Knowles
 * Android Studio
 * Puzzle Picker Final Project
 * 12/15/2016
 */

public class MorganPuzzlePickerUnscramble extends AppCompatActivity {

    private EditText text2;
    private Button sButton2;

    Random rand = new Random();//new random number generator

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.morgan_puzzle_picker_unscramble);

        //get the word passed from the last activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final String word = extras.getString("scram");
            String scrambled = scramble(rand, word);
            display(R.id.scrambledWord, scrambled);

            //create an on click listener to listen for a click
            text2 = (EditText) findViewById(R.id.userUnscrambleGuess);
            sButton2 = (Button) findViewById(R.id.checkGuess);
            sButton2.setOnClickListener(new View.OnClickListener() {

                /**
                 * when the user clicks, collect the string from the listener
                 * store string to userGuess
                 * call compareWords to compare word and userGuess
                 */
                @Override
                public void onClick(View v) {
                    String userGuess = text2.getText().toString();
                    compareWords(word, userGuess);
                }
            });
        }
    }

    /**
     *
     * Scramble uses the Fisher-Yates shuffle and returns a random string
     */
    public static String scramble(Random rand, String word){
        char arr[] = word.toCharArray();

        for(int i =0; i < arr.length -1; i++){
            int j = rand.nextInt(arr.length - 1);
            char temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
        }
        return new String(arr);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    public void display(int findID, String word) {
        TextView showWord= (TextView) findViewById(findID);
        showWord.setText(word);
    }

    public void compareWords(String orig, String guess){
        if(orig.equalsIgnoreCase(guess)){
            display(R.id.answer, "You're right!");
        }
        else{
            display(R.id.answer, "You're wrong. Try again.");
        }

    }

}