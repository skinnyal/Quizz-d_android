package com.example.android.quizzd;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String _checkForRightAnswerQuestionOne = "Question One is ";
    private String _checkForRightAnswerQuestionTwo = "Question Two is ";
    private String _checkForRightAnswerQuestionThree = "Question Three is ";
    private String _checkForRightAnswerQuestionFour = "Question Four is ";
    private final String _CORRECT = "CORRECT";
    private final String _WRONG = "WRONG";
    private String _answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * submits quiz results
     */

    public void submitResults(View view) {
        EditText nameEditTextView = (EditText) findViewById(R.id.name_edit_text_view);
        String customerName = nameEditTextView.getText().toString();

        String results = customerName
                + "\n" + questionOne()
                + "\n" + questionTwo()
                + "\n" + questionThree()
                + "\n" + questionFour();

        printResultsToScreen(results);

    }

    public String questionOne() {
        EditText answerOneEditTextView =
                (EditText) findViewById(R.id.answer_one_edit_text_view);
        String receivedAnswerOne =
                answerOneEditTextView.getText().toString();
        String ans1 = setAnswer("Solomon"); //answer for question one.

        if (receivedAnswerOne.equalsIgnoreCase(ans1)) {
            return _checkForRightAnswerQuestionOne + _CORRECT;
        }
        return _checkForRightAnswerQuestionOne + _WRONG;
    }

    public String questionTwo() {
        RadioButton radio2 =
                (RadioButton) findViewById(R.id.radio_button_view_two);
        boolean checkedRadio2 = radio2.isChecked();

        // Checks if answer for Question two is correct or not.
        if (checkedRadio2) {
            _checkForRightAnswerQuestionTwo = "Question Two is Correct";
        }else {
            _checkForRightAnswerQuestionTwo = "Question Two is WRONG!";
        }
        return _checkForRightAnswerQuestionTwo;
    }

    public String questionThree() {
        CheckBox checkBox1 =
                (CheckBox) findViewById(R.id.checkbox_view_one);
        CheckBox checkBox2 =
                (CheckBox) findViewById(R.id.checkbox_view_two);
        boolean checkedAnswerOne = checkBox1.isChecked();
        boolean checkedAnswerTwo = checkBox2.isChecked();

        // The question is only right if both checkboxes are checked.
        if ((checkedAnswerOne) && (checkedAnswerTwo)) {
            _checkForRightAnswerQuestionThree = "Question Three is Correct";
        }else {
            _checkForRightAnswerQuestionThree = "Question Three is WRONG!";
        }
        return _checkForRightAnswerQuestionThree;
    }

    public String questionFour() {
        EditText answerFourEditTextView =
                (EditText) findViewById(R.id.answer_four_edit_text_view);
        String receivedAnswerFour =
                answerFourEditTextView.getText().toString();
        String ans4 = setAnswer("Daniel"); //answer for question four.

        if (receivedAnswerFour.equalsIgnoreCase(ans4)) {
            _checkForRightAnswerQuestionFour = "Question Four is correct";
        }else {
            _checkForRightAnswerQuestionFour = "Question Four is WRONG!";
        }
        return _checkForRightAnswerQuestionFour;
    }

    public String setAnswer( String ans) {
        this._answer = ans;
        return _answer;
    }

    public void printResultsToScreen(String results) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast =
                Toast.makeText(context, results, duration);
        toast.show();
        toast.setText(results);
    }


}
