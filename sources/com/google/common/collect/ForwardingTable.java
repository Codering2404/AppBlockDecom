package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingTable<R, C, V> extends ForwardingObject implements Table<R, C, V> {
    protected ForwardingTable() {
    }

    @Override // com.google.common.collect.Table
    public Map C() {
        return k2().C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public abstract Table k2();

    @Override // com.google.common.collect.Table
    public Set O0() {
        return k2().O0();
    }

    @Override // com.google.common.collect.Table
    public void clear() {
        k2().clear();
    }

    @Override // com.google.common.collect.Table
    public boolean containsValue(Object obj) {
        return k2().containsValue(obj);
    }

    @Override // com.google.common.collect.Table
    public boolean equals(Object obj) {
        return obj == this || k2().equals(obj);
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return k2().hashCode();
    }

    @Override // com.google.common.collect.Table
    public Map l() {
        return k2().l();
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return k2().size();
    }

    @Override // com.google.common.collect.Table
    public Collection values() {
        return k2().values();
    }
}
