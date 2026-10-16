package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhdz {
    private static final zzhdx zza = zzhdy.zza;
    private final zzhdq zzb;
    private final zzhds zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private final zzhdx zzg;
    private final int zzh;

    /* synthetic */ zzhdz(zzhdq zzhdqVar, int i3, int i4, boolean z2, boolean z3, zzhdx zzhdxVar, byte[] bArr) {
        this.zzb = zzhdqVar;
        this.zzh = i3;
        int i5 = i3 - 2;
        this.zzc = i5 != 1 ? i5 != 3 ? zzhds.zzb : zzhds.zzc : zzhds.zza;
        this.zzd = i4;
        this.zze = z2;
        this.zzf = z3;
        this.zzg = zzhdxVar;
    }

    public final zzhdq zza() {
        this.zzg.zza(this);
        return this.zzb;
    }

    public final zzhds zzb() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final boolean zzd() {
        return this.zze;
    }

    final /* synthetic */ zzhdq zzf() {
        return this.zzb;
    }

    final /* synthetic */ int zzg() {
        return this.zzd;
    }

    final /* synthetic */ boolean zzh() {
        return this.zze;
    }

    final /* synthetic */ boolean zzi() {
        return this.zzf;
    }

    final /* synthetic */ int zzj() {
        return this.zzh;
    }
}
