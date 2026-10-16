package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class yo implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterator f65242a;

    yo(Iterator it) {
        this.f65242a = (Iterator) Preconditions.checkNotNull(it);
    }

    abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f65242a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f65242a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f65242a.remove();
    }
}
