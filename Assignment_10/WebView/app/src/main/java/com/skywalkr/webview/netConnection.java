package com.skywalkr.webview;

import android.content.Context;
import android.net.ConnectivityManager;

public class netConnection {
    public static boolean verifyNet(Context context) {
        ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return(cm.getActiveNetworkInfo()!=null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected());
    }
}
