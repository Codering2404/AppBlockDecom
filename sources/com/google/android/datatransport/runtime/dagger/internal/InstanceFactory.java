package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final InstanceFactory f69403b = new InstanceFactory(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f69404a;

    private InstanceFactory(Object obj) {
        this.f69404a = obj;
    }

    public static Factory a(Object obj) {
        return new InstanceFactory(Preconditions.c(obj, "instance cannot be null"));
    }

    @Override // javax.inject.Provider
    public Object get() {
        return this.f69404a;
    }
}
