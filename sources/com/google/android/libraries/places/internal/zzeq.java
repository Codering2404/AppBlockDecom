package com.google.android.libraries.places.internal;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzeq implements zzbie {
    public static zzeq a() {
        return zzep.f77793a;
    }

    public static ListeningExecutorService b() {
        ListeningScheduledExecutorService listeningScheduledExecutorServiceD = MoreExecutors.d(Executors.newScheduledThreadPool(4, new ThreadFactoryBuilder().f("Maps Platform Background-%d").g(10).b()));
        zzbig.a(listeningScheduledExecutorServiceD);
        return listeningScheduledExecutorServiceD;
    }

    @Override // com.google.android.libraries.places.internal.zzcez
    public final /* synthetic */ Object zzb() {
        return b();
    }
}
