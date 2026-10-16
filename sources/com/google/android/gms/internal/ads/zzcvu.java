package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcvu implements zzimu {
    private final zzcvs zza;

    private zzcvu(zzcvs zzcvsVar) {
        this.zza = zzcvsVar;
    }

    public static zzcvu zzc(zzcvs zzcvsVar) {
        return new zzcvu(zzcvsVar);
    }

    public static View zzd(zzcvs zzcvsVar) {
        View viewZzb = zzcvsVar.zzb();
        zzinc.zzb(viewZzb);
        return viewZzb;
    }

    public final View zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
