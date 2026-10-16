package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AppsFlyerLib;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFe1qSDK extends AFa1tSDK {
    public AFe1qSDK(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(AFe1sSDK.values, AppsFlyerLib.getInstance().getHostPrefix(), AFa1bSDK.values().getHostName()));
        sb.append(context.getPackageName());
        super("Register", sb.toString(), Boolean.FALSE);
    }

    @Override // com.appsflyer.internal.AFa1tSDK
    public final boolean afErrorLog() {
        return false;
    }

    @Override // com.appsflyer.internal.AFa1tSDK
    public final AFd1tSDK valueOf() {
        return AFd1tSDK.REGISTER;
    }
}
