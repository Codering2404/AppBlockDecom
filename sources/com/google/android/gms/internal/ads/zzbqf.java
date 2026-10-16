package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbqf implements zzbqg {
    final /* synthetic */ zzcfw zza;

    zzbqf(zzbqh zzbqhVar, zzcfw zzcfwVar) {
        this.zza = zzcfwVar;
        Objects.requireNonNull(zzbqhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbqg
    public final void zza(JSONObject jSONObject) {
        this.zza.zzc(jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbqg
    public final void zzb(String str) {
        this.zza.zzd(new zzbtx(str));
    }
}
