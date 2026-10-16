package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbli {
    private static final AtomicReference zza = new AtomicReference();
    private static final AtomicReference zzb = new AtomicReference();

    static {
        new AtomicBoolean();
    }

    static zzblg zza() {
        return (zzblg) zza.get();
    }

    static zzblh zzb() {
        return (zzblh) zzb.get();
    }

    public static void zzc(zzblg zzblgVar) {
        zza.set(zzblgVar);
    }
}
