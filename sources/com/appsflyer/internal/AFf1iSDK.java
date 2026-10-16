package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import com.appsflyer.AFLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFf1iSDK {
    private final List<AFf1jSDK> AFInAppEventParameterName = new ArrayList();

    public final void AFInAppEventParameterName(Context context, Runnable runnable, AFc1ySDK aFc1ySDK) {
        List<ResolveInfo> listQueryIntentContentProviders = context.getPackageManager().queryIntentContentProviders(new Intent("com.appsflyer.referrer.INSTALL_PROVIDER"), 0);
        if (listQueryIntentContentProviders == null || listQueryIntentContentProviders.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ResolveInfo> it = listQueryIntentContentProviders.iterator();
        while (it.hasNext()) {
            ProviderInfo providerInfo = it.next().providerInfo;
            if (providerInfo != null) {
                arrayList.add(new AFf1hSDK(providerInfo, runnable, aFc1ySDK));
            } else {
                AFLogger.afWarnLog("[Preinstall]: com.appsflyer.referrer.INSTALL_PROVIDER Action is set for non ContentProvider component");
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.AFInAppEventParameterName.addAll(arrayList);
        StringBuilder sb = new StringBuilder("[Preinstall]: Detected ");
        sb.append(arrayList.size());
        sb.append(" valid preinstall provider(s)");
        AFLogger.afDebugLog(sb.toString());
    }

    public final synchronized AFf1jSDK[] AFKeystoreWrapper() {
        return (AFf1jSDK[]) this.AFInAppEventParameterName.toArray(new AFf1jSDK[0]);
    }

    public final synchronized void valueOf(AFf1jSDK aFf1jSDK) {
        this.AFInAppEventParameterName.add(aFf1jSDK);
    }
}
