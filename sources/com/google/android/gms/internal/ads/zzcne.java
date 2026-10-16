package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcne {
    public final int zza;
    public final int zzb;
    private final int zzc;

    private zzcne(int i3, int i4, int i5) {
        this.zzc = i3;
        this.zzb = i4;
        this.zza = i5;
    }

    public static zzcne zza(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        return zzrVar.f70007d ? new zzcne(3, 0, 0) : zzrVar.f70012j ? new zzcne(2, 0, 0) : zzrVar.f70011i ? new zzcne(0, 0, 0) : new zzcne(1, zzrVar.f70009g, zzrVar.f70006c);
    }

    public static zzcne zzb() {
        return new zzcne(0, 0, 0);
    }

    public static zzcne zzc(int i3, int i4) {
        return new zzcne(1, i3, i4);
    }

    public static zzcne zzd() {
        return new zzcne(4, 0, 0);
    }

    public static zzcne zze() {
        return new zzcne(5, 0, 0);
    }

    public final boolean zzf() {
        return this.zzc == 2;
    }

    public final boolean zzg() {
        return this.zzc == 3;
    }

    public final boolean zzh() {
        return this.zzc == 0;
    }

    public final boolean zzi() {
        return this.zzc == 4;
    }

    public final boolean zzj() {
        return this.zzc == 5;
    }
}
