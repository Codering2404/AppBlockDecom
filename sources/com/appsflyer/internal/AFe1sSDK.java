package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.FirebaseMessagingServiceListener;
import com.appsflyer.internal.AFd1xSDK.AnonymousClass4;
import com.google.firebase.messaging.FirebaseMessagingService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFe1sSDK {
    public static String values;
    public final AFb1fSDK AFInAppEventParameterName;

    static {
        StringBuilder sb = new StringBuilder("https://%sregister.%s/api/v");
        sb.append(AFa1bSDK.values);
        values = sb.toString();
    }

    public AFe1sSDK(Context context) {
        this.AFInAppEventParameterName = AFa1bSDK.values().AFKeystoreWrapper(context);
    }

    public static boolean AFKeystoreWrapper(AFb1fSDK aFb1fSDK) {
        return aFb1fSDK.AFInAppEventType("sentRegisterRequestToAF");
    }

    public static boolean values(Context context) {
        if (AppsFlyerLib.getInstance().isStopped()) {
            return false;
        }
        try {
            String str = FirebaseMessagingService.ACTION_DIRECT_BOOT_REMOTE_INTENT;
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to verify manifest declarations: ", th);
        }
        return AFa1fSDK.AFKeystoreWrapper(context, new Intent("com.google.firebase.MESSAGING_EVENT", null, context, FirebaseMessagingServiceListener.class));
    }

    public final AFb1pSDK AFInAppEventType() {
        String string;
        String string2;
        String strAFKeystoreWrapper = this.AFInAppEventParameterName.AFKeystoreWrapper("afUninstallToken", null);
        long jAFInAppEventParameterName = this.AFInAppEventParameterName.AFInAppEventParameterName("afUninstallToken_received_time", 0L);
        boolean zAFInAppEventType = this.AFInAppEventParameterName.AFInAppEventType("afUninstallToken_queued");
        this.AFInAppEventParameterName.valueOf("afUninstallToken_queued", false);
        if (strAFKeystoreWrapper == null && (string2 = AppsFlyerProperties.getInstance().getString("afUninstallToken")) != null) {
            strAFKeystoreWrapper = string2.split(",")[r0.length - 1];
        }
        if (jAFInAppEventParameterName == 0 && (string = AppsFlyerProperties.getInstance().getString("afUninstallToken")) != null) {
            String[] strArrSplit = string.split(",");
            if (strArrSplit.length >= 2) {
                try {
                    jAFInAppEventParameterName = Long.parseLong(strArrSplit[strArrSplit.length - 2]);
                } catch (NumberFormatException unused) {
                }
            }
        }
        if (strAFKeystoreWrapper != null) {
            return new AFb1pSDK(strAFKeystoreWrapper, jAFInAppEventParameterName, zAFInAppEventType);
        }
        return null;
    }

    public static void AFKeystoreWrapper(String str) {
        AFc1ySDK aFc1ySDKValueOf = AFa1bSDK.values().valueOf();
        AFd1bSDK aFd1bSDK = new AFd1bSDK(str, aFc1ySDKValueOf);
        AFd1xSDK aFd1xSDKAFLogger$LogLevel = aFc1ySDKValueOf.AFLogger$LogLevel();
        aFd1xSDKAFLogger$LogLevel.valueOf.execute(aFd1xSDKAFLogger$LogLevel.new AnonymousClass4(aFd1bSDK));
    }
}
