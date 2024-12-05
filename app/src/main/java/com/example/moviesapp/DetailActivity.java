package com.example.moviesapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesapp.api.CreditsResponse;
import com.example.moviesapp.model.Result;
import com.example.moviesapp.viewmodel.FilmViewModel;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    private ImageView movieImg, movieBack, backArrow, favBtn;
    Result item = new Result();
    TextView titleTxt, rating, movieDuration, date, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        movieImg = findViewById(R.id.imageView2);
        movieBack = findViewById(R.id.imageView3);
        backArrow =findViewById(R.id.imageView4);
        backArrow.setOnClickListener(view -> {
            Intent intent = new Intent(DetailActivity.this, MainActivity.class);
            startActivity(intent);
        });

        favBtn = findViewById(R.id.imageView5);

        titleTxt = findViewById(R.id.textView12);
        rating = findViewById(R.id.textView8);
        movieDuration = findViewById(R.id.textView9);
        date = findViewById(R.id.textView10);

        sum = findViewById(R.id.textView11);




        Result item = (Result) getIntent().getSerializableExtra("object");

        favBtn.setOnClickListener(view -> {
            if (item != null){
//                Intent intent = new Intent(this, FavoriteActivity.class);
//                intent.putExtra("fav_movie",item);
//                startActivity(intent);
                Toast.makeText(this, item.getTitle()+" added To Favorite", Toast.LENGTH_SHORT).show();


            }

        });


        double rateInt =  Math.round(item.getVoteAverage()*10.00)/10.00;
        titleTxt.setText(item.getTitle());
        rating.setText(Double.toString(rateInt));
        movieDuration.setText(item.getAdult().toString());
        date.setText(item.getReleaseDate());
        sum.setText(item.getOverview());

        Glide.with(DetailActivity.this)
                .load("https://image.tmdb.org/t/p/w500/"+item.getPosterPath())
                .into(movieImg);
        Glide.with(DetailActivity.this)
                .load("https://image.tmdb.org/t/p/w500/"+item.getPosterPath())
                .into(movieBack);


    }

}