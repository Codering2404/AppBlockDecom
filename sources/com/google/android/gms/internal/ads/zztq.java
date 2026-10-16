package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zztq {
    private Exception zza;
    private long zzb = -9223372036854775807L;
    private long zzc = -9223372036854775807L;

    public final void zza(Exception exc) throws Exception {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zza == null) {
            this.zza = exc;
        }
        if (this.zzb == -9223372036854775807L && !zztr.zzH()) {
            this.zzb = 200 + jElapsedRealtime;
        }
        long j3 = this.zzb;
        if (j3 == -9223372036854775807L || jElapsedRealtime < j3) {
            this.zzc = jElapsedRealtime + 50;
            return;
        }
        Exception exc2 = this.zza;
        if (exc2 != exc) {
            exc2.addSuppressed(exc);
        }
        Exception exc3 = this.zza;
        zzc();
        throw exc3;
    }

    public final boolean zzb() {
        if (this.zza == null) {
            return false;
        }
        return zztr.zzH() || SystemClock.elapsedRealtime() < this.zzc;
    }

    public final void zzc() {
        this.zza = null;
        this.zzb = -9223372036854775807L;
        this.zzc = -9223372036854775807L;
    }
}
