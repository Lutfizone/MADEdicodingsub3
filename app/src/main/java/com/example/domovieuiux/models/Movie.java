package com.example.domovieuiux.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int thumbnail;
    private String title;
    private String director;
    private String cast;
    private String sinopsis;
    private String rating;
    private String genre;
    private String duration;
    private String releaseDate;
    private String trailer;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.thumbnail);
        dest.writeString(this.title);
        dest.writeString(this.director);
        dest.writeString(this.cast);
        dest.writeString(this.sinopsis);
        dest.writeString(this.rating);
        dest.writeString(this.genre);
        dest.writeString(this.duration);
        dest.writeString(this.releaseDate);
        dest.writeString(this.trailer);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.thumbnail = in.readInt();
        this.title = in.readString();
        this.director = in.readString();
        this.cast = in.readString();
        this.sinopsis = in.readString();
        this.rating = in.readString();
        this.genre = in.readString();
        this.duration = in.readString();
        this.releaseDate = in.readString();
        this.trailer = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}