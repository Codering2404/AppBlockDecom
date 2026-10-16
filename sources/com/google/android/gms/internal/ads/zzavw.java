package com.google.android.gms.internal.ads;

import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class zzavw implements Supplier {
    private final /* synthetic */ int zzc;
    public static final /* synthetic */ zzavw zzb = new zzavw(1);
    static final /* synthetic */ zzavw zza = new zzavw(0);

    private /* synthetic */ zzavw(int i3) {
        this.zzc = i3;
    }

    @Override // java.util.function.Supplier
    public final /* synthetic */ Object get() {
        return this.zzc != 0 ? zzawm.zza(null) : new zzavz();
    }
}
