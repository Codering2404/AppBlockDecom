package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzex {
    final /* synthetic */ zzfc zza;
    private final int zzb;
    private Object zzc;
    private int zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private long zzi;

    public zzex(zzfc zzfcVar, int i3) {
        Objects.requireNonNull(zzfcVar);
        this.zza = zzfcVar;
        this.zzb = i3;
    }

    public final void zza() {
        zzfc zzfcVar = this.zza;
        if (zzfcVar.zzd().zzh() != 2 || !zzfcVar.zzd().zzk() || zzfcVar.zzd().zzi() != 0) {
            if (this.zzh) {
                zzfcVar.zzg().zzk(1);
            }
            this.zzh = false;
            return;
        }
        zzbf zzbfVarZzq = zzfcVar.zzd().zzq();
        Object objZzf = zzbfVarZzq.zzg() ? null : zzbfVarZzq.zzf(zzfcVar.zzd().zzr());
        zzbb zzbbVarZzd = zzfcVar.zzd();
        zzbb zzbbVarZzd2 = zzfcVar.zzd();
        zzbb zzbbVarZzd3 = zzfcVar.zzd();
        zzbb zzbbVarZzd4 = zzfcVar.zzd();
        int iZzy = zzbbVarZzd.zzy();
        int iZzz = zzbbVarZzd2.zzz();
        long jZzv = zzbbVarZzd3.zzv();
        long jMax = Math.max(0L, zzfcVar.zzd().zzw() - Math.max(0L, jZzv - zzbbVarZzd4.zzu()));
        if (objZzf != null && iZzy == -1) {
            zzbfVarZzq.zzo(objZzf, zzfcVar.zzf());
            jZzv -= zzfl.zzr(0L);
            iZzy = -1;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzh && Objects.equals(objZzf, this.zzc) && iZzy == this.zzd && iZzz == this.zze && jZzv == this.zzf && jMax == this.zzg) {
            long j3 = jElapsedRealtime - this.zzi;
            int i3 = this.zzb;
            if (j3 >= i3) {
                zzfcVar.zze().zza(new zzfd(1, i3));
                return;
            }
            return;
        }
        this.zzh = true;
        this.zzi = jElapsedRealtime;
        this.zzc = objZzf;
        this.zzd = iZzy;
        this.zze = iZzz;
        this.zzf = jZzv;
        this.zzg = jMax;
        zzfcVar.zzg().zzk(1);
        zzfcVar.zzg().zzi(1, this.zzb);
    }
}
