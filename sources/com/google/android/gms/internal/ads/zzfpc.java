package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzfpc {
    private static final ListenableFuture zza = zzhbw.zza(null);
    private final zzhcg zzb;
    private final ScheduledExecutorService zzc;
    private final zzfpd zzd;

    public zzfpc(zzhcg zzhcgVar, ScheduledExecutorService scheduledExecutorService, zzfpd zzfpdVar) {
        this.zzb = zzhcgVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfpdVar;
    }

    public final zzfpb zza(Object obj, ListenableFuture listenableFuture) {
        return new zzfpb(this, obj, null, listenableFuture, Collections.singletonList(listenableFuture), listenableFuture, null);
    }

    public final zzfot zzb(Object obj, ListenableFuture... listenableFutureArr) {
        return new zzfot(this, obj, Arrays.asList(listenableFutureArr), null);
    }

    protected abstract String zzc(Object obj);

    final /* synthetic */ zzhcg zze() {
        return this.zzb;
    }

    final /* synthetic */ ScheduledExecutorService zzf() {
        return this.zzc;
    }

    final /* synthetic */ zzfpd zzg() {
        return this.zzd;
    }
}
