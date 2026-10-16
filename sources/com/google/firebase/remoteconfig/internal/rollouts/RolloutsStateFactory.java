package com.google.firebase.remoteconfig.internal.rollouts;

import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsState;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class RolloutsStateFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ConfigCacheClient f89832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ConfigCacheClient f89833b;

    RolloutsStateFactory(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        this.f89832a = configCacheClient;
        this.f89833b = configCacheClient2;
    }

    public static RolloutsStateFactory a(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        return new RolloutsStateFactory(configCacheClient, configCacheClient2);
    }

    private String c(String str) {
        String strD = d(this.f89832a, str);
        if (strD != null) {
            return strD;
        }
        String strD2 = d(this.f89833b, str);
        return strD2 != null ? strD2 : "";
    }

    private static String d(ConfigCacheClient configCacheClient, String str) {
        ConfigContainer configContainerF = configCacheClient.f();
        if (configContainerF == null) {
            return null;
        }
        try {
            return configContainerF.g().getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    RolloutsState b(ConfigContainer configContainer) throws FirebaseRemoteConfigClientException {
        JSONArray jSONArrayJ = configContainer.j();
        long jK = configContainer.k();
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < jSONArrayJ.length(); i3++) {
            try {
                JSONObject jSONObject = jSONArrayJ.getJSONObject(i3);
                String string = jSONObject.getString("rolloutId");
                JSONArray jSONArray = jSONObject.getJSONArray("affectedParameterKeys");
                if (jSONArray.length() > 1) {
                    Log.w("FirebaseRemoteConfig", String.format("Rollout has multiple affected parameter keys.Only the first key will be included in RolloutsState. rolloutId: %s, affectedParameterKeys: %s", string, jSONArray));
                }
                String strOptString = jSONArray.optString(0, "");
                hashSet.add(RolloutAssignment.a().d(string).f(jSONObject.getString("variantId")).b(strOptString).c(c(strOptString)).e(jK).a());
            } catch (JSONException e3) {
                throw new FirebaseRemoteConfigClientException("Exception parsing rollouts metadata to create RolloutsState.", e3);
            }
        }
        return RolloutsState.a(hashSet);
    }
}
