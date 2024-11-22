package com.jds.registro_de_superheroes;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jds.registro_de_superheroes.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    public static final String SUPERHERO_KEY = "superhero_name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Bundle extras = getIntent().getExtras();
        Superhero superhero = extras.getParcelable(SUPERHERO_NAME);
        String alterEgo = extras.getString(ALTER_EGO);
        String bio = extras.getString(BIO);
        float rating = extras.getFloat(RATING);
        binding.heroName.setText(superheroName);
        binding.alterEgoText.setText(alterEgo);
        binding.bioText.setText(bio);
        binding.ratingStar.setRating(rating);
    }
}