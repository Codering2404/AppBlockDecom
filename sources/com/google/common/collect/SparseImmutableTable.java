package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.Immutable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final ImmutableTable f84677h = new SparseImmutableTable(ImmutableList.y(), ImmutableSet.z(), ImmutableSet.z());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImmutableMap f84678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ImmutableMap f84679d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f84680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f84681g;

    /* JADX WARN: Multi-variable type inference failed */
    SparseImmutableTable(ImmutableList immutableList, ImmutableSet immutableSet, ImmutableSet immutableSet2) {
        ImmutableMap immutableMapV = Maps.v(immutableSet);
        LinkedHashMap linkedHashMapC = Maps.C();
        UnmodifiableIterator it = immutableSet.iterator();
        while (it.hasNext()) {
            linkedHashMapC.put(it.next(), new LinkedHashMap());
        }
        LinkedHashMap linkedHashMapC2 = Maps.C();
        UnmodifiableIterator it2 = immutableSet2.iterator();
        while (it2.hasNext()) {
            linkedHashMapC2.put(it2.next(), new LinkedHashMap());
        }
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i3 = 0; i3 < immutableList.size(); i3++) {
            Table.Cell cell = (Table.Cell) immutableList.get(i3);
            Object objA = cell.a();
            Object objB = cell.b();
            Object value = cell.getValue();
            Integer num = (Integer) immutableMapV.get(objA);
            Objects.requireNonNull(num);
            iArr[i3] = num.intValue();
            Map map = (Map) linkedHashMapC.get(objA);
            Objects.requireNonNull(map);
            Map map2 = map;
            iArr2[i3] = map2.size();
            u(objA, objB, map2.put(objB, value), value);
            Map map3 = (Map) linkedHashMapC2.get(objB);
            Objects.requireNonNull(map3);
            map3.put(objA, value);
        }
        this.f84680f = iArr;
        this.f84681g = iArr2;
        ImmutableMap.Builder builder = new ImmutableMap.Builder(linkedHashMapC.size());
        for (Map.Entry entry : linkedHashMapC.entrySet()) {
            builder.g(entry.getKey(), ImmutableMap.e((Map) entry.getValue()));
        }
        this.f84678c = builder.d();
        ImmutableMap.Builder builder2 = new ImmutableMap.Builder(linkedHashMapC2.size());
        for (Map.Entry entry2 : linkedHashMapC2.entrySet()) {
            builder2.g(entry2.getKey(), ImmutableMap.e((Map) entry2.getValue()));
        }
        this.f84679d = builder2.d();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    /* JADX INFO: renamed from: m */
    public ImmutableMap C() {
        return ImmutableMap.e(this.f84679d);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    /* JADX INFO: renamed from: s */
    public ImmutableMap l() {
        return ImmutableMap.e(this.f84678c);
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return this.f84680f.length;
    }

    @Override // com.google.common.collect.RegularImmutableTable
    Table.Cell w(int i3) {
        Map.Entry entry = (Map.Entry) this.f84678c.entrySet().a().get(this.f84680f[i3]);
        ImmutableMap immutableMap = (ImmutableMap) entry.getValue();
        Map.Entry entry2 = (Map.Entry) immutableMap.entrySet().a().get(this.f84681g[i3]);
        return ImmutableTable.i(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    @Override // com.google.common.collect.RegularImmutableTable, com.google.common.collect.ImmutableTable
    Object writeReplace() {
        ImmutableMap immutableMapV = Maps.v(k());
        int[] iArr = new int[O0().size()];
        UnmodifiableIterator it = O0().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Integer num = (Integer) immutableMapV.get(((Table.Cell) it.next()).b());
            Objects.requireNonNull(num);
            iArr[i3] = num.intValue();
            i3++;
        }
        return ImmutableTable.SerializedForm.a(this, this.f84680f, iArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RegularImmutableTable
    Object x(int i3) {
        ImmutableMap immutableMap = (ImmutableMap) this.f84678c.values().a().get(this.f84680f[i3]);
        return immutableMap.values().a().get(this.f84681g[i3]);
    }
}
