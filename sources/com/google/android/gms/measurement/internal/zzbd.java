package com.google.android.gms.measurement.internal;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbd implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterator f73481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbe f73482b;

    zzbd(zzbe zzbeVar) {
        Objects.requireNonNull(zzbeVar);
        this.f73482b = zzbeVar;
        this.f73481a = zzbeVar.z0().keySet().iterator();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String next() {
        return (String) this.f73481a.next();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f73481a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
