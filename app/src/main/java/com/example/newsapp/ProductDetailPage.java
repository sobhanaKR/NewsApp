package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.squareup.picasso.Picasso;

public class ProductDetailPage extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.product_detail_layout, container, false);
        ImageView imageView = rootView.findViewById(R.id.image_view);
        TextView name, author, title, description, url, publishedAt, content;
        name = rootView.findViewById(R.id.name);
        author = rootView.findViewById(R.id.author);
        title = rootView.findViewById(R.id.title);
        description = rootView.findViewById(R.id.description);
        url = rootView.findViewById(R.id.url);
        publishedAt = rootView.findViewById(R.id.published_at);
        content = rootView.findViewById(R.id.content);
        Bundle bundle = getArguments();
        Articles articles = bundle.getParcelable("articles");
        //name.setText(articles.get);
        author.setText(articles.getAuthor());
        title.setText(articles.getTitle());
        description.setText(articles.getDescription());
        url.setText(articles.getUrl());
        publishedAt.setText(articles.getPublishedAt());
        content.setText(articles.getContent());
        Picasso.with(imageView.getContext()).load(articles.getUrlToImage()).into(imageView);
        return rootView;
    }
}
