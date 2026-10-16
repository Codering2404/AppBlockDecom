package com.google.common.util.concurrent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class DirectExecutorService extends AbstractListeningExecutorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f85819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f85820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f85821c;

    private void a() {
        synchronized (this.f85819a) {
            try {
                int i3 = this.f85820b - 1;
                this.f85820b = i3;
                if (i3 == 0) {
                    this.f85819a.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void b() {
        synchronized (this.f85819a) {
            try {
                if (this.f85821c) {
                    throw new RejectedExecutionException("Executor already shutdown");
                }
                this.f85820b++;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j3, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j3);
        synchronized (this.f85819a) {
            while (true) {
                try {
                    if (this.f85821c && this.f85820b == 0) {
                        return true;
                    }
                    if (nanos <= 0) {
                        return false;
                    }
                    long jNanoTime = System.nanoTime();
                    TimeUnit.NANOSECONDS.timedWait(this.f85819a, nanos);
                    nanos -= System.nanoTime() - jNanoTime;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        b();
        try {
            runnable.run();
        } finally {
            a();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        boolean z2;
        synchronized (this.f85819a) {
            z2 = this.f85821c;
        }
        return z2;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        boolean z2;
        synchronized (this.f85819a) {
            try {
                z2 = this.f85821c && this.f85820b == 0;
            } finally {
            }
        }
        return z2;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        synchronized (this.f85819a) {
            try {
                this.f85821c = true;
                if (this.f85820b == 0) {
                    this.f85819a.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        shutdown();
        return Collections.EMPTY_LIST;
    }
}
