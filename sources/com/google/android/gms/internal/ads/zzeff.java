package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeff {
    private final ScheduledExecutorService zza;
    private final zzhcg zzb;
    private final zzhcg zzc;
    private final zzege zzd;
    private final zzimo zze;

    public zzeff(ScheduledExecutorService scheduledExecutorService, zzhcg zzhcgVar, zzhcg zzhcgVar2, zzege zzegeVar, zzimo zzimoVar) {
        this.zza = scheduledExecutorService;
        this.zzb = zzhcgVar;
        this.zzc = zzhcgVar2;
        this.zzd = zzegeVar;
        this.zze = zzimoVar;
    }

    public final ListenableFuture zza(final zzcbd zzcbdVar) {
        ListenableFuture listenableFutureSubmit;
        String str = zzcbdVar.zzd;
        com.google.android.gms.ads.internal.zzt.g();
        if (com.google.android.gms.ads.internal.util.zzs.f(str)) {
            listenableFutureSubmit = zzhbw.zzc(new zzegr(1));
        } else {
            listenableFutureSubmit = (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzix)).booleanValue() || ((Boolean) zzblb.zza.zze()).booleanValue()) ? this.zzc.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzefc
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.zza.zzc(zzcbdVar);
                }
            }) : this.zzd.zza(zzcbdVar);
        }
        final int callingUid = Binder.getCallingUid();
        return (zzhbo) zzhbw.zzh((zzhbo) zzhbw.zzi(zzhbo.zzw(listenableFutureSubmit), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgD)).intValue(), TimeUnit.SECONDS, this.zza), Throwable.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzefe
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzb(zzcbdVar, callingUid, (Throwable) obj);
            }
        }, this.zzb);
    }

    final /* synthetic */ ListenableFuture zzb(final zzcbd zzcbdVar, int i3, Throwable th) {
        Bundle bundle;
        if (zzcbdVar != null && (bundle = zzcbdVar.zzm) != null) {
            bundle.putBoolean("ls", true);
        }
        return zzhbw.zzj(((zzeii) this.zze.zzb()).zzk(zzcbdVar, i3), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzefd
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return zzhbw.zza(new zzegs((InputStream) obj, zzcbdVar));
            }
        }, this.zzb);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ zzegs zzc(zzcbd zzcbdVar) {
        return (zzegs) this.zzd.zza(zzcbdVar).get(((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgD)).intValue(), TimeUnit.SECONDS);
    }
}
