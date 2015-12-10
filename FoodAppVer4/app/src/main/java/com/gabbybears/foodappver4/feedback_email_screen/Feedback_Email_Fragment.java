package com.gabbybears.foodappver4.feedback_email_screen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gabbybears.foodappver4.R;

/**
 * Created by Android on 10/29/2015.
 */
public class Feedback_Email_Fragment extends Fragment {

    Button sendEmail;
    EditText nameUser;
    EditText headerMail;
    EditText contentMail;

    String nameUserStr = "";
    String headerMailStr = "";
    String contentMailStr = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feedback_email_fragment_layout, container, false);

        nameUser = (EditText) view.findViewById(R.id.nameUserFb);
        headerMail = (EditText) view.findViewById(R.id.headerMail);
        contentMail = (EditText) view.findViewById(R.id.contentMail);

        sendEmail = (Button) view.findViewById(R.id.sendEmail);
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentMailStr = contentMail.getText().toString();
                nameUserStr = nameUser.getText().toString();
                headerMailStr = headerMail.getText().toString();

                if(contentMailStr!= null && contentMailStr.length() != 0 ) {
                    sendEmailFunct();
                }
                else {
                    Toast.makeText(getActivity(), "Please input content to send Email", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    public void sendEmailFunct() {
        Log.i("Send email", "");
        String[] TO = {"liketablet@gmail.com"};
        String[] CC = {"Email From Sicily"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, nameUserStr);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, headerMailStr);
        emailIntent.putExtra(Intent.EXTRA_TEXT, contentMailStr);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void finish() {

    }
}
