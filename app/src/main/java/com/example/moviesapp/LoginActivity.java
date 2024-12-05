package com.example.moviesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private EditText nameET, passET;
    private Button logBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initiViews();
        String username = nameET.getText().toString().trim();
        String userPass = passET.getText().toString().trim();

        logBtn.setOnClickListener(view -> {
            if (nameET.getText().toString().equals("text") && passET.getText().toString().equals("text")){
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            } else  {
                Toast.makeText(this, "Field can not be empty", Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void initiViews(){
        nameET = findViewById(R.id.logName);
        passET = findViewById(R.id.logPass);
        logBtn = findViewById(R.id.button3);
    }
}