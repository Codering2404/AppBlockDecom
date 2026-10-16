package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzam extends zzah {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzah zzc;

    zzam(zzah zzahVar, int i3, int i4) {
        Objects.requireNonNull(zzahVar);
        this.zzc = zzahVar;
        this.zza = i3;
        this.zzb = i4;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzu.zza(i3, this.zzb);
        return this.zzc.get(i3 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzah, java.util.List
    public final /* synthetic */ List subList(int i3, int i4) {
        return subList(i3, i4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag
    final int zza() {
        return this.zzc.zzb() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag
    final int zzb() {
        return this.zzc.zzb() + this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzag
    final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzah
    /* JADX INFO: renamed from: zza */
    public final zzah subList(int i3, int i4) {
        zzu.zza(i3, i4, this.zzb);
        zzah zzahVar = this.zzc;
        int i5 = this.zza;
        return (zzah) zzahVar.subList(i3 + i5, i4 + i5);
    }
}
