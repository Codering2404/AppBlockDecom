package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdcd implements zzimu {
    private final zzdcb zza;
    private final zzind zzb;

    private zzdcd(zzdcb zzdcbVar, zzind zzindVar) {
        this.zza = zzdcbVar;
        this.zzb = zzindVar;
    }

    public static zzdcd zza(zzdcb zzdcbVar, zzind zzindVar) {
        return new zzdcd(zzdcbVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context contextZzf = this.zza.zzf(((zzcns) this.zzb).zza());
        zzinc.zzb(contextZzf);
        return contextZzf;
    }
}
