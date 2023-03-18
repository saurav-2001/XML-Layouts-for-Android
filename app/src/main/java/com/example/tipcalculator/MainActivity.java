package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the "Calculate" button in the layout and set a listener to it
        Button calcBtn = findViewById(R.id.calculate_button);
        calcBtn.setOnClickListener(v -> {
            tipCalculate();
        });
    }

    // This method calculates the tip and updates the UI with the result
    private void tipCalculate() {

        RadioGroup tipOption = findViewById(R.id.tip_options);
        TextView tipAmount = findViewById(R.id.tip_result);
        EditText billAmount = findViewById(R.id.cost_of_service);
        Switch roundUp = findViewById(R.id.round_up_switch);
        boolean shouldRoundUp = roundUp.isChecked();
        double result = 0;

        try {
            // Get the bill amount from the user input and parse it into an integer
            Double amount = Double.parseDouble(billAmount.getText().toString());

            // Get the selected radio button ID
            int selectedOption = tipOption.getCheckedRadioButtonId();

            // Calculate the tip based on the selected option and if the round up switch is on
            if (shouldRoundUp) {

                if (selectedOption == R.id.option_twenty_percent) {

                    // Calculate the result and round it up
                    result = Math.ceil(amount * 0.20);

                    // Update the text with the result
                    tipAmount.setText("Tip Amount: " + String.valueOf(result));

                } else if (selectedOption == R.id.option_eighteen_percent) {

                    // Calculate the result and round it up
                    result = Math.ceil(amount * 0.18);

                    // Update the text with the result
                    tipAmount.setText("Tip Amount: " + String.valueOf(result));

                } else if (selectedOption == R.id.option_fifteen_percent) {

                    // Calculate the result and round it up
                    result = Math.ceil(amount * 0.15);

                    // Update the text with the result
                    tipAmount.setText("Tip Amount: " + String.valueOf(result));

                }

            } else {

                // Calculate the tip based on the selected option and if the round up switch is off
                DecimalFormat df = new DecimalFormat("#.##");

                if (selectedOption == R.id.option_twenty_percent) {

                    // Calculate the result
                    result = amount * 0.20;

                    // Format the result based on the Decimal Format
                    String formattedResult = df.format(result);
                    double finalResult = Double.parseDouble((formattedResult));

                    // Update the text with the result
                    tipAmount.setText("Tip Amount: " + String.valueOf(finalResult));

                } else if (selectedOption == R.id.option_eighteen_percent) {

                    // Calculate the result
                    result = amount * 0.18;

                    // Format the result based on the Decimal Format
                    String formattedResult = df.format(result);
                    double finalResult = Double.parseDouble((formattedResult));

                    // Update the text with the result
                    tipAmount.setText("Tip Amount: " + String.valueOf(finalResult));

                } else if (selectedOption == R.id.option_fifteen_percent) {

                    // Calculate the result
                    result = amount * 0.15;

                    // Format the result based on the Decimal Format
                    String formattedResult = df.format(result);
                    double finalResult = Double.parseDouble((formattedResult));

                    // Update the text with the result
                    tipAmount.setText("Tip Amount: " + String.valueOf(finalResult));

                }
            }

        } catch (NumberFormatException e) {

            // Show a toast message if the user did not enter a valid bill amount
            Toast toast = Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}