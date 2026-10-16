package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdfs extends zzdip {
    private final ScheduledExecutorService zzb;
    private final Clock zzc;
    private final zzdzl zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private boolean zzi;
    private ScheduledFuture zzj;
    private ScheduledFuture zzk;

    public zzdfs(ScheduledExecutorService scheduledExecutorService, Clock clock, zzdzl zzdzlVar) {
        super(Collections.EMPTY_SET);
        this.zze = -1L;
        this.zzf = -1L;
        this.zzg = -1L;
        this.zzh = -1L;
        this.zzi = false;
        this.zzb = scheduledExecutorService;
        this.zzc = clock;
        this.zzd = zzdzlVar;
    }

    private final synchronized void zzf(long j3) {
        try {
            ScheduledFuture scheduledFuture = this.zzj;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                this.zzj.cancel(false);
            }
            this.zze = this.zzc.a() + j3;
            this.zzj = this.zzb.schedule(new zzdfq(this, null), j3, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzg(long j3) {
        try {
            ScheduledFuture scheduledFuture = this.zzk;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                this.zzk.cancel(false);
            }
            this.zzf = this.zzc.a() + j3;
            this.zzk = this.zzb.schedule(new zzdfr(this, null), j3, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zza() {
        try {
            if (this.zzi) {
                return;
            }
            ScheduledFuture scheduledFuture = this.zzj;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                this.zzg = -1L;
            } else {
                this.zzj.cancel(false);
                this.zzg = this.zze - this.zzc.a();
            }
            ScheduledFuture scheduledFuture2 = this.zzk;
            if (scheduledFuture2 == null || scheduledFuture2.isCancelled()) {
                this.zzh = -1L;
            } else {
                this.zzk.cancel(false);
                this.zzh = this.zzf - this.zzc.a();
            }
            this.zzi = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzb() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        try {
            if (this.zzi) {
                if (this.zzg > 0 && (scheduledFuture2 = this.zzj) != null && scheduledFuture2.isCancelled()) {
                    zzf(this.zzg);
                }
                if (this.zzh > 0 && (scheduledFuture = this.zzk) != null && scheduledFuture.isCancelled()) {
                    zzg(this.zzh);
                }
                this.zzi = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzc() {
        this.zzi = false;
        zzf(0L);
    }

    public final synchronized void zzd(int i3) {
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 20);
        sb.append("In scheduleRefresh: ");
        sb.append(i3);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        if (i3 > 0) {
            long millis = TimeUnit.SECONDS.toMillis(i3);
            if (this.zzi) {
                long j3 = this.zzg;
                if (j3 <= 0 || millis >= j3) {
                    millis = j3;
                }
                this.zzg = millis;
                return;
            }
            long jA = this.zzc.a();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoK)).booleanValue()) {
                long j4 = this.zze;
                if (jA >= j4 || j4 - jA > millis) {
                    zzf(millis);
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzph)).booleanValue()) {
                        zzdzk zzdzkVarZza = this.zzd.zza();
                        zzdzkVarZza.zzc("action", "rtnc");
                        zzdzkVarZza.zzf();
                    }
                }
            } else {
                long j5 = this.zze;
                if (jA > j5 || j5 - jA > millis) {
                    zzf(millis);
                }
            }
        }
    }

    public final synchronized void zze(int i3) {
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 28);
        sb.append("In scheduleShowRefreshedAd: ");
        sb.append(i3);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        if (i3 > 0) {
            long millis = TimeUnit.SECONDS.toMillis(i3);
            if (this.zzi) {
                long j3 = this.zzh;
                if (j3 <= 0 || millis >= j3) {
                    millis = j3;
                }
                this.zzh = millis;
                return;
            }
            long jA = this.zzc.a();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoK)).booleanValue()) {
                if (jA == this.zzf) {
                    com.google.android.gms.ads.internal.util.zze.k("In scheduleShowRefreshedAd: currentTimeMs = scheduledShowTimeMs");
                }
                long j4 = this.zzf;
                if (jA >= j4 || j4 - jA > millis) {
                    zzg(millis);
                }
            } else {
                long j5 = this.zzf;
                if (jA > j5 || j5 - jA > millis) {
                    zzg(millis);
                }
            }
        }
    }
}
