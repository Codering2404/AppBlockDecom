package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzch extends zzbu {
    private final zzax zza;

    zzch(zzbx zzbxVar) {
        super(zzbxVar);
        this.zza = new zzax();
    }

    public final zzax zza() {
        zzV();
        return this.zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
        zzq().c().zzc(this.zza);
        zzfv zzfvVarZzB = zzB();
        zzfvVarZzB.zzV();
        String str = zzfvVarZzB.zzb;
        if (str != null) {
            this.zza.zzk(str);
        }
        zzfvVarZzB.zzV();
        String str2 = zzfvVarZzB.zza;
        if (str2 != null) {
            this.zza.zzl(str2);
        }
    }
}
