package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcnc {
    private final zzcmt zza;
    private final zzdzl zzb;

    zzcnc(zzcmt zzcmtVar, zzdzl zzdzlVar) {
        this.zza = zzcmtVar;
        this.zzb = zzdzlVar;
    }

    public final void zza(final Context context, final VersionInfoParcel versionInfoParcel) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzps)).booleanValue()) {
            Executor threadPoolExecutor = zzcfr.zza;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpu)).booleanValue()) {
                zzcnb zzcnbVar = new zzcnb(((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpw)).intValue(), null);
                int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpv)).intValue();
                threadPoolExecutor = new ThreadPoolExecutor(iIntValue, iIntValue, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzcnbVar);
            }
            threadPoolExecutor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmz
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzb(context, versionInfoParcel);
                }
            });
        }
    }

    final /* synthetic */ void zzb(Context context, VersionInfoParcel versionInfoParcel) {
        long jA = com.google.android.gms.ads.internal.zzt.o().a();
        com.google.android.gms.ads.internal.zzt.g().P(context, versionInfoParcel.f70149a);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpt)).booleanValue()) {
            long jA2 = com.google.android.gms.ads.internal.zzt.o().a() - jA;
            zzdzk zzdzkVarZza = this.zzb.zza();
            zzdzkVarZza.zzc("action", "webview_startup_l");
            StringBuilder sb = new StringBuilder(String.valueOf(jA2).length());
            sb.append(jA2);
            zzdzkVarZza.zzc("webview_startup_l", sb.toString());
            zzdzkVarZza.zzd();
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpz)).booleanValue()) {
            zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmy
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzc();
                }
            });
        }
    }

    final /* synthetic */ void zzc() {
        this.zza.zzb(new zzcmx(this, com.google.android.gms.ads.internal.zzt.o().a()));
    }

    final /* synthetic */ zzdzl zzd() {
        return this.zzb;
    }
}
