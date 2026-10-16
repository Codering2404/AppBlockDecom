package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbzq implements Executor, Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Logger f77294d = Logger.getLogger(zzbzq.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final zzbzn f77295f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f77296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Queue f77297b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f77298c = 0;

    static {
        zzbzn zzbzpVar;
        byte[] bArr = null;
        try {
            zzbzpVar = new zzbzo(AtomicIntegerFieldUpdater.newUpdater(zzbzq.class, "c"), bArr);
        } catch (Throwable th) {
            f77294d.logp(Level.SEVERE, "io.grpc.internal.SerializingExecutor", "getAtomicHelper", "FieldUpdaterAtomicHelper failed", th);
            zzbzpVar = new zzbzp(bArr);
        }
        f77295f = zzbzpVar;
    }

    public zzbzq(Executor executor) {
        Preconditions.u(executor, "'executor' must not be null.");
        this.f77296a = executor;
    }

    private final void c(Runnable runnable) {
        if (f77295f.a(this, 0, -1)) {
            try {
                this.f77296a.execute(this);
            } catch (Throwable th) {
                if (runnable != null) {
                    this.f77297b.remove(runnable);
                }
                f77295f.b(this, 0);
                throw th;
            }
        }
    }

    final /* synthetic */ int a() {
        return this.f77298c;
    }

    final /* synthetic */ void b(int i3) {
        this.f77298c = i3;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f77297b.add((Runnable) Preconditions.u(runnable, "'r' must not be null."));
        c(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                Runnable runnable = (Runnable) this.f77297b.poll();
                if (runnable == null) {
                    break;
                }
                try {
                    runnable.run();
                } catch (RuntimeException e3) {
                    Logger logger = f77294d;
                    Level level = Level.SEVERE;
                    String string = runnable.toString();
                    StringBuilder sb = new StringBuilder(string.length() + 35);
                    sb.append("Exception while executing runnable ");
                    sb.append(string);
                    logger.logp(level, "io.grpc.internal.SerializingExecutor", "run", sb.toString(), (Throwable) e3);
                }
            } catch (Throwable th) {
                f77295f.b(this, 0);
                throw th;
            }
        }
        f77295f.b(this, 0);
        if (this.f77297b.isEmpty()) {
            return;
        }
        c(null);
    }
}
