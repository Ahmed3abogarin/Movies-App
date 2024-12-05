package com.example.moviesapp.api;

import com.example.moviesapp.model.Films;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FilmService {

    @GET("movie/popular")
    public Call<Films> getPopularMovies(@Query("api_key") String api_key);

    @GET("movie/upcoming")
    public Call<Films> getUpcomingMovies(@Query("api_key") String api_key);

    @GET("movie/{movie_id}/credits")
    Call<CreditsResponse> getMovieCredits(
            @Path("movie_id") int movieId,
            @Query("api_key") String apiKey
    );
}
