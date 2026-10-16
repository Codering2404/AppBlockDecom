package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Comparator f84763i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Factory<C, V> implements Supplier<Map<C, V>>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Comparator f84768a;

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map get() {
            return new TreeMap(this.f84768a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class TreeRow extends StandardTable<R, C, V>.Row implements SortedMap<C, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Object f84769d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Object f84770f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        transient SortedMap f84771g;

        TreeRow(TreeBasedTable treeBasedTable, Object obj) {
            this(obj, null, null);
        }

        @Override // com.google.common.collect.StandardTable.Row
        void c() {
            j();
            SortedMap sortedMap = this.f84771g;
            if (sortedMap == null || !sortedMap.isEmpty()) {
                return;
            }
            TreeBasedTable.this.f84683c.remove(this.f84710a);
            this.f84771g = null;
            this.f84711b = null;
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return TreeBasedTable.this.D();
        }

        @Override // com.google.common.collect.StandardTable.Row, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return i(obj) && super.containsKey(obj);
        }

        int f(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            d();
            Map map = this.f84711b;
            if (map != null) {
                return ((SortedMap) map).firstKey();
            }
            throw new NoSuchElementException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.StandardTable.Row
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public SortedMap b() {
            j();
            SortedMap sortedMapTailMap = this.f84771g;
            if (sortedMapTailMap == null) {
                return null;
            }
            Object obj = this.f84769d;
            if (obj != null) {
                sortedMapTailMap = sortedMapTailMap.tailMap(obj);
            }
            Object obj2 = this.f84770f;
            return obj2 != null ? sortedMapTailMap.headMap(obj2) : sortedMapTailMap;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public SortedSet keySet() {
            return new Maps.SortedKeySet(this);
        }

        @Override // java.util.SortedMap
        public SortedMap headMap(Object obj) {
            Preconditions.d(i(Preconditions.t(obj)));
            return new TreeRow(this.f84710a, this.f84769d, obj);
        }

        boolean i(Object obj) {
            if (obj == null) {
                return false;
            }
            Object obj2 = this.f84769d;
            if (obj2 != null && f(obj2, obj) > 0) {
                return false;
            }
            Object obj3 = this.f84770f;
            return obj3 == null || f(obj3, obj) > 0;
        }

        void j() {
            SortedMap sortedMap = this.f84771g;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.f84683c.containsKey(this.f84710a))) {
                this.f84771g = (SortedMap) TreeBasedTable.this.f84683c.get(this.f84710a);
            }
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            d();
            Map map = this.f84711b;
            if (map != null) {
                return ((SortedMap) map).lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.StandardTable.Row, java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            Preconditions.d(i(Preconditions.t(obj)));
            return super.put(obj, obj2);
        }

        @Override // java.util.SortedMap
        public SortedMap subMap(Object obj, Object obj2) {
            Preconditions.d(i(Preconditions.t(obj)) && i(Preconditions.t(obj2)));
            return new TreeRow(this.f84710a, obj, obj2);
        }

        @Override // java.util.SortedMap
        public SortedMap tailMap(Object obj) {
            Preconditions.d(i(Preconditions.t(obj)));
            return new TreeRow(this.f84710a, obj, this.f84770f);
        }

        TreeRow(Object obj, Object obj2, Object obj3) {
            super(obj);
            this.f84769d = obj2;
            this.f84770f = obj3;
            Preconditions.d(obj2 == null || obj3 == null || f(obj2, obj3) <= 0);
        }
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map C() {
        return super.C();
    }

    public Comparator D() {
        return this.f84763i;
    }

    @Override // com.google.common.collect.StandardTable
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public SortedMap x(Object obj) {
        return new TreeRow(this, obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set O0() {
        return super.O0();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ boolean b(Object obj, Object obj2) {
        return super.b(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2) {
        return super.e(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ Map k(Object obj) {
        return super.k(obj);
    }

    @Override // com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ Set m() {
        return super.m();
    }

    @Override // com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ boolean n(Object obj) {
        return super.n(obj);
    }

    @Override // com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ boolean p(Object obj) {
        return super.p(obj);
    }

    @Override // com.google.common.collect.StandardTable
    Iterator q() {
        final Comparator comparatorD = D();
        final UnmodifiableIterator unmodifiableIteratorB = Iterators.B(Iterables.y(this.f84683c.values(), new Function() { // from class: com.google.common.collect.g0
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ((Map) obj).keySet().iterator();
            }
        }), comparatorD);
        return new AbstractIterator<C>(this) { // from class: com.google.common.collect.TreeBasedTable.1

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f84764c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ TreeBasedTable f84767g;

            {
                this.f84767g = this;
            }

            @Override // com.google.common.collect.AbstractIterator
            protected Object a() {
                while (unmodifiableIteratorB.hasNext()) {
                    Object next = unmodifiableIteratorB.next();
                    Object obj = this.f84764c;
                    if (obj == null || comparatorD.compare(next, obj) != 0) {
                        this.f84764c = next;
                        return next;
                    }
                }
                this.f84764c = null;
                return b();
            }
        };
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ Object t(Object obj, Object obj2, Object obj3) {
        return super.t(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ Object u(Object obj, Object obj2) {
        return super.u(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public SortedMap l() {
        return super.l();
    }
}
