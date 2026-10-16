package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AFb1zSDK {
    public final Map<String, String> AFInAppEventParameterName;
    public final String AFInAppEventType;
    public final String AFKeystoreWrapper;
    private final byte[] AFLogger;
    private final boolean afDebugLog;
    public int afErrorLog;
    private boolean afInfoLog;
    private final boolean afRDLog;
    public boolean valueOf;
    public boolean values;

    public AFb1zSDK() {
    }

    public static Map<String, String> AFInAppEventType(Map<String, String> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                map2.put(URLEncoder.encode(entry.getKey(), "utf-8"), URLEncoder.encode(entry.getValue(), "utf-8"));
            } catch (UnsupportedEncodingException e3) {
                AFLogger.afErrorLogForExcManagerOnly("failed to encode map", e3);
            }
        }
        return map2;
    }

    public final boolean AFInAppEventParameterName() {
        return this.afDebugLog;
    }

    public final boolean AFKeystoreWrapper() {
        return this.afInfoLog;
    }

    public final boolean AFLogger() {
        return this.values;
    }

    public final AFb1zSDK valueOf(int i3) {
        this.afErrorLog = i3;
        return this;
    }

    public final boolean values() {
        return this.afRDLog;
    }

    public AFb1zSDK(String str, byte[] bArr, String str2, Map<String, String> map, boolean z2) {
        this(str, bArr, str2, map, z2, true);
    }

    public final boolean valueOf() {
        return this.valueOf;
    }

    public AFb1zSDK(String str, byte[] bArr, String str2, Map<String, String> map, boolean z2, boolean z3) {
        this.afInfoLog = true;
        this.valueOf = false;
        this.values = true;
        this.afErrorLog = -1;
        this.AFKeystoreWrapper = str;
        this.AFLogger = bArr;
        this.AFInAppEventType = str2;
        this.AFInAppEventParameterName = map;
        this.afRDLog = z2;
        this.afDebugLog = z3;
    }

    public final byte[] AFInAppEventType() {
        return this.AFLogger;
    }

    public AFb1zSDK(String str, String str2) {
        this(str, null, str2, new HashMap(), false);
    }
}
