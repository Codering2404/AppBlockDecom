package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f69400c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Provider f69401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Object f69402b = f69400c;

    private DoubleCheck(Provider provider) {
        this.f69401a = provider;
    }

    public static Provider a(Provider provider) {
        Preconditions.b(provider);
        return provider instanceof DoubleCheck ? provider : new DoubleCheck(provider);
    }

    private static Object b(Object obj, Object obj2) {
        if (obj == f69400c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // javax.inject.Provider
    public Object get() {
        Object obj;
        Object obj2 = this.f69402b;
        Object obj3 = f69400c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f69402b;
                if (obj == obj3) {
                    obj = this.f69401a.get();
                    this.f69402b = b(this.f69402b, obj);
                    this.f69401a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
