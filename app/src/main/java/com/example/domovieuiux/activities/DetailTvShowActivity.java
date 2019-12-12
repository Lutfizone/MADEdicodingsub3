package com.example.domovieuiux.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.domovieuiux.R;
import com.example.domovieuiux.models.TvShow;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String TV_SHOW = "movie";
    @BindView(R.id.iv_thumbnail)
    ImageView ivThumbnail;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_rating)
    TextView tvRating;
    @BindView(R.id.tv_genre)
    TextView tvGenre;
    @BindView(R.id.tv_release)
    TextView tvRelease;
    @BindView(R.id.tv_sinopsis)
    TextView tvSinopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tvshow);
        ButterKnife.bind(this);
        TvShow tvShow = getIntent().getParcelableExtra(TV_SHOW);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(tvShow.getTitle());

        tvTitle.setText(tvShow.getTitle());
        tvSinopsis.setText(tvShow.getSinopsis());
        tvRelease.setText(tvShow.getReleaseDate());
        tvRating.setText(tvShow.getRating());
        tvGenre.setText(tvShow.getGenre());
        Glide.with(this).load(tvShow.getThumbnail()).into(ivThumbnail);
    }

}
