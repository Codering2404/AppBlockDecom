package com.google.android.libraries.places.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzvg extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzvi f78679a;

    zzvg(zzvi zzviVar) {
        Objects.requireNonNull(zzviVar);
        this.f78679a = zzviVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzvf(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f78679a.h();
    }
}
