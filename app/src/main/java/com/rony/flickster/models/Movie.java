package com.rony.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Rony BIEN-AIME on 2/11/2018.
 */

public class Movie {
    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342%s",posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    String posterPath;
    String originalTitle;
    String overview;

    public Movie(JSONObject jsonObjet) throws JSONException{
        this.posterPath=jsonObjet.getString("poster_path");
        this.originalTitle=jsonObjet.getString("original_title");
        this.overview=jsonObjet.getString("overview");
    }
    public static ArrayList<Movie> fromJSONArray(JSONArray array){
        ArrayList<Movie> results=new ArrayList<>();

        for (int x=0; x<array.length(); x++){
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
