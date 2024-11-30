package com.jds.registro_de_superheroes;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jds.registro_de_superheroes.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    public static final String SUPERHERO_KEY = "superhero";
    public static final String BITMAP_KEY = "bitmap";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();
        if(extras == null){
            // Maneja el caso en el que extras es nulo
            Toast.makeText(this, "Error: no se recibieron datos", Toast.LENGTH_SHORT).show();
            finish(); // Finaliza la actividad para evitar errores
            return;
        }
        Superhero superhero = extras.getParcelable(SUPERHERO_KEY);
        if(superhero == null){
            Toast.makeText(this, "Error: No se encontró el superhéroe", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        Bitmap bitmap = extras.getParcelable(BITMAP_KEY);
        binding.setSuperhero(superhero);

        if(bitmap != null){
            binding.imageView5.setImageBitmap(bitmap);
        }
    }
}