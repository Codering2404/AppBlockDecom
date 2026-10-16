package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AFc1sSDK implements AFc1tSDK, AFc1uSDK, AFd1vSDK {
    private static String AFKeystoreWrapper;
    private static String values;
    private final AFc1lSDK AFInAppEventParameterName;
    private final ExecutorService valueOf;

    public AFc1sSDK() {
    }

    public static void AFInAppEventParameterName(String str) {
        AFKeystoreWrapper = str;
        if (str == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (i3 == 0 || i3 == str.length() - 1) {
                sb.append(str.charAt(i3));
            } else {
                sb.append("*");
            }
        }
        values = sb.toString();
    }

    public static void values(String str) {
        if (AFKeystoreWrapper == null) {
            AFInAppEventParameterName(AFa1bSDK.values().valueOf().getLevel().values);
        }
        String str2 = AFKeystoreWrapper;
        if (str2 != null) {
            AFLogger.afInfoLog(str.replace(str2, values));
        }
    }

    public AFc1sSDK(AFc1lSDK aFc1lSDK, ExecutorService executorService) {
        this.AFInAppEventParameterName = aFc1lSDK;
        this.valueOf = executorService;
    }

    public <T> AFc1qSDK<T> values(AFb1zSDK aFb1zSDK, AFc1gSDK<T> aFc1gSDK) {
        return new AFc1qSDK<>(aFb1zSDK, this.valueOf, this.AFInAppEventParameterName, aFc1gSDK);
    }
}
