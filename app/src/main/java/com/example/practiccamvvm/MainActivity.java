package com.example.practiccamvvm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        EditText editTextNumber = findViewById(R.id.editTextNumber);
        TextView textViewResult = findViewById(R.id.textViewResult);
        Button buttonDouble = findViewById(R.id.buttonDouble);

        // Observar los cambios en el ViewModel
        viewModel.getResult().observe(this, result -> textViewResult.setText(result));

        buttonDouble.setOnClickListener(v -> {
            try {
                int number = Integer.parseInt(editTextNumber.getText().toString());
                viewModel.doubleTheNumber(number);
            } catch (NumberFormatException e) {
                viewModel.setResult("Please enter a valid number.");
            }
        });
    }
}

