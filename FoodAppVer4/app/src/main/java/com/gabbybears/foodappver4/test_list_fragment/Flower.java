package com.gabbybears.foodappver4.test_list_fragment;

public class Flower {

    public String mCategory, mPhoto, mName;

    private Flower(Builder builder){
        mCategory = builder.mCategory;
        mPhoto = builder.mPhoto;
        mName = builder.mName;
    }

    public static class Builder {

        private String mCategory, mPhoto, mName;

        public Builder setCategory(String category) {
            mCategory = category;
            return Builder.this;
        }

        public Builder setPhoto(String photo) {
            mPhoto = photo;
            return Builder.this;
        }

        public Builder setName(String name) {
            mName = name;
            return Builder.this;
        }

        public Flower build() {
            return new Flower(Builder.this);
        }
    }
}

