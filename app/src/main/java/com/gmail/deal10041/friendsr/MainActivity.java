package com.gmail.deal10041.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // holds all friends
    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add friends to list
        friends.add(new Friend("Do the flop guy", "Everybody do the flop!", R.drawable.dtfg));
        friends.add(new Friend("Pedobear", "I've got candy!", R.drawable.pedobear));
        friends.add(new Friend("Doge", "So good, much amaze, wow.", R.drawable.doge));
        friends.add(new Friend("Grumpy Cat", "I had fun once. It was awful", R.drawable.grumpy));
        friends.add(new Friend("Mineturtle", "Hello!", R.drawable.mineturtle));
        friends.add(new Friend("Nyan cat", "Nyan nyan nyan nyan nyan.", R.drawable.nyan));
        friends.add(new Friend("Robbie Rotten", "I am number one.", R.drawable.robbie));
        friends.add(new Friend("Ugandan Knuckles", "Do you know the wae?", R.drawable.ugandanknuckles));
        friends.add(new Friend("Yee dinosaur", "Yee!!", R.drawable.yee));
        friends.add(new Friend("Pepe the frog", "Feels bad, man.", R.drawable.pepe));

        // instantiate adapter
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);

        // set adapter of grid view
        GridView gridview = findViewById(R.id.gridview);
        gridview.setAdapter(adapter);

        // connect listener to grid view
        gridview.setOnItemClickListener(new GridItemClickListener());
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            // get position of clicked item
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);

            // launch profile activity
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}
