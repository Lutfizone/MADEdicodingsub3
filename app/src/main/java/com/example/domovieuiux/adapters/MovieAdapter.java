package com.example.domovieuiux.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domovieuiux.R;
import com.example.domovieuiux.activities.DetailMovieActivity;
import com.example.domovieuiux.models.Movie;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Context context;
    ArrayList<Movie> movieList;

    private Context getContext() {
        return context;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movieList = new ArrayList<>();
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.imgThumbnail.setImageResource(movie.getThumbnail());
        holder.txtTitle.setText(movie.getTitle());
        holder.txtRating.setText(movie.getRating());
        holder.txtSinopsis.setText(movie.getSinopsis().substring(0, 50) + " ... ");
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.MOVIE, movie);
                context.startActivity(intent);
            }
        });
        holder.btnTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(movie.getTrailer()));
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return getMovieList().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_thumnail)
        ImageView imgThumbnail;
        @BindView(R.id.txt_title)
        TextView txtTitle;
        @BindView(R.id.txt_rating)
        TextView txtRating;
        @BindView(R.id.txt_sinopsis)
        TextView txtSinopsis;
        @BindView(R.id.btn_detail)
        Button btnDetail;
        @BindView(R.id.btn_trailer)
        Button btnTrailer;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}