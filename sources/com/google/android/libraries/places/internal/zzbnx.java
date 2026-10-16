package com.google.android.libraries.places.internal;

import androidx.compose.animation.core.h;
import com.google.common.base.Preconditions;
import java.lang.Thread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbnx implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f76515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Queue f76516b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference f76517c = new AtomicReference();

    public zzbnx(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f76515a = (Thread.UncaughtExceptionHandler) Preconditions.u(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    public final void a(Runnable runnable) {
        this.f76516b.add((Runnable) Preconditions.u(runnable, "runnable is null"));
    }

    public final void b() {
        Preconditions.A(Thread.currentThread() == this.f76517c.get(), "Not called from the SynchronizationContext");
    }

    public final zzbnw c(Runnable runnable, long j3, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzbnv zzbnvVar = new zzbnv(runnable);
        return new zzbnw(zzbnvVar, scheduledExecutorService.schedule(new zzbnu(this, zzbnvVar, runnable), j3, timeUnit), null);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        a(runnable);
        zza();
    }

    public final void zza() {
        while (h.a(this.f76517c, null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable runnable = (Runnable) this.f76516b.poll();
                    if (runnable == null) {
                        break;
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        this.f76515a.uncaughtException(Thread.currentThread(), th);
                    }
                } catch (Throwable th2) {
                    this.f76517c.set(null);
                    throw th2;
                }
            }
            this.f76517c.set(null);
            if (this.f76516b.isEmpty()) {
                return;
            }
        }
    }
}
