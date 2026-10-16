package com.appsflyer.internal;

import android.content.pm.PackageItemInfo;
import android.os.Bundle;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFb1gSDK {
    private static String AFKeystoreWrapper = "265";
    private Bundle AFInAppEventType = null;
    public final AFb1fSDK valueOf;
    public final AFc1zSDK values;

    public AFb1gSDK(AFc1zSDK aFc1zSDK, AFb1fSDK aFb1fSDK) {
        this.values = aFc1zSDK;
        this.valueOf = aFb1fSDK;
    }

    public static String valueOf() {
        StringBuilder sb = new StringBuilder("version: 6.12.3 (build ");
        sb.append(AFKeystoreWrapper);
        sb.append(")");
        return sb.toString();
    }

    public static String values() {
        return AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
    }

    public final String AFInAppEventParameterName(String str) {
        Object obj;
        try {
            if (this.AFInAppEventType == null) {
                this.AFInAppEventType = ((PackageItemInfo) this.values.values.getPackageManager().getApplicationInfo(this.values.values.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)).metaData;
            }
            Bundle bundle = this.AFInAppEventType;
            if (bundle == null || (obj = bundle.get(str)) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Could not load manifest metadata!");
            sb.append(th.getMessage());
            AFLogger.afErrorLog(sb.toString(), th);
            return null;
        }
    }

    public final boolean AFInAppEventType(String str) {
        String strAFInAppEventParameterName = AFInAppEventParameterName(str);
        if (strAFInAppEventParameterName != null) {
            return Boolean.parseBoolean(strAFInAppEventParameterName);
        }
        return false;
    }

    public final String AFKeystoreWrapper() {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.CHANNEL);
        if (string == null) {
            string = AFInAppEventParameterName("CHANNEL");
        }
        if (string == null || !string.equals("")) {
            return string;
        }
        return null;
    }
}
