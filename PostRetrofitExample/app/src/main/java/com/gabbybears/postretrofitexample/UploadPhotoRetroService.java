package com.gabbybears.postretrofitexample;

import retrofit.Callback;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.mime.TypedFile;

/**
 * Created by Android on 11/23/2015.
 */
public interface UploadPhotoRetroService {
    @Multipart
    @POST("/photo")
    public void upload(@Part("Photo") TypedFile file, Callback<String> callback);
}
