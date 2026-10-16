package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcnt implements zzimu {
    private final zzcnl zza;

    private zzcnt(zzcnl zzcnlVar) {
        this.zza = zzcnlVar;
    }

    public static zzcnt zzc(zzcnl zzcnlVar) {
        return new zzcnt(zzcnlVar);
    }

    public static WeakReference zzd(zzcnl zzcnlVar) {
        WeakReference weakReferenceZzc = zzcnlVar.zzc();
        zzinc.zzb(weakReferenceZzc);
        return weakReferenceZzc;
    }

    public final WeakReference zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
