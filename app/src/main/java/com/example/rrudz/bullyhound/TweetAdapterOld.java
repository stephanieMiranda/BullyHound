package com.example.rrudz.bullyhound;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class TweetAdapterOld extends ArrayAdapter<Tweet> {

    public TweetAdapterOld(Activity context, ArrayList<Tweet> tweets) {
        super(context, 0, tweets);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }



        return listView;
    }
}
