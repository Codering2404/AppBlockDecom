package com.applovin.impl;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class pe extends e4 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f62432e = {"ads", "settings", "auto_init_adapters", "test_mode_idfas", "test_mode_auto_init_adapters", "ad_unit_signal_providers"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f62433f = {"ads", "settings", "signal_providers", "ad_unit_signal_providers"};

    public static String a(com.applovin.impl.sdk.j jVar) {
        return e4.a((String) jVar.a(ue.G6), "1.0/mediate", jVar);
    }

    public static String b(com.applovin.impl.sdk.j jVar) {
        return e4.a((String) jVar.a(ue.F6), "1.0/mediate", jVar);
    }

    public static void d(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (JsonUtils.valueExists(jSONObject, "ad_unit_signal_providers")) {
            fm.a(jSONObject, jVar);
        }
    }

    public static void e(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject.length() == 0) {
            return;
        }
        if (!JsonUtils.valueExists(jSONObject, "auto_init_adapters") && !JsonUtils.valueExists(jSONObject, "test_mode_auto_init_adapters")) {
            jVar.c(uj.G);
            return;
        }
        JSONObject jSONObjectShallowCopy = JsonUtils.shallowCopy(jSONObject);
        JsonUtils.removeObjectsForKeys(jSONObjectShallowCopy, f62433f);
        jVar.b(uj.G, jSONObjectShallowCopy.toString());
    }

    public static void f(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (JsonUtils.valueExists(jSONObject, "signal_providers")) {
            JSONObject jSONObjectShallowCopy = JsonUtils.shallowCopy(jSONObject);
            JsonUtils.removeObjectsForKeys(jSONObjectShallowCopy, f62432e);
            jVar.b(uj.F, jSONObjectShallowCopy.toString());
            fm.a(jSONObjectShallowCopy);
        }
    }

    public static void g(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (JsonUtils.valueExists(jSONObject, "ad_unit_signal_providers") && JsonUtils.valueExists(jSONObject, "signal_providers")) {
            try {
                HashSet hashSet = new HashSet();
                JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "signal_providers", null);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    hashSet.add(JsonUtils.getString(jSONArray.getJSONObject(i3), "name", null));
                }
                HashSet hashSet2 = new HashSet();
                JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "ad_unit_signal_providers", (JSONObject) null);
                Iterator it = JsonUtils.toList(jSONObject2.names()).iterator();
                while (it.hasNext()) {
                    hashSet2.addAll(JsonUtils.getList(jSONObject2, (String) it.next(), null));
                }
                if (hashSet.equals(hashSet2)) {
                    return;
                }
                Set differenceSet = CollectionUtils.getDifferenceSet(hashSet, hashSet2);
                com.applovin.impl.sdk.n.h("MediationConnectionUtils", "\"signal_providers\" contains extra network(s): " + differenceSet);
                Set differenceSet2 = CollectionUtils.getDifferenceSet(hashSet2, hashSet);
                com.applovin.impl.sdk.n.h("MediationConnectionUtils", "\"ad_unit_signal_providers\" contains extra network(s): " + differenceSet2);
                jVar.D().a(ka.f60949c0, "signalProvidersMismatch", (Map) CollectionUtils.hashMap("details", "extraSignalProviderNetworks=" + differenceSet + ",extraAdUnitSignalProviderNetworks=" + differenceSet2));
                p6.a("Networks within \"signal_providers\" and \"ad_unit_signal_providers\" do not match.", new Object[0]);
            } catch (JSONException e3) {
                com.applovin.impl.sdk.n.c("MediationConnectionUtils", "Failed to parse JSON", e3);
                jVar.D().a("MediationConnectionUtils", "verifyBidderNetworksMatchFromJson", e3);
                p6.a((Throwable) e3, "Failed to parse JSON in verifyBidderNetworksMatchFromJson", new Object[0]);
            }
        }
    }

    public static String h(com.applovin.impl.sdk.j jVar) {
        return e4.a((String) jVar.a(ue.G6), "1.0/mediate_debug", jVar);
    }

    public static String i(com.applovin.impl.sdk.j jVar) {
        return e4.a((String) jVar.a(ue.F6), "1.0/mediate_debug", jVar);
    }
}
