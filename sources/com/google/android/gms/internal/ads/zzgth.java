package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzgth implements Serializable {
    zzgth() {
    }

    public static zzgth zzc() {
        return zzgsq.zza;
    }

    public static zzgth zzd(Object obj) {
        return obj == null ? zzgsq.zza : new zzgto(obj);
    }

    public abstract Object zza(Object obj);

    public abstract zzgth zzb(zzgta zzgtaVar);
}
