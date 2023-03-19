package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText ConvertValue;
    private RadioGroup radioGroup;
    private Switch switch1;
    private Button Calculate;
    private TextView Amount;
    private double conversionRate;
    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConvertValue = findViewById(R.id.ConversionNumber);
        radioGroup = findViewById(R.id.radioGroup);
        switch1 = findViewById(R.id.switch1);
        Calculate = findViewById(R.id.Calcluatebutton);
        Amount = findViewById(R.id.Result);

        Calculate.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                try {
                    String value = ConvertValue.getText().toString();
                    int value1 = Integer.parseInt(value);
                    int radioId = radioGroup.getCheckedRadioButtonId(); // get the id of the selected radio button/


                    //use switch case
                    switch(radioId)
                    {
                        case (R.id.ML):
                            if(switch1.isChecked())
                            {
                                conversionRate = 29.573;

                            }
                            else
                            {
                                conversionRate = 0.033814;

                            }
                            break;
                        case( R.id.G):

                            if(switch1.isChecked())
                            {
                                conversionRate = 240;

                            }

                            else
                            {
                                conversionRate = 0.008;

                            }
                            break;
                    }
                    double result = value1* conversionRate;
                    Amount.setText(String.valueOf(result));

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Please enter a valid number.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}