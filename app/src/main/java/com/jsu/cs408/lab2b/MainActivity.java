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
        if(binding.fahrenheitInput.getText().length() <= 0 && binding.celsiusInput.getText().length() <= 0) return; // Both are empty

        if(binding.fahrenheitInput.getText().length() > 0) { // Convert Fahrenheit to Celsius
            double fTemp = Double.parseDouble(binding.fahrenheitInput.getText().toString());
            double temp = convertFToC(fTemp);

            binding.celsiusInput.setText(String.valueOf(temp));
        } else { // Convert Celsius to Fahrenheit
            double cTemp = Double.parseDouble(binding.celsiusInput.getText().toString());
            double temp = convertCToF(cTemp);

            binding.fahrenheitInput.setText(String.valueOf(temp));
        }
    }

    private double convertFToC(double fahr) {
        double cel = (fahr - 32.0) * (5.0 / 9.0);

        // Round to 2 decimal
        return Math.round(cel * 100.0) / 100.0;
    }

    private double convertCToF(double cel) {
        double fahr = (cel * 1.8) + 32;

        return Math.round(fahr * 100.0) / 100.0;
    }
}