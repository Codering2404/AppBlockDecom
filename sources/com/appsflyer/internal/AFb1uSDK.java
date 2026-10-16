package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import java.nio.charset.Charset;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFb1uSDK {
    public final AFb1fSDK AFInAppEventParameterName;
    public long AFInAppEventType;
    public long valueOf;
    public AFe1mSDK values;

    public AFb1uSDK() {
    }

    static JSONObject AFKeystoreWrapper(String str) {
        JSONObject jSONObjectValueOf = AFa1uSDK.valueOf(str);
        if (jSONObjectValueOf != null) {
            try {
                boolean z2 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
                boolean zOptBoolean = jSONObjectValueOf.optBoolean("monitor", false);
                AFb1ySDK aFb1ySDKAfErrorLogForExcManagerOnly = AFa1bSDK.values().valueOf().afErrorLogForExcManagerOnly();
                if (!zOptBoolean || z2) {
                    aFb1ySDKAfErrorLogForExcManagerOnly.AFInAppEventType();
                    aFb1ySDKAfErrorLogForExcManagerOnly.values();
                } else {
                    aFb1ySDKAfErrorLogForExcManagerOnly.AFInAppEventParameterName();
                }
                if (jSONObjectValueOf.has("ol_id")) {
                    String strOptString = jSONObjectValueOf.optString("ol_scheme", null);
                    String strOptString2 = jSONObjectValueOf.optString("ol_domain", null);
                    String strOptString3 = jSONObjectValueOf.optString("ol_ver", null);
                    if (strOptString != null) {
                        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_SCHEME, strOptString);
                    }
                    if (strOptString2 != null) {
                        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_DOMAIN, strOptString2);
                    }
                    if (strOptString3 != null) {
                        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_VERSION, strOptString3);
                        return jSONObjectValueOf;
                    }
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("Error in handleResponse: ");
                sb.append(th.getMessage());
                AFLogger.afErrorLogForExcManagerOnly(sb.toString(), th);
                AFa1bSDK.values().valueOf().afErrorLogForExcManagerOnly().AFInAppEventType();
                AFa1bSDK.values().valueOf().afErrorLogForExcManagerOnly().values();
            }
        }
        return jSONObjectValueOf;
    }

    public AFb1uSDK(AFb1fSDK aFb1fSDK) {
        this.AFInAppEventParameterName = aFb1fSDK;
        this.values = AFKeystoreWrapper();
        this.AFInAppEventType = aFb1fSDK.AFInAppEventParameterName("af_rc_timestamp", 0L);
        this.valueOf = aFb1fSDK.AFInAppEventParameterName("af_rc_max_age", 0L);
    }

    private AFe1mSDK AFKeystoreWrapper() {
        String strAFKeystoreWrapper = this.AFInAppEventParameterName.AFKeystoreWrapper("af_remote_config", null);
        if (strAFKeystoreWrapper == null) {
            AFLogger.afDebugLog("CFG: No configuration found in cache");
            return null;
        }
        try {
            return new AFe1mSDK(new String(Base64.decode(strAFKeystoreWrapper, 2), Charset.defaultCharset()));
        } catch (Exception e3) {
            AFLogger.afErrorLog("CFG: Error reading malformed configuration from cache, requires fetching from remote again", e3, true);
            return null;
        }
    }
}
