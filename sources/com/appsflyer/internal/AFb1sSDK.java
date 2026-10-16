package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.AFd1xSDK.AnonymousClass4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFb1sSDK {
    public static Intent values;
    public String AFInAppEventParameterName;
    public Map<String, String> AFInAppEventType;
    public List<List<String>> AFKeystoreWrapper = new ArrayList();
    public final List<String> AFLogger = new ArrayList();
    public String[] afDebugLog;
    private final AFc1ySDK afErrorLog;
    public long afRDLog;
    public DeepLinkListener valueOf;

    public AFb1sSDK(AFc1ySDK aFc1ySDK) {
        this.afErrorLog = aFc1ySDK;
    }

    private Uri valueOf(Object obj, Iterator<String> it) {
        while (obj != JSONObject.NULL) {
            if (!it.hasNext()) {
                Uri uri = Uri.parse(obj.toString());
                if (uri == null || uri.getScheme() == null || uri.getHost() == null) {
                    return null;
                }
                return uri;
            }
            try {
                obj = new JSONObject(obj.toString()).get(it.next());
            } catch (JSONException e3) {
                AFLogger.afErrorLogForExcManagerOnly("recursiveSearch error", e3);
                return null;
            }
        }
        return null;
    }

    private static void values(String str) {
        AppsFlyerConversionListener appsFlyerConversionListener = AFa1bSDK.values().AFKeystoreWrapper;
        if (appsFlyerConversionListener != null) {
            try {
                AFLogger.afDebugLog("Calling onAppOpenAttributionFailure with: ".concat(String.valueOf(str)));
                appsFlyerConversionListener.onAttributionFailure(str);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    public final void AFInAppEventType(Context context, Map<String, Object> map, Uri uri) {
        AFd1iSDK aFd1iSDK = new AFd1iSDK(context, map, uri, this.AFLogger);
        AFa1bSDK.values().AFInAppEventType(context);
        AFd1xSDK aFd1xSDKAFLogger$LogLevel = this.afErrorLog.AFLogger$LogLevel();
        aFd1xSDKAFLogger$LogLevel.valueOf.execute(aFd1xSDKAFLogger$LogLevel.new AnonymousClass4(aFd1iSDK));
        values = null;
    }

    public final void AFKeystoreWrapper(Map<String, Object> map, Intent intent, Context context) {
        AFc1xSDK aFc1xSDK = (AFc1xSDK) this.afErrorLog;
        if (context != null) {
            aFc1xSDK.valueOf.values = context.getApplicationContext();
        }
        if (!values(intent, context, map) && this.valueOf != null && this.afErrorLog.AFInAppEventParameterName().valueOf.values("appsFlyerCount", 0) == 0 && !this.afErrorLog.AFKeystoreWrapper().AFInAppEventType("ddl_sent")) {
            AFb1oSDK aFb1oSDK = new AFb1oSDK(this.afErrorLog);
            AFd1xSDK aFd1xSDKAFLogger$LogLevel = this.afErrorLog.AFLogger$LogLevel();
            aFd1xSDKAFLogger$LogLevel.valueOf.execute(aFd1xSDKAFLogger$LogLevel.new AnonymousClass4(new AFd1jSDK(aFb1oSDK)));
        }
        this.afErrorLog.AFKeystoreWrapper().valueOf("ddl_sent", true);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0074 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[LOOP:0: B:21:0x0046->B:63:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean values(android.content.Intent r10, android.content.Context r11, java.util.Map<java.lang.String, java.lang.Object> r12) {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1sSDK.values(android.content.Intent, android.content.Context, java.util.Map):boolean");
    }

    public final void AFInAppEventType(DeepLinkResult deepLinkResult) {
        if (this.valueOf != null) {
            StringBuilder sb = new StringBuilder("[DDL] Calling onDeepLinking with:\n");
            sb.append(deepLinkResult.toString());
            AFLogger.afDebugLog(sb.toString());
            try {
                this.valueOf.onDeepLinking(deepLinkResult);
                return;
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
                return;
            }
        }
        AFLogger.afDebugLog("[DDL] skipping, no callback registered");
    }

    public final void valueOf(String str, DeepLinkResult.Error error) {
        if (this.valueOf != null) {
            AFLogger.afDebugLog("[DDL] Error occurred: ".concat(String.valueOf(str)));
            AFInAppEventType(new DeepLinkResult(null, error));
        } else {
            values(str);
        }
    }

    private static void AFInAppEventType(Map<String, String> map) {
        AppsFlyerConversionListener appsFlyerConversionListener = AFa1bSDK.values().AFKeystoreWrapper;
        if (appsFlyerConversionListener != null) {
            try {
                StringBuilder sb = new StringBuilder("Calling onAppOpenAttribution with:\n");
                sb.append(map.toString());
                AFLogger.afDebugLog(sb.toString());
                appsFlyerConversionListener.onAppOpenAttribution(map);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    public final void valueOf(Map<String, String> map) {
        DeepLinkResult deepLinkResult;
        if (this.valueOf != null) {
            try {
                try {
                    DeepLink deepLinkValues = DeepLink.values(map);
                    deepLinkValues.values.put("is_deferred", false);
                    deepLinkResult = new DeepLinkResult(deepLinkValues, null);
                } catch (JSONException e3) {
                    AFLogger.afErrorLog("[DDL] Error occurred", e3, true);
                    deepLinkResult = new DeepLinkResult(null, DeepLinkResult.Error.UNEXPECTED);
                }
                AFInAppEventType(deepLinkResult);
                return;
            } catch (Throwable th) {
                AFInAppEventType(new DeepLinkResult(null, null));
                throw th;
            }
        }
        AFInAppEventType(map);
    }
}
