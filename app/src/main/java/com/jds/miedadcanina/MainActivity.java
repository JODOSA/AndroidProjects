package com.jds.miedadcanina;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText ageEdit = findViewById((R.id.age_edit));
        TextView resultText = findViewById((R.id.result_text));
        Button button = findViewById(R.id.button);

        button.setOnClickListener(view -> {
            String age = ageEdit.getText().toString();
            int ageInt = Integer.parseInt(age);

            int result = ageInt * 7;
            String resultString = "Si fueras perro, tu edad sería " + result + " años";
            resultText.setText(resultString);
        });
    }
}