package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zztl {
    private final zzv zza;
    private final zzv zzb;
    private final int zzc;
    private final int zzd;
    private final zzre zze;
    private final zzck zzf;

    private zztl(zzv zzvVar, zzv zzvVar2, int i3, int i4, zzre zzreVar, zzck zzckVar) {
        this.zza = zzvVar;
        this.zzb = zzvVar2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = zzreVar;
        this.zzf = zzckVar;
    }

    final /* synthetic */ zztl zza(zzre zzreVar) {
        return new zztl(this.zza, this.zzb, this.zzc, this.zzd, zzreVar, this.zzf);
    }

    final /* synthetic */ long zzb(long j3) {
        return zzfl.zzt(j3, this.zza.zzI);
    }

    final /* synthetic */ long zzc(long j3) {
        return zzfl.zzt(j3, this.zze.zzb);
    }

    final /* synthetic */ zzry zzd() {
        zzre zzreVar = this.zze;
        return new zzry(zzreVar.zza, zzreVar.zzb, zzreVar.zzc, false, false, zzreVar.zze);
    }

    final /* synthetic */ boolean zze() {
        return Objects.equals(this.zza.zzp, "audio/raw");
    }

    final /* synthetic */ zzv zzf() {
        return this.zza;
    }

    final /* synthetic */ zzv zzg() {
        return this.zzb;
    }

    final /* synthetic */ int zzh() {
        return this.zzc;
    }

    final /* synthetic */ int zzi() {
        return this.zzd;
    }

    final /* synthetic */ zzre zzj() {
        return this.zze;
    }

    final /* synthetic */ zzck zzk() {
        return this.zzf;
    }

    /* synthetic */ zztl(zzv zzvVar, zzv zzvVar2, int i3, int i4, zzre zzreVar, zzck zzckVar, byte[] bArr) {
        this(zzvVar, zzvVar2, i3, i4, zzreVar, zzckVar);
    }
}
