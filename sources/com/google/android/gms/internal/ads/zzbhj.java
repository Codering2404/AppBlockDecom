package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbhj implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbhb zza;
    final /* synthetic */ zzcfw zzb;
    final /* synthetic */ zzbhl zzc;

    zzbhj(zzbhl zzbhlVar, zzbhb zzbhbVar, zzcfw zzcfwVar) {
        this.zza = zzbhbVar;
        this.zzb = zzcfwVar;
        Objects.requireNonNull(zzbhlVar);
        this.zzc = zzbhlVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzbhl zzbhlVar = this.zzc;
        synchronized (zzbhlVar.zzf()) {
            try {
                if (zzbhlVar.zzd()) {
                    return;
                }
                zzbhlVar.zze(true);
                final zzbha zzbhaVarZzc = zzbhlVar.zzc();
                if (zzbhaVarZzc == null) {
                    return;
                }
                zzhcg zzhcgVar = zzcfr.zza;
                final zzbhb zzbhbVar = this.zza;
                final zzcfw zzcfwVar = this.zzb;
                final ListenableFuture listenableFutureSubmit = zzhcgVar.submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbhi
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzcfw zzcfwVar2 = zzcfwVar;
                        zzbha zzbhaVar = zzbhaVarZzc;
                        zzbhj zzbhjVar = this.zza;
                        try {
                            zzbhd zzbhdVarZzq = zzbhaVar.zzq();
                            boolean zZzp = zzbhaVar.zzp();
                            zzbhb zzbhbVar2 = zzbhbVar;
                            zzbgy zzbgyVarZzf = zZzp ? zzbhdVarZzq.zzf(zzbhbVar2) : zzbhdVarZzq.zze(zzbhbVar2);
                            if (!zzbgyVarZzf.zza()) {
                                zzcfwVar2.zzd(new RuntimeException("No entry contents."));
                                zzbhjVar.zzc.zzb();
                                return;
                            }
                            zzbhg zzbhgVar = new zzbhg(zzbhjVar, zzbgyVarZzf.zzb(), 1);
                            int i3 = zzbhgVar.read();
                            if (i3 == -1) {
                                throw new IOException("Unable to read from cache.");
                            }
                            zzbhgVar.unread(i3);
                            zzcfwVar2.zzc(zzbhn.zza(zzbhgVar, zzbgyVarZzf.zzd(), zzbgyVarZzf.zzg(), zzbgyVarZzf.zzf(), zzbgyVarZzf.zze()));
                        } catch (RemoteException e3) {
                            e = e3;
                            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                            com.google.android.gms.ads.internal.util.client.zzo.d("Unable to obtain a cache service instance.", e);
                            zzcfwVar2.zzd(e);
                            zzbhjVar.zzc.zzb();
                        } catch (IOException e4) {
                            e = e4;
                            int i42 = com.google.android.gms.ads.internal.util.zze.f70328b;
                            com.google.android.gms.ads.internal.util.client.zzo.d("Unable to obtain a cache service instance.", e);
                            zzcfwVar2.zzd(e);
                            zzbhjVar.zzc.zzb();
                        }
                    }
                });
                zzcfwVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbhh
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        if (zzcfwVar.isCancelled()) {
                            listenableFutureSubmit.cancel(true);
                        }
                    }
                }, zzcfr.zzh);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i3) {
    }
}
