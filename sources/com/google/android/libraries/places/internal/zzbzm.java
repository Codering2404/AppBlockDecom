package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbzm implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Logger f77290c = Logger.getLogger(zzbzm.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f77291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayDeque f77292b;

    zzbzm() {
    }

    private final void zza() {
        while (true) {
            Runnable runnable = (Runnable) this.f77292b.poll();
            if (runnable == null) {
                return;
            }
            try {
                runnable.run();
            } catch (Throwable th) {
                f77290c.logp(Level.SEVERE, "io.grpc.internal.SerializeReentrantCallsDirectExecutor", "completeQueuedTasks", "Exception while executing runnable ".concat(runnable.toString()), th);
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        Preconditions.u(runnable, "'task' must not be null.");
        if (this.f77291a) {
            if (this.f77292b == null) {
                this.f77292b = new ArrayDeque(4);
            }
            this.f77292b.add(runnable);
            return;
        }
        this.f77291a = true;
        try {
            runnable.run();
            if (this.f77292b != null) {
                zza();
            }
            this.f77291a = false;
        } catch (Throwable th) {
            try {
                Logger logger = f77290c;
                Level level = Level.SEVERE;
                String strValueOf = String.valueOf(runnable);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 35);
                sb.append("Exception while executing runnable ");
                sb.append(strValueOf);
                logger.logp(level, "io.grpc.internal.SerializeReentrantCallsDirectExecutor", "execute", sb.toString(), th);
                if (this.f77292b != null) {
                    zza();
                }
                this.f77291a = false;
            } catch (Throwable th2) {
                if (this.f77292b != null) {
                    zza();
                }
                this.f77291a = false;
                throw th2;
            }
        }
    }
}
