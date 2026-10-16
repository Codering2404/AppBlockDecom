package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSet<E> extends ForwardingCollection<E> implements Set<E> {
    protected ForwardingSet() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || o2().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return o2().hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection
    /* JADX INFO: renamed from: k2, reason: merged with bridge method [inline-methods] */
    public abstract Set k2();

    protected boolean m2(Collection collection) {
        return Sets.n(this, (Collection) Preconditions.t(collection));
    }
}
