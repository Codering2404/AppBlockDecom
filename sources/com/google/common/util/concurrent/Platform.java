package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class Platform {
    static boolean a(Throwable th, Class cls) {
        return cls.isInstance(th);
    }

    static void b(Throwable th) {
        Preconditions.t(th);
        if (th instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
    }
}
