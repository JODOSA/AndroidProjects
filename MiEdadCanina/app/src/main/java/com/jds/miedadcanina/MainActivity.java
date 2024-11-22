package com.jds.miedadcanina;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jds.miedadcanina.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> {
            String age = binding.ageEdit.getText().toString();
            if(!age.isEmpty()) {
                int ageInt = Integer.parseInt(age);
                int result = ageInt * 7;
                String resultString = getString(R.string.result_format, result);
                binding.resultText.setText(resultString);
            }else{
                Log.d("MainActivity", "Age field is empty");
                Toast.makeText(this, getString(R.string.you_have_to_insert_an_age), Toast.LENGTH_SHORT).show();
            }
        });
    }
}