package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class OptionalProvider<T> implements Provider<T>, Deferred<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Deferred.DeferredHandler f88138c = new Deferred.DeferredHandler() { // from class: com.google.firebase.components.k
        @Override // com.google.firebase.inject.Deferred.DeferredHandler
        public final void a(Provider provider) {
            OptionalProvider.d(provider);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Provider f88139d = new Provider() { // from class: com.google.firebase.components.l
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            return OptionalProvider.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Deferred.DeferredHandler f88140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Provider f88141b;

    private OptionalProvider(Deferred.DeferredHandler deferredHandler, Provider provider) {
        this.f88140a = deferredHandler;
        this.f88141b = provider;
    }

    public static /* synthetic */ Object b() {
        return null;
    }

    public static /* synthetic */ void c(Deferred.DeferredHandler deferredHandler, Deferred.DeferredHandler deferredHandler2, Provider provider) {
        deferredHandler.a(provider);
        deferredHandler2.a(provider);
    }

    static OptionalProvider e() {
        return new OptionalProvider(f88138c, f88139d);
    }

    static OptionalProvider f(Provider provider) {
        return new OptionalProvider(null, provider);
    }

    @Override // com.google.firebase.inject.Deferred
    public void a(final Deferred.DeferredHandler deferredHandler) {
        Provider provider;
        Provider provider2;
        Provider provider3 = this.f88141b;
        Provider provider4 = f88139d;
        if (provider3 != provider4) {
            deferredHandler.a(provider3);
            return;
        }
        synchronized (this) {
            provider = this.f88141b;
            if (provider != provider4) {
                provider2 = provider;
            } else {
                final Deferred.DeferredHandler deferredHandler2 = this.f88140a;
                this.f88140a = new Deferred.DeferredHandler() { // from class: com.google.firebase.components.m
                    @Override // com.google.firebase.inject.Deferred.DeferredHandler
                    public final void a(Provider provider5) {
                        OptionalProvider.c(deferredHandler2, deferredHandler, provider5);
                    }
                };
                provider2 = null;
            }
        }
        if (provider2 != null) {
            deferredHandler.a(provider);
        }
    }

    void g(Provider provider) {
        Deferred.DeferredHandler deferredHandler;
        if (this.f88141b != f88139d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            deferredHandler = this.f88140a;
            this.f88140a = null;
            this.f88141b = provider;
        }
        deferredHandler.a(provider);
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        return this.f88141b.get();
    }

    public static /* synthetic */ void d(Provider provider) {
    }
}
