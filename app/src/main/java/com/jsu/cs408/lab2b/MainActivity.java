package com.jsu.cs408.lab2b;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jsu.cs408.lab2b.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void clickConvertButton(View v) {
        if(binding.fahrenheitInput.getText() == null || binding.celsiusInput.getText() == null) return; // Both are empty

        double fTemp = Double.parseDouble(binding.fahrenheitInput.getText().toString());

        double cel = (fTemp - 32.0) * (5.0 / 9.0);

        // Round to 2 decimal
        double round = Math.round(cel * 100.0) / 100.0;

        binding.celsiusInput.setText(String.valueOf(round));
    }
}