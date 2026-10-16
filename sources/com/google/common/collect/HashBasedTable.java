package com.google.common.collect;

import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class HashBasedTable<R, C, V> extends StandardTable<R, C, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Factory<C, V> implements Supplier<Map<C, V>>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f83966a;

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map get() {
            return Maps.D(this.f83966a);
        }
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map C() {
        return super.C();
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

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map l() {
        return super.l();
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

    @Override // com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ Map x(Object obj) {
        return super.x(obj);
    }
}
