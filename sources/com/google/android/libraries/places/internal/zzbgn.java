package com.google.android.libraries.places.internal;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbgn implements Iterator, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Iterator f76217a;

    public zzbgn(Iterator delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f76217a = delegate;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f76217a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.f76217a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
