package com.google.firebase.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class LimitedConcurrencyExecutor implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f88182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Semaphore f88183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedBlockingQueue f88184c;

    public static /* synthetic */ void a(LimitedConcurrencyExecutor limitedConcurrencyExecutor, Runnable runnable) {
        limitedConcurrencyExecutor.getClass();
        try {
            runnable.run();
        } finally {
            limitedConcurrencyExecutor.f88183b.release();
            limitedConcurrencyExecutor.c();
        }
    }

    private Runnable b(final Runnable runnable) {
        return new Runnable() { // from class: com.google.firebase.concurrent.v
            @Override // java.lang.Runnable
            public final void run() {
                LimitedConcurrencyExecutor.a(this.f88249a, runnable);
            }
        };
    }

    private void c() {
        while (this.f88183b.tryAcquire()) {
            Runnable runnable = (Runnable) this.f88184c.poll();
            if (runnable == null) {
                this.f88183b.release();
                return;
            }
            this.f88182a.execute(b(runnable));
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f88184c.offer(runnable);
        c();
    }
}
