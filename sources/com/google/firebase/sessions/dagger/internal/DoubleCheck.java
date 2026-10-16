package com.google.firebase.sessions.dagger.internal;

import com.google.firebase.sessions.dagger.Lazy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f90146c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Provider f90147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Object f90148b = f90146c;

    private DoubleCheck(Provider provider) {
        this.f90147a = provider;
    }

    public static Provider a(Provider provider) {
        Preconditions.b(provider);
        return provider instanceof DoubleCheck ? provider : new DoubleCheck(provider);
    }

    private static Object b(Object obj, Object obj2) {
        if (obj == f90146c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // javax.inject.Provider
    public Object get() {
        Object obj;
        Object obj2 = this.f90148b;
        Object obj3 = f90146c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f90148b;
                if (obj == obj3) {
                    obj = this.f90147a.get();
                    this.f90148b = b(this.f90148b, obj);
                    this.f90147a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
