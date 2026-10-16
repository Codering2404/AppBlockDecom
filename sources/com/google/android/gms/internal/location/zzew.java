package com.google.android.gms.internal.location;

import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzew extends zzex {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzex zzc;

    zzew(zzex zzexVar, int i3, int i4) {
        this.zzc = zzexVar;
        this.zza = i3;
        this.zzb = i4;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzer.zzc(i3, this.zzb, "index");
        return this.zzc.get(i3 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.location.zzex, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i3, int i4) {
        return subList(i3, i4);
    }

    @Override // com.google.android.gms.internal.location.zzeu
    @CheckForNull
    final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.location.zzeu
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.location.zzeu
    final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.location.zzeu
    final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.location.zzex
    /* JADX INFO: renamed from: zzh */
    public final zzex subList(int i3, int i4) {
        zzer.zze(i3, i4, this.zzb);
        int i5 = this.zza;
        return this.zzc.subList(i3 + i5, i4 + i5);
    }
}
