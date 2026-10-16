package com.google.android.gms.internal.play_billing;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcd extends zzbw {
    static final zzbw zza = new zzcd(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzcd(Object[] objArr, int i3) {
        this.zzb = objArr;
        this.zzc = i3;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzbj.zza(i3, this.zzc, "index");
        Object obj = this.zzb[i3];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw, com.google.android.gms.internal.play_billing.zzbt
    final int zza(Object[] objArr, int i3) {
        Object[] objArr2 = this.zzb;
        int i4 = this.zzc;
        System.arraycopy(objArr2, 0, objArr, 0, i4);
        return i4;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    final Object[] zzg() {
        return this.zzb;
    }
}
