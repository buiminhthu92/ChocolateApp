package com.gabbybears.foodappver4.friends_screen;

/**
 * Created by Android on 10/26/2015.
 */
public class Follower_Item {
    private int avarFriends;
    private String nameFriends;
    private String numFollowFriends;

    public Follower_Item(int avarFriends, String nameFriends, String numFollowFriends) {
        this.avarFriends = avarFriends;
        this.nameFriends = nameFriends;
        this.numFollowFriends = numFollowFriends;
    }

    public int getAvarFriends() {
        return avarFriends;
    }

    public void setAvarFriends(int avarFriends) {
        this.avarFriends = avarFriends;
    }

    public String getNameFriends() {
        return nameFriends;
    }

    public void setNameFriends(String nameFriends) {
        this.nameFriends = nameFriends;
    }

    public String getNumFollowFriends() {
        return numFollowFriends;
    }

    public void setNumFollowFriends(String numFollowFriends) {
        this.numFollowFriends = numFollowFriends;
    }
}
