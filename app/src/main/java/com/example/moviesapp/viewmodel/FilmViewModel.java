package com.example.moviesapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.moviesapp.api.CreditsResponse;
import com.example.moviesapp.api.FilmRepository;
import com.example.moviesapp.model.Result;

import java.util.List;

public class FilmViewModel extends AndroidViewModel {

    FilmRepository filmRepository;

    public FilmViewModel(@NonNull Application application) {
        super(application);
        this.filmRepository = new FilmRepository(application);
    }

    public LiveData<List<Result>> getPopularMovies(){
        return filmRepository.getMutableLiveData1();
    }
    public LiveData<List<Result>> getUpcomingMovies(){
        return filmRepository.getMutableLiveData2();
    }

}
