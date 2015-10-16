package com.gabbyberas.foodmapversion3;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;


/**
 * A placeholder fragment containing a simple view.
 */
public class FBLoginBtnFragment extends Fragment {

    private TextView mTextDetails;
    private ImageView mAvarUser;

    private CallbackManager mCallbackManager;

    private AccessTokenTracker mTokenTracker;
    private ProfileTracker mProfileTracker;

    private FacebookCallback<LoginResult> mCallback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            AccessToken accessToken = loginResult.getAccessToken();
            Profile profile = Profile.getCurrentProfile();

            displayWellcomeMessage(profile);
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException e) {

        }
    };

    public FBLoginBtnFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        mCallbackManager = CallbackManager.Factory.create();

        mTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {
                if (newToken != null) {
                    Toast.makeText(getActivity(), "You Login", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "You Logout", Toast.LENGTH_SHORT).show();
                }
            }
        };

        mProfileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
                displayWellcomeMessage(newProfile);
            }
        };

        mTokenTracker.startTracking();
        mProfileTracker.startTracking();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fbbtn_layout, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTextDetails = (TextView) view.findViewById(R.id.textDetail);
        mAvarUser = (ImageView) view.findViewById(R.id.vavarUser);
        LoginButton loginButton = (LoginButton)view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");
        loginButton.setFragment(this);
        loginButton.registerCallback(mCallbackManager, mCallback);
    }

    public void displayWellcomeMessage(Profile profile) {
        if (profile != null) {
            mTextDetails.setText("Wellcome: " + profile.getName());
            Picasso.with(getActivity()).load(profile.getProfilePictureUri(70, 70))
                    .placeholder(R.drawable.default_img_user)
                    .into(mAvarUser);


        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Profile profile = Profile.getCurrentProfile();
        displayWellcomeMessage(profile);
    }

    @Override
    public void onStop() {
        super.onStop();
        mTokenTracker.stopTracking();
        mProfileTracker.stopTracking();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
