package com.appsflyer.internal;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFe1ySDK;
import com.facebook.AuthenticationToken;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFe1pSDK implements AFe1ySDK.AFa1ySDK {
    public final AFe1ySDK AFInAppEventParameterName;
    public long AFKeystoreWrapper;
    public volatile String AFLogger;
    private Map<String, Object> afInfoLog;
    public final AFc1zSDK valueOf;
    public volatile String values;
    public boolean AFInAppEventType = false;
    public volatile boolean afRDLog = false;

    public AFe1pSDK(AFc1zSDK aFc1zSDK, AFe1ySDK aFe1ySDK) {
        this.valueOf = aFc1zSDK;
        this.AFInAppEventParameterName = aFe1ySDK;
    }

    private boolean AFInAppEventParameterName() {
        Map<String, Object> map = this.afInfoLog;
        return (map == null || map.isEmpty()) ? false : true;
    }

    private void values() {
        this.afInfoLog.put("ttr", Long.valueOf(System.currentTimeMillis() - this.AFKeystoreWrapper));
        this.afInfoLog.put("lvl_timestamp", Long.valueOf(this.AFKeystoreWrapper));
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String AFInAppEventType(com.appsflyer.internal.AFb1fSDK r8) {
        /*
            r7 = this;
            java.lang.String r0 = "use cached IMEI: "
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "collectIMEI"
            r3 = 0
            boolean r1 = r1.getBoolean(r2, r3)
            java.lang.String r2 = "imeiCached"
            r3 = 0
            java.lang.String r4 = r8.AFKeystoreWrapper(r2, r3)
            if (r1 == 0) goto L98
            java.lang.String r1 = r7.AFLogger
            boolean r1 = com.appsflyer.internal.AFb1tSDK.AFKeystoreWrapper(r1)
            if (r1 == 0) goto L98
            com.appsflyer.internal.AFc1zSDK r1 = r7.valueOf
            android.content.Context r1 = r1.values
            if (r1 == 0) goto L9f
            boolean r5 = AFKeystoreWrapper(r1)
            if (r5 == 0) goto L9f
            java.lang.String r5 = "phone"
            java.lang.Object r1 = r1.getSystemService(r5)     // Catch: java.lang.Exception -> L4f java.lang.reflect.InvocationTargetException -> L51
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch: java.lang.Exception -> L4f java.lang.reflect.InvocationTargetException -> L51
            java.lang.Class r5 = r1.getClass()     // Catch: java.lang.Exception -> L4f java.lang.reflect.InvocationTargetException -> L51
            java.lang.String r6 = "getDeviceId"
            java.lang.reflect.Method r5 = r5.getMethod(r6, r3)     // Catch: java.lang.Exception -> L4f java.lang.reflect.InvocationTargetException -> L51
            java.lang.Object r1 = r5.invoke(r1, r3)     // Catch: java.lang.Exception -> L4f java.lang.reflect.InvocationTargetException -> L51
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L4f java.lang.reflect.InvocationTargetException -> L51
            if (r1 == 0) goto L45
            goto La0
        L45:
            if (r4 == 0) goto L53
            java.lang.String r1 = r0.concat(r4)     // Catch: java.lang.Exception -> L4f java.lang.reflect.InvocationTargetException -> L51
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch: java.lang.Exception -> L4f java.lang.reflect.InvocationTargetException -> L51
            goto L54
        L4f:
            r1 = move-exception
            goto L56
        L51:
            r1 = move-exception
            goto L77
        L53:
            r4 = r3
        L54:
            r1 = r4
            goto La0
        L56:
            if (r4 == 0) goto L60
            java.lang.String r0 = r0.concat(r4)
            com.appsflyer.AFLogger.afDebugLog(r0)
            goto L61
        L60:
            r4 = r3
        L61:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = "WARNING: Can't collect IMEI: other reason: "
            r0.<init>(r5)
            java.lang.String r5 = r1.getMessage()
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afErrorLog(r0, r1)
            goto L54
        L77:
            if (r4 == 0) goto L81
            java.lang.String r0 = r0.concat(r4)
            com.appsflyer.AFLogger.afDebugLog(r0)
            goto L82
        L81:
            r4 = r3
        L82:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = "WARNING: Can't collect IMEI because of missing permissions: "
            r0.<init>(r5)
            java.lang.String r5 = r1.getMessage()
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afErrorLog(r0, r1)
            goto L54
        L98:
            java.lang.String r0 = r7.AFLogger
            if (r0 == 0) goto L9f
            java.lang.String r1 = r7.AFLogger
            goto La0
        L9f:
            r1 = r3
        La0:
            boolean r0 = com.appsflyer.internal.AFb1tSDK.AFKeystoreWrapper(r1)
            if (r0 != 0) goto Laa
            r8.values(r2, r1)
            return r1
        Laa:
            java.lang.String r8 = "IMEI was not collected."
            com.appsflyer.AFLogger.afInfoLog(r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1pSDK.AFInAppEventType(com.appsflyer.internal.AFb1fSDK):java.lang.String");
    }

    public final boolean AFKeystoreWrapper() {
        return this.afRDLog;
    }

    public final boolean valueOf() {
        return this.AFInAppEventType && !AFInAppEventParameterName();
    }

    private static boolean AFKeystoreWrapper(Context context) {
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) {
            return true;
        }
        AFa1bSDK.values();
        return !AFa1bSDK.AFInAppEventParameterName(context);
    }

    @Override // com.appsflyer.internal.AFe1ySDK.AFa1ySDK
    public final void AFInAppEventParameterName(String str, String str2) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.afInfoLog = concurrentHashMap;
        concurrentHashMap.put("signedData", str);
        this.afInfoLog.put(AuthenticationToken.SIGNATURE_KEY, str2);
        values();
        AFLogger.afInfoLog("Successfully retrieved Google LVL data.");
    }

    @Override // com.appsflyer.internal.AFe1ySDK.AFa1ySDK
    public final void values(String str, Exception exc) {
        this.afInfoLog = new ConcurrentHashMap();
        String message = exc.getMessage();
        if (message == null) {
            message = "unknown";
        }
        values();
        this.afInfoLog.put("error", message);
        AFLogger.afErrorLog(str, exc, true, true, false);
    }

    public final Map<String, Object> AFInAppEventType(Map<String, Object> map) throws Throwable {
        try {
            try {
                return (Map) ((Class) AFb1mSDK.values(View.MeasureSpec.getSize(0) + 37, (char) KeyEvent.getDeadChar(0, 0), View.getDefaultSize(0, 0) + 89)).getDeclaredConstructor(Map.class, Context.class).newInstance(map, this.valueOf.values);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (Exception e3) {
            AFLogger.afErrorLogForExcManagerOnly("AFCksmV3: reflection init failed", e3);
            return new HashMap();
        }
    }

    public final Map<String, Object> AFInAppEventType() {
        HashMap map = new HashMap();
        if (AFInAppEventParameterName()) {
            map.put("lvl", this.afInfoLog);
            return map;
        }
        if (this.AFInAppEventType) {
            this.afInfoLog = new HashMap();
            values();
            this.afInfoLog.put("error", "pending LVL response");
            map.put("lvl", this.afInfoLog);
        }
        return map;
    }
}
