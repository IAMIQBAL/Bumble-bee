package com.mib.bumblebee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.mib.bumblebee.Design.FriendList_Adapter;
import com.mib.bumblebee.pojos.Friends;


import java.util.ArrayList;

public class Friends_list extends AppCompatActivity {

    private ListView listView;
    private FriendList_Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);

        listView = findViewById(R.id.friend_listview);
        ArrayList<Friends> friends = new ArrayList<>();

        friends.add(new Friends("Jack", "Online", R.drawable.avatar));
        friends.add(new Friends("IQBAL", "OFFLINE", R.drawable.avatar));
        friends.add(new Friends("BILAL", "OFFLINE", R.drawable.avatar));
        friends.add(new Friends("ASIF", "Online", R.drawable.avatar));
        friends.add(new Friends("Jack", "OFFLINE", R.drawable.avatar));
        friends.add(new Friends("Jack", "OFFLINE", R.drawable.avatar));
        friends.add(new Friends("Jack", "OFFLINE", R.drawable.avatar));
        friends.add(new Friends("Jack", "OFFLINE", R.drawable.avatar));
        friends.add(new Friends("Jack", "OFFLINE", R.drawable.avatar));
        friends.add(new Friends("Jack", "OFFLINE", R.drawable.avatar));
        friends.add(new Friends("Jack", "OFFLINE", R.drawable.avatar));
        friends.add(new Friends("Jack", "OFFLINE", R.drawable.avatar));

        mAdapter = new FriendList_Adapter(this, friends);
        listView.setAdapter(mAdapter);

    }
}
