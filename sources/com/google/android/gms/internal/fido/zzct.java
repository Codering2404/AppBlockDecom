package com.google.android.gms.internal.fido;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzct extends zzcc {
    static final zzcc zza = new zzct(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzct(Object[] objArr, int i3) {
        this.zzb = objArr;
        this.zzc = i3;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzbm.zza(i3, this.zzc, "index");
        Object obj = this.zzb[i3];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.fido.zzcc, com.google.android.gms.internal.fido.zzby
    final int zza(Object[] objArr, int i3) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.fido.zzby
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.fido.zzby
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.fido.zzby
    final Object[] zze() {
        return this.zzb;
    }
}
