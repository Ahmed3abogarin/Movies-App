package com.example.moviesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class favAdapter extends RecyclerView.Adapter<favAdapter.FavViewHoler> {

    @NonNull
    @Override
    public FavViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_film,parent,false);
        return new FavViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavViewHoler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class FavViewHoler extends RecyclerView.ViewHolder{

        public FavViewHoler(@NonNull View itemView) {
            super(itemView);
        }
    }
}
