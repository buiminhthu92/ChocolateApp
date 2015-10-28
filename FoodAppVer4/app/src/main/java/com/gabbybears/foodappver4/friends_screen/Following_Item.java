package com.gabbybears.foodappver4.friends_screen;

public class Following_Item {

    private String nameFriend;
    private int avarFriend;
    private String timePostFriend;
    private String commentFriend;
    private int imgPostFriend;
    private String numLikeFriend;
    private String numCmtFriend;
    private String numShareFriend;

    public Following_Item(String nameFriend, int avarFriend, String timePostFriend, String commentFriend,
                          int imgPostFriend, String numLikeFriend, String numCmtFriend, String numShareFriend) {
        this.nameFriend = nameFriend;
        this.avarFriend = avarFriend;
        this.timePostFriend = timePostFriend;
        this.commentFriend = commentFriend;
        this.imgPostFriend = imgPostFriend;
        this.numLikeFriend = numLikeFriend;
        this.numCmtFriend = numCmtFriend;
        this.numShareFriend = numShareFriend;
    }

    public String getNameFriend() {
        return nameFriend;
    }

    public void setNameFriend(String nameFriend) {
        this.nameFriend = nameFriend;
    }

    public int getAvarFriend() {
        return avarFriend;
    }

    public void setAvarFriend(int avarFriend) {
        this.avarFriend = avarFriend;
    }

    public String getTimePostFriend() {
        return timePostFriend;
    }

    public void setTimePostFriend(String timePostFriend) {
        this.timePostFriend = timePostFriend;
    }

    public String getCommentFriend() {
        return commentFriend;
    }

    public void setCommentFriend(String commentFriend) {
        this.commentFriend = commentFriend;
    }

    public int getImgPostFriend() {
        return imgPostFriend;
    }

    public void setImgPostFriend(int imgPostFriend) {
        this.imgPostFriend = imgPostFriend;
    }

    public String getNumLikeFriend() {
        return numLikeFriend;
    }

    public void setNumLikeFriend(String numLikeFriend) {
        this.numLikeFriend = numLikeFriend;
    }

    public String getNumCmtFriend() {
        return numCmtFriend;
    }

    public void setNumCmtFriend(String numCmtFriend) {
        this.numCmtFriend = numCmtFriend;
    }

    public String getNumShareFriend() {
        return numShareFriend;
    }

    public void setNumShareFriend(String numShareFriend) {
        this.numShareFriend = numShareFriend;
    }
}