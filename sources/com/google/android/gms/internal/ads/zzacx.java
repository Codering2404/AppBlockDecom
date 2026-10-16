package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzacx {
    private boolean zzc;
    private int zze;
    private zzacw zza = new zzacw();
    private zzacw zzb = new zzacw();
    private long zzd = -9223372036854775807L;

    public final void zza() {
        this.zza.zza();
        this.zzb.zza();
        this.zzc = false;
        this.zzd = -9223372036854775807L;
        this.zze = 0;
    }

    public final void zzb(long j3) {
        this.zza.zzf(j3);
        if (this.zza.zzb()) {
            this.zzc = false;
        } else if (this.zzd != -9223372036854775807L) {
            if (!this.zzc || this.zzb.zzc()) {
                this.zzb.zza();
                this.zzb.zzf(this.zzd);
            }
            this.zzc = true;
            this.zzb.zzf(j3);
        }
        if (this.zzc && this.zzb.zzb()) {
            zzacw zzacwVar = this.zza;
            this.zza = this.zzb;
            this.zzb = zzacwVar;
            this.zzc = false;
        }
        this.zzd = j3;
        this.zze = this.zza.zzb() ? 0 : this.zze + 1;
    }

    public final boolean zzc() {
        return this.zza.zzb();
    }

    public final int zzd() {
        return this.zze;
    }

    public final long zze() {
        if (this.zza.zzb()) {
            return this.zza.zzd();
        }
        return -9223372036854775807L;
    }

    public final long zzf() {
        if (this.zza.zzb()) {
            return this.zza.zze();
        }
        return -9223372036854775807L;
    }

    public final float zzg() {
        if (this.zza.zzb()) {
            return (float) (1.0E9d / this.zza.zze());
        }
        return -1.0f;
    }
}
