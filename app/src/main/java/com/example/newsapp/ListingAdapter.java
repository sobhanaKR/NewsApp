package com.example.newsapp;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ViewHolder>  {
    List<Articles> articles;
    FragmentActivity activity;
    public ListingAdapter(List<Articles> articles, FragmentActivity activity) {
        this.articles = articles;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ListingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View convertView = inflater.inflate(R.layout.listing_item_layout, parent, false);
        return new ListingAdapter.ViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListingAdapter.ViewHolder holder, final int position) {
     holder.articleName.setText(articles.get(position).source.getName());
     holder.title.setText(articles.get(position).getTitle());
     Picasso.with(holder.imageView.getContext()).load(articles.get(position).urlToImage).into(holder.imageView);
     holder.cardView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             androidx.fragment.app.FragmentManager fragmentManager = activity.getSupportFragmentManager();
             FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
             ProductDetailPage productDetailPage = new ProductDetailPage();
             Bundle bundle = new Bundle();
             bundle.putParcelable("articles",  articles.get(position));
             productDetailPage.setArguments(bundle);
             fragmentTransaction.replace(R.id.container, productDetailPage, "");
             fragmentTransaction.addToBackStack(productDetailPage.getClass().getSimpleName());
             fragmentTransaction.commitAllowingStateLoss();
         }
     });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView articleName, title;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            articleName = itemView.findViewById(R.id.blog_name);
            cardView = itemView.findViewById(R.id.card_view);
            imageView = itemView.findViewById(R.id.image_view);
            title = itemView.findViewById(R.id.title);
        }
    }
}
