package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzacd {
    public static final zzabx zza = new zzabx(2, -9223372036854775807L, null);
    public static final zzabx zzb = new zzabx(3, -9223372036854775807L, null);
    private final zzacj zzc = zzacj.zzb(zzfl.zzg("ExoPlayer:Loader:ProgressiveMediaPeriod"), zzabw.zza);
    private zzaby zzd;
    private IOException zze;

    public zzacd(String str) {
    }

    public static zzabx zza(boolean z2, long j3) {
        return new zzabx(z2 ? 1 : 0, j3, null);
    }

    public final boolean zzb() {
        return this.zze != null;
    }

    public final void zzc() {
        this.zze = null;
    }

    public final long zzd(zzabz zzabzVar, zzabv zzabvVar, int i3) {
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        this.zze = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new zzaby(this, looperMyLooper, zzabzVar, zzabvVar, i3, jElapsedRealtime).zzb(0L);
        return jElapsedRealtime;
    }

    public final boolean zze() {
        return this.zzd != null;
    }

    public final void zzf() {
        zzaby zzabyVar = this.zzd;
        zzabyVar.getClass();
        zzabyVar.zzc(false);
    }

    public final void zzg(zzaca zzacaVar) {
        zzaby zzabyVar = this.zzd;
        if (zzabyVar != null) {
            zzabyVar.zzc(true);
        }
        zzacj zzacjVar = this.zzc;
        zzacjVar.execute(new zzacb(zzacaVar));
        zzacjVar.zza();
    }

    public final void zzh(int i3) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null) {
            throw iOException;
        }
        zzaby zzabyVar = this.zzd;
        if (zzabyVar != null) {
            zzabyVar.zza(i3);
        }
    }

    final /* synthetic */ zzacj zzi() {
        return this.zzc;
    }

    final /* synthetic */ zzaby zzj() {
        return this.zzd;
    }

    final /* synthetic */ void zzk(zzaby zzabyVar) {
        this.zzd = zzabyVar;
    }

    final /* synthetic */ void zzl(IOException iOException) {
        this.zze = iOException;
    }
}
