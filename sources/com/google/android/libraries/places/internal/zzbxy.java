package com.google.android.libraries.places.internal;

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbxy implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Collection f77186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbzd f77187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Future f77188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f77189d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Future f77190f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ zzbzf f77191g;

    zzbxy(zzbzf zzbzfVar, Collection collection, zzbzd zzbzdVar, Future future, boolean z2, Future future2) {
        this.f77186a = collection;
        this.f77187b = zzbzdVar;
        this.f77188c = future;
        this.f77189d = z2;
        this.f77190f = future2;
        Objects.requireNonNull(zzbzfVar);
        this.f77191g = zzbzfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (zzbzd zzbzdVar : this.f77186a) {
            if (zzbzdVar != this.f77187b) {
                zzbzdVar.f77244a.c(zzbzf.C);
            }
        }
        Future future = this.f77188c;
        if (future != null) {
            future.cancel(false);
            if (!this.f77189d) {
                zzbzf zzbzfVar = this.f77191g;
                if (zzbzfVar.B().decrementAndGet() == Integer.MIN_VALUE) {
                    zzbnx zzbnxVar = (zzbnx) zzbzfVar.m();
                    zzbnxVar.a(new zzbxx(this));
                    zzbnxVar.zza();
                }
            }
        }
        Future future2 = this.f77190f;
        if (future2 != null) {
            future2.cancel(false);
        }
        this.f77191g.U();
    }
}
