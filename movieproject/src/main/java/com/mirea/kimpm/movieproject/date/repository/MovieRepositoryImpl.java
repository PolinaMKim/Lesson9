package com.mirea.kimpm.movieproject.date.repository;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

import com.mirea.kimpm.movieproject.MainActivity;
import com.mirea.kimpm.movieproject.domain.models.Movie;
import com.mirea.kimpm.movieproject.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {


    public MovieRepositoryImpl(MainActivity mainActivity) {
    }

    @Override
    public boolean saveMovie(Movie movie){
        return true;
    }
    @Override
    public Movie getMovie(){
        return new Movie(1, "Film without name");
    }
}