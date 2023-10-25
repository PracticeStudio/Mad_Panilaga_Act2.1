package com.mad_panilaga_act21;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private TextView calculationTextView;
    private String currentInput = "";
    private String operator = "";
    private double firstNumber = 0;
    private boolean clearScreen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.result);
        calculationTextView = findViewById(R.id.calculation);

        MaterialButton num0 = findViewById(R.id.num0);
        MaterialButton num1 = findViewById(R.id.num1);
        MaterialButton num2 = findViewById(R.id.num2);
        MaterialButton num3 = findViewById(R.id.num3);
        MaterialButton num4 = findViewById(R.id.num4);
        MaterialButton num5 = findViewById(R.id.num5);
        MaterialButton num6 = findViewById(R.id.num6);
        MaterialButton num7 = findViewById(R.id.num7);
        MaterialButton num8 = findViewById(R.id.num8);
        MaterialButton num9 = findViewById(R.id.num9);

        MaterialButton addition = findViewById(R.id.addition);
        MaterialButton subtraction = findViewById(R.id.subtraction);
        MaterialButton multiplication = findViewById(R.id.multiply);
        MaterialButton division = findViewById(R.id.divide);

        MaterialButton dot = findViewById(R.id.dot);
        MaterialButton ac = findViewById(R.id.ac);
        MaterialButton equals = findViewById(R.id.equals);

        num0.setOnClickListener(v -> onNumberClick(v));
        num1.setOnClickListener(v -> onNumberClick(v));
        num2.setOnClickListener(v -> onNumberClick(v));
        num3.setOnClickListener(v -> onNumberClick(v));
        num4.setOnClickListener(v -> onNumberClick(v));
        num5.setOnClickListener(v -> onNumberClick(v));
        num6.setOnClickListener(v -> onNumberClick(v));
        num7.setOnClickListener(v -> onNumberClick(v));
        num8.setOnClickListener(v -> onNumberClick(v));
        num9.setOnClickListener(v -> onNumberClick(v));

        addition.setOnClickListener(v -> onOperatorClick(v));
        subtraction.setOnClickListener(v -> onOperatorClick(v));
        multiplication.setOnClickListener(v -> onOperatorClick(v));
        division.setOnClickListener(v -> onOperatorClick(v));

        dot.setOnClickListener(v -> onDotClick(v));
        ac.setOnClickListener(v -> onClearClick(v));
        equals.setOnClickListener(v -> onEqualsClick(v));
    }

    // Function to handle number button clicks
    public void onNumberClick(View view) {
        if (clearScreen) {
            clearScreen = false;
            currentInput = "";
        }
        String number = ((TextView) view).getText().toString();
        currentInput += number;
        calculationTextView.setText(currentInput);
    }

    // Function to handle operator button clicks
    public void onOperatorClick(View view) {
        if (!currentInput.isEmpty()) {
            operator = ((TextView) view).getText().toString();
            firstNumber = Double.parseDouble(currentInput);
            currentInput = "";
            calculationTextView.setText(operator);
        }
    }

    // Function to handle dot button click
    public void onDotClick(View view) {
        if (clearScreen) {
            clearScreen = false;
            currentInput = "";
        }
        if (!currentInput.contains(".")) {
            currentInput += ".";
            calculationTextView.setText(currentInput);
        }
    }

    // Function to handle equals button click
    public void onEqualsClick(View view) {
        if (!currentInput.isEmpty()) {
            double secondNumber = Double.parseDouble(currentInput);
            double result = 0;
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        // Handle division by zero error
                        calculationTextView.setText("Error");
                        clearScreen = true;
                        return;
                    }
                    break;
            }
            resultTextView.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
            clearScreen = true;
        }
    }

    // Function to handle clear button click
    public void onClearClick(View view) {
        currentInput = "";
        operator = "";
        firstNumber = 0;
        resultTextView.setText("");
        calculationTextView.setText("");
    }
}
