package com.gabbybears.foodappver4.test_list_fragment;

public class Rest_Item_Test {

    public String nameRest, nameCoverRest, addressRest, nameTagRest;
    public double longtitude, latitude;

    private Rest_Item_Test(Builder builder){
        nameRest = builder.nameRest;
        nameCoverRest = builder.nameCoverRest;
        addressRest = builder.addressRest;
        nameTagRest = builder.nameTagRest;
        longtitude = builder.longtitude;
        latitude = builder.latitude;
    }

    public static class Builder {

        private String nameRest, nameCoverRest, addressRest, nameTagRest;
        private double longtitude, latitude;

        public Builder setNameRest(String name) {
            nameRest = name;
            return Builder.this;
        }

        public Builder setNameCoverRest(String nameCover) {
            nameCoverRest = nameCover;
            return Builder.this;
        }

        public Builder setAddressRest(String address) {
            addressRest = address;
            return Builder.this;
        }

        public Builder setNameTagRest(String nameTag) {
            nameTagRest = nameTag;
            return Builder.this;
        }

        public Builder setLongtitude(double longti) {
            longtitude = longti;
            return Builder.this;
        }

        public Builder setLatitude(double lati) {
            latitude = lati;
            return Builder.this;
        }

        public Rest_Item_Test build() {
            return new Rest_Item_Test(Builder.this);
        }
    }
}

