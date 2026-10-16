package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.SortedMultisets;
import java.util.Comparator;
import java.util.NavigableSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected abstract class StandardDescendingMultiset extends DescendingMultiset<E> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ForwardingSortedMultiset f83958d;

        @Override // com.google.common.collect.DescendingMultiset
        SortedMultiset r2() {
            return this.f83958d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected class StandardElementSet extends SortedMultisets.NavigableElementSet<E> {
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset A1() {
        return k2().A1();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset Q1(Object obj, BoundType boundType) {
        return k2().Q1(obj, boundType);
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public Comparator comparator() {
        return k2().comparator();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry firstEntry() {
        return k2().firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset h2(Object obj, BoundType boundType) {
        return k2().h2(obj, boundType);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset i1(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return k2().i1(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry lastEntry() {
        return k2().lastEntry();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMultiset
    /* JADX INFO: renamed from: m2, reason: merged with bridge method [inline-methods] */
    public abstract SortedMultiset k2();

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry pollFirstEntry() {
        return k2().pollFirstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry pollLastEntry() {
        return k2().pollLastEntry();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public NavigableSet i() {
        return k2().i();
    }
}
