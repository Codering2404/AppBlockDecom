package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcur implements zzimu {
    private final zzind zza;

    private zzcur(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcur zza(zzind zzindVar) {
        return new zzcur(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return new JSONObject(((zzcyk) this.zza).zza().zzz);
        } catch (JSONException unused) {
            return null;
        }
    }
}
