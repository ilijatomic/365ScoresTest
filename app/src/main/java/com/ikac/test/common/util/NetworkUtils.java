package com.ikac.test.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.ikac.test.common.App;

/**
 * Created by ikac on 3/25/18.
 */

public class NetworkUtils {
    public static boolean isOnlineMode() {
        ConnectivityManager cm = (ConnectivityManager) App.getAppComponent().context().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return (netInfo != null && netInfo.isConnected());
    }
}
