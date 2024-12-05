package com.example.moviesapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesapp.model.Result;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {
    private ImageView backArrow;
    private TextView noMovieTxt;
    private RecyclerView.Adapter favAdapter;
    private RecyclerView favRecycler;
    private ArrayList<Result> favMoviesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_favorite);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initiViews();
        // the press movie to be favorite
        Result favMovie = (Result) getIntent().getSerializableExtra("fav_movie");
        if (favMovie != null){
            favMoviesList.add(favMovie);
        }


//        Log.v("TAGY","The movie title: "+favMovie.getTitle());
        if (favMoviesList != null) {
            Log.v("TAGY",favMoviesList.get(0).getTitle());
            noMovieTxt.setVisibility(View.GONE);
            favRecycler.setVisibility(View.VISIBLE);
            setFavMovies();
        }



    }

    private void setFavMovies() {
            favAdapter = new CustomAdapter(this,favMoviesList);
            favRecycler.setAdapter(favAdapter);
    }

    private void initiViews() {
        backArrow = findViewById(R.id.imageView4);
        noMovieTxt = findViewById(R.id.textView16);
        favRecycler = findViewById(R.id.recyclerView5);
        favRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
   }
}