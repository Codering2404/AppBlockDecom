package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Closer implements Closeable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Suppressor f85252d = new Suppressor() { // from class: com.google.common.io.a
        @Override // com.google.common.io.Closer.Suppressor
        public final void a(Closeable closeable, Throwable th, Throwable th2) {
            Closer.a(closeable, th, th2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Suppressor f85253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Deque f85254b = new ArrayDeque(4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Throwable f85255c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Suppressor {
        void a(Closeable closeable, Throwable th, Throwable th2);
    }

    Closer(Suppressor suppressor) {
        this.f85253a = (Suppressor) Preconditions.t(suppressor);
    }

    public static /* synthetic */ void a(Closeable closeable, Throwable th, Throwable th2) {
        if (th == th2) {
            return;
        }
        try {
            th.addSuppressed(th2);
        } catch (Throwable unused) {
            Closeables.f85251a.log(Level.WARNING, "Suppressing exception thrown when closing " + closeable, th2);
        }
    }

    public static Closer b() {
        return new Closer(f85252d);
    }

    public Closeable c(Closeable closeable) {
        if (closeable != null) {
            this.f85254b.addFirst(closeable);
        }
        return closeable;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Throwable th = this.f85255c;
        while (!this.f85254b.isEmpty()) {
            Closeable closeable = (Closeable) this.f85254b.removeFirst();
            try {
                closeable.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    this.f85253a.a(closeable, th, th2);
                }
            }
        }
        if (this.f85255c != null || th == null) {
            return;
        }
        Throwables.l(th, IOException.class);
        Throwables.m(th);
        throw new AssertionError(th);
    }

    public RuntimeException f(Throwable th) throws Throwable {
        Preconditions.t(th);
        this.f85255c = th;
        Throwables.l(th, IOException.class);
        Throwables.m(th);
        throw new RuntimeException(th);
    }
}
