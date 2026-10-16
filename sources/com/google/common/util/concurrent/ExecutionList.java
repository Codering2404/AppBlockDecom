package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class ExecutionList {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LazyLogger f85822c = new LazyLogger(ExecutionList.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RunnableExecutorPair f85823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f85824b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class RunnableExecutorPair {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f85825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f85826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        RunnableExecutorPair f85827c;

        RunnableExecutorPair(Runnable runnable, Executor executor, RunnableExecutorPair runnableExecutorPair) {
            this.f85825a = runnable;
            this.f85826b = executor;
            this.f85827c = runnableExecutorPair;
        }
    }

    private static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e3) {
            f85822c.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e3);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        Preconditions.u(runnable, "Runnable was null.");
        Preconditions.u(executor, "Executor was null.");
        synchronized (this) {
            try {
                if (this.f85824b) {
                    c(runnable, executor);
                } else {
                    this.f85823a = new RunnableExecutorPair(runnable, executor, this.f85823a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        synchronized (this) {
            try {
                if (this.f85824b) {
                    return;
                }
                this.f85824b = true;
                RunnableExecutorPair runnableExecutorPair = this.f85823a;
                RunnableExecutorPair runnableExecutorPair2 = null;
                this.f85823a = null;
                while (runnableExecutorPair != null) {
                    RunnableExecutorPair runnableExecutorPair3 = runnableExecutorPair.f85827c;
                    runnableExecutorPair.f85827c = runnableExecutorPair2;
                    runnableExecutorPair2 = runnableExecutorPair;
                    runnableExecutorPair = runnableExecutorPair3;
                }
                while (runnableExecutorPair2 != null) {
                    c(runnableExecutorPair2.f85825a, runnableExecutorPair2.f85826b);
                    runnableExecutorPair2 = runnableExecutorPair2.f85827c;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
