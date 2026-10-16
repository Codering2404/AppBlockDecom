package com.google.firebase.remoteconfig.internal;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class Personalization {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f89798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f89799b = Collections.synchronizedMap(new HashMap());

    public Personalization(Provider provider) {
        this.f89798a = provider;
    }

    public void a(String str, ConfigContainer configContainer) {
        JSONObject jSONObjectOptJSONObject;
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) this.f89798a.get();
        if (analyticsConnector == null) {
            return;
        }
        JSONObject jSONObjectI = configContainer.i();
        if (jSONObjectI.length() < 1) {
            return;
        }
        JSONObject jSONObjectG = configContainer.g();
        if (jSONObjectG.length() >= 1 && (jSONObjectOptJSONObject = jSONObjectI.optJSONObject(str)) != null) {
            String strOptString = jSONObjectOptJSONObject.optString("choiceId");
            if (strOptString.isEmpty()) {
                return;
            }
            synchronized (this.f89799b) {
                try {
                    if (strOptString.equals(this.f89799b.get(str))) {
                        return;
                    }
                    this.f89799b.put(str, strOptString);
                    Bundle bundle = new Bundle();
                    bundle.putString("arm_key", str);
                    bundle.putString("arm_value", jSONObjectG.optString(str));
                    bundle.putString("personalization_id", jSONObjectOptJSONObject.optString("personalizationId"));
                    bundle.putInt("arm_index", jSONObjectOptJSONObject.optInt("armIndex", -1));
                    bundle.putString("group", jSONObjectOptJSONObject.optString("group"));
                    analyticsConnector.b("fp", "personalization_assignment", bundle);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_fpid", strOptString);
                    analyticsConnector.b("fp", "_fpc", bundle2);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
