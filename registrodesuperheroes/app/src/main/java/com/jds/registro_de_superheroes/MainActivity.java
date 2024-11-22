package com.jds.registro_de_superheroes;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jds.registro_de_superheroes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding.saveButton.setOnClickListener(v -> {
            String superheroName = binding.heroNameEdit.getText().toString();
            String alterEgo = binding.alterEgoEdit.getText().toString();
            String bio = binding.miniBio.getText().toString();
            float rating = binding.rating.getRating();
            openDetailActivity(superheroName, alterEgo, bio, rating);
        });

    }
    private void openDetailActivity(String superheroName, String alterEgo, String bio, float rating) {
        Superhero superhero = new Superhero(superheroName, alterEgo, bio, rating);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.SUPERHERO_KEY, superheroName);
        startActivity(intent);
    }
}