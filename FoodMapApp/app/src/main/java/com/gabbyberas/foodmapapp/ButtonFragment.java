package com.gabbyberas.foodmapapp;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by Android on 9/26/2015.
 */
public class ButtonFragment extends DialogFragment implements View.OnClickListener {

    LinearLayout sang_Trong, van_Phong, binh_Dan, cafe, quan_Nhau, an_Nhanh, duong_Pho;
    ImageView checkImg1, checkImg2, checkImg3, checkImg4, checkImg5, checkImg6, checkImg7;
    ImageView[] checkImg = new ImageView[7];
    Button cancelBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {

        setCancelable(false);

        View view = inflater.inflate(R.layout.search_by_tag_layout, null);
        getDialog().setTitle("Search By Tag");

        //Set Size for Fragmrnt Dialong
//        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
//        params.width = LinearLayout.LayoutParams.MATCH_PARENT;
//        params.height = LinearLayout.LayoutParams.WRAP_CONTENT;
//        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);

//        ok = (Button) view.findViewById(R.id.okBtn);
//        cancel = (Button) view.findViewById(R.id.cancelBtn);
//        ok.setOnClickListener(this);
//        cancel.setOnClickListener(this);

        sang_Trong = (LinearLayout)view.findViewById(R.id.sang_trong_choose);
        van_Phong = (LinearLayout)view.findViewById(R.id.van_phong_choose);
        binh_Dan = (LinearLayout)view.findViewById(R.id.binh_dan_choose);
        cafe = (LinearLayout)view.findViewById(R.id.cafe_choose);
        quan_Nhau = (LinearLayout)view.findViewById(R.id.quan_nhau_choose);
        an_Nhanh = (LinearLayout)view.findViewById(R.id.do_an_nhanh_choose);
        duong_Pho = (LinearLayout)view.findViewById(R.id.duong_pho_choose);

        checkImg1 = (ImageView)view.findViewById(R.id.ImgV1);
        checkImg2 = (ImageView)view.findViewById(R.id.ImgV2);
        checkImg3 = (ImageView)view.findViewById(R.id.ImgV3);
        checkImg4 = (ImageView)view.findViewById(R.id.ImgV4);
        checkImg5 = (ImageView)view.findViewById(R.id.ImgV5);
        checkImg6 = (ImageView)view.findViewById(R.id.ImgV6);
        checkImg7 = (ImageView)view.findViewById(R.id.ImgV7);

        checkImg[0] = checkImg1;
        checkImg[1] = checkImg2;
        checkImg[2] = checkImg3;
        checkImg[3] = checkImg4;
        checkImg[4] = checkImg5;
        checkImg[5] = checkImg6;
        checkImg[6] = checkImg7;

        cancelBtn = (Button)view.findViewById(R.id.cancelBtn);

        sang_Trong.setOnClickListener(this);
        van_Phong.setOnClickListener(this);
        binh_Dan.setOnClickListener(this);
        cafe.setOnClickListener(this);
        quan_Nhau.setOnClickListener(this);
        an_Nhanh.setOnClickListener(this);
        duong_Pho.setOnClickListener(this);

        for(int i = 0; i < checkImg.length; i++) {
            checkImg[i].setOnClickListener(this);
        }

        cancelBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int a = v.getId();
        String b = String.valueOf(a);
       if (v.getId() == R.id.sang_trong_choose) {
            for(int i = 0; i < checkImg.length; i++) {
                if(checkImg[i] == checkImg1) {
                    checkImg[i].setVisibility(View.VISIBLE);
                }
                else {
                    checkImg[i].setVisibility(View.INVISIBLE);
                }
            }
            Toast.makeText(getActivity(), "Sang Trong" + b, Toast.LENGTH_SHORT).show();
            dismiss();
        }

        if (v.getId() == R.id.van_phong_choose) {
            for(int i = 0; i < checkImg.length; i++) {
                if(checkImg[i] == checkImg2) {
                    checkImg[i].setVisibility(View.VISIBLE);
                }
                else {
                    checkImg[i].setVisibility(View.INVISIBLE);
                }
            }
            Toast.makeText(getActivity(), "Binh Dan", Toast.LENGTH_SHORT).show();
            dismiss();
        }

        if (v.getId() == R.id.binh_dan_choose) {
            for(int i = 0; i < checkImg.length; i++) {
                if(checkImg[i] == checkImg3) {
                    checkImg[i].setVisibility(View.VISIBLE);
                }
                else {
                    checkImg[i].setVisibility(View.INVISIBLE);
                }
            }
            Toast.makeText(getActivity(), "Binh Dan", Toast.LENGTH_SHORT).show();
            dismiss();
        }

        if (v.getId() == R.id.cafe_choose) {
            for(int i = 0; i < checkImg.length; i++) {
                if(checkImg[i] == checkImg4) {
                    checkImg[i].setVisibility(View.VISIBLE);
                }
                else {
                    checkImg[i].setVisibility(View.INVISIBLE);
                }
            }
            Toast.makeText(getActivity(), "Cafe", Toast.LENGTH_SHORT).show();
            dismiss();
        }

        if (v.getId() == R.id.quan_nhau_choose) {
            for(int i = 0; i < checkImg.length; i++) {
                if(checkImg[i] == checkImg5) {
                    checkImg[i].setVisibility(View.VISIBLE);
                }
                else {
                    checkImg[i].setVisibility(View.INVISIBLE);
                }
            }
            Toast.makeText(getActivity(), "Quan Nhau", Toast.LENGTH_SHORT).show();
            dismiss();
        }

        if (v.getId() == R.id.do_an_nhanh_choose) {
            for(int i = 0; i < checkImg.length; i++) {
                if(checkImg[i] == checkImg6) {
                    checkImg[i].setVisibility(View.VISIBLE);
                }
                else {
                    checkImg[i].setVisibility(View.INVISIBLE);
                }
            }
            Toast.makeText(getActivity(), "Do An Nhanh", Toast.LENGTH_SHORT).show();
            dismiss();
        }

        if (v.getId() == R.id.duong_pho_choose) {
            for(int i = 0; i < checkImg.length; i++) {
                if(checkImg[i] == checkImg7) {
                    checkImg[i].setVisibility(View.VISIBLE);
                }
                else {
                    checkImg[i].setVisibility(View.INVISIBLE);
                }
            }
            Toast.makeText(getActivity(), "Duong Pho", Toast.LENGTH_SHORT).show();
            dismiss();
        }

        if(v.getId() == R.id.cancelBtn) {
            dismiss();
        }
    }
}
