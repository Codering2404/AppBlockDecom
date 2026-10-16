package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfeg implements zzfci {
    private final String zza;
    private final String zzb;

    public zzfeg(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        try {
            JSONObject jSONObjectH = com.google.android.gms.ads.internal.util.zzbp.h((JSONObject) obj, "pii");
            jSONObjectH.put("doritos", this.zza);
            jSONObjectH.put("doritos_v2", this.zzb);
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zze.k("Failed putting doritos string.");
        }
    }
}
