package com.google.android.libraries.places.internal;

import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbyp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f77210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Future f77211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f77212c;

    zzbyp(Object obj) {
        this.f77210a = obj;
    }

    final void a(Future future) {
        boolean z2;
        synchronized (this.f77210a) {
            try {
                z2 = this.f77212c;
                if (!z2) {
                    this.f77211b = future;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            future.cancel(false);
        }
    }

    final Future b() {
        this.f77212c = true;
        return this.f77211b;
    }
}
