package com.example.domovieuiux.fragments;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domovieuiux.adapters.TvShowAdapter;
import com.example.domovieuiux.models.TvShow;
import com.example.domovieuiux.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TvShowFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.rv_movie)
    RecyclerView rvMovie;
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
    private TvShowAdapter tvShowAdapter;
    private ArrayList<TvShow> tvShows;

    public TvShowFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv_show, container, false);
        unbinder = ButterKnife.bind(this, view);

        tvShowAdapter = new TvShowAdapter(getContext());
        rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMovie.setAdapter(tvShowAdapter);

        prepare();
        addItem();

        return view;
    }

    private void prepare() {
        title = getResources().getStringArray(R.array.title_tv);
        cast = getResources().getStringArray(R.array.cast_tv);
        director = getResources().getStringArray(R.array.director_tv);
        genre = getResources().getStringArray(R.array.genre_tv);
        sinopsis = getResources().getStringArray(R.array.sinopsis_tv);
        releaseDate = getResources().getStringArray(R.array.release_date_tv);
        trailer = getResources().getStringArray(R.array.trailer_tv);
        rating = getResources().getStringArray(R.array.rating_tv);
        thumbnail = getResources().obtainTypedArray(R.array.thumbnail_tv);
    }

    private void addItem() {
        tvShows = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            TvShow tvShow = new TvShow();
            tvShow.setThumbnail(thumbnail.getResourceId(i, -1));
            tvShow.setTitle(title[i]);
            tvShow.setCast(cast[i]);
            tvShow.setDirector(director[i]);
            tvShow.setGenre(genre[i]);
            tvShow.setRating(rating[i]);
            tvShow.setReleaseDate(releaseDate[i]);
            tvShow.setSinopsis(sinopsis[i]);
            tvShow.setTrailer(trailer[i]);
            tvShows.add(tvShow);
        }
        tvShowAdapter.setTvShowsList(tvShows);
    }

}
