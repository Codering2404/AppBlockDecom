package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzvf implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f78677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzvg f78678b;

    zzvf(zzvg zzvgVar) {
        Objects.requireNonNull(zzvgVar);
        this.f78678b = zzvgVar;
        this.f78677a = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f78677a < this.f78678b.f78679a.h();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i3 = this.f78677a;
        this.f78677a = i3 + 1;
        zzvi zzviVar = this.f78678b.f78679a;
        return zzviVar.e(zzviVar.g()[i3] & 31);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
