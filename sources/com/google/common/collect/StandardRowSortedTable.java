package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class StandardRowSortedTable<R, C, V> extends StandardTable<R, C, V> implements RowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class RowSortedMap extends StandardTable<R, C, V>.RowMap implements SortedMap<R, Map<C, V>> {
        private RowSortedMap() {
            super();
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return StandardRowSortedTable.this.A().comparator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public SortedSet g() {
            return new Maps.SortedKeySet(this);
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return StandardRowSortedTable.this.A().firstKey();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public SortedSet h() {
            return (SortedSet) super.h();
        }

        @Override // java.util.SortedMap
        public SortedMap headMap(Object obj) {
            Preconditions.t(obj);
            return new StandardRowSortedTable(StandardRowSortedTable.this.A().headMap(obj), StandardRowSortedTable.this.f84684d).l();
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return StandardRowSortedTable.this.A().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap subMap(Object obj, Object obj2) {
            Preconditions.t(obj);
            Preconditions.t(obj2);
            return new StandardRowSortedTable(StandardRowSortedTable.this.A().subMap(obj, obj2), StandardRowSortedTable.this.f84684d).l();
        }

        @Override // java.util.SortedMap
        public SortedMap tailMap(Object obj) {
            Preconditions.t(obj);
            return new StandardRowSortedTable(StandardRowSortedTable.this.A().tailMap(obj), StandardRowSortedTable.this.f84684d).l();
        }
    }

    StandardRowSortedTable(SortedMap sortedMap, Supplier supplier) {
        super(sortedMap, supplier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SortedMap A() {
        return (SortedMap) this.f84683c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.StandardTable
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public SortedMap r() {
        return new RowSortedMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public SortedMap l() {
        return (SortedMap) super.l();
    }
}
