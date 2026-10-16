package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableTable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class SingletonImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Object f84663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Object f84664d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Object f84665f;

    SingletonImmutableTable(Object obj, Object obj2, Object obj3) {
        this.f84663c = Preconditions.t(obj);
        this.f84664d = Preconditions.t(obj2);
        this.f84665f = Preconditions.t(obj3);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public ImmutableMap C() {
        return ImmutableMap.o(this.f84664d, ImmutableMap.o(this.f84663c, this.f84665f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    /* JADX INFO: renamed from: n */
    public ImmutableSet c() {
        return ImmutableSet.A(ImmutableTable.i(this.f84663c, this.f84664d, this.f84665f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    /* JADX INFO: renamed from: o */
    public ImmutableCollection d() {
        return ImmutableSet.A(this.f84665f);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public ImmutableMap l() {
        return ImmutableMap.o(this.f84663c, ImmutableMap.o(this.f84664d, this.f84665f));
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableTable
    Object writeReplace() {
        return ImmutableTable.SerializedForm.a(this, new int[]{0}, new int[]{0});
    }
}
