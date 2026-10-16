package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbnv implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Runnable f76510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f76511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f76512c;

    zzbnv(Runnable runnable) {
        this.f76510a = (Runnable) Preconditions.u(runnable, "task");
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f76511b) {
            return;
        }
        this.f76512c = true;
        this.f76510a.run();
    }
}
