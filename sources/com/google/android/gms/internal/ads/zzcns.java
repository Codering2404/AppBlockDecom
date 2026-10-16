package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcns implements zzimu {
    private final zzcnl zza;

    private zzcns(zzcnl zzcnlVar) {
        this.zza = zzcnlVar;
    }

    public static zzcns zzc(zzcnl zzcnlVar) {
        return new zzcns(zzcnlVar);
    }

    public static Context zzd(zzcnl zzcnlVar) {
        Context contextZza = zzcnlVar.zza();
        zzinc.zzb(contextZza);
        return contextZza;
    }

    public final Context zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
