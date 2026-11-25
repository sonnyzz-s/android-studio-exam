
package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends Activity {

    EditText firstNumber;
    EditText secondNumber;
    TextView result;

    Button addButton;
    Button subtractButton;
    Button multiplyButton;
    Button divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        result = findViewById(R.id.result);

        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);

        addButton.setOnClickListener(v -> calculate("+"));
        subtractButton.setOnClickListener(v -> calculate("-"));
        multiplyButton.setOnClickListener(v -> calculate("*"));
        divideButton.setOnClickListener(v -> calculate("/"));
    }

    public void calculate(String operation) {

        String first = firstNumber.getText().toString();
        String second = secondNumber.getText().toString();

        if (first.length() == 0 || second.length() == 0) {
            result.setText("Введите оба числа");
            return;
        }

        double a = Double.parseDouble(first);
        double b = Double.parseDouble(second);
        double answer = 0;

        if (operation.equals("+")) {
            answer = a + b;
        } else if (operation.equals("-")) {
            answer = a - b;
        } else if (operation.equals("*")) {
            answer = a * b;
        } else if (operation.equals("/")) {
            if (b == 0) {
                result.setText("На ноль делить нельзя");
                return;
            }

            answer = a / b;
        }

        result.setText("Результат: " + answer);
    }
}
