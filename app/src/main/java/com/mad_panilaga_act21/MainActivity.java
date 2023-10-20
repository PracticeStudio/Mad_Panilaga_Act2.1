package com.mad_panilaga_act21;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String currentInput = "";
    private String currentOperator = "";
    private double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_main); // Corrected the layout resource name

        resultTextView = findViewById(R.id.result);

        // Initialize buttons
        Button buttonZero = findViewById(R.id.button_zero);
        Button buttonOne = findViewById(R.id.button_one);
        Button buttonTwo = findViewById(R.id.button_two);
        Button buttonThree = findViewById(R.id.button_three);
        Button buttonFour = findViewById(R.id.button_four);
        Button buttonFive = findViewById(R.id.button_five);
        Button buttonSix = findViewById(R.id.button_six);
        Button buttonSeven = findViewById(R.id.button_seven);
        Button buttonEight = findViewById(R.id.button_eight);
        Button buttonNine = findViewById(R.id.button_nine);

        Button buttonAddition = findViewById(R.id.button_addition);
        Button buttonSubtraction = findViewById(R.id.button_minus); // Corrected button ID
        Button buttonMultiplication = findViewById(R.id.button_multiply); // Corrected button ID
        Button buttonDivision = findViewById(R.id.button_divide); // Corrected button ID

        Button buttonEquals = findViewById(R.id.button_equals);
        Button buttonClear = findViewById(R.id.button_ac);
        Button buttonDot = findViewById(R.id.button_dot);

        findViewById(R.id.button_openbracket);
        findViewById(R.id.button_closebracket);
        findViewById(R.id.button_mod);
        findViewById(R.id.button_negative);
        findViewById(R.id.button_squareroot);
        findViewById(R.id.button_powerofn);

        findViewById(R.id.button_square);
        findViewById(R.id.button_logarithmic);
        findViewById(R.id.button_exponents);
        findViewById(R.id.button_reciprocal);

        findViewById(R.id.button_rootsofn);

        buttonZero.setOnClickListener(v -> appendToResult("0"));

        buttonOne.setOnClickListener(v -> appendToResult("1"));

        buttonTwo.setOnClickListener(v -> appendToResult("2"));

        buttonThree.setOnClickListener(v -> appendToResult("3"));

        buttonFour.setOnClickListener(v -> appendToResult("4"));

        buttonFive.setOnClickListener(v -> appendToResult("5"));

        buttonSix.setOnClickListener(v -> appendToResult("6"));

        buttonSeven.setOnClickListener(v -> appendToResult("7"));

        buttonEight.setOnClickListener(v -> appendToResult("8"));

        buttonNine.setOnClickListener(v -> appendToResult("9"));

        buttonAddition.setOnClickListener(v -> handleOperator("+"));

        buttonSubtraction.setOnClickListener(v -> handleOperator("-"));

        buttonMultiplication.setOnClickListener(v -> handleOperator("*"));

        buttonDivision.setOnClickListener(v -> handleOperator("/"));

        buttonEquals.setOnClickListener(v -> calculateResult());

        buttonClear.setOnClickListener(v -> clearInput());

        buttonDot.setOnClickListener(v -> appendToResult("."));

    }

    private void appendToResult(String text) {
        String currentText = resultTextView.getText().toString();
        resultTextView.setText(currentText + text);
    }

    private void handleOperator(String operator) {
        if (!currentInput.isEmpty()) {
            currentOperator = operator;
            result = Double.parseDouble(currentInput);
            currentInput = "";
        }
    }

    private void calculateResult() {
        if (!currentInput.isEmpty()) {
            double secondOperand = Double.parseDouble(currentInput);
            switch (currentOperator) {
                case "+":
                    result += secondOperand;
                    break;
                case "-":
                    result -= secondOperand;
                    break;
                case "*":
                    result *= secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result /= secondOperand;
                    } else {
                        // Handle division by zero error
                        resultTextView.setText("Error");
                        return;
                    }
                    break;
            }
            resultTextView.setText(String.valueOf(result));
            currentInput = "";
        }
    }

    private void clearInput() {
        resultTextView.setText("0");
        currentInput = "";
        currentOperator = "";
        result = 0.0;
    }

}
