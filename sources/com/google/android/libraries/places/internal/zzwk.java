package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzwk implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f78736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzwl f78737b;

    zzwk(zzwl zzwlVar) {
        Objects.requireNonNull(zzwlVar);
        this.f78737b = zzwlVar;
        this.f78736a = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i3 = this.f78736a;
        zzwl zzwlVar = this.f78737b;
        return i3 < zzwlVar.b() - zzwlVar.a();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i3 = this.f78736a;
        zzwl zzwlVar = this.f78737b;
        if (i3 >= zzwlVar.b() - zzwlVar.a()) {
            throw new NoSuchElementException();
        }
        zzwm zzwmVar = zzwlVar.f78739b;
        Object obj = zzwmVar.b()[zzwlVar.a() + i3];
        this.f78736a = i3 + 1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
