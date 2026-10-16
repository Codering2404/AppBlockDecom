package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.Immutable;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImmutableMap f83876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ImmutableMap f83877d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImmutableMap f83878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ImmutableMap f83879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int[] f83880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f83881i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object[][] f83882j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int[] f83883k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int[] f83884l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class Column extends ImmutableArrayMap<R, V> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f83885g;

        Column(int i3) {
            super(DenseImmutableTable.this.f83881i[i3]);
            this.f83885g = i3;
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean k() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        Object v(int i3) {
            return DenseImmutableTable.this.f83882j[i3][this.f83885g];
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap, com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        Object writeReplace() {
            return super.writeReplace();
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap x() {
            return DenseImmutableTable.this.f83876c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ColumnMap extends ImmutableArrayMap<C, ImmutableMap<R, V>> {
        @Override // com.google.common.collect.ImmutableMap
        boolean k() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap, com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        Object writeReplace() {
            return super.writeReplace();
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap x() {
            return DenseImmutableTable.this.f83877d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public ImmutableMap v(int i3) {
            return new Column(i3);
        }

        private ColumnMap() {
            super(DenseImmutableTable.this.f83881i.length);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class ImmutableArrayMap<K, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f83888f;

        ImmutableArrayMap(int i3) {
            this.f83888f = i3;
        }

        private boolean w() {
            return this.f83888f == x().size();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        ImmutableSet g() {
            return w() ? x().keySet() : super.g();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public Object get(Object obj) {
            Integer num = (Integer) x().get(obj);
            if (num == null) {
                return null;
            }
            return v(num.intValue());
        }

        @Override // java.util.Map
        public int size() {
            return this.f83888f;
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        UnmodifiableIterator t() {
            return new AbstractIterator<Map.Entry<K, V>>() { // from class: com.google.common.collect.DenseImmutableTable.ImmutableArrayMap.1

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private int f83889c = -1;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private final int f83890d;

                {
                    this.f83890d = ImmutableArrayMap.this.x().size();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Map.Entry a() {
                    int i3 = this.f83889c;
                    while (true) {
                        this.f83889c = i3 + 1;
                        int i4 = this.f83889c;
                        if (i4 >= this.f83890d) {
                            return (Map.Entry) b();
                        }
                        Object objV = ImmutableArrayMap.this.v(i4);
                        if (objV != null) {
                            return Maps.u(ImmutableArrayMap.this.u(this.f83889c), objV);
                        }
                        i3 = this.f83889c;
                    }
                }
            };
        }

        Object u(int i3) {
            return x().keySet().a().get(i3);
        }

        abstract Object v(int i3);

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        Object writeReplace() {
            return super.writeReplace();
        }

        abstract ImmutableMap x();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class Row extends ImmutableArrayMap<C, V> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f83892g;

        Row(int i3) {
            super(DenseImmutableTable.this.f83880h[i3]);
            this.f83892g = i3;
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean k() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        Object v(int i3) {
            return DenseImmutableTable.this.f83882j[this.f83892g][i3];
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap, com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        Object writeReplace() {
            return super.writeReplace();
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap x() {
            return DenseImmutableTable.this.f83877d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class RowMap extends ImmutableArrayMap<R, ImmutableMap<C, V>> {
        @Override // com.google.common.collect.ImmutableMap
        boolean k() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap, com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        Object writeReplace() {
            return super.writeReplace();
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        ImmutableMap x() {
            return DenseImmutableTable.this.f83876c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public ImmutableMap v(int i3) {
            return new Row(i3);
        }

        private RowMap() {
            super(DenseImmutableTable.this.f83880h.length);
        }
    }

    DenseImmutableTable(ImmutableList immutableList, ImmutableSet immutableSet, ImmutableSet immutableSet2) {
        this.f83882j = (Object[][]) Array.newInstance((Class<?>) Object.class, immutableSet.size(), immutableSet2.size());
        ImmutableMap immutableMapV = Maps.v(immutableSet);
        this.f83876c = immutableMapV;
        ImmutableMap immutableMapV2 = Maps.v(immutableSet2);
        this.f83877d = immutableMapV2;
        this.f83880h = new int[immutableMapV.size()];
        this.f83881i = new int[immutableMapV2.size()];
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i3 = 0; i3 < immutableList.size(); i3++) {
            Table.Cell cell = (Table.Cell) immutableList.get(i3);
            Object objA = cell.a();
            Object objB = cell.b();
            Integer num = (Integer) this.f83876c.get(objA);
            Objects.requireNonNull(num);
            int iIntValue = num.intValue();
            Integer num2 = (Integer) this.f83877d.get(objB);
            Objects.requireNonNull(num2);
            int iIntValue2 = num2.intValue();
            u(objA, objB, this.f83882j[iIntValue][iIntValue2], cell.getValue());
            this.f83882j[iIntValue][iIntValue2] = cell.getValue();
            int[] iArr3 = this.f83880h;
            iArr3[iIntValue] = iArr3[iIntValue] + 1;
            int[] iArr4 = this.f83881i;
            iArr4[iIntValue2] = iArr4[iIntValue2] + 1;
            iArr[i3] = iIntValue;
            iArr2[i3] = iIntValue2;
        }
        this.f83883k = iArr;
        this.f83884l = iArr2;
        this.f83878f = new RowMap();
        this.f83879g = new ColumnMap();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public Object e(Object obj, Object obj2) {
        Integer num = (Integer) this.f83876c.get(obj);
        Integer num2 = (Integer) this.f83877d.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return this.f83882j[num.intValue()][num2.intValue()];
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    /* JADX INFO: renamed from: m */
    public ImmutableMap C() {
        return ImmutableMap.e(this.f83879g);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    /* JADX INFO: renamed from: s */
    public ImmutableMap l() {
        return ImmutableMap.e(this.f83878f);
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.f83883k.length;
    }

    @Override // com.google.common.collect.RegularImmutableTable
    Table.Cell w(int i3) {
        int i4 = this.f83883k[i3];
        int i5 = this.f83884l[i3];
        E e3 = r().a().get(i4);
        E e4 = k().a().get(i5);
        Object obj = this.f83882j[i4][i5];
        Objects.requireNonNull(obj);
        return ImmutableTable.i(e3, e4, obj);
    }

    @Override // com.google.common.collect.RegularImmutableTable, com.google.common.collect.ImmutableTable
    Object writeReplace() {
        return ImmutableTable.SerializedForm.a(this, this.f83883k, this.f83884l);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    Object x(int i3) {
        Object obj = this.f83882j[this.f83883k[i3]][this.f83884l[i3]];
        Objects.requireNonNull(obj);
        return obj;
    }
}
