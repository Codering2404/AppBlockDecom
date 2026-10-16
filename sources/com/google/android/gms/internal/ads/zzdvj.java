package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdvj implements zzbqi {
    private final zzddy zza;
    private final zzccb zzb;
    private final String zzc;
    private final String zzd;

    public zzdvj(zzddy zzddyVar, zzfkf zzfkfVar) {
        this.zza = zzddyVar;
        this.zzb = zzfkfVar.zzl;
        this.zzc = zzfkfVar.zzj;
        this.zzd = zzfkfVar.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzbqi
    public final void zza() {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbqi
    @ParametersAreNonnullByDefault
    public final void zzb(zzccb zzccbVar) {
        int i3;
        String str;
        zzccb zzccbVar2 = this.zzb;
        if (zzccbVar2 != null) {
            zzccbVar = zzccbVar2;
        }
        if (zzccbVar != null) {
            str = zzccbVar.zza;
            i3 = zzccbVar.zzb;
        } else {
            i3 = 1;
            str = "";
        }
        this.zza.zze(new zzcbm(str, i3), this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbqi
    public final void zzc() {
        this.zza.zzf();
    }
}
