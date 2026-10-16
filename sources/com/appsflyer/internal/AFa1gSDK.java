package com.appsflyer.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.appsflyer.AFLogger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AFa1gSDK {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AFa1zSDK {
        public final String AFInAppEventParameterName;
        public final String valueOf;
        public final String values;

        public AFa1zSDK(String str, String str2, String str3) {
            this.values = str;
            this.AFInAppEventParameterName = str2;
            this.valueOf = str3;
        }
    }

    private static boolean valueOf(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    public final AFa1zSDK AFKeystoreWrapper(Context context) {
        String str;
        String simOperatorName;
        String str2 = "unknown";
        String networkOperatorName = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                Network[] allNetworks = connectivityManager.getAllNetworks();
                int length = allNetworks.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(allNetworks[i3]);
                    if (!valueOf(networkInfo)) {
                        i3++;
                    } else if (1 == networkInfo.getType()) {
                        str2 = "WIFI";
                    } else if (networkInfo.getType() == 0) {
                        str2 = "MOBILE";
                    }
                }
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            simOperatorName = telephonyManager.getSimOperatorName();
            try {
                networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (networkOperatorName == null || networkOperatorName.isEmpty()) {
                    if (2 == telephonyManager.getPhoneType()) {
                        networkOperatorName = "CDMA";
                    }
                }
            } catch (Throwable th) {
                th = th;
                str = networkOperatorName;
                networkOperatorName = simOperatorName;
                AFLogger.afErrorLog("Exception while collecting network info. ", th);
                String str3 = str;
                simOperatorName = networkOperatorName;
                networkOperatorName = str3;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
        return new AFa1zSDK(str2, networkOperatorName, simOperatorName);
    }
}
