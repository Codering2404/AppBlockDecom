package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdcf implements zzimu {
    private final zzdcb zza;

    private zzdcf(zzdcb zzdcbVar) {
        this.zza = zzdcbVar;
    }

    public static zzdcf zzc(zzdcb zzdcbVar) {
        return new zzdcf(zzdcbVar);
    }

    public final zzdbu zza() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return this.zza.zze();
    }
}
