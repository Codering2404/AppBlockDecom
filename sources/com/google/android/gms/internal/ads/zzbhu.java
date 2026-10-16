package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbhu {
    zzbem zza;
    boolean zzb;
    private final ExecutorService zzc;

    public zzbhu() {
        this.zzc = com.google.android.gms.ads.internal.util.client.zzb.f70157b;
    }

    final /* synthetic */ ExecutorService zza() {
        return this.zzc;
    }

    public zzbhu(final Context context) {
        ExecutorService executorService = com.google.android.gms.ads.internal.util.client.zzb.f70157b;
        this.zzc = executorService;
        executorService.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbhq
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzge)).booleanValue();
                Context context2 = context;
                zzbhu zzbhuVar = this.zza;
                if (zBooleanValue) {
                    try {
                        zzbhuVar.zza = (zzbem) com.google.android.gms.ads.internal.util.client.zzs.a(context2, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzbhr.zza);
                        zzbhuVar.zza.zze(ObjectWrapper.i5(context2), "GMA_SDK");
                        zzbhuVar.zzb = true;
                    } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException unused) {
                        com.google.android.gms.ads.internal.util.client.zzo.a("Cannot dynamite load clearcut");
                    }
                }
            }
        });
    }
}
