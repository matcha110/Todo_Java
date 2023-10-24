package com.todoapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.todoapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//　ボタンを押すとダイアログが出る処理
        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.add_task_button);
        button.setOnClickListener(view -> {
            AddTaskDialogFragment dialog = new AddTaskDialogFragment();
            dialog.show(getSupportFragmentManager(), "AddTaskDialogFragment");
        });
    }
}