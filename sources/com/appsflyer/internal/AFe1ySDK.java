package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.lvl.AppsFlyerLVL;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFe1ySDK {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface AFa1ySDK {
        void AFInAppEventParameterName(String str, String str2);

        void values(String str, Exception exc);
    }

    public final boolean values(long j3, Context context, final AFa1ySDK aFa1ySDK) {
        try {
            AppsFlyerLVL.checkLicense(j3, context, new AppsFlyerLVL.resultListener() { // from class: com.appsflyer.internal.AFe1ySDK.5
                public final void onLvlFailure(Exception exc) {
                    aFa1ySDK.values("onLvlFailure with exception", exc);
                }

                public final void onLvlResult(String str, String str2) {
                    if (str != null && str2 != null) {
                        aFa1ySDK.AFInAppEventParameterName(str, str2);
                    } else if (str2 == null) {
                        aFa1ySDK.values("onLvlResult with error", new Exception("AFLVL Invalid signature"));
                    } else {
                        aFa1ySDK.values("onLvlResult with error", new Exception("AFLVL Invalid signedData"));
                    }
                }
            });
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
