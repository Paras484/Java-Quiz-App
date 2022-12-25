package com.example.javaquizzer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    private int score=0;
    private int index=0;
    private String selectedAnswer="";
    TextView question;
    Button opt1;
    Button opt2;
    Button opt3;
    Button opt4;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        opt1=findViewById(R.id.button7);
        opt2=findViewById(R.id.button4);
        opt3=findViewById(R.id.button5);
        opt4=findViewById(R.id.button6);
        submit=findViewById(R.id.button8);
        question=findViewById(R.id.textView4);

        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);
        opt3.setOnClickListener(this);
        opt4.setOnClickListener(this);
        submit.setOnClickListener(this);

        loadNewQuestion();

    }

    private void loadNewQuestion() {

        if(index==6){
            finishQuiz();
            return;
        }

        question.setText(QuestionAnswers.questions[index]);
        opt1.setText(QuestionAnswers.choices[index][0]);
        opt2.setText(QuestionAnswers.choices[index][1]);
        opt3.setText(QuestionAnswers.choices[index][2]);
        opt4.setText(QuestionAnswers.choices[index][3]);
    }

    private void finishQuiz() {
        Toast.makeText(this, "Your score is " + score, Toast.LENGTH_SHORT).show();
        new AlertDialog.Builder(this).setTitle("Score").setMessage("Your score is " + score).setPositiveButton("Restart", ((dialog, which) -> restartQuiz())).setCancelable(false).show();
    }

    private void restartQuiz() {
        index=0;
        score=0;
        loadNewQuestion();
    }

    @Override
    public void onClick(View v) {

        opt1.setBackgroundColor(Color.GRAY);
        opt2.setBackgroundColor(Color.GRAY);
        opt3.setBackgroundColor(Color.GRAY);
        opt4.setBackgroundColor(Color.GRAY);

        Button clickedButton = (Button) v;
        if(clickedButton.getId()==R.id.button8){
            if(selectedAnswer == QuestionAnswers.answers[index]){
                score++;
            }
            index++;
            loadNewQuestion();
        }
        else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }
}