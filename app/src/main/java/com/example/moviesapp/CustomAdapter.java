package com.example.moviesapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.moviesapp.model.Result;

import java.util.ArrayList;
import java.util.Locale;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    Context context;
    ArrayList<Result> items;

    public CustomAdapter(Context context, ArrayList<Result> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_film,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        //Result film = items.get(position);
        holder.titleTxt.setText(items.get(position).getTitle());
        double rating = items.get(position).getVoteAverage();
        holder.scoreTxt.setText(String.format("%.1f",rating));


        // to load image glide

        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500/"+items.get(position).getPosterPath())
                .into(holder.filmImage);

        // clicks events
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("object",items.get(position));
                holder.itemView.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImg;
        TextView titleTxt, scoreTxt;
        ImageView filmImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            movieImg = itemView.findViewById(R.id.imageView2);

            titleTxt = itemView.findViewById(R.id.textView14);
            scoreTxt = itemView.findViewById(R.id.textView15);
            filmImage = itemView.findViewById(R.id.imageView7);

        }
    }
}
