package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ForwardingSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class InvalidatableSet<E> extends ForwardingSet<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Supplier f84977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f84978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Supplier f84979c;

    private InvalidatableSet(Set set, Supplier supplier, Supplier supplier2) {
        this.f84978b = set;
        this.f84977a = supplier;
        this.f84979c = supplier2;
    }

    public static final InvalidatableSet o2(Set set, Supplier supplier, Supplier supplier2) {
        return new InvalidatableSet((Set) Preconditions.t(set), (Supplier) Preconditions.t(supplier), (Supplier) Preconditions.t(supplier2));
    }

    private void r2() {
        if (!((Boolean) this.f84977a.get()).booleanValue()) {
            throw new IllegalStateException((String) this.f84979c.get());
        }
    }

    @Override // com.google.common.collect.ForwardingSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f84978b.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
    public Set k2() {
        r2();
        return this.f84978b;
    }
}
