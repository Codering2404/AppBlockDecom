package com.google.android.gms.internal.p002firebaseauthapi;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbq {
    private boolean zza;
    private zzbk zzb;

    @Nullable
    private final zzcb zzc;
    private zzbp zzd;

    @Nullable
    private zzbn zze;

    private zzbq(zzcb zzcbVar) {
        this.zzb = zzbk.zza;
        this.zzd = null;
        this.zze = null;
        this.zzc = zzcbVar;
    }

    public final zzbq zzb() {
        this.zzd = zzbp.zza;
        return this;
    }

    public final zzbq zza() {
        zzbn zzbnVar = this.zze;
        if (zzbnVar != null) {
            zzbnVar.zzb();
        }
        this.zza = true;
        return this;
    }
}
