package com.google.android.libraries.places.internal;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbsu implements zzbzx {
    zzbsu() {
    }

    @Override // com.google.android.libraries.places.internal.zzbzx
    public final /* synthetic */ void zza(Object obj) {
        ((ScheduledExecutorService) obj).shutdown();
    }

    @Override // com.google.android.libraries.places.internal.zzbzx
    public final /* bridge */ /* synthetic */ Object zzb() {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, zzbsz.d("grpc-timer-%d", true));
        try {
            scheduledExecutorServiceNewScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(scheduledExecutorServiceNewScheduledThreadPool, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
        return Executors.unconfigurableScheduledExecutorService(scheduledExecutorServiceNewScheduledThreadPool);
    }
}
