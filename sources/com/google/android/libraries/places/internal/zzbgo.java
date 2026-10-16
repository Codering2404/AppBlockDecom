package com.google.android.libraries.places.internal;

import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbgo implements ListIterator, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ListIterator f76218a;

    public zzbgo(ListIterator delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f76218a = delegate;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f76218a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f76218a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return this.f76218a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f76218a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return this.f76218a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f76218a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
