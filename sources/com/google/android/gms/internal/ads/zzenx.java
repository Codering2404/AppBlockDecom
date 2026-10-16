package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzenx implements zzelu {
    private final zzdxc zza;

    public zzenx(zzdxc zzdxcVar) {
        this.zza = zzdxcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzelu
    public final zzelv zza(String str, JSONObject jSONObject) throws zzflf {
        return new zzelv(this.zza.zza(str, jSONObject), new zzenh(), str);
    }
}
