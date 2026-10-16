package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqm implements Supplier {
    private static final zzqm zza = new zzqm();
    private final Supplier zzb = Suppliers.b(new zzqo());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    @SideEffectFree
    public static long zzb() {
        return zza.get().zzb();
    }

    @SideEffectFree
    public static double zzc() {
        return zza.get().zzc();
    }

    @SideEffectFree
    public static long zzd() {
        return zza.get().zzd();
    }

    @SideEffectFree
    public static long zze() {
        return zza.get().zze();
    }

    @SideEffectFree
    public static String zzf() {
        return zza.get().zzf();
    }

    @Override // com.google.common.base.Supplier
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzqn get() {
        return (zzqn) this.zzb.get();
    }
}
