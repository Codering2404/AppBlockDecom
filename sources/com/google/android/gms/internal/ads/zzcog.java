package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcog implements zzimu {
    private final zzind zza;

    private zzcog(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcog zza(zzind zzindVar) {
        return new zzcog(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZza = ((zzcns) this.zza).zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmS)).booleanValue()) {
            return com.google.android.gms.ads.internal.util.client.zzf.q(contextZza);
        }
        return null;
    }
}
