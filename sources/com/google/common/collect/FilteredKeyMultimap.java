package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class FilteredKeyMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Multimap f83940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Predicate f83941h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AddRejectingList<K, V> extends ForwardingList<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f83942a;

        AddRejectingList(Object obj) {
            this.f83942a = obj;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(Object obj) {
            add(0, obj);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            addAll(0, collection);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection
        public List k2() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public void add(int i3, Object obj) {
            Preconditions.w(i3, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f83942a);
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public boolean addAll(int i3, Collection collection) {
            Preconditions.t(collection);
            Preconditions.w(i3, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f83942a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AddRejectingSet<K, V> extends ForwardingSet<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f83943a;

        AddRejectingSet(Object obj) {
            this.f83943a = obj;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(Object obj) {
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f83943a);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            Preconditions.t(collection);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f83943a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        public Set k2() {
            return Collections.EMPTY_SET;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class Entries extends ForwardingCollection<Map.Entry<K, V>> {
        Entries() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* JADX INFO: renamed from: I1 */
        public Collection k2() {
            return Collections2.d(FilteredKeyMultimap.this.f83940g.b(), FilteredKeyMultimap.this.R0());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (FilteredKeyMultimap.this.f83940g.containsKey(entry.getKey()) && FilteredKeyMultimap.this.f83941h.apply(entry.getKey())) {
                return FilteredKeyMultimap.this.f83940g.remove(entry.getKey(), entry.getValue());
            }
            return false;
        }
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Predicate R0() {
        return Maps.z(this.f83941h);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection a(Object obj) {
        return containsKey(obj) ? this.f83940g.a(obj) : k();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map c() {
        return Maps.t(this.f83940g.a1(), this.f83941h);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        keySet().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(Object obj) {
        if (this.f83940g.containsKey(obj)) {
            return this.f83941h.apply(obj);
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection d() {
        return new Entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set e() {
        return Sets.d(this.f83940g.keySet(), this.f83941h);
    }

    public Multimap f() {
        return this.f83940g;
    }

    @Override // com.google.common.collect.AbstractMultimap
    Multiset g() {
        return Multisets.g(this.f83940g.keys(), this.f83941h);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection get(Object obj) {
        return this.f83941h.apply(obj) ? this.f83940g.get(obj) : this.f83940g instanceof SetMultimap ? new AddRejectingSet(obj) : new AddRejectingList(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection h() {
        return new FilteredMultimapValues(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Iterator i() {
        throw new AssertionError("should never be called");
    }

    Collection k() {
        return this.f83940g instanceof SetMultimap ? Collections.EMPTY_SET : Collections.EMPTY_LIST;
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        Iterator<V> it = a1().values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((Collection) it.next()).size();
        }
        return size;
    }
}
