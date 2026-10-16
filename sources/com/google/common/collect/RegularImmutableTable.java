package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Table;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class CellSet extends IndexedImmutableSet<Table.Cell<R, C, V>> {
        private CellSet() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.IndexedImmutableSet
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public Table.Cell get(int i3) {
            return RegularImmutableTable.this.w(i3);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Table.Cell) {
                Table.Cell cell = (Table.Cell) obj;
                Object objE = RegularImmutableTable.this.e(cell.a(), cell.b());
                if (objE != null && objE.equals(cell.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableTable.this.size();
        }

        @Override // com.google.common.collect.IndexedImmutableSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class Values extends ImmutableList<V> {
        private Values() {
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i3) {
            return RegularImmutableTable.this.x(i3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return RegularImmutableTable.this.size();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    RegularImmutableTable() {
    }

    static RegularImmutableTable v(ImmutableList immutableList, ImmutableSet immutableSet, ImmutableSet immutableSet2) {
        return ((long) immutableList.size()) > (((long) immutableSet.size()) * ((long) immutableSet2.size())) / 2 ? new DenseImmutableTable(immutableList, immutableSet, immutableSet2) : new SparseImmutableTable(immutableList, immutableSet, immutableSet2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final ImmutableSet c() {
        return f() ? ImmutableSet.z() : new CellSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final ImmutableCollection d() {
        return f() ? ImmutableList.y() : new Values();
    }

    final void u(Object obj, Object obj2, Object obj3, Object obj4) {
        Preconditions.q(obj3 == null, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", obj, obj2, obj4, obj3);
    }

    abstract Table.Cell w(int i3);

    @Override // com.google.common.collect.ImmutableTable
    abstract Object writeReplace();

    abstract Object x(int i3);
}
