package com.google.common.collect;

import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected class StandardDescendingSet extends Sets.DescendingSet<E> {
    }

    protected ForwardingNavigableSet() {
    }

    protected SortedSet C2(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    protected SortedSet J2(Object obj) {
        return tailSet(obj, true);
    }

    @Override // java.util.NavigableSet
    public Object ceiling(Object obj) {
        return k2().ceiling(obj);
    }

    @Override // java.util.NavigableSet
    public Iterator descendingIterator() {
        return k2().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet descendingSet() {
        return k2().descendingSet();
    }

    @Override // java.util.NavigableSet
    public Object floor(Object obj) {
        return k2().floor(obj);
    }

    @Override // java.util.NavigableSet
    public NavigableSet headSet(Object obj, boolean z2) {
        return k2().headSet(obj, z2);
    }

    @Override // java.util.NavigableSet
    public Object higher(Object obj) {
        return k2().higher(obj);
    }

    @Override // java.util.NavigableSet
    public Object lower(Object obj) {
        return k2().lower(obj);
    }

    @Override // java.util.NavigableSet
    public Object pollFirst() {
        return k2().pollFirst();
    }

    @Override // java.util.NavigableSet
    public Object pollLast() {
        return k2().pollLast();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSortedSet
    /* JADX INFO: renamed from: r2, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract NavigableSet o2();

    @Override // java.util.NavigableSet
    public NavigableSet subSet(Object obj, boolean z2, Object obj2, boolean z3) {
        return k2().subSet(obj, z2, obj2, z3);
    }

    @Override // java.util.NavigableSet
    public NavigableSet tailSet(Object obj, boolean z2) {
        return k2().tailSet(obj, z2);
    }

    protected SortedSet z2(Object obj) {
        return headSet(obj, false);
    }
}
