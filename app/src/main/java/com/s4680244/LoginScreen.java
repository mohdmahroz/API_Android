package com.s4680244;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.button.MaterialButton;
import com.s4680244.Models.AuthRequest;
import com.s4680244.Models.AuthResponse;
import com.s4680244.Screens.EntityScreen;
import com.s4680244.Services.ApiService;
import com.s4680244.Utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginScreen extends AppCompatActivity {
    private RelativeLayout progressBar;
    private EditText username;
    private EditText password;
    private MaterialButton submitBtn;
    private AuthRequest request;
    ApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        username = findViewById(R.id.usernameEditText);
        password = findViewById(R.id.passwordEditText);
        submitBtn = findViewById(R.id.submitButton);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if(user.isEmpty() || pass.isEmpty()){
                    Toast.makeText(LoginScreen.this, "Username or password is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                request = new AuthRequest(user, pass);
                Call<AuthResponse> call = apiService.login(request);
                progressBar.setVisibility(VISIBLE);
                call.enqueue(new Callback<AuthResponse>() {
                    @Override
                    public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                        AuthResponse authResponse = response.body();
//                        Toast.makeText(LoginScreen.this, "-- " + authResponse.getKeypass(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(GONE);
                        startActivity(new Intent(LoginScreen.this , EntityScreen.class).putExtra("keypass" , authResponse.getKeypass()));
                    }

                    @Override
                    public void onFailure(Call<AuthResponse> call, Throwable t) {
                        Toast.makeText(LoginScreen.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(GONE);
                    }
                });
            }
        });


    }
}