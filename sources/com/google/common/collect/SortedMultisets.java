package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class SortedMultisets {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ElementSet<E> extends Multisets.ElementSet<E> implements SortedSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SortedMultiset f84676a;

        ElementSet(SortedMultiset sortedMultiset) {
            this.f84676a = sortedMultiset;
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return f().comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return SortedMultisets.d(f().firstEntry());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Multisets.ElementSet
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public final SortedMultiset f() {
            return this.f84676a;
        }

        @Override // java.util.SortedSet
        public SortedSet headSet(Object obj) {
            return f().Q1(obj, BoundType.OPEN).i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return Multisets.e(f().entrySet().iterator());
        }

        @Override // java.util.SortedSet
        public Object last() {
            return SortedMultisets.d(f().lastEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet subSet(Object obj, Object obj2) {
            return f().i1(obj, BoundType.CLOSED, obj2, BoundType.OPEN).i();
        }

        @Override // java.util.SortedSet
        public SortedSet tailSet(Object obj) {
            return f().h2(obj, BoundType.CLOSED).i();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class NavigableElementSet<E> extends ElementSet<E> implements NavigableSet<E> {
        NavigableElementSet(SortedMultiset sortedMultiset) {
            super(sortedMultiset);
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return SortedMultisets.c(f().h2(obj, BoundType.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            return new NavigableElementSet(f().A1());
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return SortedMultisets.c(f().Q1(obj, BoundType.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z2) {
            return new NavigableElementSet(f().Q1(obj, BoundType.b(z2)));
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return SortedMultisets.c(f().h2(obj, BoundType.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return SortedMultisets.c(f().Q1(obj, BoundType.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return SortedMultisets.c(f().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return SortedMultisets.c(f().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z2, Object obj2, boolean z3) {
            return new NavigableElementSet(f().i1(obj, BoundType.b(z2), obj2, BoundType.b(z3)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z2) {
            return new NavigableElementSet(f().h2(obj, BoundType.b(z2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object c(Multiset.Entry entry) {
        if (entry == null) {
            return null;
        }
        return entry.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object d(Multiset.Entry entry) {
        if (entry != null) {
            return entry.a();
        }
        throw new NoSuchElementException();
    }
}
