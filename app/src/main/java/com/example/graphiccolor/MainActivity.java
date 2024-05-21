package com.example.graphiccolor;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RadioButton red, blue, yellow, green;
    RadioGroup colorRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red = findViewById(R.id.rbRed);
        blue = findViewById(R.id.rbBlue);
        yellow = findViewById(R.id.rbYellow);
        green = findViewById(R.id.rbGreen);

        colorRadioGroup = findViewById(R.id.colorRadioGroup);
        colorRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                changeBackgroundColor(findViewById(checkedId));
            }
        });
    }

    public void showSelectedColor(View view) {
        RadioButton radioButton = (RadioButton) view;
        Toast.makeText(getApplicationContext(), "Color: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

    public void changeBackgroundColor(View view) {
        if (view instanceof RadioButton) {
            RadioButton radioButton = (RadioButton) view;
            int color;
            if (radioButton.getId() == R.id.rbRed) {
                color = Color.RED;
            } else if (radioButton.getId() == R.id.rbBlue) {
                color = Color.BLUE;
            } else if (radioButton.getId() == R.id.rbYellow) {
                color = Color.YELLOW;
            } else if (radioButton.getId() == R.id.rbGreen) {
                color = Color.GREEN;
            } else {
                color = Color.RED;
            }
            getWindow().getDecorView().setBackgroundColor(color);
            showSelectedColor(view);
        } else {

        }
    }
    public void selectRandomColor(View view) {

        int randomIndex = new Random().nextInt(4);


        RadioButton randomRadioButton = null;
        switch (randomIndex) {
            case 0:
                randomRadioButton = red;
                break;
            case 1:
                randomRadioButton = blue;
                break;
            case 2:
                randomRadioButton = yellow;
                break;
            case 3:
                randomRadioButton = green;
                break;
        }


        if (randomRadioButton != null) {
            randomRadioButton.setChecked(true);
        }
    }


}