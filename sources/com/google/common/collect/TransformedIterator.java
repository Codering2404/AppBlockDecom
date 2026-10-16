package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class TransformedIterator<F, T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterator f84762a;

    TransformedIterator(Iterator it) {
        this.f84762a = (Iterator) Preconditions.t(it);
    }

    abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f84762a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f84762a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f84762a.remove();
    }
}
