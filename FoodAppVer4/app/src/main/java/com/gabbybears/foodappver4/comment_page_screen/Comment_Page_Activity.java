package com.gabbybears.foodappver4.comment_page_screen;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.gabbybears.foodappver4.R;

/**
 * Created by Android on 11/2/2015.
 */
public class Comment_Page_Activity extends Activity {

    Button backBtnCmt;
    ImageView browseImage;
    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_page_activity_layout);

        browseImage = (ImageView) findViewById(R.id.browseImageBtn);
        browseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent();
                intent.setType("image*//*");
                intent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(intent, REQUEST_PICK_IMAGE);*/
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        backBtnCmt = (Button) findViewById(R.id.backBtnComtAct);
        backBtnCmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
                builder1.setMessage("Do you want cancel this comment");
                builder1.setCancelable(true);
                builder1.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                builder1.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
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
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.contentImageUpload);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }


    }
}
