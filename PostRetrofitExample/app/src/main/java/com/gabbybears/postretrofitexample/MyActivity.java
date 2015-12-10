package com.gabbybears.postretrofitexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedFile;

/**
 * Created by Android on 11/2/2015.
 */
public class MyActivity extends Activity {

    Button backBtnCmt;
    ImageView browseImage;
    ImageView showImage;
    private static int RESULT_LOAD_IMAGE = 1;
    private static File imagePath2;
    private String picturePath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_main);

        showImage = (ImageView) findViewById(R.id.imageDisp);
        browseImage = (ImageView) findViewById(R.id.imageDisp2);
        backBtnCmt = (Button) findViewById(R.id.uploadImg);

        browseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        backBtnCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagePath2 = new File(picturePath);
                Upload();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.imageDisp);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
    }

    public void Upload() {
        if(picturePath != null && !picturePath.equals("")) {
            imagePath2 = new File(picturePath);
            Toast.makeText(MyActivity.this, picturePath, Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MyActivity.this, "Link image is null", Toast.LENGTH_SHORT).show();
        }

        FileUploadService service = ServiceGenerator.createService(FileUploadService.class, FileUploadService.BASE_URL);
        TypedFile typedFile = new TypedFile("multipart/form-data", imagePath2);
        String description = "hello, this is description speaking";

        service.upload(typedFile, description, new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                Log.e("Upload", "success");
                Toast.makeText(MyActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("Upload", "error");
                Toast.makeText(MyActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

