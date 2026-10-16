package com.google.android.libraries.places.internal;

import com.google.common.base.Stopwatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbxv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScheduledExecutorService f77178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f77179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f77180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Stopwatch f77181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f77182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f77183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ScheduledFuture f77184g;

    zzbxv(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, Stopwatch stopwatch) {
        this.f77180c = runnable;
        this.f77179b = executor;
        this.f77178a = scheduledExecutorService;
        this.f77181d = stopwatch;
        stopwatch.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public final long c() {
        return this.f77181d.e(TimeUnit.NANOSECONDS);
    }

    final void a(long j3, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j3);
        long jC = c() + nanos;
        this.f77183f = true;
        if (jC - this.f77182e < 0 || this.f77184g == null) {
            ScheduledFuture scheduledFuture = this.f77184g;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.f77184g = this.f77178a.schedule(new zzbxu(this, null), nanos, TimeUnit.NANOSECONDS);
        }
        this.f77182e = jC;
    }

    final void b(boolean z2) {
        ScheduledFuture scheduledFuture;
        this.f77183f = false;
        if (!z2 || (scheduledFuture = this.f77184g) == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f77184g = null;
    }

    final /* synthetic */ ScheduledExecutorService d() {
        return this.f77178a;
    }

    final /* synthetic */ Executor e() {
        return this.f77179b;
    }

    final /* synthetic */ Runnable f() {
        return this.f77180c;
    }

    final /* synthetic */ long g() {
        return this.f77182e;
    }

    final /* synthetic */ boolean h() {
        return this.f77183f;
    }

    final /* synthetic */ void i(boolean z2) {
        this.f77183f = false;
    }

    final /* synthetic */ void j(ScheduledFuture scheduledFuture) {
        this.f77184g = scheduledFuture;
    }
}
