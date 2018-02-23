package com.gmail.deal10041.friendsr;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dylan Wellner on 20-2-2018.
 * Implements an adapter
 */

public class FriendsAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friends;

    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // sets image
        ImageView image = convertView.findViewById(R.id.image);
        image.setImageDrawable(getContext().getResources().getDrawable(friends.get(position).getDrawableId(), null));

        // sets text to name
        TextView name = convertView.findViewById(R.id.name);
        name.setText(friends.get(position).getName());

        // get screen dimensions
        int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;

        // set item height
        int itemHeight = screenHeight > screenWidth ? screenHeight / 3 : screenWidth / 2;
        convertView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, itemHeight));

        return convertView;
    }
}
