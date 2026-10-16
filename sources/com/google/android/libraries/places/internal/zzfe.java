package com.google.android.libraries.places.internal;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzfe implements zzfa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzblw f77810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ListeningExecutorService f77811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzex f77812c;

    public zzfe(zzblw managedChannel, zzex zwiebackCookieManager, ListeningExecutorService backgroundExecutorService) {
        Intrinsics.checkNotNullParameter(managedChannel, "managedChannel");
        Intrinsics.checkNotNullParameter(zwiebackCookieManager, "zwiebackCookieManager");
        Intrinsics.checkNotNullParameter(backgroundExecutorService, "backgroundExecutorService");
        this.f77810a = managedChannel;
        this.f77812c = zwiebackCookieManager;
        this.f77811b = backgroundExecutorService;
    }

    static /* synthetic */ ListenableFuture a(zzfe zzfeVar, String cookie) {
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        zzbhi zzbhiVarB = zzbhj.b(zzfeVar.f77810a);
        zzbhd zzbhdVarG = zzbhe.G();
        zzbhdVarG.y(cookie);
        return zzcef.b(zzbhiVarB.b().d(zzbhj.a(), zzbhiVarB.c()), (zzbhe) zzbhdVarG.zzG());
    }

    @Override // com.google.android.libraries.places.internal.zzfa
    public final void zza() {
        ListenableFuture listenableFutureA = this.f77812c.a();
        final Function1 function1 = new Function1() { // from class: com.google.android.libraries.places.internal.zzfc
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                return zzfe.a(this.f77808a, (String) obj);
            }
        };
        AsyncFunction asyncFunction = new AsyncFunction() { // from class: com.google.android.libraries.places.internal.zzfb
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return (ListenableFuture) function1.invoke(obj);
            }
        };
        ListeningExecutorService listeningExecutorService = this.f77811b;
        Futures.a(Futures.i(listenableFutureA, asyncFunction, listeningExecutorService), new zzfd(this), listeningExecutorService);
    }

    @Override // com.google.android.libraries.places.internal.zzfa
    public final void zzb() {
        this.f77810a.g();
    }
}
