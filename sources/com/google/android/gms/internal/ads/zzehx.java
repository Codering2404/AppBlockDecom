package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzehx implements zzfok {
    static final /* synthetic */ zzehx zza = new zzehx();

    private /* synthetic */ zzehx() {
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    public final /* synthetic */ Object zza(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        com.google.android.gms.ads.internal.util.zze.k("Ad request signals:");
        com.google.android.gms.ads.internal.util.zze.k(jSONObject.toString(2));
        return jSONObject;
    }
}
