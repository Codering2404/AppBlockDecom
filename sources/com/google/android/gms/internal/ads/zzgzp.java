package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgzp implements Closeable {
    private static final zzgzo zzc = zzgzo.zza;
    private final Deque zza = new ArrayDeque(4);
    private Throwable zzb;

    zzgzp(zzgzo zzgzoVar) {
    }

    public static zzgzp zza() {
        return new zzgzp(zzc);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        Throwable th = this.zzb;
        while (true) {
            Deque deque = this.zza;
            if (deque.isEmpty()) {
                break;
            }
            Closeable closeable = (Closeable) deque.removeFirst();
            try {
                closeable.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else if (th != th2) {
                    try {
                        th.addSuppressed(th2);
                    } catch (Throwable unused) {
                        zzgzn.zza.logp(Level.WARNING, "com.google.common.io.Closer", "<init>", "Suppressing exception thrown when closing ".concat(String.valueOf(closeable)), th2);
                    }
                }
            }
        }
        if (this.zzb != null || th == null) {
            return;
        }
        zzgug.zza(th, IOException.class);
        zzgug.zzb(th);
        throw new AssertionError(th);
    }

    public final Closeable zzb(Closeable closeable) {
        this.zza.addFirst(closeable);
        return closeable;
    }

    public final RuntimeException zzc(Throwable th) throws Throwable {
        this.zzb = th;
        zzgug.zza(th, IOException.class);
        zzgug.zzb(th);
        throw new RuntimeException(th);
    }
}
