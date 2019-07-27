package com.example.newsapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ListingModel implements Parcelable {

    int totalResults;
    List<Articles> articles;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public static Creator<ListingModel> getCREATOR() {
        return CREATOR;
    }

    protected ListingModel(Parcel in) {
        totalResults = in.readInt();
        articles = in.createTypedArrayList(Articles.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(totalResults);
        dest.writeTypedList(articles);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ListingModel> CREATOR = new Creator<ListingModel>() {
        @Override
        public ListingModel createFromParcel(Parcel in) {
            return new ListingModel(in);
        }

        @Override
        public ListingModel[] newArray(int size) {
            return new ListingModel[size];
        }
    };
}
