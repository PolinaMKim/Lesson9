package com.mirea.kimpm.movieproject;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.mirea.kimpm.movieproject.databinding.ActivityMainBinding;
import com.mirea.kimpm.movieproject.date.repository.MovieRepositoryImpl;
import com.mirea.kimpm.movieproject.domain.models.Movie;
import com.mirea.kimpm.movieproject.domain.repository.MovieRepository;
import com.mirea.kimpm.movieproject.domain.usecases.GetFavoriteFilmUseCase;
import com.mirea.kimpm.movieproject.domain.usecases.SaveFilmToFavoriteUseCase;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MovieRepository movieRepository = new MovieRepositoryImpl(this);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);

        String empty_msg = "Нет данных!";


        binding.buttonSaveMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean result = new SaveFilmToFavoriteUseCase(movieRepository).execute(new Movie(2, binding.editTextMovie.getText().toString()));
                binding.textViewMovie.setText(String.format("Save result %s", result));
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("name", binding.editTextMovie.getText().toString());
                editor.apply();
            }
        });

        binding.buttonGetMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String movie_name = sharedPref.getString("name", empty_msg);
                Log.d("MSG", movie_name);
                if (movie_name.equals(empty_msg)){
                    Movie movie = new GetFavoriteFilmUseCase(movieRepository).execute();
                    binding.textViewMovie.setText(String.format("Save result %s", movie.getName()));
                }else{
                    binding.textViewMovie.setText(movie_name);
                }
            }
        });
    }
}