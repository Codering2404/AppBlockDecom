package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbuf implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f76909b = Logger.getLogger(zzbuf.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f76910a;

    public zzbuf(Runnable runnable) {
        this.f76910a = (Runnable) Preconditions.u(runnable, "task");
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f76910a.run();
        } catch (Throwable th) {
            f76909b.logp(Level.SEVERE, "io.grpc.internal.LogExceptionRunnable", "run", "Exception while executing runnable ".concat(String.valueOf(this.f76910a)), th);
            Throwables.m(th);
            throw new AssertionError(th);
        }
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f76910a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
        sb.append("LogExceptionRunnable(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }
}
