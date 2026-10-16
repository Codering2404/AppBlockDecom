package com.google.android.libraries.places.internal;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzati implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Executor f75834a;

    public zzati(Executor executor) {
        this.f75834a = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f75834a.execute(runnable);
    }

    public final void zza() {
        this.f75834a = MoreExecutors.a();
    }
}
