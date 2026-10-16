package com.appsflyer.internal;

import android.net.Uri;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AFa1tSDK {
    public String AFInAppEventParameterName;
    public Map<String, Object> AFInAppEventType;
    public AppsFlyerRequestListener AFKeystoreWrapper;
    public String AFLogger;
    private final boolean AFVersionDeclaration;
    public String afDebugLog;
    public String afErrorLog;
    private byte[] afErrorLogForExcManagerOnly;
    public int afInfoLog;
    public String afRDLog;
    public String valueOf;
    public final Map<String, Object> values;

    public AFa1tSDK() {
        this(null, null, null);
    }

    public final boolean AFInAppEventParameterName() {
        return this.afErrorLog == null && this.valueOf == null;
    }

    public final AFa1tSDK AFInAppEventType(String str, Object obj) {
        synchronized (this.values) {
            this.values.put(str, obj);
        }
        return this;
    }

    public final Map<String, Object> AFKeystoreWrapper() {
        return this.values;
    }

    public boolean AFLogger() {
        return true;
    }

    public boolean afErrorLog() {
        return true;
    }

    public boolean afInfoLog() {
        return true;
    }

    public boolean afRDLog() {
        return false;
    }

    public final AFa1tSDK valueOf(Map<String, ?> map) {
        synchronized (map) {
            this.values.putAll(map);
        }
        return this;
    }

    public abstract AFd1tSDK valueOf();

    public AFa1tSDK values(String str) {
        this.AFLogger = str;
        return this;
    }

    public AFa1tSDK(String str, String str2, Boolean bool) {
        this.values = new HashMap();
        this.afErrorLog = str;
        this.AFLogger = str2;
        this.AFVersionDeclaration = bool != null ? bool.booleanValue() : true;
    }

    protected static String AFKeystoreWrapper(String str) {
        String strAFKeystoreWrapper = AFa1bSDK.values().valueOf().AFInAppEventParameterName().AFKeystoreWrapper();
        return strAFKeystoreWrapper != null ? Uri.parse(str).buildUpon().appendQueryParameter(AppsFlyerProperties.CHANNEL, strAFKeystoreWrapper).build().toString() : str;
    }

    public final AFa1tSDK AFInAppEventParameterName(byte[] bArr) {
        this.afErrorLogForExcManagerOnly = bArr;
        return this;
    }

    public final AFa1tSDK values(int i3) {
        this.afInfoLog = i3;
        synchronized (this.values) {
            try {
                if (this.values.containsKey("counter")) {
                    this.values.put("counter", Integer.toString(i3));
                }
                if (this.values.containsKey("launch_counter")) {
                    this.values.put("launch_counter", Integer.toString(i3));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    public final boolean AFInAppEventType() {
        return this.AFVersionDeclaration;
    }

    public final byte[] values() {
        return this.afErrorLogForExcManagerOnly;
    }

    public static boolean values(double d3) {
        if (d3 < 0.0d || d3 >= 1.0d) {
            return false;
        }
        if (d3 == 0.0d) {
            return true;
        }
        int i3 = (int) (1.0d / d3);
        if (i3 + 1 > 0) {
            return ((int) ((Math.random() * ((double) i3)) + 1.0d)) != i3;
        }
        throw new IllegalArgumentException("Unsupported max value");
    }
}
