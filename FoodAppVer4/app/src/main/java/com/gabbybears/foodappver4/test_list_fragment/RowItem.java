package com.gabbybears.foodappver4.test_list_fragment;

public class RowItem {

    private String title;
    private int icon;
    private String timePost;
    private String commentContent;
    private int imgPost;
    private String numLike;
    private String numComment;
    private String numShare;

    public RowItem(String title, int icon, String timePost, String commentContent, int imgPost,
                   String numLike, String numComment, String numShare) {
        this.title = title;
        this.icon = icon;
        this.timePost = timePost;
        this.commentContent = commentContent;
        this.imgPost = imgPost;
        this.numLike = numLike;
        this.numComment = numComment;
        this.numShare = numShare;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTimePost() {
        return timePost;
    }

    public void setTimePost(String timePost) {
        this.timePost = timePost;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getImgPost() {
        return imgPost;
    }

    public void setImgPost(int imgPost) {
        this.imgPost = imgPost;
    }

    public String getNumLike() {
        return numLike;
    }

    public void setNumLike(String numLike) {
        this.numLike = numLike;
    }

    public String getNumComment() {
        return numComment;
    }

    public void setNumComment(String numComment) {
        this.numComment = numComment;
    }

    public String getNumShare() {
        return numShare;
    }

    public void setNumShare(String numShare) {
        this.numShare = numShare;
    }
}
