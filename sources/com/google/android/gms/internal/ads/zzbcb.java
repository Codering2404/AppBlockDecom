package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbcb {
    private static final String[] zza = {"android:establish_vpn_service", "android:establish_vpn_manager"};
    private long zzb = 0;
    private long zzc = 0;
    private long zzd = -1;
    private boolean zze = false;

    zzbcb(Context context, Executor executor, String[] strArr) {
        if (Build.VERSION.SDK_INT < 30) {
            return;
        }
        try {
            ((AppOpsManager) context.getSystemService("appops")).startWatchingActive(strArr, executor, new zzbca(this));
        } catch (IllegalArgumentException | NoSuchMethodError unused) {
        }
    }

    public static zzbcb zza(Context context, Executor executor) {
        return new zzbcb(context, executor, zza);
    }

    public final void zzb() {
        if (this.zze) {
            this.zzc = System.currentTimeMillis();
        }
    }

    public final long zzc() {
        if (this.zze) {
            return this.zzc - this.zzb;
        }
        return -1L;
    }

    public final long zzd() {
        long j3 = this.zzd;
        this.zzd = -1L;
        return j3;
    }

    final /* synthetic */ void zze(long j3) {
        this.zzb = j3;
    }

    final /* synthetic */ long zzf() {
        return this.zzc;
    }

    final /* synthetic */ void zzg(long j3) {
        this.zzd = j3;
    }

    final /* synthetic */ void zzh(boolean z2) {
        this.zze = z2;
    }
}
