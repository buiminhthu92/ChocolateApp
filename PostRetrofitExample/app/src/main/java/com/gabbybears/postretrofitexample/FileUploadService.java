package com.gabbybears.postretrofitexample;

import retrofit.Callback;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.mime.TypedFile;

/**
 * Created by Android on 11/24/2015.
 */
public interface FileUploadService {
    public static final String BASE_URL = "http://hungnt-001-site1.1tempurl.com/";

    @Multipart
    @POST("/photo")
    void upload(@Part("myfile") TypedFile file,
                @Part("description") String description,
                Callback<String> cb);
}
