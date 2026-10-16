package com.google.common.collect;

import com.google.common.collect.Multisets;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected class StandardElementSet extends Multisets.ElementSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ForwardingMultiset f83953a;

        @Override // com.google.common.collect.Multisets.ElementSet
        Multiset f() {
            return this.f83953a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return Multisets.e(f().entrySet().iterator());
        }
    }

    protected ForwardingMultiset() {
    }

    @Override // com.google.common.collect.Multiset
    public boolean L1(Object obj, int i3, int i4) {
        return k2().L1(obj, i3, i4);
    }

    @Override // com.google.common.collect.Multiset
    public int Y1(Object obj) {
        return k2().Y1(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int e0(Object obj, int i3) {
        return k2().e0(obj, i3);
    }

    public Set entrySet() {
        return k2().entrySet();
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(Object obj) {
        return obj == this || k2().equals(obj);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return k2().hashCode();
    }

    public Set i() {
        return k2().i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection
    public abstract Multiset k2();

    @Override // com.google.common.collect.Multiset
    public int o1(Object obj, int i3) {
        return k2().o1(obj, i3);
    }

    @Override // com.google.common.collect.Multiset
    public int t1(Object obj, int i3) {
        return k2().t1(obj, i3);
    }
}
