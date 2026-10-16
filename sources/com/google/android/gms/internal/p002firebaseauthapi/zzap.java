package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzap<E> extends zzah<E> {
    static final zzah<Object> zza = new zzap(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    zzap(Object[] objArr, int i3) {
        this.zzb = objArr;
        this.zzc = i3;
    }

    @Override // java.util.List
    public final E get(int i3) {
        zzu.zza(i3, this.zzc);
        E e3 = (E) this.zzb[i3];
        Objects.requireNonNull(e3);
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzah, com.google.android.gms.internal.p002firebaseauthapi.zzag
    final int zza(Object[] objArr, int i3) {
        System.arraycopy(this.zzb, 0, objArr, i3, this.zzc);
        return i3 + this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag
    final int zzb() {
        return 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag
    final Object[] zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag
    final int zza() {
        return this.zzc;
    }
}
