package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcse implements zzcru {
    private final zzecr zza;

    zzcse(zzecr zzecrVar) {
        this.zza = zzecrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcru
    public final void zza(JSONObject jSONObject) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkE)).booleanValue()) {
            this.zza.zzp(jSONObject);
        }
    }
}
