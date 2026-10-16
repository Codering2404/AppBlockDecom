package com.appsflyer.internal;

import android.content.pm.PackageManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface AFb1ySDK {
    void AFInAppEventParameterName();

    void AFInAppEventParameterName(String str, String str2);

    void AFInAppEventParameterName(String str, String... strArr);

    void AFInAppEventType();

    void AFInAppEventType(String str, PackageManager packageManager, AFc1ySDK aFc1ySDK);

    void AFInAppEventType(Throwable th);

    void AFKeystoreWrapper();

    boolean afInfoLog();

    void valueOf();

    void values();

    void values(String str);

    void values(String str, int i3, String str2);

    void values(String str, String str2);
}
