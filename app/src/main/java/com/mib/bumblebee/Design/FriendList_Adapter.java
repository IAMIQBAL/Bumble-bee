package com.mib.bumblebee.Design;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mib.bumblebee.R;
import com.mib.bumblebee.pojos.Friends;

import java.util.ArrayList;
import java.util.List;

public class FriendList_Adapter  extends ArrayAdapter<Friends> {


    private Context mContext;
    private List<Friends> friendList = new ArrayList<>();

    public FriendList_Adapter(@NonNull Context context, ArrayList<Friends> list) {
        super(context, 0, list);
        mContext = context;
        friendList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null){
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_items, parent, false);
        }

        Friends friend = friendList.get(position);

        ImageView image = listItem.findViewById(R.id.friend_pic);
        image.setImageResource(friend.getProfilePicture());

        TextView friendName = listItem.findViewById(R.id.friend_name);
        friendName.setText(friend.getFriend_name());

        TextView status = listItem.findViewById(R.id.friend_status);
        status.setText(friend.getStatus());

        return listItem;
    }
}
