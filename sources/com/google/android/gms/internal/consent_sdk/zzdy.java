package com.google.android.gms.internal.consent_sdk;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdy extends zzdv {
    static final zzdv zza = new zzdy(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzdy(Object[] objArr, int i3) {
        this.zzb = objArr;
        this.zzc = i3;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzdj.zza(i3, this.zzc, "index");
        Object obj = this.zzb[i3];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdv, com.google.android.gms.internal.consent_sdk.zzds
    final int zza(Object[] objArr, int i3) {
        Object[] objArr2 = this.zzb;
        int i4 = this.zzc;
        System.arraycopy(objArr2, 0, objArr, 0, i4);
        return i4;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzds
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzds
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzds
    final Object[] zze() {
        return this.zzb;
    }
}
