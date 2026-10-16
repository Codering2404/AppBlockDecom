package com.google.android.libraries.places.internal;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzxd implements Closeable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f78791b = new zzxc();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f78792a = 0;

    public static int a() {
        return b().f78792a;
    }

    private static zzxd b() {
        return (zzxd) f78791b.get();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i3 = this.f78792a;
        if (i3 <= 0) {
            throw new AssertionError("Mismatched calls to RecursionDepth (possible error in core library)");
        }
        this.f78792a = i3 - 1;
    }
}
