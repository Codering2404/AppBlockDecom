package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class FilteredMultimapValues<K, V> extends AbstractCollection<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FilteredMultimap f83946a;

    FilteredMultimapValues(FilteredMultimap filteredMultimap) {
        this.f83946a = (FilteredMultimap) Preconditions.t(filteredMultimap);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f83946a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f83946a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return Maps.Y(this.f83946a.b().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        Predicate predicateR0 = this.f83946a.R0();
        Iterator it = this.f83946a.f().b().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (predicateR0.apply(entry) && Objects.a(entry.getValue(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        return Iterables.p(this.f83946a.f().b(), Predicates.c(this.f83946a.R0(), Maps.a0(Predicates.g(collection))));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        return Iterables.p(this.f83946a.f().b(), Predicates.c(this.f83946a.R0(), Maps.a0(Predicates.j(Predicates.g(collection)))));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f83946a.size();
    }
}
