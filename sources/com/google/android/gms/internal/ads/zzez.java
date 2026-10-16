package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzez {
    final /* synthetic */ zzfc zza;
    private final int zzb;
    private Object zzc;
    private int zzd;
    private int zze;
    private long zzf;
    private boolean zzg;
    private long zzh;

    public zzez(zzfc zzfcVar, int i3) {
        Objects.requireNonNull(zzfcVar);
        this.zza = zzfcVar;
        this.zzb = i3;
    }

    public final void zza() {
        zzfc zzfcVar = this.zza;
        if (!zzfcVar.zzd().zza()) {
            if (this.zzg) {
                zzfcVar.zzg().zzk(2);
            }
            this.zzg = false;
            return;
        }
        zzbf zzbfVarZzq = zzfcVar.zzd().zzq();
        Object objZzf = zzbfVarZzq.zzg() ? null : zzbfVarZzq.zzf(zzfcVar.zzd().zzr());
        zzbb zzbbVarZzd = zzfcVar.zzd();
        zzbb zzbbVarZzd2 = zzfcVar.zzd();
        zzbb zzbbVarZzd3 = zzfcVar.zzd();
        int iZzy = zzbbVarZzd.zzy();
        int iZzz = zzbbVarZzd2.zzz();
        long jZzu = zzbbVarZzd3.zzu();
        if (objZzf != null && iZzy == -1) {
            zzbfVarZzq.zzo(objZzf, zzfcVar.zzf());
            jZzu -= zzfl.zzr(0L);
            iZzy = -1;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzg && Objects.equals(objZzf, this.zzc) && iZzy == this.zzd && iZzz == this.zze && jZzu == this.zzf) {
            long j3 = jElapsedRealtime - this.zzh;
            int i3 = this.zzb;
            if (j3 >= i3) {
                zzfcVar.zze().zza(new zzfd(2, i3));
                return;
            }
            return;
        }
        this.zzg = true;
        this.zzh = jElapsedRealtime;
        this.zzc = objZzf;
        this.zzd = iZzy;
        this.zze = iZzz;
        this.zzf = jZzu;
        zzfcVar.zzg().zzk(2);
        zzfcVar.zzg().zzi(2, this.zzb);
    }
}
