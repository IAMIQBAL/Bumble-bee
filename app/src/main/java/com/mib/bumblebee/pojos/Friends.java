package com.mib.bumblebee.pojos;

import java.util.List;

public class Friends {

    private String friend_name;
    private String status;
    private int profilePicture;

    public Friends(String friend_name, String status, int profilePicture) {
        this.friend_name = friend_name;
        this.status = status;
        this.profilePicture = profilePicture;
    }

    public String getFriend_name() {
        return friend_name;
    }

    public void setFriend_name(String friend_name) {
        this.friend_name = friend_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }
}
