package com.appsflyer.internal;

import android.app.Activity;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFf1sSDK implements AFf1rSDK {
    private String values;

    private static String AFInAppEventType(Activity activity) {
        Uri uriAFInAppEventType = AFb1pSDK.AFInAppEventType(activity != null ? activity.getIntent() : null);
        String string = uriAFInAppEventType != null ? uriAFInAppEventType.toString() : null;
        if (string == null) {
            string = "";
        }
        if (AFInAppEventType(string)) {
            return null;
        }
        return string;
    }

    @Override // com.appsflyer.internal.AFf1rSDK
    public final String AFKeystoreWrapper(Activity activity) {
        Uri referrer = (activity == null || activity.getIntent() == null) ? null : activity.getReferrer();
        String string = referrer != null ? referrer.toString() : null;
        return string == null ? "" : string;
    }

    @Override // com.appsflyer.internal.AFf1rSDK
    public final String valueOf(Activity activity) {
        String str = this.values;
        this.values = null;
        return (str == null || str.length() == 0) ? AFInAppEventType(activity) : str;
    }

    @Override // com.appsflyer.internal.AFf1rSDK
    public final void values(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        String str = this.values;
        if (str == null || str.length() == 0) {
            this.values = AFInAppEventType(activity);
        }
    }

    private static boolean AFInAppEventType(String str) {
        return StringsKt.U(str, "android-app://", false, 2, null);
    }
}
