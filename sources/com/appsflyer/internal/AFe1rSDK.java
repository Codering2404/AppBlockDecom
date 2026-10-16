package com.appsflyer.internal;

import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface AFe1rSDK {
    void AFInAppEventParameterName(AFa1tSDK aFa1tSDK);

    void AFInAppEventParameterName(AFa1tSDK aFa1tSDK, String str, AFb1hSDK aFb1hSDK);

    void AFInAppEventParameterName(Map<String, Object> map, String str);

    void AFInAppEventType(AFa1tSDK aFa1tSDK, int i3, String str);

    long AFKeystoreWrapper();

    void AFKeystoreWrapper(Map<String, Object> map);

    void AFKeystoreWrapper(Map<String, Object> map, AFa1fSDK aFa1fSDK);

    void AFKeystoreWrapper(Map<String, Object> map, boolean z2, Function0<String> function0);

    void values(Map<String, Object> map);

    void values(Map<String, Object> map, int i3, int i4);
}
