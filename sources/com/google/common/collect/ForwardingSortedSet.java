package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    protected ForwardingSortedSet() {
    }

    @Override // java.util.SortedSet
    public Comparator comparator() {
        return k2().comparator();
    }

    @Override // java.util.SortedSet
    public Object first() {
        return k2().first();
    }

    @Override // java.util.SortedSet
    public SortedSet headSet(Object obj) {
        return k2().headSet(obj);
    }

    @Override // java.util.SortedSet
    public Object last() {
        return k2().last();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSet
    /* JADX INFO: renamed from: o2, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract SortedSet o2();

    @Override // java.util.SortedSet
    public SortedSet subSet(Object obj, Object obj2) {
        return k2().subSet(obj, obj2);
    }

    @Override // java.util.SortedSet
    public SortedSet tailSet(Object obj) {
        return k2().tailSet(obj);
    }
}
