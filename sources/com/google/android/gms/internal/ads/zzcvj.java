package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcvj implements zzimu {
    private final zzcvi zza;

    private zzcvj(zzcvi zzcviVar) {
        this.zza = zzcviVar;
    }

    public static zzcvj zzc(zzcvi zzcviVar) {
        return new zzcvj(zzcviVar);
    }

    public final ViewGroup zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return this.zza.zza();
    }
}
