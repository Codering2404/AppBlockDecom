package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdci implements zzimu {
    private final zzdcb zza;

    private zzdci(zzdcb zzdcbVar) {
        this.zza = zzdcbVar;
    }

    public static zzdci zzc(zzdcb zzdcbVar) {
        return new zzdci(zzdcbVar);
    }

    public static zzfky zzd(zzdcb zzdcbVar) {
        zzfky zzfkyVarZzb = zzdcbVar.zzb();
        zzinc.zzb(zzfkyVarZzb);
        return zzfkyVarZzb;
    }

    public final zzfky zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
