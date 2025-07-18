package com.s4680244.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.s4680244.Models.Entity;
import com.s4680244.R;

import org.w3c.dom.Text;

public class DetailScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_screen);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        Entity entity = (Entity) getIntent().getSerializableExtra("entity");

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        TextView tvSpecies = findViewById(R.id.tvSpecies);
        tvSpecies.setText(entity.getSpecies() + " ");
        TextView tvScientificName = findViewById(R.id.tvScientificName);
        tvScientificName.setText(entity.getScientificName() + " ");
        TextView tvHabitat = findViewById(R.id.tvHabitat);
        tvHabitat.setText(entity.getHabitat() + " ");
        TextView tvDiet = findViewById(R.id.tvDiet);
        tvDiet.setText(entity.getDiet() + " ");
        TextView tvConservationStatus = findViewById(R.id.tvConservationStatus);
        tvConservationStatus.setText(entity.getConservationStatus() + " ");
        TextView tvAverageLifespan = findViewById(R.id.tvAverageLifespan);
        tvAverageLifespan.setText(entity.getAverageLifespan() + " ");
        TextView tvDescription = findViewById(R.id.tvDescription);
        tvDescription.setText(entity.getDescription() + " ");


    }
}