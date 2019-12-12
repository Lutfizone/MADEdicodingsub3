package com.example.domovieuiux.models;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {

    private int thumbnail;
    private String title;
    private String director;
    private String cast;
    private String sinopsis;
    private String rating;
    private String genre;
    private String releaseDate;
    private String trailer;


    protected TvShow(Parcel in) {
        thumbnail = in.readInt();
        title = in.readString();
        director = in.readString();
        cast = in.readString();
        sinopsis = in.readString();
        rating = in.readString();
        genre = in.readString();
        releaseDate = in.readString();
        trailer = in.readString();
    }

    public TvShow() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(thumbnail);
        dest.writeString(title);
        dest.writeString(director);
        dest.writeString(cast);
        dest.writeString(sinopsis);
        dest.writeString(rating);
        dest.writeString(genre);
        dest.writeString(releaseDate);
        dest.writeString(trailer);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}