package com.appsflyer.internal;

import com.appsflyer.AppsFlyerLib;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFf1aSDK implements AFg1xSDK {
    @Override // com.appsflyer.internal.AFg1xSDK
    public final String AFInAppEventParameterName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        String str2 = String.format(str, AppsFlyerLib.getInstance().getHostPrefix(), AFa1bSDK.values().getHostName());
        Intrinsics.checkNotNullExpressionValue(str2, "");
        return str2;
    }
}
