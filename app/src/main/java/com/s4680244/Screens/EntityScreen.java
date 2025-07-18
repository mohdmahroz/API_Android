package com.s4680244.Screens;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
//import your.package.api.RetrofitClient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.s4680244.Adapters.EntityAdapter;
import com.s4680244.Models.Entity;
import com.s4680244.Models.EntityResponse;
import com.s4680244.R;
import retrofit2.Callback;
import com.s4680244.Services.ApiService;
import com.s4680244.Utils.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class EntityScreen extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EntityAdapter adapter;
    private RelativeLayout progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_entity_screen);
        progressBar = findViewById(R.id.progressBar);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        Intent intent = getIntent();
        recyclerView = findViewById(R.id.recyclerViewEntities);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String keypass = intent.getStringExtra("keypass");
//        Toast.makeText(this, "---" + keypass + "----", Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(VISIBLE);

//        String entityType = "animals"; // This can be dynamic based on your app
        fetchDataFromApi(keypass);
        Toast.makeText(this, "Keypass -> " + keypass, Toast.LENGTH_SHORT).show();

    }
    private void fetchDataFromApi(String entityType) {
        progressBar.setVisibility(VISIBLE);
        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);

        Call<EntityResponse> call = apiService.getEntities(entityType);

        call.enqueue(new Callback<EntityResponse>() {
            @Override
            public void onResponse(Call<EntityResponse> call, Response<EntityResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Entity> entities = response.body().getEntities();
//                    Toast.makeText(EntityScreen.this, "Size" + entities.size(), Toast.LENGTH_SHORT).show();
//                    for(Entity e : entities){
//                        Toast.makeText(EntityScreen.this, "-> " +e.getDiet(), Toast.LENGTH_SHORT).show();
//                    }
                    progressBar.setVisibility(GONE);
                    adapter = new EntityAdapter(entities , EntityScreen.this);
                    recyclerView.setAdapter(adapter);
                } else {
                    Log.e("Retrofit", "Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<EntityResponse> call, Throwable t) {
                Log.e("Retrofit", "Failure: " + t.getMessage());
                progressBar.setVisibility(GONE);
                Toast.makeText(EntityScreen.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}