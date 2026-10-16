package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class PrimitiveConstructor<KeyT extends Key, PrimitiveT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f86265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f86266b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PrimitiveConstructionFunction<KeyT extends Key, PrimitiveT> {
    }

    public static PrimitiveConstructor a(final PrimitiveConstructionFunction primitiveConstructionFunction, Class cls, Class cls2) {
        return new PrimitiveConstructor<Key, Object>(cls, cls2) { // from class: com.google.crypto.tink.internal.PrimitiveConstructor.1
        };
    }

    public Class b() {
        return this.f86265a;
    }

    public Class c() {
        return this.f86266b;
    }

    private PrimitiveConstructor(Class cls, Class cls2) {
        this.f86265a = cls;
        this.f86266b = cls2;
    }
}
