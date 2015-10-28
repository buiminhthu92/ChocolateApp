package com.gabbybears.foodappver4.find_by_distance_screen;

public class Find_By_Distance_Item {

    private int coverRestItem;
    private String nameRestItem;
    private String addressRestItem;
    private String distanceRestItem;
    private String nameTagRestItem;
    private String numCmtRestItem;
    private String numImgRestItem;
    private String numLikeRestItem;

    public Find_By_Distance_Item(int coverRestItem, String nameRestItem, String addressRestItem,
                                 String distanceRestItem, String nameTagRestItem, String numCmtRestItem,
                                 String numImgRestItem, String numLikeRestItem) {
        this.coverRestItem = coverRestItem;
        this.nameRestItem = nameRestItem;
        this.addressRestItem = addressRestItem;
        this.distanceRestItem = distanceRestItem;
        this.nameTagRestItem = nameTagRestItem;
        this.numCmtRestItem = numCmtRestItem;
        this.numImgRestItem = numImgRestItem;
        this.numLikeRestItem = numLikeRestItem;
    }

    public int getCoverRestItem() {
        return coverRestItem;
    }

    public void setCoverRestItem(int coverRestItem) {
        this.coverRestItem = coverRestItem;
    }

    public String getNameRestItem() {
        return nameRestItem;
    }

    public void setNameRestItem(String nameRestItem) {
        this.nameRestItem = nameRestItem;
    }

    public String getAddressRestItem() {
        return addressRestItem;
    }

    public void setAddressRestItem(String addressRestItem) {
        this.addressRestItem = addressRestItem;
    }

    public String getDistanceRestItem() {
        return distanceRestItem;
    }

    public void setDistanceRestItem(String distanceRestItem) {
        this.distanceRestItem = distanceRestItem;
    }

    public String getNameTagRestItem() {
        return nameTagRestItem;
    }

    public void setNameTagRestItem(String nameTagRestItem) {
        this.nameTagRestItem = nameTagRestItem;
    }

    public String getNumCmtRestItem() {
        return numCmtRestItem;
    }

    public void setNumCmtRestItem(String numCmtRestItem) {
        this.numCmtRestItem = numCmtRestItem;
    }

    public String getNumImgRestItem() {
        return numImgRestItem;
    }

    public void setNumImgRestItem(String numImgRestItem) {
        this.numImgRestItem = numImgRestItem;
    }

    public String getNumLikeRestItem() {
        return numLikeRestItem;
    }

    public void setNumLikeRestItem(String numLikeRestItem) {
        this.numLikeRestItem = numLikeRestItem;
    }
}
