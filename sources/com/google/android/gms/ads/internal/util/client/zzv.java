package com.google.android.gms.ads.internal.util.client;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzx f70200a;

    private zzv(zzx zzxVar) {
        this.f70200a = zzxVar;
    }

    public static zzv b(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ping_strategy");
        return new zzv(jSONObjectOptJSONObject == null ? new zzn(1, 0, 1.0d, false) : new zzn(jSONObjectOptJSONObject.optInt("max_attempts", 1), jSONObjectOptJSONObject.optInt("initial_backoff_ms", 0), jSONObjectOptJSONObject.optDouble("backoff_multiplier", 1.0d), jSONObjectOptJSONObject.optBoolean("buffer_after_max_attempts", false)));
    }

    public final zzx a() {
        return this.f70200a;
    }
}
