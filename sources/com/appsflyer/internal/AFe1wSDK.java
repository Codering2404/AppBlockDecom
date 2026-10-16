package com.appsflyer.internal;

import com.appsflyer.internal.AFb1dSDK;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFe1wSDK {
    public final AFe1oSDK AFKeystoreWrapper;
    public final AFb1dSDK.AFa1wSDK valueOf;

    public AFe1wSDK() {
    }

    public final boolean equals(Object obj) {
        AFe1oSDK aFe1oSDK;
        if (this == obj) {
            return true;
        }
        if (obj != null && AFe1wSDK.class == obj.getClass()) {
            AFe1wSDK aFe1wSDK = (AFe1wSDK) obj;
            AFb1dSDK.AFa1wSDK aFa1wSDK = this.valueOf;
            if (aFa1wSDK != null && aFa1wSDK.equals(aFe1wSDK.valueOf) && (aFe1oSDK = this.AFKeystoreWrapper) != null && aFe1oSDK.equals(aFe1wSDK.AFKeystoreWrapper)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        AFb1dSDK.AFa1wSDK aFa1wSDK = this.valueOf;
        if (aFa1wSDK != null) {
            return aFa1wSDK.hashCode();
        }
        return 0;
    }

    public AFe1wSDK(JSONObject jSONObject) {
        AFb1dSDK.AFa1wSDK aFa1wSDK;
        AFe1oSDK aFe1oSDK = null;
        if (jSONObject.has("exc_mngr")) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.getJSONArray("exc_mngr").optJSONObject(0).optJSONObject("data");
                Objects.requireNonNull(jSONObjectOptJSONObject);
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("v1");
                aFa1wSDK = new AFb1dSDK.AFa1wSDK(jSONObjectOptJSONObject2.getString("sdk_ver"), jSONObjectOptJSONObject2.optInt("min", -1), jSONObjectOptJSONObject2.optInt("expire", -1), jSONObjectOptJSONObject2.optLong("ttl", -1L));
            } catch (NullPointerException | JSONException unused) {
                aFa1wSDK = null;
            }
        } else {
            aFa1wSDK = null;
        }
        if (jSONObject.has("meta_data")) {
            try {
                JSONObject jSONObjectOptJSONObject3 = jSONObject.getJSONArray("meta_data").optJSONObject(0).optJSONObject("data");
                Objects.requireNonNull(jSONObjectOptJSONObject3);
                aFe1oSDK = new AFe1oSDK(jSONObjectOptJSONObject3.optJSONObject("v1").optDouble("send_rate", 1.0d));
            } catch (NullPointerException | JSONException unused2) {
            }
        }
        this.valueOf = aFa1wSDK;
        this.AFKeystoreWrapper = aFe1oSDK;
    }
}
