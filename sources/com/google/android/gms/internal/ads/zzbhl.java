package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbhl {
    private zzbha zza;
    private boolean zzb;
    private final Context zzc;
    private final Object zzd = new Object();

    zzbhl(Context context) {
        this.zzc = context;
    }

    final Future zza(zzbhb zzbhbVar) {
        zzbhf zzbhfVar = new zzbhf(this);
        zzbhj zzbhjVar = new zzbhj(this, zzbhbVar, zzbhfVar);
        zzbhk zzbhkVar = new zzbhk(this, zzbhfVar);
        synchronized (this.zzd) {
            zzbha zzbhaVar = new zzbha(this.zzc, com.google.android.gms.ads.internal.zzt.w().a(), zzbhjVar, zzbhkVar);
            this.zza = zzbhaVar;
            zzbhaVar.checkAvailabilityAndConnect();
        }
        return zzbhfVar;
    }

    final /* synthetic */ void zzb() {
        synchronized (this.zzd) {
            try {
                zzbha zzbhaVar = this.zza;
                if (zzbhaVar == null) {
                    return;
                }
                zzbhaVar.disconnect();
                this.zza = null;
                Binder.flushPendingCommands();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ zzbha zzc() {
        return this.zza;
    }

    final /* synthetic */ boolean zzd() {
        return this.zzb;
    }

    final /* synthetic */ void zze(boolean z2) {
        this.zzb = true;
    }

    final /* synthetic */ Object zzf() {
        return this.zzd;
    }
}
