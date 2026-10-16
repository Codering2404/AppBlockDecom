package com.google.android.gms.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AdError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f69627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f69628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f69629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AdError f69630d;

    public AdError(int i3, String str, String str2, AdError adError) {
        this.f69627a = i3;
        this.f69628b = str;
        this.f69629c = str2;
        this.f69630d = adError;
    }

    public int a() {
        return this.f69627a;
    }

    public String b() {
        return this.f69629c;
    }

    public String c() {
        return this.f69628b;
    }

    public final com.google.android.gms.ads.internal.client.zze d() {
        com.google.android.gms.ads.internal.client.zze zzeVar;
        AdError adError = this.f69630d;
        if (adError == null) {
            zzeVar = null;
        } else {
            zzeVar = new com.google.android.gms.ads.internal.client.zze(adError.f69627a, adError.f69628b, adError.f69629c, null, null);
        }
        return new com.google.android.gms.ads.internal.client.zze(this.f69627a, this.f69628b, this.f69629c, zzeVar, null);
    }

    public JSONObject e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Code", this.f69627a);
        jSONObject.put("Message", this.f69628b);
        jSONObject.put("Domain", this.f69629c);
        AdError adError = this.f69630d;
        if (adError == null) {
            jSONObject.put("Cause", "null");
            return jSONObject;
        }
        jSONObject.put("Cause", adError.e());
        return jSONObject;
    }

    public String toString() {
        try {
            return e().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public AdError(int i3, String str, String str2) {
        this(i3, str, str2, null);
    }
}
