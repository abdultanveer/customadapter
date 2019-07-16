package com.example.customadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    LayoutInflater mInflater;
    String[] movies;
    String[] imageurls;
    Context mContext;
    WordListAdapter mAdapter;


    public WordListAdapter(Context context, String[] movies, String[] imageurls) {//2
        mInflater = LayoutInflater.from(context);
        this.movies = movies;
        this.imageurls = imageurls;
        mContext = context;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {//3
        View view = mInflater.inflate(R.layout.list_row,viewGroup,false);
        return new WordViewHolder(view, this);//4

    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int position) {//6
            // Retrieve the data for that position
            String mCurrent = movies[position];
            // Add the data to the view
        wordViewHolder.wordItemView.setText(mCurrent);
        Glide.with(mContext)
                //.load(mImageUri) // Load image from assets
                .load(imageurls[position]) // Image URL
                .centerCrop() // Image scale type
                .crossFade()
                .override(100,100) // Resize image
                .placeholder(R.drawable.ic_launcher_background) // Place holder image
                .error(R.drawable.ic_launcher_foreground) // On error image
                .into(wordViewHolder.imageView); // ImageView to display image


        }

    @Override
    public int getItemCount() {
        return movies.length;
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        TextView wordItemView;
        ImageView imageView;

        public WordViewHolder(@NonNull View itemView,WordListAdapter adapter) {//5
            super(itemView);
            wordItemView = itemView.findViewById(R.id.detailsTextview);
            imageView = itemView.findViewById(R.id.imageview);
            mAdapter = adapter;
        }
    }
}
