package com.google.firebase.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class PausableExecutorImpl implements PausableExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f88186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f88187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final LinkedBlockingQueue f88188c;

    private void a() {
        if (this.f88186a) {
            return;
        }
        Runnable runnable = (Runnable) this.f88188c.poll();
        while (runnable != null) {
            this.f88187b.execute(runnable);
            runnable = !this.f88186a ? (Runnable) this.f88188c.poll() : null;
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f88188c.offer(runnable);
        a();
    }
}
