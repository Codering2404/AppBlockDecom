package com.appsflyer.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFf1ySDK {
    public final long AFInAppEventParameterName;
    public final String AFInAppEventType;
    public final int AFKeystoreWrapper;
    public final AFf1qSDK AFLogger;
    public final String afDebugLog;
    public final Throwable afRDLog;
    public final String valueOf;
    public final long values;

    public AFf1ySDK(String str, String str2, long j3, long j4, int i3, AFf1qSDK aFf1qSDK, String str3, Throwable th) {
        this.valueOf = str;
        this.AFInAppEventType = str2;
        this.values = j3;
        this.AFInAppEventParameterName = j4;
        this.AFKeystoreWrapper = i3;
        this.AFLogger = aFf1qSDK;
        this.afDebugLog = str3;
        this.afRDLog = th;
    }
}
