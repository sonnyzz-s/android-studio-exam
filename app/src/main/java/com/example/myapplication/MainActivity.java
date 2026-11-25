
package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.widget.AdapterView;
import android.app.Activity;
import java.util.ArrayList;
import android.content.Intent;

public class MainActivity extends Activity {

    EditText taskInput;
    Button addButton;
    TextView taskCounter;
    ListView taskList;

    ArrayList<String> tasks;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculatorButton = findViewById(R.id.calculatorButton);

        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });

        taskInput = findViewById(R.id.taskInput);
        addButton = findViewById(R.id.addButton);
        taskCounter = findViewById(R.id.taskCounter);
        taskList = findViewById(R.id.taskList);

        tasks = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                tasks
        );

        taskList.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String task = taskInput.getText().toString();

                if (task.trim().length() > 0) {
                    tasks.add(task);
                    adapter.notifyDataSetChanged();

                    taskInput.setText("");
                    taskCounter.setText("Количество задач: " + tasks.size());
                }
            }
        });

        taskList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                tasks.remove(position);
                adapter.notifyDataSetChanged();

                taskCounter.setText("Количество задач: " + tasks.size());
            }
        });
    }
}
