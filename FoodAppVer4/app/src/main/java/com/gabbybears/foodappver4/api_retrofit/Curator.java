package com.gabbybears.foodappver4.api_retrofit;

import java.util.List;

public class Curator {
    public int success;
    public List<Dataset> restaurent;

    public class Dataset{
        public String longitudeX;
        public String latitudeY;
        public String restName;
        public String address;
        public String phone;
        public String tagId;
    }
}