package com.example.simplecal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1, editText2;
    Button add, subtract, multiply, divide;
    TextView result;
    double resultAnswer = 0;
    String srtDouble;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.texta);
        editText2 = (EditText) findViewById(R.id.textf);

        add = (Button) findViewById(R.id.add);
        subtract = (Button) findViewById(R.id.subtract);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);


        Button answer = findViewById(R.id.answer);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("message", srtDouble);
                startActivity(intent);
            }
        });

        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        double numberOne = 0;
        double numberTwo = 0;


        if (TextUtils.isEmpty(editText2.getText().toString()) || TextUtils.isEmpty(editText2.getText().toString())) {
            return;
        }

        numberOne = Float.parseFloat(editText1.getText().toString());
        numberTwo = Float.parseFloat(editText2.getText().toString());


        switch (v.getId()) {
            case R.id.add:
                resultAnswer = numberOne + numberTwo;
                srtDouble = String.format("%.3f",resultAnswer);
                break;
            case R.id.subtract:
                resultAnswer = numberOne - numberTwo;
                srtDouble = String.format("%.3f",resultAnswer);
                break;
            case R.id.multiply:
                resultAnswer = numberOne * numberTwo;
                srtDouble = String.format("%.3f",resultAnswer);
                break;
            case R.id.divide:
                if (numberTwo == 0) {
                    srtDouble = "Division by zero is not possible";
                } else {
                resultAnswer = numberOne / numberTwo;
                srtDouble = String.format("%.3f",resultAnswer);
                }
                break;
            default:
                break;
        }

    }
}

