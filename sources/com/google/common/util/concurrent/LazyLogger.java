package com.google.common.util.concurrent;

import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class LazyLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f85876a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f85877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Logger f85878c;

    LazyLogger(Class cls) {
        this.f85877b = cls.getName();
    }

    Logger a() {
        Logger logger = this.f85878c;
        if (logger != null) {
            return logger;
        }
        synchronized (this.f85876a) {
            try {
                Logger logger2 = this.f85878c;
                if (logger2 != null) {
                    return logger2;
                }
                Logger logger3 = Logger.getLogger(this.f85877b);
                this.f85878c = logger3;
                return logger3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
