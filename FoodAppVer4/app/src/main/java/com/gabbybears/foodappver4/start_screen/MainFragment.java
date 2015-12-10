package com.gabbybears.foodappver4.start_screen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.gabbybears.foodappver4.R;
import com.gabbybears.foodappver4.home_screen.HomeActivity;
import com.squareup.picasso.Picasso;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {

    private CallbackManager mCallbackManager;

    private AccessTokenTracker mTokenTracker;
    private ProfileTracker mProfileTracker;

    public static Uri uriImgUser;
    public static String nameUser;

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

    public MainFragment() {
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

                    Intent intent = new Intent(getActivity(), HomeActivity.class);
                    startActivity(intent);
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
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LoginButton loginButton = (LoginButton)view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");
        loginButton.setFragment(this);
        loginButton.registerCallback(mCallbackManager, mCallback);
    }

    public void displayWellcomeMessage(Profile profile) {
        if (profile != null) {
            uriImgUser = profile.getProfilePictureUri(90, 90);
            nameUser = profile.getFirstName() + " " + profile.getLastName();
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
