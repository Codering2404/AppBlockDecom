package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzh {
    private int zza;
    private int zzb;
    private int zzc;
    private byte[] zzd;
    private int zze;
    private int zzf;

    public zzh() {
        this.zza = -1;
        this.zzb = -1;
        this.zzc = -1;
        this.zze = -1;
        this.zzf = -1;
    }

    public final zzh zza(int i3) {
        this.zza = i3;
        return this;
    }

    public final zzh zzb(int i3) {
        this.zzb = i3;
        return this;
    }

    public final zzh zzc(int i3) {
        this.zzc = i3;
        return this;
    }

    public final zzh zzd(byte[] bArr) {
        this.zzd = bArr;
        return this;
    }

    public final zzh zze(int i3) {
        this.zze = i3;
        return this;
    }

    public final zzh zzf(int i3) {
        this.zzf = i3;
        return this;
    }

    public final zzi zzg() {
        return new zzi(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, null);
    }

    /* synthetic */ zzh(zzi zziVar, byte[] bArr) {
        this.zza = zziVar.zzb;
        this.zzb = zziVar.zzc;
        this.zzc = zziVar.zzd;
        this.zzd = zziVar.zze;
        this.zze = zziVar.zzf;
        this.zzf = zziVar.zzg;
    }
}
