package com.google.android.gms.internal.consent_sdk;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdu extends zzdv {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzdv zzc;

    zzdu(zzdv zzdvVar, int i3, int i4) {
        Objects.requireNonNull(zzdvVar);
        this.zzc = zzdvVar;
        this.zza = i3;
        this.zzb = i4;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzdj.zza(i3, this.zzb, "index");
        return this.zzc.get(i3 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdv, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i3, int i4) {
        return subList(i3, i4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzds
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzds
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzds
    final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdv
    /* JADX INFO: renamed from: zzf */
    public final zzdv subList(int i3, int i4) {
        zzdj.zzc(i3, i4, this.zzb);
        int i5 = this.zza;
        return this.zzc.subList(i3 + i5, i4 + i5);
    }
}
