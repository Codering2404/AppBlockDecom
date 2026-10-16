package com.google.android.gms.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AdapterResponseInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzv f69667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdError f69668b;

    private AdapterResponseInfo(zzv zzvVar) {
        this.f69667a = zzvVar;
        com.google.android.gms.ads.internal.client.zze zzeVar = zzvVar.f70026c;
        this.f69668b = zzeVar == null ? null : zzeVar.M();
    }

    public static AdapterResponseInfo e(zzv zzvVar) {
        if (zzvVar != null) {
            return new AdapterResponseInfo(zzvVar);
        }
        return null;
    }

    public String a() {
        return this.f69667a.f70029g;
    }

    public String b() {
        return this.f69667a.f70031i;
    }

    public String c() {
        return this.f69667a.f70030h;
    }

    public String d() {
        return this.f69667a.f70028f;
    }

    public final JSONObject f() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        zzv zzvVar = this.f69667a;
        jSONObject.put("Adapter", zzvVar.f70024a);
        jSONObject.put("Latency", zzvVar.f70025b);
        String strD = d();
        if (strD == null) {
            jSONObject.put("Ad Source Name", "null");
        } else {
            jSONObject.put("Ad Source Name", strD);
        }
        String strA = a();
        if (strA == null) {
            jSONObject.put("Ad Source ID", "null");
        } else {
            jSONObject.put("Ad Source ID", strA);
        }
        String strC = c();
        if (strC == null) {
            jSONObject.put("Ad Source Instance Name", "null");
        } else {
            jSONObject.put("Ad Source Instance Name", strC);
        }
        String strB = b();
        if (strB == null) {
            jSONObject.put("Ad Source Instance ID", "null");
        } else {
            jSONObject.put("Ad Source Instance ID", strB);
        }
        JSONObject jSONObject2 = new JSONObject();
        Bundle bundle = zzvVar.f70027d;
        for (String str : bundle.keySet()) {
            jSONObject2.put(str, bundle.get(str));
        }
        jSONObject.put("Credentials", jSONObject2);
        AdError adError = this.f69668b;
        if (adError == null) {
            jSONObject.put("Ad Error", "null");
            return jSONObject;
        }
        jSONObject.put("Ad Error", adError.e());
        return jSONObject;
    }

    public String toString() {
        try {
            return f().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
