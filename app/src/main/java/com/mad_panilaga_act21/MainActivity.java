package com.mad_panilaga_act21;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView resultTextView;
    private String currentInput = ""; // Store the current input
    private double firstOperand = 0; // Store the first operand
    private String operator = ""; // Store the current operator

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.result);
        initializeButtons();
    }

    private void initializeButtons() {
        // Initialize buttons by their IDs
        Button[] buttons = {
                findViewById(R.id.button_O),
                findViewById(R.id.button_openbracket),
                findViewById(R.id.button_closebracket),
                findViewById(R.id.button_divide),
                findViewById(R.id.button_seven),
                findViewById(R.id.button_eight),
                findViewById(R.id.button_nine),
                findViewById(R.id.button_multiply),
                findViewById(R.id.button_four),
                findViewById(R.id.button_five),
                findViewById(R.id.button_six),
                findViewById(R.id.button_addition),
                findViewById(R.id.button_one),
                findViewById(R.id.button_two),
                findViewById(R.id.button_three),
                findViewById(R.id.button_minus),
                findViewById(R.id.button_ac),
                findViewById(R.id.button_zero),
                findViewById(R.id.button_dot),
                findViewById(R.id.button_equals),
                findViewById(R.id.button_mod),
                findViewById(R.id.button_negative),
                findViewById(R.id.button_squareroot),
                findViewById(R.id.button_powerofn),
                findViewById(R.id.button_square),
                findViewById(R.id.button_logarithmic),
                findViewById(R.id.button_exponents),
                findViewById(R.id.button_reciprocal),
                findViewById(R.id.button_rootsofn)
        };

        for (Button button : buttons) {
            setButtonClickListener(button);
        }
    }

    private void setButtonClickListener(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick(button.getText().toString());
            }
        });
    }

    private void handleButtonClick(String buttonValue) {
        if (isNumber(buttonValue)) {
            currentInput += buttonValue;
        } else if (isOperator(buttonValue)) {
            performOperation();
            operator = buttonValue;
        } else if (buttonValue.equals("=")) {
            performOperation();
            operator = "";
        }

        updateResultTextView();
    }

    private void performOperation() {
        if (!currentInput.isEmpty()) {
            double input = Double.parseDouble(currentInput);
            switch (operator) {
                case "+":
                    firstOperand += input;
                    break;
                case "-":
                    firstOperand -= input;
                    break;
                case "*":
                    firstOperand *= input;
                    break;
                case "/":
                    if (input != 0) {
                        firstOperand /= input;
                    } else {
                        // Handle division by zero error
                    }
                    break;
                // Add cases for other operators
            }
            currentInput = Double.toString(firstOperand);
        }
    }

    private void updateResultTextView() {
        resultTextView.setText(currentInput);
    }

    private boolean isNumber(String value) {
        return value.matches("\\d") || value.equals(".");
    }

    private boolean isOperator(String value) {
        return "+-*/".contains(value);
    }
}
