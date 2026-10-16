package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcfm {
    private zzhcg zza;
    private zzdzl zzb;
    private Context zzc;
    private final AtomicBoolean zzd = new AtomicBoolean(false);
    private final AtomicBoolean zze = new AtomicBoolean(false);
    private long zzf = -1;
    private long zzg = -1;

    public final void zza(zzhcg zzhcgVar, zzdzl zzdzlVar, Context context) {
        if (this.zzd.getAndSet(true)) {
            return;
        }
        this.zza = zzhcgVar;
        this.zzb = zzdzlVar;
        this.zzf = ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpm)).longValue();
        this.zzg = ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpn)).longValue();
        this.zzc = context;
    }

    public final void zzb() {
        zzhcg zzhcgVar;
        if (!this.zzd.get() || this.zzf < 0 || this.zzg < 0 || !this.zze.compareAndSet(false, true) || (zzhcgVar = this.zza) == null) {
            return;
        }
        zzhcgVar.submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzc();
            }
        });
    }

    final /* synthetic */ void zzc() {
        zzdzl zzdzlVar;
        ActivityManager.MemoryInfo memoryInfoP;
        while (this.zze.get()) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfj
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    atomicBoolean.getAndSet(true);
                }
            });
            try {
                Thread.sleep(this.zzf);
                if (!atomicBoolean.get()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpo)).booleanValue() && (zzdzlVar = this.zzb) != null) {
                        zzdzk zzdzkVarZza = zzdzlVar.zza();
                        zzdzkVarZza.zzc("action", "panr");
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpQ)).booleanValue() && (memoryInfoP = com.google.android.gms.ads.internal.util.client.zzf.p(this.zzc)) != null) {
                            zzdzkVarZza.zzc("mem_avl", String.valueOf(memoryInfoP.availMem));
                            zzdzkVarZza.zzc("mem_tt", String.valueOf(memoryInfoP.totalMem));
                            zzdzkVarZza.zzc("low_m", true != memoryInfoP.lowMemory ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
                        }
                        zzdzkVarZza.zzf();
                    }
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpp)).booleanValue()) {
                        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                        zzcfl zzcflVar = new zzcfl(tDEtWsFLJfe.DbQbMr);
                        zzcflVar.setStackTrace(stackTrace);
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpq)).booleanValue()) {
                            zzbzy.zzc(this.zzc).zzi(zzcflVar, "AnrWatchdog", ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpr)).intValue() / 100.0f);
                        } else {
                            com.google.android.gms.ads.internal.zzt.l().zzg(zzcflVar, "AnrWatchdog");
                        }
                    }
                }
                do {
                    try {
                        Thread.sleep(this.zzg);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                } while (!atomicBoolean.get());
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
