package com.mirea.kimpm.movieproject.domain.usecases;

import com.mirea.kimpm.movieproject.domain.models.Movie;
import com.mirea.kimpm.movieproject.domain.repository.MovieRepository;

public class GetFavoriteFilmUseCase {

    private MovieRepository movieRepository;

    public GetFavoriteFilmUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie execute(){
        return movieRepository.getMovie();
    }
}