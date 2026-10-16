package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfb {
    final /* synthetic */ zzfc zza;
    private final int zzb;
    private int zzc;
    private boolean zzd;
    private long zze;

    public zzfb(zzfc zzfcVar, int i3) {
        Objects.requireNonNull(zzfcVar);
        this.zza = zzfcVar;
        this.zzb = i3;
    }

    public final void zza() {
        zzfc zzfcVar = this.zza;
        int iZzi = zzfcVar.zzd().zzi();
        if (!zzfcVar.zzd().zzk() || zzfcVar.zzd().zzh() == 1 || zzfcVar.zzd().zzh() == 4 || iZzi == 0 || iZzi == 1) {
            if (this.zzd) {
                zzfcVar.zzg().zzk(4);
            }
            this.zzd = false;
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzd && this.zzc == iZzi) {
            long j3 = jElapsedRealtime - this.zze;
            int i3 = this.zzb;
            if (j3 >= i3) {
                zzfcVar.zze().zza(new zzfd(4, i3));
                return;
            }
            return;
        }
        this.zzd = true;
        this.zze = jElapsedRealtime;
        this.zzc = iZzi;
        zzfcVar.zzg().zzk(4);
        zzfcVar.zzg().zzi(4, this.zzb);
    }
}
