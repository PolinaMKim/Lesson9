package com.mirea.kimpm.movieproject.domain.repository;

import com.mirea.kimpm.movieproject.domain.models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);
    public Movie getMovie();
}
