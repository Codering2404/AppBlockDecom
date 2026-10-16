package com.google.common.collect;

import com.google.common.collect.Tables;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class TableCollectors {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ImmutableTableCollectorState<R, C, V> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MutableCell<R, C, V> extends Tables.AbstractCell<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f84748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f84749b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f84750c;

        @Override // com.google.common.collect.Table.Cell
        public Object a() {
            return this.f84748a;
        }

        @Override // com.google.common.collect.Table.Cell
        public Object b() {
            return this.f84749b;
        }

        @Override // com.google.common.collect.Table.Cell
        public Object getValue() {
            return this.f84750c;
        }
    }
}
