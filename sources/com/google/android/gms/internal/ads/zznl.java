package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zznl implements zzmb {
    private boolean zza;
    private long zzb;
    private long zzc;
    private zzav zzd = zzav.zza;

    public zznl(zzdo zzdoVar) {
    }

    public final void zza() {
        if (this.zza) {
            return;
        }
        this.zzc = SystemClock.elapsedRealtime();
        this.zza = true;
    }

    public final void zzb() {
        if (this.zza) {
            zzc(zzg());
            this.zza = false;
        }
    }

    public final void zzc(long j3) {
        this.zzb = j3;
        if (this.zza) {
            this.zzc = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final long zzg() {
        long j3 = this.zzb;
        if (!this.zza) {
            return j3;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.zzc;
        zzav zzavVar = this.zzd;
        return j3 + (zzavVar.zzb == 1.0f ? zzfl.zzs(jElapsedRealtime) : zzavVar.zza(jElapsedRealtime));
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final void zzi(zzav zzavVar) {
        if (this.zza) {
            zzc(zzg());
        }
        this.zzd = zzavVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final zzav zzj() {
        return this.zzd;
    }
}
