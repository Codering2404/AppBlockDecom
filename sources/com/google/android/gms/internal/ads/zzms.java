package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzms {
    private static final zzxk zzu = new zzxk(new Object(), -1);
    public final zzbf zza;
    public final zzxk zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;
    public final zzjk zzf;
    public final boolean zzg;
    public final zzzn zzh;
    public final zzabi zzi;
    public final List zzj;
    public final zzxk zzk;
    public final boolean zzl;
    public final int zzm;
    public final int zzn;
    public final zzav zzo;
    public final boolean zzp = false;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;
    public volatile long zzt;

    public zzms(zzbf zzbfVar, zzxk zzxkVar, long j3, long j4, int i3, zzjk zzjkVar, boolean z2, zzzn zzznVar, zzabi zzabiVar, List list, zzxk zzxkVar2, boolean z3, int i4, int i5, zzav zzavVar, long j5, long j6, long j7, long j8, boolean z4) {
        this.zza = zzbfVar;
        this.zzb = zzxkVar;
        this.zzc = j3;
        this.zzd = j4;
        this.zze = i3;
        this.zzf = zzjkVar;
        this.zzg = z2;
        this.zzh = zzznVar;
        this.zzi = zzabiVar;
        this.zzj = list;
        this.zzk = zzxkVar2;
        this.zzl = z3;
        this.zzm = i4;
        this.zzn = i5;
        this.zzo = zzavVar;
        this.zzq = j5;
        this.zzr = j6;
        this.zzs = j7;
        this.zzt = j8;
    }

    public static zzms zza(zzabi zzabiVar) {
        zzbf zzbfVar = zzbf.zza;
        zzxk zzxkVar = zzu;
        return new zzms(zzbfVar, zzxkVar, -9223372036854775807L, 0L, 1, null, false, zzzn.zza, zzabiVar, zzgwm.zzi(), zzxkVar, false, 1, 0, zzav.zza, 0L, 0L, 0L, 0L, false);
    }

    public static zzxk zzb() {
        return zzu;
    }

    public final zzms zzc(zzxk zzxkVar, long j3, long j4, long j5, long j6, zzzn zzznVar, zzabi zzabiVar, List list) {
        zzxk zzxkVar2 = this.zzk;
        boolean z2 = this.zzl;
        int i3 = this.zzm;
        int i4 = this.zzn;
        zzav zzavVar = this.zzo;
        long j7 = this.zzq;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        return new zzms(this.zza, zzxkVar, j4, j5, this.zze, this.zzf, this.zzg, zzznVar, zzabiVar, list, zzxkVar2, z2, i3, i4, zzavVar, j7, j6, j3, jElapsedRealtime, false);
    }

    public final zzms zzd(zzbf zzbfVar) {
        return new zzms(zzbfVar, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzms zze(int i3) {
        return new zzms(this.zza, this.zzb, this.zzc, this.zzd, i3, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzms zzf(zzjk zzjkVar) {
        return new zzms(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzjkVar, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzms zzg(boolean z2) {
        return new zzms(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, z2, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzms zzh(zzxk zzxkVar) {
        return new zzms(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzxkVar, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzms zzi(boolean z2, int i3, int i4) {
        return new zzms(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z2, i3, i4, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final boolean zzj() {
        return this.zze == 3 && this.zzl && this.zzn == 0;
    }
}
