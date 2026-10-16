package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhz extends zzjf {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicLong f73872k = new AtomicLong(Long.MIN_VALUE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzhy f73873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzhy f73874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PriorityBlockingQueue f73875e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BlockingQueue f73876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f73877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f73878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f73879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Semaphore f73880j;

    zzhz(zzic zzicVar) {
        super(zzicVar);
        this.f73879i = new Object();
        this.f73880j = new Semaphore(2);
        this.f73875e = new PriorityBlockingQueue();
        this.f73876f = new LinkedBlockingQueue();
        this.f73877g = new zzhw(this, "Thread death: Uncaught exception on worker thread");
        this.f73878h = new zzhw(this, "Thread death: Uncaught exception on network thread");
    }

    private final void F(zzhx zzhxVar) {
        synchronized (this.f73879i) {
            try {
                PriorityBlockingQueue priorityBlockingQueue = this.f73875e;
                priorityBlockingQueue.add(zzhxVar);
                zzhy zzhyVar = this.f73873c;
                if (zzhyVar == null) {
                    zzhy zzhyVar2 = new zzhy(this, "Measurement Worker", priorityBlockingQueue);
                    this.f73873c = zzhyVar2;
                    zzhyVar2.setUncaughtExceptionHandler(this.f73877g);
                    this.f73873c.start();
                } else {
                    zzhyVar.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ void A(zzhy zzhyVar) {
        this.f73874d = null;
    }

    final /* synthetic */ Object B() {
        return this.f73879i;
    }

    final /* synthetic */ Semaphore C() {
        return this.f73880j;
    }

    final /* synthetic */ boolean D() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzje
    public final void g() {
        if (Thread.currentThread() != this.f73874d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzje
    public final void h() {
        if (Thread.currentThread() != this.f73873c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    protected final boolean i() {
        return false;
    }

    public final void o() {
        if (Thread.currentThread() == this.f73873c) {
            throw new IllegalStateException("Call not expected from worker thread");
        }
    }

    public final boolean p() {
        return Thread.currentThread() == this.f73873c;
    }

    public final boolean q() {
        return Thread.currentThread() == this.f73874d;
    }

    public final Future r(Callable callable) {
        l();
        Preconditions.m(callable);
        zzhx zzhxVar = new zzhx(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() != this.f73873c) {
            F(zzhxVar);
            return zzhxVar;
        }
        if (!this.f73875e.isEmpty()) {
            this.f73997a.a().r().a("Callable skipped the worker queue.");
        }
        zzhxVar.run();
        return zzhxVar;
    }

    public final Future s(Callable callable) {
        l();
        Preconditions.m(callable);
        zzhx zzhxVar = new zzhx(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f73873c) {
            zzhxVar.run();
            return zzhxVar;
        }
        F(zzhxVar);
        return zzhxVar;
    }

    public final void t(Runnable runnable) {
        l();
        Preconditions.m(runnable);
        F(new zzhx(this, runnable, false, "Task exception on worker thread"));
    }

    final Object u(AtomicReference atomicReference, long j3, String str, Runnable runnable) {
        synchronized (atomicReference) {
            this.f73997a.b().t(runnable);
            try {
                atomicReference.wait(j3);
            } catch (InterruptedException unused) {
                zzgs zzgsVarR = this.f73997a.a().r();
                StringBuilder sb = new StringBuilder(str.length() + 24);
                sb.append("Interrupted waiting for ");
                sb.append(str);
                zzgsVarR.a(sb.toString());
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            this.f73997a.a().r().a("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final void v(Runnable runnable) {
        l();
        Preconditions.m(runnable);
        F(new zzhx(this, runnable, true, "Task exception on worker thread"));
    }

    public final void w(Runnable runnable) {
        l();
        Preconditions.m(runnable);
        zzhx zzhxVar = new zzhx(this, runnable, false, "Task exception on network thread");
        synchronized (this.f73879i) {
            try {
                BlockingQueue blockingQueue = this.f73876f;
                blockingQueue.add(zzhxVar);
                zzhy zzhyVar = this.f73874d;
                if (zzhyVar == null) {
                    zzhy zzhyVar2 = new zzhy(this, "Measurement Network", blockingQueue);
                    this.f73874d = zzhyVar2;
                    zzhyVar2.setUncaughtExceptionHandler(this.f73878h);
                    this.f73874d.start();
                } else {
                    zzhyVar.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ zzhy x() {
        return this.f73873c;
    }

    final /* synthetic */ void y(zzhy zzhyVar) {
        this.f73873c = null;
    }

    final /* synthetic */ zzhy z() {
        return this.f73874d;
    }
}
