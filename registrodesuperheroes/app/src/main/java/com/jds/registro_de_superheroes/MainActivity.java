package com.jds.registro_de_superheroes;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.graphics.Bitmap;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jds.registro_de_superheroes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> cameraLauncher;
    private Bitmap takenPhotoBitmap;

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

        // Registrar el ActivityResultLauncher
        cameraLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == RESULT_OK){
                        Intent data = result.getData();
                        if(data != null && data.getExtras() != null){
                            takenPhotoBitmap = (Bitmap) data.getExtras().get("data");
                            binding.heroImage.setImageBitmap(takenPhotoBitmap); // Mostrar la imagen en el InageView
                        }
                    }
                }
        );

        binding.saveButton.setOnClickListener(v -> {
            String superheroName = binding.heroNameEdit.getText().toString();
            String alterEgo = binding.alterEgoEdit.getText().toString();
            String bio = binding.miniBio.getText().toString();
            float rating = binding.rating.getRating();
            openDetailActivity(superheroName, alterEgo, bio, rating);
        });

        binding.heroImage.setOnClickListener(v -> {
            openCamera();
        });

    }

    private void openCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraLauncher.launch(cameraIntent);
    }

    private void openDetailActivity(String superheroName, String alterEgo, String bio, float rating) {
        Superhero superhero = new Superhero(superheroName, alterEgo, bio, rating);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.SUPERHERO_KEY, superhero);
        intent.putExtra(DetailActivity.BITMAP_KEY, takenPhotoBitmap);
        startActivity(intent);
    }
}