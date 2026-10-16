package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class ArrayTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImmutableList f83761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ImmutableList f83762d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImmutableMap f83763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ImmutableMap f83764g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object[][] f83765h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private transient ColumnMap f83766i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private transient RowMap f83767j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class ArrayMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableMap f83774a;

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator a() {
            return new AbstractIndexedListIterator<Map.Entry<K, V>>(size()) { // from class: com.google.common.collect.ArrayTable.ArrayMap.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIndexedListIterator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Map.Entry a(int i3) {
                    return ArrayMap.this.b(i3);
                }
            };
        }

        Map.Entry b(final int i3) {
            Preconditions.r(i3, size());
            return new AbstractMapEntry<K, V>(this) { // from class: com.google.common.collect.ArrayTable.ArrayMap.1

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ ArrayMap f83776b;

                {
                    this.f83776b = this;
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public Object getKey() {
                    return this.f83776b.c(i3);
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public Object getValue() {
                    return this.f83776b.e(i3);
                }

                @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                public Object setValue(Object obj) {
                    return this.f83776b.f(i3, obj);
                }
            };
        }

        Object c(int i3) {
            return this.f83774a.keySet().a().get(i3);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f83774a.containsKey(obj);
        }

        abstract String d();

        abstract Object e(int i3);

        abstract Object f(int i3, Object obj);

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Integer num = (Integer) this.f83774a.get(obj);
            if (num == null) {
                return null;
            }
            return e(num.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f83774a.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return this.f83774a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            Integer num = (Integer) this.f83774a.get(obj);
            if (num != null) {
                return f(num.intValue(), obj2);
            }
            throw new IllegalArgumentException(d() + " " + obj + " not in " + this.f83774a.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f83774a.size();
        }

        private ArrayMap(ImmutableMap immutableMap) {
            this.f83774a = immutableMap;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class Column extends ArrayMap<R, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f83778b;

        Column(int i3) {
            super(ArrayTable.this.f83763f);
            this.f83778b = i3;
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        String d() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        Object e(int i3) {
            return ArrayTable.this.o(i3, this.f83778b);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        Object f(int i3, Object obj) {
            return ArrayTable.this.r(i3, this.f83778b, obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ColumnMap extends ArrayMap<C, Map<R, V>> {
        @Override // com.google.common.collect.ArrayTable.ArrayMap
        String d() {
            return "Column";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Map e(int i3) {
            return new Column(i3);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Map put(Object obj, Map map) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Map f(int i3, Map map) {
            throw new UnsupportedOperationException();
        }

        private ColumnMap() {
            super(ArrayTable.this.f83764g);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class Row extends ArrayMap<C, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f83781b;

        Row(int i3) {
            super(ArrayTable.this.f83764g);
            this.f83781b = i3;
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        String d() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        Object e(int i3) {
            return ArrayTable.this.o(this.f83781b, i3);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap
        Object f(int i3, Object obj) {
            return ArrayTable.this.r(this.f83781b, i3, obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class RowMap extends ArrayMap<R, Map<C, V>> {
        @Override // com.google.common.collect.ArrayTable.ArrayMap
        String d() {
            return "Row";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Map e(int i3) {
            return new Row(i3);
        }

        @Override // com.google.common.collect.ArrayTable.ArrayMap, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Map put(Object obj, Map map) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ArrayTable.ArrayMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Map f(int i3, Map map) {
            throw new UnsupportedOperationException();
        }

        private RowMap() {
            super(ArrayTable.this.f83763f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Table.Cell p(int i3) {
        return new Tables.AbstractCell<R, C, V>(this, i3) { // from class: com.google.common.collect.ArrayTable.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final int f83769a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final int f83770b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f83771c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ ArrayTable f83772d;

            {
                this.f83771c = i3;
                this.f83772d = this;
                this.f83769a = i3 / this.f83762d.size();
                this.f83770b = i3 % this.f83762d.size();
            }

            @Override // com.google.common.collect.Table.Cell
            public Object a() {
                return this.f83772d.f83761c.get(this.f83769a);
            }

            @Override // com.google.common.collect.Table.Cell
            public Object b() {
                return this.f83772d.f83762d.get(this.f83770b);
            }

            @Override // com.google.common.collect.Table.Cell
            public Object getValue() {
                return this.f83772d.o(this.f83769a, this.f83770b);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object q(int i3) {
        return o(i3 / this.f83762d.size(), i3 % this.f83762d.size());
    }

    @Override // com.google.common.collect.Table
    public Map C() {
        ColumnMap columnMap = this.f83766i;
        if (columnMap != null) {
            return columnMap;
        }
        ColumnMap columnMap2 = new ColumnMap();
        this.f83766i = columnMap2;
        return columnMap2;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set O0() {
        return super.O0();
    }

    @Override // com.google.common.collect.AbstractTable
    Iterator a() {
        return new AbstractIndexedListIterator<Table.Cell<R, C, V>>(size()) { // from class: com.google.common.collect.ArrayTable.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIndexedListIterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Table.Cell a(int i3) {
                return ArrayTable.this.p(i3);
            }
        };
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(Object obj) {
        for (Object[] objArr : this.f83765h) {
            for (Object obj2 : objArr) {
                if (Objects.a(obj, obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractTable
    Iterator g() {
        return new AbstractIndexedListIterator<V>(size()) { // from class: com.google.common.collect.ArrayTable.3
            @Override // com.google.common.collect.AbstractIndexedListIterator
            protected Object a(int i3) {
                return ArrayTable.this.q(i3);
            }
        };
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.Table
    public Map l() {
        RowMap rowMap = this.f83767j;
        if (rowMap != null) {
            return rowMap;
        }
        RowMap rowMap2 = new RowMap();
        this.f83767j = rowMap2;
        return rowMap2;
    }

    public Object o(int i3, int i4) {
        Preconditions.r(i3, this.f83761c.size());
        Preconditions.r(i4, this.f83762d.size());
        return this.f83765h[i3][i4];
    }

    public Object r(int i3, int i4, Object obj) {
        Preconditions.r(i3, this.f83761c.size());
        Preconditions.r(i4, this.f83762d.size());
        Object[] objArr = this.f83765h[i3];
        Object obj2 = objArr[i4];
        objArr[i4] = obj;
        return obj2;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.f83761c.size() * this.f83762d.size();
    }

    @Override // com.google.common.collect.AbstractTable
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Collection values() {
        return super.values();
    }
}
