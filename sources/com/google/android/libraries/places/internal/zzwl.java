package com.google.android.libraries.places.internal;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzwl extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f78738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzwm f78739b;

    zzwl(zzwm zzwmVar, int i3) {
        Objects.requireNonNull(zzwmVar);
        this.f78739b = zzwmVar;
        this.f78738a = i3;
    }

    final int a() {
        int i3 = this.f78738a;
        if (i3 == -1) {
            return 0;
        }
        return this.f78739b.c()[i3];
    }

    final int b() {
        return this.f78739b.c()[this.f78738a + 1];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return Arrays.binarySearch(this.f78739b.b(), a(), b(), obj, this.f78738a == -1 ? zzwm.f78740g : zzwo.f78751b) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzwk(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return b() - a();
    }
}
