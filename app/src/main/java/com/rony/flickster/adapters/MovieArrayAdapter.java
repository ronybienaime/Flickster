package com.rony.flickster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rony.flickster.R;
import com.rony.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Rony BIEN-AIME on 2/11/2018.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {
    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        Movie movie=getItem(position);
        if (convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.item_movie, parent, false);
        }
        ImageView ivImage=(ImageView) convertView.findViewById(R.id.ivMovieImage);
        ivImage.setImageResource(0);
        TextView tvTitle=(TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview=(TextView) convertView.findViewById(R.id.tvOverview);
        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());
        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
        return convertView;
    }
}


