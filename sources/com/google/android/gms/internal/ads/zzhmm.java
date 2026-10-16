package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhmm {
    private static final zzhmm zza = new zzhmm();
    private static final zzhml zzb = new zzhml(null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzhmm zza() {
        return zza;
    }

    public final zzhme zzb() {
        zzhme zzhmeVar = (zzhme) this.zzc.get();
        return zzhmeVar == null ? zzb : zzhmeVar;
    }
}
