package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpl implements Supplier {
    private static final zzpl zza = new zzpl();
    private final Supplier zzb = Suppliers.b(new zzpn());

    @SideEffectFree
    public static boolean zza() {
        return zza.get().zza();
    }

    @SideEffectFree
    public static boolean zzb() {
        return zza.get().zzb();
    }

    @Override // com.google.common.base.Supplier
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzpm get() {
        return (zzpm) this.zzb.get();
    }
}
