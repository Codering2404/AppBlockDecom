package com.google.android.gms.internal.play_billing;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzch extends zzbw {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzch(Object[] objArr, int i3, int i4) {
        this.zza = objArr;
        this.zzb = i3;
        this.zzc = i4;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzbj.zza(i3, this.zzc, "index");
        Object obj = this.zza[i3 + i3 + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    final boolean zzf() {
        return true;
    }
}
