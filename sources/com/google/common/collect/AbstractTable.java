package com.google.common.collect;

import com.google.common.collect.Table;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractTable<R, C, V> implements Table<R, C, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Set f83754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient Collection f83755b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class CellSet extends AbstractSet<Table.Cell<R, C, V>> {
        CellSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractTable.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Table.Cell) {
                Table.Cell cell = (Table.Cell) obj;
                Map map = (Map) Maps.J(AbstractTable.this.l(), cell.a());
                if (map != null && Collections2.g(map.entrySet(), Maps.u(cell.b(), cell.getValue()))) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return AbstractTable.this.a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Table.Cell) {
                Table.Cell cell = (Table.Cell) obj;
                Map map = (Map) Maps.J(AbstractTable.this.l(), cell.a());
                if (map != null && Collections2.h(map.entrySet(), Maps.u(cell.b(), cell.getValue()))) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractTable.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class Values extends AbstractCollection<V> {
        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractTable.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractTable.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractTable.this.g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractTable.this.size();
        }
    }

    AbstractTable() {
    }

    @Override // com.google.common.collect.Table
    public Set O0() {
        Set set = this.f83754a;
        if (set != null) {
            return set;
        }
        Set setC = c();
        this.f83754a = setC;
        return setC;
    }

    abstract Iterator a();

    public boolean b(Object obj, Object obj2) {
        Map map = (Map) Maps.J(l(), obj);
        return map != null && Maps.I(map, obj2);
    }

    Set c() {
        return new CellSet();
    }

    @Override // com.google.common.collect.Table
    public void clear() {
        Iterators.e(O0().iterator());
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(Object obj) {
        Iterator<V> it = l().values().iterator();
        while (it.hasNext()) {
            if (((Map) it.next()).containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    Collection d() {
        return new Values();
    }

    public Object e(Object obj, Object obj2) {
        Map map = (Map) Maps.J(l(), obj);
        if (map == null) {
            return null;
        }
        return Maps.J(map, obj2);
    }

    @Override // com.google.common.collect.Table
    public boolean equals(Object obj) {
        return Tables.c(this, obj);
    }

    public boolean f() {
        return size() == 0;
    }

    Iterator g() {
        return new TransformedIterator<Table.Cell<R, C, V>, V>(O0().iterator()) { // from class: com.google.common.collect.AbstractTable.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.TransformedIterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object a(Table.Cell cell) {
                return cell.getValue();
            }
        };
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return O0().hashCode();
    }

    public String toString() {
        return l().toString();
    }

    @Override // com.google.common.collect.Table
    public Collection values() {
        Collection collection = this.f83755b;
        if (collection != null) {
            return collection;
        }
        Collection collectionD = d();
        this.f83755b = collectionD;
        return collectionD;
    }
}
