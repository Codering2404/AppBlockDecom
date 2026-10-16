package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFe1mSDK {
    public final AFe1wSDK AFInAppEventParameterName;
    public final String AFInAppEventType;
    public final AFf1vSDK AFKeystoreWrapper;
    public final String valueOf;
    private final boolean values;

    public AFe1mSDK() {
    }

    public static boolean AFKeystoreWrapper(Context context) {
        return context.getPackageManager().isInstantApp();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AFe1mSDK.class != obj.getClass()) {
            return false;
        }
        AFe1mSDK aFe1mSDK = (AFe1mSDK) obj;
        if (this.values == aFe1mSDK.values && this.AFInAppEventType.equals(aFe1mSDK.AFInAppEventType)) {
            return this.valueOf.equals(aFe1mSDK.valueOf);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((this.values ? 1 : 0) * 31) + this.AFInAppEventType.hashCode()) * 31) + this.valueOf.hashCode();
        AFe1wSDK aFe1wSDK = this.AFInAppEventParameterName;
        return aFe1wSDK != null ? (iHashCode * 31) + aFe1wSDK.hashCode() : iHashCode;
    }

    public AFe1mSDK(String str) throws JSONException {
        if (str == null) {
            throw new JSONException("Failed to parse remote configuration JSON: originalJson is null");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("ver");
            this.AFInAppEventType = string;
            this.values = jSONObject.optBoolean("test_mode");
            this.valueOf = str;
            this.AFKeystoreWrapper = string.startsWith("default") ? AFf1vSDK.DEFAULT : AFf1vSDK.CUSTOM;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("features");
            this.AFInAppEventParameterName = jSONObjectOptJSONObject != null ? new AFe1wSDK(jSONObjectOptJSONObject) : null;
        } catch (JSONException e3) {
            AFLogger.afErrorLogForExcManagerOnly("Error in RC config parsing", e3);
            throw new JSONException("Failed to parse remote configuration JSON");
        }
    }
}
