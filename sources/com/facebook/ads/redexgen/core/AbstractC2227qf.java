package com.facebook.ads.redexgen.core;

import java.util.AbstractSet;
import java.util.Collection;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.qf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2227qf<E> extends AbstractSet<E> {
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.qf != com.google.common.collect.Sets$ImprovedAbstractSet<E> */
    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> c3) {
        return AbstractC2231qj.A0A(this, c3);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.qf != com.google.common.collect.Sets$ImprovedAbstractSet<E> */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> c3) {
        return super.retainAll((Collection) AbstractC1878ki.A04(c3));
    }
}
