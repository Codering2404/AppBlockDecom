package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcnr implements zzimu {
    private final zzind zza;

    private zzcnr(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcnr zza(zzind zzindVar) {
        return new zzcnr(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        ApplicationInfo applicationInfo = ((zzcns) this.zza).zza().getApplicationInfo();
        zzinc.zzb(applicationInfo);
        return applicationInfo;
    }
}
