package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class LazySet<T> implements Provider<Set<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Set f88137b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Set f88136a = Collections.newSetFromMap(new ConcurrentHashMap());

    LazySet(Collection collection) {
        this.f88136a.addAll(collection);
    }

    static LazySet b(Collection collection) {
        return new LazySet((Set) collection);
    }

    private synchronized void d() {
        try {
            Iterator it = this.f88136a.iterator();
            while (it.hasNext()) {
                this.f88137b.add(((Provider) it.next()).get());
            }
            this.f88136a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized void a(Provider provider) {
        try {
            if (this.f88137b == null) {
                this.f88136a.add(provider);
            } else {
                this.f88137b.add(provider.get());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.firebase.inject.Provider
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set get() {
        if (this.f88137b == null) {
            synchronized (this) {
                try {
                    if (this.f88137b == null) {
                        this.f88137b = Collections.newSetFromMap(new ConcurrentHashMap());
                        d();
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableSet(this.f88137b);
    }
}
