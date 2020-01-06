package com.example.temperature_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button fBtn , cBtn;
    TextView showResultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.enterET);
        fBtn = (Button) findViewById(R.id.farenhaidBTN);
        cBtn = (Button) findViewById(R.id.ciliclusBTN);
        showResultTv = (TextView) findViewById(R.id.Result);

        fBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getEditText() != 0){
                    float result = conerverToCelsius(getEditText());
                    setTestToTextview(result);
                }
            }
        });

        cBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getEditText() != 0){
                    float result = conerverToFahrenheit(getEditText());
                    setTestToTextview(result);
                }
            }
        });
    }

    void setTestToTextview(float st){
        showResultTv.setText(String.valueOf(st));
    }

    float conerverToCelsius(double farVal){
        return (float) ((farVal - 32) * 5/9);
    }

    float conerverToFahrenheit(double celVal){
        return (float) ((celVal * 9/5) - 32);
    }

    float getEditText(){
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext() , "مقداری را وارد کنید!" , Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Float.valueOf(editText.getText().toString());
    }
}
