package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzege extends zzegc {
    private final Context zzg;
    private final Executor zzh;

    zzege(Context context, Executor executor) {
        this.zzg = context;
        this.zzh = executor;
        this.zzf = new zzcaf(context, com.google.android.gms.ads.internal.zzt.w().a(), this, this);
    }

    @Override // com.google.android.gms.internal.ads.zzegc, com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            try {
                if (!this.zzd) {
                    this.zzd = true;
                    try {
                        this.zzf.zzp().zzf(this.zze, ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzov)).booleanValue() ? new zzegb(this.zza, this.zze) : new zzega(this));
                    } catch (RemoteException | IllegalArgumentException unused) {
                        this.zza.zzd(new zzegr(1));
                    } catch (Throwable th) {
                        com.google.android.gms.ads.internal.zzt.l().zzg(th, "RemoteSignalsClientTask.onConnected");
                        this.zza.zzd(new zzegr(1));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final ListenableFuture zza(zzcbd zzcbdVar) {
        synchronized (this.zzb) {
            try {
                if (this.zzc) {
                    return this.zza;
                }
                this.zzc = true;
                this.zze = zzcbdVar;
                this.zzf.checkAvailabilityAndConnect();
                zzcfw zzcfwVar = this.zza;
                zzcfwVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzegd
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzb();
                    }
                }, zzcfr.zzh);
                zzegc.zzc(this.zzg, zzcfwVar, this.zzh);
                return zzcfwVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
