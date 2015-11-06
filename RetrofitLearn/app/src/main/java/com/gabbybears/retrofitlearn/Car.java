package com.gabbybears.retrofitlearn;

/**
 * Created by Android on 11/3/2015.
 */
public class Car {
    private String tagId;
    private String tagNo;
    private String tagName;

    public Car(String tagId, String tagNo, String tagName) {
        this.tagId = tagId;
        this.tagNo = tagNo;
        this.tagName = tagName;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTagNo() {
        return tagNo;
    }

    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
