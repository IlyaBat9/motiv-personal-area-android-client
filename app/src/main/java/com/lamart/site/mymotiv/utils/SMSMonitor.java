package com.lamart.site.mymotiv.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.lamart.site.mymotiv.activities.LoginPageActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SMSMonitor extends BroadcastReceiver {

    private static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";
    private boolean firstLaunch = true;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null &&
                ACTION.compareToIgnoreCase(intent.getAction()) == 0) {
            Object[] pduArray = (Object[]) intent.getExtras().get("pdus");
            SmsMessage[] messages = new SmsMessage[pduArray.length];
            for (int i = 0; i < pduArray.length; i++) {
                messages[i] = SmsMessage.createFromPdu((byte[]) pduArray[i]);
                String[] body = messages[i].getMessageBody().split(" ");
                if(firstLaunch && body.length == 2){
                    if(body[0].equals("MOTIV")) {
                        firstLaunch = false;
                        LoginPageActivity.setText(body[1]);
                    }
                }
            }
        }
    }
}
