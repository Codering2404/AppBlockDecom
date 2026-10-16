package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdor implements zzimu {
    private final zzdop zza;

    private zzdor(zzdop zzdopVar) {
        this.zza = zzdopVar;
    }

    public static zzdor zzc(zzdop zzdopVar) {
        return new zzdor(zzdopVar);
    }

    public static JSONObject zzd(zzdop zzdopVar) {
        JSONObject jSONObjectZzc = zzdopVar.zzc();
        zzinc.zzb(jSONObjectZzc);
        return jSONObjectZzc;
    }

    public final JSONObject zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
