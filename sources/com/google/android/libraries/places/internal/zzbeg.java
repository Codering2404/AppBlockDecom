package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbeg implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Iterator f76107a;

    public zzbeg(Iterator it) {
        this.f76107a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f76107a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.f76107a.next();
        return entry.getValue() instanceof zzbeh ? new zzbef(entry, null) : entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f76107a.remove();
    }
}
