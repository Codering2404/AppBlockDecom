package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzx implements zzth {
    private final zztk zza;
    private final zztk zzb;
    private final zztk zzc;
    private final zztk zzd;
    private final zztk zze;
    private final zztk zzf;
    private final zztk zzg;
    private final zztk zzh;

    private zzx(zztk zztkVar, zztk zztkVar2, zztk zztkVar3, zztk zztkVar4, zztk zztkVar5, zztk zztkVar6, zztk zztkVar7, zztk zztkVar8, zztk zztkVar9, zztk zztkVar10) {
        this.zza = zztkVar;
        this.zzb = zztkVar2;
        this.zzc = zztkVar5;
        this.zzd = zztkVar6;
        this.zze = zztkVar7;
        this.zzf = zztkVar8;
        this.zzg = zztkVar9;
        this.zzh = zztkVar10;
    }

    public static zzx zzc(zztk zztkVar, zztk zztkVar2, zztk zztkVar3, zztk zztkVar4, zztk zztkVar5, zztk zztkVar6, zztk zztkVar7, zztk zztkVar8, zztk zztkVar9, zztk zztkVar10) {
        return new zzx(zztkVar, zztkVar2, zztkVar3, zztkVar4, zztkVar5, zztkVar6, zztkVar7, zztkVar8, zztkVar9, zztkVar10);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztm, com.google.android.gms.internal.consent_sdk.zztl
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzw zzb() {
        return new zzw((Application) this.zza.zzb(), (zzad) this.zzb.zzb(), zzav.zza(), zzax.zza(), (zzaq) this.zzc.zzb(), (zzbq) this.zzd.zzb(), ((zzq) this.zze).zzb(), ((zzac) this.zzf).zzb(), (zze) this.zzg.zzb(), (zzcr) this.zzh.zzb());
    }
}
