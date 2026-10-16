package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Tables {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Function f84751a = new Function<Map<Object, Object>, Map<Object, Object>>() { // from class: com.google.common.collect.Tables.1
        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map apply(Map map) {
            return Collections.unmodifiableMap(map);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class AbstractCell<R, C, V> implements Table.Cell<R, C, V> {
        AbstractCell() {
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Table.Cell) {
                Table.Cell cell = (Table.Cell) obj;
                if (Objects.a(a(), cell.a()) && Objects.a(b(), cell.b()) && Objects.a(getValue(), cell.getValue())) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.b(a(), b(), getValue());
        }

        public String toString() {
            return "(" + a() + "," + b() + ")=" + getValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ImmutableCell<R, C, V> extends AbstractCell<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f84752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f84753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f84754c;

        ImmutableCell(Object obj, Object obj2, Object obj3) {
            this.f84752a = obj;
            this.f84753b = obj2;
            this.f84754c = obj3;
        }

        @Override // com.google.common.collect.Table.Cell
        public Object a() {
            return this.f84752a;
        }

        @Override // com.google.common.collect.Table.Cell
        public Object b() {
            return this.f84753b;
        }

        @Override // com.google.common.collect.Table.Cell
        public Object getValue() {
            return this.f84754c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TransformedTable<R, C, V1, V2> extends AbstractTable<R, C, V2> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Table f84755c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Function f84756d;

        @Override // com.google.common.collect.Table
        public Map C() {
            return Maps.Q(this.f84755c.C(), new Function<Map<R, V1>, Map<R, V2>>() { // from class: com.google.common.collect.Tables.TransformedTable.3
                @Override // com.google.common.base.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map apply(Map map) {
                    return Maps.Q(map, TransformedTable.this.f84756d);
                }
            });
        }

        @Override // com.google.common.collect.AbstractTable
        Iterator a() {
            return Iterators.N(this.f84755c.O0().iterator(), h());
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void clear() {
            this.f84755c.clear();
        }

        @Override // com.google.common.collect.AbstractTable
        Collection d() {
            return Collections2.j(this.f84755c.values(), this.f84756d);
        }

        Function h() {
            return new Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>>() { // from class: com.google.common.collect.Tables.TransformedTable.1
                @Override // com.google.common.base.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Table.Cell apply(Table.Cell cell) {
                    return Tables.d(cell.a(), cell.b(), TransformedTable.this.f84756d.apply(cell.getValue()));
                }
            };
        }

        @Override // com.google.common.collect.Table
        public Map l() {
            return Maps.Q(this.f84755c.l(), new Function<Map<C, V1>, Map<C, V2>>() { // from class: com.google.common.collect.Tables.TransformedTable.2
                @Override // com.google.common.base.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map apply(Map map) {
                    return Maps.Q(map, TransformedTable.this.f84756d);
                }
            });
        }

        @Override // com.google.common.collect.Table
        public int size() {
            return this.f84755c.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TransposeTable<C, R, V> extends AbstractTable<C, R, V> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Table f84760c;

        @Override // com.google.common.collect.Table
        public Map C() {
            return this.f84760c.l();
        }

        @Override // com.google.common.collect.AbstractTable
        Iterator a() {
            return Iterators.N(this.f84760c.O0().iterator(), new Function() { // from class: com.google.common.collect.f0
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return Tables.e((Table.Cell) obj);
                }
            });
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public void clear() {
            this.f84760c.clear();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public boolean containsValue(Object obj) {
            return this.f84760c.containsValue(obj);
        }

        @Override // com.google.common.collect.Table
        public Map l() {
            return this.f84760c.C();
        }

        @Override // com.google.common.collect.Table
        public int size() {
            return this.f84760c.size();
        }

        @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
        public Collection values() {
            return this.f84760c.values();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements RowSortedTable<R, C, V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable
        /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public RowSortedTable k2() {
            return (RowSortedTable) super.k2();
        }

        @Override // com.google.common.collect.Tables.UnmodifiableTable, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public SortedMap l() {
            return Collections.unmodifiableSortedMap(Maps.R(I1().l(), Tables.f()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class UnmodifiableTable<R, C, V> extends ForwardingTable<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Table f84761a;

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map C() {
            return Collections.unmodifiableMap(Maps.Q(super.C(), Tables.f()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        /* JADX INFO: renamed from: I1 */
        public Table k2() {
            return this.f84761a;
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Set O0() {
            return Collections.unmodifiableSet(super.O0());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map l() {
            return Collections.unmodifiableMap(Maps.Q(super.l(), Tables.f()));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Collection values() {
            return Collections.unmodifiableCollection(super.values());
        }
    }

    static boolean c(Table table, Object obj) {
        if (obj == table) {
            return true;
        }
        if (obj instanceof Table) {
            return table.O0().equals(((Table) obj).O0());
        }
        return false;
    }

    public static Table.Cell d(Object obj, Object obj2, Object obj3) {
        return new ImmutableCell(obj, obj2, obj3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Table.Cell e(Table.Cell cell) {
        return d(cell.b(), cell.a(), cell.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Function f() {
        return f84751a;
    }
}
