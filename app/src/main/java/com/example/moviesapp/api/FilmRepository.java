package com.example.moviesapp.api;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.moviesapp.R;
import com.example.moviesapp.model.Films;
import com.example.moviesapp.model.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmRepository {
    private ArrayList<Result> films1 = new ArrayList<>();
    private ArrayList<Result> films2 = new ArrayList<>();
    private ArrayList<CreditsResponse.Crew> filmsActors = new ArrayList<>();
    private MutableLiveData<List<Result>> mutableLiveData1 = new MutableLiveData<>();
    private MutableLiveData<List<Result>> mutableLiveData2 = new MutableLiveData<>();
    private MutableLiveData<List<CreditsResponse.Crew>> mutableLiveDataActors = new MutableLiveData<>();


    private Application application;
    RetrofitInstance retrofitInstance;
    FilmService filmService =  retrofitInstance.getService();

    public FilmRepository(Application application) {
        this.application = application;
    }



    public MutableLiveData<List<Result>> getMutableLiveData2(){
        Call<Films> call2 = filmService
                .getUpcomingMovies(application.getApplicationContext().getString(R.string.api_key));

        call2.enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                // Success
                Films result = response.body();

                if(result != null && result.getResults()!=null){
                    films2 =(ArrayList<Result>) result.getResults();
                    mutableLiveData2.setValue(films2);
                }


            }

            @Override
            public void onFailure(Call<Films> call, Throwable throwable) {
                Log.v("Tagy","GLoooooat");

            }
        });

        return mutableLiveData2;
    }

    public MutableLiveData<List<Result>> getMutableLiveData1() {


        Call<Films> call = filmService
                .getPopularMovies(application.getApplicationContext().getString(R.string.api_key));



        call.enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                // Success
                Films result = response.body();

                if(result != null && result.getResults()!=null){
                    films1 =(ArrayList<Result>) result.getResults();
                    mutableLiveData1.setValue(films1);
                }
            }
            @Override
            public void onFailure(Call<Films> call, Throwable throwable) {

            }
        });
        return mutableLiveData1;
    }

    public MutableLiveData<List<CreditsResponse.Crew>> getMutableLiveDataActors(int filmId) {
        Call<CreditsResponse> call3 = filmService
                .getMovieCredits(filmId,application.getApplicationContext().getString(R.string.api_key));

        call3.enqueue(new Callback<CreditsResponse>() {
            @Override
            public void onResponse(Call<CreditsResponse> call, Response<CreditsResponse> response) {
                CreditsResponse c1 = response.body();
                if (c1 != null && c1.getCrew()!=null){
                    filmsActors = (ArrayList<CreditsResponse.Crew>) c1.getCrew();
                    mutableLiveDataActors.setValue(filmsActors);

                }

            }

            @Override
            public void onFailure(Call<CreditsResponse> call, Throwable throwable) {

            }
        });

        return mutableLiveDataActors;
    }
}
