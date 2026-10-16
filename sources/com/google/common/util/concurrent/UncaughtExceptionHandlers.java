package com.google.common.util.concurrent;

import java.lang.Thread;
import java.util.Locale;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class UncaughtExceptionHandlers {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Exiter implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final LazyLogger f85979b = new LazyLogger(Exiter.class);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runtime f85980a;

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            try {
                f85979b.a().log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", thread), th);
            } finally {
                try {
                } finally {
                }
            }
        }
    }
}
