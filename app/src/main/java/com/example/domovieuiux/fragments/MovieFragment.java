package com.example.domovieuiux.fragments;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domovieuiux.adapters.MovieAdapter;
import com.example.domovieuiux.models.Movie;


import com.example.domovieuiux.R;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MovieFragment extends Fragment {

    @BindView(R.id.rv_movie)
    RecyclerView rvMovie;
    Unbinder unbinder;
    private String[] title;
    private String[] director;
    private String[] cast;
    private String[] sinopsis;
    private String[] releaseDate;
    private String[] genre;
    private String[] duration;
    private String[] trailer;
    private String[] rating;
    private TypedArray thumbnail;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie> movies;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        unbinder = ButterKnife.bind(this, view);


        movieAdapter = new MovieAdapter(getContext());
        rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMovie.setAdapter(movieAdapter);

        prepare();
        addItem();

        return view;
    }

    private void prepare() {
        title = getResources().getStringArray(R.array.title_movie);
        cast = getResources().getStringArray(R.array.cast_movie);
        director = getResources().getStringArray(R.array.director_movie);
        genre = getResources().getStringArray(R.array.genre_movie);
        sinopsis = getResources().getStringArray(R.array.sinopsis_movie);
        duration = getResources().getStringArray(R.array.duration_movie);
        releaseDate = getResources().getStringArray(R.array.release_date_movie);
        trailer = getResources().getStringArray(R.array.trailer_movie);
        rating = getResources().getStringArray(R.array.rating_movie);
        thumbnail = getResources().obtainTypedArray(R.array.thumbnail_movie);
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            Movie movie = new Movie();
            movie.setThumbnail(thumbnail.getResourceId(i, -1));
            movie.setTitle(title[i]);
            movie.setCast(cast[i]);
            movie.setDirector(director[i]);
            movie.setDuration(duration[i]);
            movie.setGenre(genre[i]);
            movie.setRating(rating[i]);
            movie.setReleaseDate(releaseDate[i]);
            movie.setSinopsis(sinopsis[i]);
            movie.setTrailer(trailer[i]);
            movies.add(movie);
        }
        movieAdapter.setMovieList(movies);
    }

}
