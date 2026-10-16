package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzgyg implements Comparator {
    protected zzgyg() {
    }

    public static zzgyg zzb() {
        return zzgye.zza;
    }

    public static zzgyg zzc(Comparator comparator) {
        return new zzgvv(comparator);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public zzgyg zza() {
        return new zzgyp(this);
    }

    public final zzgyg zzd(zzgta zzgtaVar) {
        return new zzgvh(zzgtaVar, this);
    }
}
