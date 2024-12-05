 package com.example.moviesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.example.moviesapp.model.Result;
import com.example.moviesapp.viewmodel.FilmViewModel;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView1, recyclerView2;
    private RecyclerView.Adapter adapter1, adapter2;
    private ImageView favBtn;
    private ProgressBar loading1, loading2;
    private ArrayList<Result> films = new ArrayList<>();
     private ArrayList<Result> films2 = new ArrayList<>();
    private FilmViewModel viewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        viewModel = new ViewModelProvider(this).get(FilmViewModel.class);

        initiViews();
        sendRequest1();
        sendRequest2();

        favBtn.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this,FavoriteActivity.class);
            startActivity(i);
        });

    }
    private void initiViews(){
        recyclerView1 = findViewById(R.id.recyclerView);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        favBtn = findViewById(R.id.fav_btn);


        recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        loading1 = findViewById(R.id.progressBar);
        loading2 = findViewById(R.id.progressBar2);
    }
    private void sendRequest1(){
        viewModel.getPopularMovies().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                 films = (ArrayList<Result>) results;
                 adapter1 = new CustomAdapter(MainActivity.this,films);
                 recyclerView1.setAdapter(adapter1);
                 adapter1.notifyDataSetChanged();
            }
        });

    }
    private void sendRequest2(){
        viewModel.getUpcomingMovies().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                films2 = (ArrayList<Result>) results;
                adapter2 = new CustomAdapter(MainActivity.this,films2);
                recyclerView2.setAdapter(adapter2);
                adapter2.notifyDataSetChanged();
            }
        });
    }
}