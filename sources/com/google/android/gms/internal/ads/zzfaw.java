package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfaw implements zzfck {
    private final zzfck zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzfaw(zzfck zzfckVar, long j3, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzfckVar;
        this.zzb = j3;
        this.zzc = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        ListenableFuture listenableFutureZza = this.zza.zza();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzde)).booleanValue()) {
            timeUnit = TimeUnit.MICROSECONDS;
        }
        long j3 = this.zzb;
        if (j3 > 0) {
            listenableFutureZza = zzhbw.zzi(listenableFutureZza, j3, timeUnit, this.zzc);
        }
        return zzhbw.zzh(listenableFutureZza, Throwable.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzfav
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc((Throwable) obj);
            }
        }, zzcfr.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return this.zza.zzb();
    }

    final /* synthetic */ ListenableFuture zzc(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdc)).booleanValue()) {
            zzfck zzfckVar = this.zza;
            zzcfd zzcfdVarL = com.google.android.gms.ads.internal.zzt.l();
            int iZzb = zzfckVar.zzb();
            StringBuilder sb = new StringBuilder(String.valueOf(iZzb).length() + 22);
            sb.append("OptionalSignalTimeout:");
            sb.append(iZzb);
            zzcfdVarL.zzg(th, sb.toString());
        }
        return zzhbw.zza(null);
    }
}
