package com.gabbybears.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.os.PowerManager;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by Android on 10/24/2015.
 */
public class PhoneStateBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //day la phuong thuc dung de nhan cac ban tin
        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            DisplayManager dm = (DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE);
            //lay state cua cuoc goi
            String state = bundle.getString(PowerManager.S);

            Log.d("STATE", state);

            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                String phoneNum = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.d("PHONE_NUM", phoneNum);
            }
        }
    }


}
