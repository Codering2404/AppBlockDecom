package com.google.crypto.tink.internal;

import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.internal.PrimitiveRegistry;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MutablePrimitiveRegistry {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static MutablePrimitiveRegistry f86255b = new MutablePrimitiveRegistry();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f86256a = new AtomicReference(new PrimitiveRegistry.Builder().c());

    MutablePrimitiveRegistry() {
    }

    public static MutablePrimitiveRegistry a() {
        return f86255b;
    }

    public synchronized void b(PrimitiveConstructor primitiveConstructor) {
        this.f86256a.set(new PrimitiveRegistry.Builder((PrimitiveRegistry) this.f86256a.get()).d(primitiveConstructor).c());
    }

    public synchronized void c(PrimitiveWrapper primitiveWrapper) {
        this.f86256a.set(new PrimitiveRegistry.Builder((PrimitiveRegistry) this.f86256a.get()).e(primitiveWrapper).c());
    }
}
