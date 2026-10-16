package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class Lazy<T> implements Provider<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f88133c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Object f88134a = f88133c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Provider f88135b;

    public Lazy(Provider provider) {
        this.f88135b = provider;
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        Object obj;
        Object obj2 = this.f88134a;
        Object obj3 = f88133c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f88134a;
                if (obj == obj3) {
                    obj = this.f88135b.get();
                    this.f88134a = obj;
                    this.f88135b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
