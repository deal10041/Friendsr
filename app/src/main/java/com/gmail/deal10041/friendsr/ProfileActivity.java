package com.gmail.deal10041.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    // current friend profile
    private Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // extract clicked friend
        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // show image
        ImageView image = findViewById(R.id.profile);
        image.setImageResource(retrievedFriend.getDrawableId());

        // show name
        TextView name = findViewById(R.id.name);
        name.setText(retrievedFriend.getName());

        // show bio
        TextView bio = findViewById(R.id.bio);
        bio.setText(retrievedFriend.getBio());

        // get rating
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float rating = prefs.getFloat(retrievedFriend.getName(),0);

        // set up ratingbar
        RatingBar ratingBar = findViewById(R.id.rating);
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener());
    }

    class OnRatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

            // set up shared preferences editor
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();

            // store rating
            editor.putFloat(retrievedFriend.getName(),v);
            editor.apply();
        }
    }
}
